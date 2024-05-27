package stack;

public class LinkedListStack<E> implements Stack<E> {

	private static class Node<T> {
		T data;
		Node<T> next;

		// Constructor to initialize node
		Node(T data) {
			this.data = data;
		}

		/**
		 * toString method that matches test cases for easy testing.
		 */
		@Override
		public String toString() {
			return ((next == null) ? "" : next.toString() + "-") + data.toString();
		}
	}

	Node<E> top;

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public E top() throws Underflow {
		if (isEmpty()) {
			throw new Underflow();
		}
		return top.data;
	}

	@Override
	public void push(E element) {
		Node<E> newNode = new Node<>(element);
		newNode.next = top;
		top = newNode;
	}

	@Override
	public E pop() throws Underflow {
		if (isEmpty()) {
			throw new Underflow();
		}
		E data = top.data;
		top = top.next;
		return data;
	}

	/**
	 * toString method that matches test cases for easy testing.
	 *
	 * @return String representation of the stack
	 */
	@Override
	public String toString() {
		if (top == null) {
			return "<empty>";
		}
		StringBuilder result = new StringBuilder();
		Node<E> current = top;
		while (current != null) {
			result.insert(0, current.data);
			if (current.next != null) {
				result.insert(0, "-");
			}
			current = current.next;
		}
		return "<stack: " + result.toString() + ">";
	}
}
