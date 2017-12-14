package com.comp20010;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList {

    // instance variables of the SinglyLinkedList
    /**
     * The head node of the list
     */
    private Node head = null; // head node of the list (or null if empty)

    /**
     * The last node of the list
     */
    private Node tail = null; // last node of the list (or null if empty)

    /**
     * Number of nodes in the list
     */
    private int size = 0; // number of nodes in the list

    /**
     * Node of a singly linked list, which stores a reference to its element and to
     * the subsequent node in the list (or null if this is the last node).
     */
    private static class Node {

        /**
         * The element stored at this node
         */
        private String element; // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node next; // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e: the element to be stored
         * @param n: reference to a node that should follow the new node
         */
        public Node(String e, Node n) {
            this.element = e;
            this.next = n;
        }

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public String getElement() {
            return this.element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node n) {
            this.next = n;
        }
    }

    /**
     * Constructs an initially empty list.
     */
    public SinglyLinkedList() {
    }

    // access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public String first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        } else {
            return head.getElement();
        }
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public String last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        } else {
            return tail.getElement();
        }
    }

    // update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(String e) { // adds element e to the front of the list
        head = new Node(e, head);

        if (size == 0) {
            tail = head;
        }
        size++;
    }


    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(String e) { // adds element e to the end of the list
        Node newNode = new Node(e, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public String removeFirst() { // removes and returns the first element

        if (isEmpty()) {
            return null;
        }
        if (size == 0) {
            tail = null;
        }

        String remove;
        remove = head.getElement();
        head = head.getNext();
        size--;
        return remove;
    }

    public Iterator<String> iterator() {
        return new ListIterator();
    }

    /*private inner class implements interface Iterator*/
    private class ListIterator implements Iterator<String> {
        private Node current = head;

        public ListIterator() {
            this.current = head.getNext();
        }

        /*Overriding interface method hasNext()
        * Method checks if list has a next node
        * @return true if current node does not equal trailer node*/
        @Override
        public boolean hasNext() {
            return current != tail;
        }

        /*Overriding interface method next()
        * @return the element stored at the current node
        * iterate to the next node*/
        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String tmp;
            tmp = current.getElement();
            current = current.getNext();
            return tmp;
        }
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        String result = " ";
        if (isEmpty()) {
            return "nothing in list";
        } else {

            Node curr = head;
            while (curr.next != tail) {

                curr = curr.getNext();
                result += curr.element + " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}