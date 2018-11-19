package application;


public class Stack<T> {

	Node<T> first;

	Node<T> last;

	public void push(T element) {

		Node<T> node = new Node<>(element);

		if (isEmpty()) {
			first = last = node;
			return;
		}

		node.next = first;
		first = node;
		return;
	}

	public void Push(T element) {

		Node<T> temp = new Node<>(element);

		if (isEmpty()) {
			first = last = temp;
			return;
		}

		last.next = temp;
		last = temp;
		
	}

	public T pop() {

		if (isEmpty())
			return null;

		Node<T> temp = first;

		first = first.next;

		return temp.Data;

	}

	public Node<T> Pop() {

		if (isEmpty())
			return null;

		Node<T> temp = first;

		first = first.next;

		return temp;

	}

	public int length() {

		int counter = 0;
		Node<T> temp = first;

		while (temp != null) {
			counter++;

			temp = temp.next;
		}

		return counter;

	}

	public boolean isEmpty() {

		return first == null;
	}

	public Node<T> search(T element) {

		if (!isEmpty()) {

			Node<T> temp = first;

			while (first.next != null) {

				if (temp.Data.toString().equals(element.toString()))
					return temp;

				temp = temp.next;
			}

		}

		return null;
	}

	public boolean isTop(T element) {

		if (!isEmpty()) {

			return first == element;
		}

		return false;
	}

	public Node<T> getTop() {

		if (!isEmpty()) {

			return first;
		}

		return null;
	}

	public T GetTop() {

		if (!isEmpty()) {

			return first.Data;
		}

		return null;
	}

	public void traverseStack() {

		if (!isEmpty()) {

			Node<T> curr = first;

			while (curr != null) {

				System.out.print(curr.Data.toString() + "-->");

				curr = curr.next;

			}
		}

		return;
	}

	public void reverse() {
		Node<T> previous, current, after;
		current = previous = this.first;
		current = current.next;
		previous.next = null;
		while (current != null) {

			after = current.next;
			current.next = previous;
			previous = current;
			current = after;
		}
		this.first = previous;
	}

}
