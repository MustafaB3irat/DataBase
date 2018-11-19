package application;

public class Tree<T extends Comparable<T>> {

	private TNode<T> root;

	public Tree() {

		root = null;
	}

	public void insert(T element) {// now we need to think how to connect this with the root, so i used utility
		// function

		root = insertT(root, element);

	}

	private TNode<T> insertT(TNode<T> x, T element) {

		if (x == null) {
			x = new TNode<T>(element);

			return x;
		}

		if (x.Data instanceof Instructor) {

			if (((Instructor) x.Data).getName().compareTo(((Instructor) element).getName()) > 0)
				x.setLeft(insertT(x.getLeft(), element));

			else if (((Instructor) x.Data).getName().compareTo(((Instructor) element).getName()) < 0)
				x.setRight(insertT(x.getRight(), element));

		}

		else if (x.Data instanceof Course) {

			if (((Course) x.Data).getId() > ((Course) element).getId())
				x.setLeft(insertT(x.getLeft(), element));

			else if (((Course) x.Data).getId() < ((Course) element).getId())
				x.setLeft(insertT(x.getRight(), element));
		}

		else if (x.Data instanceof Student) {

			if (((Student) x.Data).getId() > ((Student) element).getId())
				x.setLeft(insertT(x.getLeft(), element));

			else if (((Student) x.Data).getId() < ((Student) element).getId())
				x.setRight(insertT(x.getRight(), element));

		}

		return x;

	}

	public TNode<T> Delete(int code) {

		return Delete(root, code);
	}

	public TNode<T> Delete(TNode<T> x, int code) {

		if (this.Find(code) == null) {
			System.out.println("Not Found!");
			return null;
		}

		TNode<T> curr = root;
		TNode<T> parent = root;
		boolean isLeft = false;

		if (x.Data instanceof Instructor) {

			while (curr != null && !(((Instructor) curr.Data).getId() == code)) {

				curr = parent;

				if (((Instructor) curr.Data).getId() > code) {

					curr = curr.getLeft();

					isLeft = true;
				}

				else if (((Instructor) curr.Data).getId() < code) {

					curr = curr.getRight();

					isLeft = false;
				}

			}

		}

		if (x.Data instanceof Course) {

			while (curr != null && !(((Course) curr.Data).getId() == code)) {

				curr = parent;

				if (((Course) curr.Data).getId() > code) {

					curr = curr.getLeft();

					isLeft = true;
				}

				else if (((Course) curr.Data).getId() < code) {

					curr = curr.getRight();

					isLeft = false;
				}

			}

		}

		if (x.Data instanceof Student) {

			while (curr != null && !(((Student) curr.Data).getId() == code)) {

				curr = parent;

				if (((Student) curr.Data).getId() > code) {

					curr = curr.getLeft();

					isLeft = true;
				}

				else if (((Student) curr.Data).getId() < code) {

					curr = curr.getRight();

					isLeft = false;
				}

			}

		}

		// case1:Node is leaf

		if (isLeaf(curr)) {

			if (curr == root)
				root = null;

			if (isLeft)
				parent.setLeft(null);

			else
				parent.setRight(null);

			return curr;

		}

		// case2: Node has left and !right

		if (curr.getLeft() != null && curr.getRight() == null) {

			if (curr == root)
				root = curr.getLeft();

			else if (isLeft)
				parent.setLeft(curr.getLeft());

			else
				parent.setRight(curr.getLeft());

			return curr;
		}

		// case3: Node has right and !left

		if (curr.getRight() != null && curr.getLeft() == null) {

			if (curr == root)
				root = curr.getRight();

			else if (isLeft)
				parent.setLeft(curr.getRight());

			else
				parent.setRight(curr.getRight());

			return curr;

		}

		// case4: Node has children left and right...

		else if (curr.getRight() != null && curr.getLeft() != null) {

			TNode<T> successer = getSuccesser(curr);

			if (curr == root)
				root = successer;

			else if (isLeft)
				parent.setLeft(successer);

			else
				parent.setRight(successer);

			successer.setLeft(curr.getLeft());

			return curr;

		}

		return null;

	}

