package application;

public class Queue<T> {

	Node<T> first;
	Node<T> last;

	public void enqueue(T Data) {

		if (isEmpty(this)) {
			first = last = new Node<T>(Data);

			return;
		}

		Node<T> newNode = new Node<>(Data);

		last.next = newNode;
		last = newNode;

		return;
	}

	public void Enqueue(T Data) {

		if (isEmpty(this)) {
			first = last = new Node<T>(Data);

			return;
		}

		Node<T> newNode = new Node<>(Data);

		newNode.next = first;
		first = newNode;

		return;
	}

	public void enqueueCircular(T Data) {

		if (isEmpty(this)) {
			first = last = new Node<T>(Data);
			last.next = first;

			return;
		}

		Node<T> newNode = new Node<>(Data);

		last.next = newNode;
		last = newNode;
		last.next = first;

		return;
	}

	public Node<T> dequeue() {

		Node<T> front = first;

		if (first == last) {

			first = null;
			last = null;

			return front;

		}

		if (!isEmpty(this) && first != last) {

			first = first.next;

			return front;
		}

		return null;
	}

	public Node<T> dequeueCircular() {

		Node<T> front = first;

		if (first == last) {

			first = null;
			last = null;

			return front;

		}

		if (!isEmpty(this) && first != last) {

			first = first.next;
			last.next = first;

			return front;
		}

		return null;
	}

	public boolean isEmpty(Queue<T> q) {

		return (q.first == null && q.last == null);
	}

	public Node<T> getFront() {

		return first;
	}

	public int length() {

		int count = 0;

		Node<T> temp = first;

		if (!isEmpty(this)) {
			while (temp != null) {

				count++;

				temp = temp.next;

			}

			return count;

		}

		return -1;
	}

	public void traverse() {

		if (!isEmpty(this)) {

			Node<T> temp = first;

			while (temp != null) {
				System.out.println(temp.Data + "-->");

				temp = temp.next;
			}

			return;
		}

		System.out.println("This Queue is Empty!");

		return;
	}

	public void Enqueue(Node<T> node) {

		if (isEmpty(this)) {
			first = last = node;
			return;
		}

		last.next = node;
		last = node;
	}

	public void reverse(Queue<T> s) {

		System.out.println("HElaaafdaffljfsllflo");

		Node<T> temp;

		if (!isEmpty(s)) {

			temp = s.dequeue();

			reverse(s);

			s.Enqueue(temp);

		}

	}

}
