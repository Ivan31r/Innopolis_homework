package homework4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMapPart2<K,V> implements Map<K,V> {
    public Node<K,V>[] nodes;
    private static final double LOAD_FACTOR = 0.75;
    private int bucketCounter ;
    private int size;
    private int capacity;

    public HashMapPart2(){
        this.capacity=16;
        nodes=new Node[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return nodes==null;
    }

    @Override
    public boolean containsKey(Object key) {
        return get( key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> node : nodes) {
            Node<K, V> headNode = node;
            if (headNode.getValue().equals(value)) {
                return true;
            }
            while (headNode.getNextNode() != null) {
                headNode = headNode.getNextNode();
                if (headNode.getValue().equals(value)) {
                    return true;
                }

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
        capacity = oldNodes.length * 2;
        nodes = new Node[capacity];
        for (int i = 0; i < oldNodes.length; i++) {
            if (oldNodes[i] != null) {
                put(oldNodes[i].getKey(), oldNodes[i].getValue());
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
        V val =null;

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
                val= currentNode.getValue() ;
                break;
            } else if (currentNode.getNextNode() == null) {
                currentNode.setNextNode(newNode);
                size++;
                val  = currentNode.getValue();
                break;
            }
            currentNode = currentNode.getNextNode();
        }

        return val;
    }

    @Override
    public V remove(Object key) {

        Node<K, V> newNode = new Node(key, null);
        boolean isFind = false;
        int hash = getHash(newNode);

        if (nodes[hash] == null) {
            throw new IllegalArgumentException("Wrong key, try again");
        }

        Node<K, V> currentNode = nodes[hash];

        if (currentNode.getKey().equals(newNode.getKey()) && currentNode.getNextNode() == null) {
            nodes[hash] = null;
            isFind = true;
        } else {

            while (currentNode.getNextNode() != null) {
                if (currentNode.getKey().equals(newNode.getKey())) {
                    System.out.println(currentNode.getValue());
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                    isFind = true;
                } else {
                    currentNode.setNextNode(currentNode.getNextNode());
                }
            }
        }
        if (!isFind) {
            throw new IllegalArgumentException("Wrong key, try again");
        }


        return newNode.getValue();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = null;
        }
        size=0;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