	private TNode<T> getSuccesser(TNode<T> node) {

		TNode<T> ps = node;
		TNode<T> s = node;
		TNode<T> c = node.getRight();

		while (c != null) {

			ps = s;
			s = c;
			c = c.getLeft();
		}

		if (s != node.getRight()) {

			ps.setLeft(s.getRight());
			s.setRight(node.getRight());
		}

		return s;

	}

	private boolean isLeaf(TNode<T> x) {

		return (x.getLeft() == null && x.getRight() == null);
	}

	public boolean isEmpty() {

		return (root == null);
	}

	public void inOrder() {// using utility function -_-

		inOrder(root);

	}

	int i = 1, j = 1, h = 1;

	@SuppressWarnings("unchecked")
	private void inOrder(TNode<T> x) {

		if (x != null) {

			inOrder(x.getLeft());

			if (x.Data instanceof Instructor) {

				System.out.println(i + "." + ((Instructor) x.Data).getName() + "   " + ((Instructor) x.Data).getId()
						+ "  " + ((Instructor) x.Data).getDOB() + "  " + ((Instructor) x.Data).getAddress() + "  "
						+ ((Instructor) x.Data).getSalary() + "  " + ((Instructor) x.Data).getStartDate() + "  "
						+ ((Instructor) x.Data).getField() + " " + ((Instructor) x.Data).getDepartment() + " ");

				inOrder((TNode<T>) ((Instructor) x.Data).getCourses().root);
				i++;

			}

			if (x.Data instanceof Course) {

				System.out.println(j + "." + ((Course) x.Data).getName() + "   " + ((Course) x.Data).getId() + "  "
						+ ((Course) x.Data).getHours() + "  " + "  ");

				inOrder((TNode<T>) ((Course) x.Data).students.root);
				j++;

			}

			if (x.Data instanceof Student) {

				System.out.println(h + "." + ((Student) x.Data).getName() + "   " + ((Student) x.Data).getId() + "  "
						+ ((Student) x.Data).getDOB() + "  " + ((Student) x.Data).getAddress() + "  " + "  "
						+ ((Student) x.Data).getGender() + "  " + ((Student) x.Data).getMajor() + " "
						+ ((Student) x.Data).getMajorYears() + " " + ((Student) x.Data).getJoinDate() + " ");

				h++;

			}

			inOrder(x.getRight());
		}

		if (root == null)
			System.out.println("This tree is Empty!");

	}

	public TNode<T> Find(int code) {

		return find(root, code);
	}

	private TNode<T> find(TNode<T> x, int code) {

		if (x.Data instanceof Instructor) {

			if (x == null || ((Instructor) x.Data).getId() == code) {

				return x;
			}

			else if (((Instructor) x.Data).getId() > code)
				return find(x.getLeft(), code);

			else
				return find(x.getRight(), code);

		}

		if (x.Data instanceof Course) {

			if (x == null || ((Course) x.Data).getId() == code) {

				return x;
			}

			else if (((Course) x.Data).getId() > code)
				return find(x.getLeft(), code);

			else
				return find(x.getRight(), code);

		}

		if (x.Data instanceof Student) {

			if (x == null || ((Student) x.Data).getId() == code) {

				return x;
			}

			else if (((Student) x.Data).getId() > code)
				return find(x.getLeft(), code);

			else
				return find(x.getRight(), code);

		}

		return x;

	}

	public int countleafs() {

		return countleafs(root);
	}

	int leafsCounter = 0;

	private int countleafs(TNode<T> x) {

		if (x.getLeft() == null && x.getRight() == null)
			return 1;

		if (root == null)
			return 0;

		if (x != null) {

			leafsCounter += countleafs(x.getRight());
			leafsCounter += countleafs(x.getLeft());

		}

		return leafsCounter;

	}

	public int countItems() {

		return countItems(root);
	}

	int ItemsCounter = 0;

	private int countItems(TNode<T> x) {

		if (root == null)
			return 0;

		if (x != null) {

			ItemsCounter += countleafs(x.getRight());
			ItemsCounter += countleafs(x.getLeft());

			ItemsCounter++;

		}

		return ItemsCounter;

	}

	public TNode<T> getRoot() {
		return root;
	}

	public void setRoot(TNode<T> root) {
		this.root = root;
	}

	// ----------------------------------------------------------------------------------------------------

}