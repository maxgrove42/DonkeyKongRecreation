/*
* PARTNER 1 
* Partner 1 Name: Ethan Terner
* Partner 1 PennKey: eterner
* Partner 1 Recitation #: 206
*
* PARTNER 2 (whose PennKey would come second in alphabetical order)
* (If you chose to do this project without a partner, write NONE in each spot below.)
* Partner 2 Name: Max Grove
* Partner 2 PennKey: maxgrove
* Partner 2 Recitation #: 205
* 
* Execution: java LinkedList
* 
* This program creates a generic LinkedList class and implements the generic
* List.java interface. It contains a private Node class which is used to 
* connect points within the LinkedList. 
* 
*/
public class LinkedList<T> implements List<T> {
    private class Node {
        private T data;
        private Node next;
        
        public Node(T data) {
            this.data = data;
        }
        public Node(T data, Node next) {
            this.next = next;
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
    
    /**
     * Adds the object x to the end of the list.
     * @param x the element to be added to this list
     * @return true
     */
    public boolean add(T x) {
        if (isEmpty()) {
            head = new Node(x);
            tail = head;
            return true;
        } else {
            Node current = head;
            
            //loops through the list and finds the last element
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(x);
            tail = current.next;
            return true;
        }
    }
    
    /**
     * Adds the object x at the specified position
     * @param index the position to add the element
     * @param x the element to be added to the list
     * @return true if the operation succeeded, false otherwise
     * @throws IllegalArgumentException - if index is longer
     * than the currentlength of the list
     */
    public boolean add(int index, T x) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException("adding at invalid index");
        }
        
        if (index == 0) {
            head = new Node(x, head);
            return true;
        }
        Node current = head;
        
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = new Node(x, current.next);
        tail = current.next;
        return true;
    }
    
    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int counter = 1;
        Node current = head;
        
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }
    
    /**
     * Returns the element with the specified position in this list
     * @param index the position of the element
     * @return the element at the specified position in this list
     * @throws IllegalArugmentException if index is longer than the
     * number of elements in the list
     */
    public T get(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Invalid index");
        }
        int counter = 0;
        Node current = head;
        
        while (counter < index) {
            current = current.next;
            counter++;
        }
        return current.data;
    }
    
    /**
     * Replaces the object at the specified position
     * @param index the position to replace
     * @param x the element to be stored
     * @return the previous value of the element at index
     * @throws IllegalArugmentException if index is longer than the
     * number of elements in the list
     */
    public T set(int index, T x) {
        if (index >= size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node current = head;
        
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T temp = current.data;
        current.data = x;
        return temp;
    }
    
    /**
     * Removes the object at the specified position
     * @param index the position to remove
     * @return the object that was removed
     * @throws IllegalArugmentException if index is more than
     * the number of elements in the list
     */
    public T remove(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Invalid index");
        }
        Node previous = null;
        Node current = head;
        if (index == 0) {
            T temp = head.data;
            head = head.next;
            return temp;
        }
        
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current.data;
    }
    
    /**
     * Tests if this list has no elements.
     * @return  <tt>true</tt> if this list has no elements;
     *          <tt>false</tt> otherwise.
     */
    public boolean isEmpty() {
        if (head == null) return true;
        return false;
    }
    
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param element element whose presence in this List is to be tested.
     * @return  <code>true</code> if the specified element is present;
     *  <code>false</code> otherwise.
     */
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }
        
        for (Node i = head; i != null; i = i.next) {
            if (i.data.equals(element)) return true;
        }
        return false;
    }
    
    /** 
     * Returns the index of the specified element
     *
     * @param element the element we're looking for
     * @return the index of the element in the list, or -1 
     * if it is not contained within the list
     */
    public int indexOf(T element) {
        int idx = 0;
        
        for (Node i = head; i != null; i = i.next) {
            if (i.data.equals(element)) return idx;
            idx++;
        }
        return -1;
    }
    
    public static void main(String[] args) {
       
        //testing code
        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.add(5);
        myList.add(1);
        myList.add(3);
        myList.add(10);
        myList.add(1, 534);
        myList.add(1, 53);
        myList.add(0, 55555);
        //myList.remove(1);
        System.out.println(myList.contains(5));
    }
}