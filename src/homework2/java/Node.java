package homework2.java;

import java.util.Objects;

/**
 * Node will be use as elements in HashMap.
 * Node have key,value and link to another element.
 */
public class Node {
    private Object key;
    private Object value;
    private Node nextNode;


    public Node(Object key, Object value){
        this.key=key;
        this.value=value;
        nextNode=null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(key, node.key) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
