package com.bobocode.cs;

import java.util.NoSuchElementException;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedList<T> implements List<T> {

    private Node<T> tail;
    private Node<T> head;
    private int size = 0;

    public static class Node<T> {
        private T element;
        private Node<T> nextNode;

        public Node(T element) {
            this.element = element;
        }


        public T getElement() {
            return element;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }


    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T element : elements) {
            linkedList.add(element);
        }
        return linkedList;
    }

    /**
     * Reverses a linked list and returns a new head (old tail). PLEASE NOTE that it does not create new nodes,
     * instead in changes the next references of the current elements.
     */
    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
        tail = newNode;
        size++;
    }

    private Node<T> findNode(int index) {
        Node<T> node = head;
        if (index == 0) {
            return node;
        }
        for (int i = 1; i <= index; i++) {
            node = node.nextNode;
        }
        return node;
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        Node<T> node = new Node<>(element);
        if (index == 0) {
            node.nextNode = head;
            head = node;
            size++;
            return;
        }
        Node<T> tempNode = findNode(index - 1);
        Node<T> nextNode = tempNode.getNextNode();
        tempNode.nextNode = node;
        node.nextNode = nextNode;
        size++;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        Node<T> node = new Node<>(element);

        Node<T> prevNode = findNode(index - 1);
        node.setNextNode(prevNode.getNextNode().getNextNode());
        prevNode.setNextNode(node);
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        return findNode(index).getElement();

    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getElement();
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        T value;
        if (index == 0) {
            value = head.getElement();
            head = head.getNextNode();
            size--;
            return value;
        }

        Node<T> node = findNode(index - 1);
        value = node.getNextNode().getElement();
        node.setNextNode(node.getNextNode().getNextNode());
        if (index == size - 1) {
            tail = node;
        }
        size--;
        return value;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }
        Node<T> node = head;
        while (null != node.getNextNode()) {
            if (node.getElement().equals(element)) {
                return true;
            }
            node = node.getNextNode();
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        size = 0;
        tail = null;
        head = null;
    }
}
