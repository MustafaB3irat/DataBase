package application;

public class Course implements Comparable<Course> {

	private String name;
	private int id;
	private int hours;
	public Tree<Student> students;

	public Course(String name, int id, int hours, Tree<Student> students) {
		super();
		this.name = name;
		this.id = id;
		this.hours = hours;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Tree<Student> getStudents() {
		return students;
	}

	public void setStudents(Tree<Student> students) {
		this.students = students;
	}

	@Override
	public int compareTo(Course o) {

		return this.id - o.id;
	}

}
