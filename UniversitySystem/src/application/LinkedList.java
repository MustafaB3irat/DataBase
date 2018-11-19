package application;

public class LinkedList<T> {

	private Node<T> first;
	private Node<T> last;

	private int counter;

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean addFirst(T element) {

		if (this.counter == 0 || first == null) {
			Node<T> current = new Node<>(element);
			first = last = current;
			counter++;

			return true;

		}

		Node<T> current = new Node<>(element);
		current.next = first;

		first = current;
		counter++;

		return true;
	}

	public boolean addLast(T element) {

		if (counter == 0 || first == null) {
			first = last = new Node<T>(element);
			counter++;
			return true;
		}

		Node<T> item = new Node<T>(element);

		last.next = item;
		item.next = null;
		last = item;

		counter++;

		return true;
	}

	public boolean addAtIndex(T element, int index) {

		if (index == 0 || first == null) {
			addFirst(element);
			return true;
		}

		if (index >= counter) {

			addLast(element);
			return true;
		}

		else {
			Node<T> temp = first;

			for (int i = 0; i < index; i++)

				temp = temp.next;

			Node<T> Item = new Node<T>(element);

			Item.next = temp.next;
			temp.next = Item;

			counter++;

			return true;
		}

	}

	public Node<T> removefirst() {

		if (counter == 0 || first == null)
			return null;

		Node<T> node = first;

		first.Data = null;
		first = first.next;
		counter--;
		return node;

	}

	public Node<T> removeLast() {

		if (counter == 0 || first == null)
			return null;

		Node<T> Temp = first;

		for (int i = 0; i < counter - 1; i++)
			Temp = Temp.next;

		Node<T> node = Temp.next;

		last = Temp;
		Temp.next = null;
		counter--;

		return node;
	}

	public Node<T> find(T element) {

		Node<T> temp = this.first;

		while (temp != null) {
			if (element.toString().equals(temp.Data.toString()))
				return temp;
			temp = temp.next;
		}

		return null;

	}

	public Node<T> remove(T element) {

		Node<T> temp = this.first;
		Node<T> node = null;

		if (element.equals(this.first.Data))
			node = this.removefirst();

		else if (element.equals(this.last.Data)) {
			node = this.removeLast();

		}

		else {

			while (temp != null) {

				if (temp.next.Data.equals(element)) {

					node = temp.next;

					temp.next = temp.next.next;

				}

			}
		}

		return node;

	}
}
