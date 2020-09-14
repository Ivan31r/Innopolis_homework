package homework2.java;

/**
 * This class can keep data in any type.2 main parameters are key and value.
 */
public class HashMap {
    /**
     * Array with Node type.
     */
    private Node[] nodesArray;
    /**
     * Capacity of nodesArray
     */
    private int capacity;
    /**
     * Counter of added elements.
     */
    private int counter;
    /**
     * Bucket counter use for check maximum load of HashMap
     */
    private int bucketCounter;


    /**
     * Constructor of HashMap has not any parameters.
     * Default
     */
    public HashMap() {
        this.capacity = 16;
        nodesArray = new Node[capacity];
    }


    /**
     * This method adds elements to HashMap collection.
     * Element have key and value. Key and Value can be any parameter.
     *
     * @param key   Unique value in HashMap. Using in get/contains/delete methods.
     * @param value Value of element.
     */
    public void put(Object key, Object value) {

        if (isFull()) {
            increaseCapacity();
        }

        Node newNode = new Node(key, value);


        int hash = getHash(newNode);
        if (nodesArray[hash] == null) {
            nodesArray[hash] = newNode;
            counter++;
            bucketCounter++;
        }
        Node currentNode = nodesArray[hash];
        while (currentNode != null) {

            if (currentNode.getKey().equals(newNode.getKey())) {
                currentNode.setValue(newNode.getValue());
                return;
            } else if (currentNode.getNextNode() == null) {
                currentNode.setNextNode(newNode);
                counter++;
                break;
            }
            currentNode = currentNode.getNextNode();
        }

    }

    /**
     * This methods use for update our old data and rewrite new data in HashMap.
     * If key was not a valid , we will get IllegalArgumentException.
     *
     * @param key   We can get IllegalArgumentException, if key is not a valid.
     * @param value This parameter will be changed in element.
     */
    public void update(Object key, Object value) {
        Node newNode = new Node(key, value);
        boolean isUpdated = false;
        int hash = getHash(newNode);
        Node currentNode = nodesArray[hash];
        while (currentNode != null) {

            if (currentNode.getKey().equals(newNode.getKey())) {
                currentNode.setValue(newNode.getValue());
                isUpdated = true;
                break;
            }

            currentNode = currentNode.getNextNode();
        }
        if (!isUpdated) {
            throw new IllegalArgumentException("Nonexistent key");
        }
    }

    /**
     * Use for create unique hash for element.
     *
     * @param newNode This method not for public using.
     * @return hash code in int type
     */

    private int getHash(Node newNode) {
        return Math.abs(newNode.hashCode() % capacity);
    }

    /**
     * Return element by key.
     *
     * @param key If key is wrong , we will get IllegalArgumentException.
     * @return True or IllegalArgumentException
     */
    public Object get(Object key) {
        Node newNode = new Node(key, null);
        int hash = getHash(newNode);
        Node currentNode = nodesArray[hash];
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

    /**
     * This method can delete our data from Hashmap.
     *
     * @param key Variable of any type.
     * @return True or IllegalArgumentException
     */
    public boolean delete(Object key) {
        Node newNode = new Node(key, null);
        boolean isFind = false;
        int hash = getHash(newNode);

        if (nodesArray[hash] == null) {
            return false;
        }

        Node currentNode = nodesArray[hash];

        if (currentNode.getKey().equals(newNode.getKey()) && currentNode.getNextNode() == null) {
            nodesArray[hash] = null;
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


        return true;
    }

    /**
     * Checking  HashMap , if this map contain element with this key.
     *
     * @param key key of element
     * @return True or False
     */
    public boolean contain(Object key) {
        return get(key) != null;
    }

    /**
     * Return count of all element in HashMap
     *
     * @return int value of common quantity of elements.
     */
    public int getElementsCounter() {
        return counter;
    }

    /**
     * Method for dynamic increase of nodesArray.
     */
    private void increaseCapacity() {
        counter = 0;
        bucketCounter = 0;
        Node[] oldNodes = nodesArray;
        capacity = oldNodes.length * 2;
        nodesArray = new Node[capacity];
        for (int i = 0; i < oldNodes.length; i++) {
            if (oldNodes[i] != null) {
                put(oldNodes[i].getKey(), oldNodes[i].getValue());
            }

        }
    }


    private boolean isFull() {
        return bucketCounter > capacity * 0.7;
    }


    public boolean isEmpty() {
        return nodesArray == null;
    }
}
