import java.lang.StringBuilder;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

/** 
 * LinkedList implementation using generics.
 *
 * @author Pauline Walsh
 * @version 1.0 2017.10.27
 */
public class LinkedList<T extends Comparable> implements Iterable<T>{

    protected Node<T> head;
    private int length;

    /** No-arg constructer to initialize an empty list.*/
    public LinkedList() {
        head = null;
        length = 0;
    }

    /** @param data     the data to use for the first node in a new list. */
    public LinkedList(T data) {
        insert(data);
    }

    /** @return     length of list */
    public int length() {
        return length;
    }

    /** Insert a new node at the head of the list.
     *  @param data     the data for the node.
     */
    public void insert(T data) {
        Node<T> next = null;        
        if (head != null) {
            next = head;
        }
        Node<T> n = new Node<T>(data, next);
        head = n;
        length++;
    }

    /** Check to see if the list contains an element.
     *  @param data     the data to look for.
     *  @return         true if found, else false
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** Delete a node from the list
     *  @param data     the data that the node to be deleted holds.
     *  @return         true if the node was found and deleted, otherwise false
     */
    public boolean delete(T data) {
        Node<T> current = head;
        Node<T> previous = current;
        while (current != null) {
            if (current.data == data) {
                Node<T> next = current.next;
                previous.next = next;
                length--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** Get data from node at index.
     *  @param      index of node to retrieve data from.
     *  @return     data from node at index, or null if index is invalid.
     */ 
    public T get(int index) {
        if (index >= length || index < 0) {
            return null;
        }
        Node<T> current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public LinkedListIterator iterator() {
        return new LinkedListIterator();
    }




    /** Get a string containing the data from every node in the list.
     *  @return         String representation of list.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("List Contents:  ");
        Node<T> current = head; 
        while (current != null) {
            s.append(current    .data);
            s.append(", ");
            current = current.next;
        }
        String listString = s.substring(0, s.length()-2);
        return listString;
    }


    private class LinkedListIterator implements Iterator<T> {
        private Node<T> previous;
        private Node<T> current;
        private Node<T> next;

        public LinkedListIterator() {
            previous = null;
            current = null;
            next = head;
        }

        public boolean hasNext() {
            return next != null;
        }

        public T next() {
            if (!hasNext()) 
                throw new NoSuchElementException();
            previous = current;
            current = next;
            next = current.next;
            return current.data;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        System.out.println();
        LinkedList<Integer>list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        System.out.println(list.toString());
        list.delete(3);
        list.insert(10);
        System.out.println(list.toString());
        System.out.println("List contains 3: " + list.contains(3));
        System.out.println("List contains 42 " + list.contains(42));
        int last = list.length-1;
        System.out.println("Node at index " + last + " data: " + list.get(last));

        Iterator iterator = list.iterator();
        for (int i : list) {
            System.out.println(i);
        }
    }

}