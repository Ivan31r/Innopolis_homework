package homework4;


import java.util.Objects;

public class Node<K,V> {
    public K key;
    public V value;
    public Node<K,V> nextNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public Node(){

    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(key, node.key) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(key) ^ Objects.hash(value);
//        return Objects.hash(key);
        int hash = (hash = key.hashCode()) ^ (hash >>> 16);
        return hash;
    }
}
