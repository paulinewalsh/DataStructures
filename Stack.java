/** 
 * Stack implementation using generics.
 *
 * @author Pauline Walsh
 * @version 1.0 2017.10.27
 */
public class Stack<T> {
	private LinkedList<T> stack;

	public Stack() {
		stack = new LinkedList<T>();
	}

	public Stack(T data) {
		stack = new LinkedList<T>(data);
	}

	public void push(T data) {
		stack.insert(data);
	}

	public T pop() {
		T data = this.peek();		
		return data;
	}

	public T peek() {
		T data = stack.get(0);
		return data;
	}


	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(0);
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		int top = stack.peek();
		assert top == 9;
		top = stack.pop();
		assert top == 9;
		top = stack.pop();
		assert top == 8;
	}

}