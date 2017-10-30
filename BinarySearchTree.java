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
			if (previous.data.compareTo(data) == 0) {
				return false;
			}
			if (previous.data.compareTo(data) > 0) {
				previous.left = newNode;
				System.out.println("Inserted " + data + " as left child of " + previous.data);
			}
			else {
				previous.right = newNode;
				System.out.println("Inserted " + data + " as right child of " + previous.data);
			}
		}
		return true;

	}

	// if node to delete has 2 children must find two places for them
	public boolean delete(T data) {
		Node<T> current = top;
		Node<T> previous = top;
		boolean leftNode = false;
		if (current.data == data) {
			top = current.left;
			return true;
		}
		while (current != null) {
			if (current.data.compareTo(data) == 0) {
				break;
			}
			if (current.data.compareTo(data) < 0) {
				current = current.right;
			}	
			else {
				current = current.left;
			}
		}
		if (current == null) return false;

		if (previous.left != null && previous.left.data.compareTo(current.data) == 0) {
			leftNode = true;
		}
		else {
			leftNode = false;
		}

		// for leaf node, check if it is left or right child of parent and set to null
		if (current.left == null && current.right == null) {
			if (leftNode) {
				previous.left = null;
			}
			else {
				previous.right = null;
			}
		}

		//  Node to delete has one child 
		else if (current.right == null) {
			if (leftNode) {
				previous.left = current.left;
			}
			else {
				previous.right = current.left;
			}
		}

		else if (current.left == null) {
			if (leftNode) {
				previous.left = current.right;
			}
			else {
				previous.right = current.right;
			}
		}

		// Node to delete has two children. 
		else {
			Node<T> minParent = getMinimumParent(current);
			if (leftNode) {
				previous.left = minParent.left;
			}
			else {
				previous.right = minParent.left;
			}
			minParent.left = null;
		}
		return true;
	} 


	private Node<T> getMinimumParent(Node<T> root) {
		Node<T> previous = root;
		while (root.left != null) {
			previous = root;
			root = root.left;
		}
		return previous;
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
		int[] nums = {50, 20, 70, 30, 100, 10, 2, 8, 55, 37};
		for (int i = 0; i < nums.length; i++) {
			tree.insert(nums[i]);
		}
		tree.delete(70);
	}

}