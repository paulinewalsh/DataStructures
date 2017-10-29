import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<? super T>> {

	private Node<T> top;

	public BinarySearchTree() {
		top = null;
	}

	public boolean insert(T data) {
		Node<T> newNode = new Node<T>(data, null, null);
		if (top == null) {
			top = newNode;
		}
		else {
			Node<T> current = top;
			Node<T> previous = current;
			while (current != null) {
				previous = current;
				if (current.data.compareTo(data) > 0) {
					current = current.left;
				}
				else {
					current = current.right;
				}

			}
			if (previous.data.compareTo(data)) == 0) {
				return false;
			}
			if (previous.data.compareTo(data) > 0) {
				previous.left = newNode;
				System.out.println("Inserted " + data + " as left child of " + previous.data);
			}
			else {
				previous.right = newNode;
				System.out.println("Inserted " + data + " as rigth child of " + previous.data);
			}
		}

	}

	


	private static class Node<T>{
		private T data;
		private Node<T> left;
		private Node<T> right;

		private Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}


	}



	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(50);
		tree.insert(20);
		tree.insert(70);
	}

}