package homework5.main;

import java.util.*;

public class HashMapPart2<K, V> implements Map<K, V> {
    public Node<K, V>[] nodes;
    private static final double LOAD_FACTOR = 0.75;
    private int bucketCounter;
    private int size;
    private int capacity;

    public HashMapPart2() {
        this.capacity = 16;
        nodes = new Node[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return nodes == null;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> node : nodes) {
            Node<K, V> headNode = node;
            if (headNode!=null && (headNode.getValue().equals(value))) {
                return true;
            }
            while (headNode != null) {

                if (headNode.getValue().equals(value)) {
                    return true;
                }
                headNode = headNode.getNextNode();

            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> newNode = new Node(key, null);
        int hash = getHash(newNode);
        Node<K, V> currentNode = nodes[hash];
        while (currentNode != null) {

            if (currentNode.getKey().equals(newNode.getKey())) {
                break;
            }

            currentNode = currentNode.getNextNode();
        }
        if (currentNode == null) {
            throw new IllegalArgumentException("Nonexistent key, try again with another key");
        }
        return currentNode.getValue();
    }

    private boolean isFull() {
        return bucketCounter > capacity * LOAD_FACTOR;
    }

    private void increaseCapacity() {
        size = 0;
        bucketCounter = 0;
        Node<K, V>[] oldNodes = nodes;
        capacity *= 2;
        nodes = new Node[capacity];
        for (Node<K, V> oldNode : oldNodes) {
            while (oldNode != null) {
                put(oldNode.getKey(), oldNode.getValue());
                oldNode = oldNode.getNextNode();

            }
        }

    }

    private int getHash(Node<K, V> newNode) {
        return Math.abs(newNode.hashCode() % capacity);
    }


    @Override
    public V put(K key, V value) {

        if (isFull()) {
            increaseCapacity();
        }

        Node<K, V> newNode = new Node<>(key, value);
        V val = null;

        int hash = getHash(newNode);
        if (nodes[hash] == null) {
            nodes[hash] = newNode;
            size++;
            bucketCounter++;
            val = newNode.getValue();
        }
        Node<K, V> currentNode = nodes[hash];
        while (currentNode != null) {

            if (currentNode.getKey().equals(newNode.getKey())) {
                currentNode.setValue(newNode.getValue());
                val = currentNode.getValue();
                break;
            } else if (currentNode.getNextNode() == null) {
                currentNode.setNextNode(newNode);
                size++;
                val = currentNode.getValue();
                break;
            }
            currentNode = currentNode.getNextNode();
        }

        return val;
    }

    @Override
    public V remove(Object key) {
        boolean isFind = false;
        Node<K, V> newNode = new Node(key, null);
        int hash = getHash(newNode);
        V val = null;
        if (nodes[hash] == null) {
            throw new IllegalArgumentException("Wrong key, try again");
        }

        Node<K, V> currentNode = nodes[hash];
        if (currentNode.getKey().equals(newNode.getKey()) && currentNode.getNextNode() == null) {
            isFind = true;
            val = currentNode.getValue();
            nodes[hash] = null;
            size--;
            return val;
        } else {

            while (currentNode.getNextNode() != null) {
                if (currentNode.getKey().equals(newNode.getKey())) {
                    val = currentNode.getValue();
                    currentNode.setCurrentNode(currentNode.getNextNode());
                    isFind = true;
                    size--;
                    return val;
                } else {
                    currentNode = currentNode.getNextNode();
                }
            }
        }
        if (!isFind) {
            throw new IllegalArgumentException("Wrong key, try again");
        }
        return val;

    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);

    }

    @Override
    public void clear() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = null;
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        Node<K,V> tempNode ;
        for (int i =0;i<nodes.length;i++){
            tempNode=nodes[i];
            if (tempNode!=null){
                while (tempNode!=null){
                    keys.add(tempNode.getKey());
                    tempNode=tempNode.getNextNode();
                }
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        List<V> valueList = new ArrayList<>();
       for (Map.Entry<K,V> entry : entrySet()){
           valueList.add(entry.getValue());
       }
        return valueList;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> setNodes = new HashSet<>();
        Node<K,V> node;
        for (int i=0;i<nodes.length;i++){
            node=nodes[i];
            while (node!=null){
                setNodes.add(node);
                node=node.getNextNode();

            }
        }
        return setNodes;
    }
}
