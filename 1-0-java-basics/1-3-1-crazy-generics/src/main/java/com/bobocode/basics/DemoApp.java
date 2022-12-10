package com.bobocode.basics;

public class DemoApp {
    public static void main(String[] args) {
    }

    /**
     * Creates a linked list of elements using class {@link Node} and returns a head of the list.
     */
    public static <T> Node<T> createLinkedList(T... elements) {
        if (0 == elements.length) {
            return null;
        }
        Node<T> head = new Node<>(elements[0]);
        Node<T> next = head;
        if (elements.length > 1) {
            for (int i = 1; i < elements.length; i++) {
                Node<T> newNode = new Node<>(elements[i]);
                next.next = newNode;
                next = newNode;

            }
        }
        return head;
    }

    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
