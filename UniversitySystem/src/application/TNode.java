package application;

public class TNode<T extends Comparable<T>> implements Comparable<T> {

	private TNode<T> left;

	 private TNode<T> right;

	T Data;

	public TNode(T x) {
		this.Data = x;

	}

	@Override
	public int compareTo(T o) {

		return o.compareTo(Data);
	}

	public TNode<T> getLeft() {
		return left;
	}

	public void setLeft(TNode<T> left) {
		this.left = left;
	}

	public TNode<T> getRight() {
		return right;
	}

	public void setRight(TNode<T> right) {
		this.right = right;
	}
	
	

}