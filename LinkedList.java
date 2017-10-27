import java.lang.StringBuilder;

/** 
 * LinkedList implementation using generics.
 *
 * @author Pauline Walsh
 * @version 1.0 2017.10.27
 */


public class LinkedList<T> {

	private Node<T> head;
	private int length;

	/** No-arg constructer to initialize an empty list.*/
	public LinkedList() {
		head = null;
		length = 0;
	}

	/** @param data		the data to use for the first node in a new list. */
	public LinkedList(T data) {
		insert(data);
	}

	/** @return		length of list */
	public int getLength() {
		return length;
	}

	/** Insert a new node at the head of the list.
	 *  @param data		the data for the node.
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
	 *  @param data		the data to look for.
	 *  @return 		true if found, else false
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
	 *  @param data		the data that the node to be deleted holds.
	 *  @return 		true if the node was found and deleted, otherwise false
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

	/** Get a string containing the data from every node in the list.
	 *  @return 		String representation of list.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("List Contents:  ");
		Node<T> current = head; 
		while (current != null) {
			s.append(current	.data);
			s.append(", ");
			current = current.next;
		}
		String listString = s.substring(0, s.length()-2);
		return listString;
	}

	/** Private inner Node class for holding data and reference to next node.*/
	private static class Node<T> {

		private T data;
		private Node<T> next;

		/** Node constructor 
		 *  @param data		data for node to hold
		 *  @param next		reference to next node
		 */
		private Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}


	public static void main(String[] args) {
		System.out.println();
		LinkedList<Object>list = new LinkedList<Object>();
		list.insert(1);
		list.insert("two");
		list.insert(3);
		list.insert(4);
		System.out.println(list.toString());
		list.delete(3);
		list.insert('a');
		System.out.println(list.toString());
		System.out.println("List contains a: " + list.contains('a'));
		System.out.println("List contains b: " + list.contains(42));
	}

}