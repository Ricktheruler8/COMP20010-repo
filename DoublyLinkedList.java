package com.comp20010;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

// Doubly Linked List generic class. Implements Iterable interface
public class DoublyLinkedList<E extends Comparable<E>> implements Iterable<E> {
    // Random object variable seeded from system time
    private static  Random random = new Random(System.currentTimeMillis());

    private Node<E> header; // private inner class Node variable, first Node of doubly linked list
    private Node<E> trailer; // last node of doubly linked list
    private int size = 0; // size of list, incremented or decremented when a node is added or removed

    // inner class Node uses generics and implements Iterator interface
    private static class  Node<E> implements Iterator<E>{

        private E element; // private instance variable, is the element stored in each node
        private Node<E> prev; // is the previous node of the current node selected
        private Node<E> next; // is the next node of the current node selected
        Node<E> current; // current node selected

        /*Class Node constructor
        * @Param E e is the element to be stored in each new node instance
        * @Param Node<E> p is the previous node before the new node
        * @Param Node<E> n is the next node after the new node*/
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        /*Getter method for previous instance variable
        * @Return returns the node positioned before the current node*/
        public Node<E> getPrev() {
            return prev;
        }
        /*Setter method for previous instance variable
        * @Param prev is the node that will be set as the previous node of the current node*/
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
        /*Getter method for next instance variable
        * @Return returns next node after current*/
        public Node<E> getNext() {
            return next;
        }
        /*Setter method for next instance variable
        * @Param next is the node that will be set as the next node of the current node*/
        public void setNext(Node<E> next) {
            this.next = next;
        }
        /*Getter method for instance variable element
        * @return returns the element stored in the current slected node*/
        public E getElement() {
            return element;
        }
        /*Overriding hasNext() method from Iterator interface
        * method checks if the list has a next node and returns true or false
        * @return returns true if next does not equal null otherwise return true*/
       @Override
        public boolean hasNext() {
            return next != null;
        }
        /*Overriding next() method from Iterator interface
        * @return returns the element of the next node of current node selected*/
        @Override
        public E next() {
            E res = next.getElement();
            current = current.getNext();
            return res;
        }
    }
    /**/
    @Override
    public Iterator<E> iterator() {

        return new DllIterator();
    }
    /*private inner class implements interface Iterator*/
    private class DllIterator implements Iterator<E>{
        private Node<E> current; // class instance variable, is current node
        /*Constructor for DllIterator class
        * instantiates current node with the first node which is header.getNext()*/
        public DllIterator() {
            this.current = header.getNext();
        }
        /*Overriding interface method hasNext()
        * Method checks if list has a next node
        * @return true if current node does not equal trailer node*/
        @Override
        public boolean hasNext() {
            return current != trailer;
        }
        /*Overriding interface method next()
        * @return the element stored at the current node
        * iterate to the next node*/
        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            E tmp;
            tmp = current.getElement();
            current = current.getNext();
            return tmp;
        }
    }
    /*Constructor method for DoublyLinkedList class
    * instantiates a header and trailer node for the linked list*/
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    /*Implementing the List ADT
    * method size()
    * @return the current size of the list*/
    public int size(){
        return size;
    }
    /*Implementing the List ADT
    * method isEmpty()
    * checks if list is empty
    * @return true if size is equivalent to 0*/
    public boolean isEmpty(){
        return size == 0;
    }
    /*method to return the first element of the list
    * if isEmpty() == true
    * @return null
    * else
    * @return element of node after header*/
    public E first(){
        if (isEmpty()){
            return null;
        }
        else
            return header.getNext().getElement();
    }
    /*method to return the last element of the list
    * if isEmpty() == true
    * @return null
    * else
    * @return element of node before trailer*/
    public E last(){
        if(isEmpty()){
            return null;
        }
        else
            return trailer.getPrev().getElement();
    }
    /*method to remove a specific node access specifier private, can only be called by methods of this class
    * @Param node is the node to be removed
    * @return is the element of the node that is removed*/
    private E remove(Node<E> node){
       Node<E> predecessor = node.getPrev();
       Node<E> successor = node.getNext();
        predecessor.setNext(successor);
       successor.setPrev(predecessor);
       size--;

       return node.getElement();
    }
    /*method to remove a node at a specific index
    * @Param index is the index number of the node to be removed*/
    public void removeNode(int index){

        if(index > size) {  // if index is greater than size print error
            System.out.println("ERROR: index out of bounds");
        }
        else if(index > size / 2){ // else if index is greater than size divided by two traverse the list from trailer
            index = size%index; // assign the remainder of size divided by index, gives the correct index value to iterate backwards through the list
            Node<E> curr = trailer;

            while (index-- != 0) { // iterate through the list from trailer to the desired node
                curr = curr.getPrev();
            }

            Node<E> toBeDeleted = curr.getPrev();
            remove(toBeDeleted); // call private method remove and pass node to be deleted as an argument
        }
        else{ // else the node to be deleted is situated in the first half of the list
            Node<E> curr = header.getNext(); // start from the header node

            while (index-- != 0) { // iterate forward to desired node
                curr = curr.getNext();
            }

            Node<E> toBeDeleted = curr;
            remove(toBeDeleted); // call private method remove and pass node to be deleted as argument
        }
    }
    /*Implementing List ADT
    * method removes first element of list*/
    public void removeFirst(){
        Node<E> tmpFirst = header.getNext();
        remove(tmpFirst);
    }
    /*Implementing List ADT
    * method removes last element of list*/
    public void removeLast(){
        Node<E> tmpLast = trailer.getPrev();
        remove(tmpLast);
    }
    /*Implementing List ADT
    * method adds a new node with a given element to the end of list
    * @Param E e is the element to be added at the end of the list*/
    public void addLast(E e){
        Node<E> tmpLast = trailer.getPrev();
        Node<E> newest = new Node<>(e, tmpLast, trailer);
        trailer.prev = newest;
        tmpLast.next = newest;
        size++;
    }
    /*Implementing List ADT
    * method adds a new node with a given element to the start of the list
    * @Param E e is the element to be added at the start of the list*/
    public void addFirst(E e){
        Node<E> tmpFirst = header.getNext();
        Node<E> newest = new Node<>(e, header, tmpFirst);
        header.next = newest;
        tmpFirst.prev = newest;
        size++;
    }
    /* method adds a new node with a given element to a specific place of the list between two existing nodes
    * @Param E e is the element to be added to the list
    * @Param prev is the node that will be before the new node
    * @Param next is the node that will be after the new node*/
    private void add(E e, Node<E> prev, Node<E> next){
        Node<E> newest = new Node<>(e, prev, next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
    }
    /*overloaded add method with public access specifier
    * adds a node to a specific index of the list
    * @Param e is the element of the new node to be added
    * @Param index is the index value to place the new node
    * method calls private class method add*/
    public void add(E e, int index) {
        if(index > size){
            System.out.println("Error: Index Out Of Bounds");
        }
        else{
            Node<E> curr = header.getNext();

            while(index-- != 0){
                curr = curr.next;
            }

            Node<E> tmp = curr;
            add(e, curr.getPrev(), tmp);
        }

    }
    /*method finds the first instance of an element in the list
    * @Param e is the element to find*/
    public void findElement(E e){
        int index = 0;

        if(isEmpty()){
            System.out.println("List Empty");
        }
        else{
            Node<E> curr = header;

            while(curr.element != e && curr != trailer){ // while element is not found and current node is not trailer continue iteration
                curr = curr.getNext();
                index++; // increment index until element is found
            }
            if(curr.next == trailer && e != curr.element){ // if the next node is trailer and the element has not been found
                System.out.println("Element not found!"); // print message
            }
            else{
                System.out.println("Element: " + e +  " found at index: " + index); // print the element and index value of where it was found
            }
        }
    }
    /*Assignment specific method to get the kth element
    * @Param k is the kth position of the list
    * @return element found at kth place in the list*/
    public E getKth(int k){

        if(k > size){
            System.out.println("Error: Index Out Of Bounds");
        }

        Node<E> curr = header.getNext();

        while (k-- != 0) {
            curr = curr.getNext();
        }

        return curr.getElement();
    }
    /*Assignment specific method findMinimum()
    * Starts at the first node and iterates through the list storing the minimum node
    * @return minimum node*/
    public Node<E> findMinimum(){
        Node<E> minimum = header.getNext();
        Node<E> nextNode = minimum.getNext();

        while(nextNode != trailer){ // iterate until node reaches trailer
            if(minimum.element.compareTo(nextNode.element) < 0){ // implementing comareTo() interface method if return value of compareTo() is less than 0 nextNode.element is less than the current minimum node
                minimum = nextNode; // change current minimum node to the new minimum
                nextNode = nextNode.getNext(); // iterate nextNode to the next node
            }
            else // if compareTo() returns a value = to or greater than 0 current minimum is still minimum node
                nextNode = nextNode.getNext(); // get next node and continue comareTo() until end of list
        }

        return minimum;
    }
    /*Assignment specific method
    * removes the smallest found node in the list
    * @return pop is the element stored in the minimum node to be removed*/
    public E popMinimum(){
        Node<E> min = findMinimum(); // calls findMinimum() method and stores the returned minimum node in min node variable
        E pop = min.getElement(); // stores element of min node in pop variable
        remove(min); // calls remove method and passes min node as an argument

        return pop;
    }
    /*Assignment specific method
    * method tests if current list is a palindrome
    * @return true if list is a palindrome*/
    public boolean isPalindrome(){
        if (isEmpty()) {
            return false;
        }
        else {
            Node<E> left = header.getNext(); // start left from node after header
            Node<E> right = trailer.getPrev(); // start right from node previous to trailer

            while(left != right){ // iterate until left meets right
                if(left.element != right.element){ // each iteration checks if the current left and right node elements are equal if they are not the list is not a palindrome
                    return false;
                }
                else{ // else move left and right nodes one place inwards until left != right or until they meet in the middle
                    left = left.getNext();
                    right = right.getPrev();
                }
            }
        }
        return true; // if left and right meet in the middle then the list is a palindrome
    }
    /*Assignment specific method
    * method reverses a linked list by making the pointers to each node work in opposite direction*/
   public void reverse(){
        Node<E> prev = trailer;
        Node<E> current = header.getNext();

        while(!(current == null)){
            Node<E> next = current.getNext();
            current.next = prev;
            prev = current;
            current = next;
        }
        header = prev;
    }
    /*Overrides ToStringMethod method from java.lang.Object
    * converts elements stored in each node and concatenates them in a single string
    * @return result is the concatenated string of all elements in a list*/
    @Override
    public String toString() {
        String result = " ";
        if(isEmpty()){
            return "nothing in list";
        }
        else{

            Node<E> curr = header;
            while(curr.next != trailer){

                curr = curr.getNext();
                result += curr.element + " ";
            }
        }
        return result;
    }
    /*Assignment specific method
    * tests the isPalindrome method*/
    public static void testPalindrome(){
        String [] data = {"a", "m", "a", "n", "a", "p", "l", "a", "n", "a", "c", "a", "n", "a", "l", "p", "a", "n", "a", "m", "a"};

        DoublyLinkedList<String> dll = new DoublyLinkedList<>();

        for(String s : data) dll.addLast(s);

        System.out.println("isPalindrome(): " + dll.isPalindrome());
    }
    /*Assignment specific method
    * tests the getKth method*/
    public static void testKth(){
        String [] data = {"one", "two", "three", "four", "five", "six"};

        DoublyLinkedList<String> dll = new DoublyLinkedList<>();

        for(String s : data){
            dll.addLast(s);
        }
        for(int k = 0; k < data.length; k++){
            System.out.println("K: " + " " + k + " " + data[k] + " " + dll.getKth(k));
        }
    }
    /*Assignment specific method
    * tests the reverse method*/
    public static void testReverse(){
        String [] data = {"one", "two", "three", "four", "five", "six"};

        DoublyLinkedList<String> dll = new DoublyLinkedList<>();

        for(String s : data){
            dll.addLast(s);
        }

        System.out.println("Before reverse: " + dll.toString());
        dll.reverse();
        System.out.println("After reverse: " + dll.toString());
    }
    /*tests the findElement method*/
    public static void testFindElement(){

        String [] data = {"a", "m", "a", "n", "a", "p", "l", "a", "n", "a", "c", "a", "n", "a", "l", "p", "a", "n", "a", "m", "a"};

        DoublyLinkedList<String> dll = new DoublyLinkedList<>();

        for(String s : data) {
            dll.addLast(s);
        }

        String str = data[random.nextInt(data.length)];

        dll.findElement(str);
    }
    /*Assignment specific method
    * tests the findMinimum and popMinimum methods*/
    public static void selectionSort(){

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        int n = 100;

        for(int i = 0; i < n; i++){
            dll.addLast(random.nextInt(1000));
        }

        System.out.println("Before sorting: " + dll);
        System.out.println("First element is: " + dll.first());
        System.out.println("Last element is: " + dll.last() + "\n");

        DoublyLinkedList<Integer> sorted_dll = new DoublyLinkedList<>();

        while(!dll.isEmpty()){
            sorted_dll.addFirst(dll.popMinimum());
        }

        System.out.println("After sorting: " + sorted_dll);
        System.out.println("First element is: " + sorted_dll.first());
        System.out.println("Last element is: " + sorted_dll.last());
    }
    /*Calls all test methods*/
    public static void runTests(){

        System.out.println("\nTest finding a random element\n");
        testFindElement();
        System.out.println("\nTest palindrome\n");
        testPalindrome();
        System.out.println("\nTest finding kth element\n");
        testKth();
        System.out.println("\nTest reversing linked list\n");
        testReverse();
        System.out.println("\nTest selection sort\n");
        selectionSort();
    }
}
