package application;

import java.time.LocalDate;

public class Student implements Comparable<Student> {

	private String name;
	private int id;
	private String address;
	private String major;
	private LocalDate joinDate;
	private int majorYears;
	private LocalDate DOB;
	private char gender;
	public Stack<ToDo> toDo;
	public Queue<Friend> friends;

	public Student() {

	}

	public Student(String name, int id, String address, String major, LocalDate joinDate, int majorYears, LocalDate DOB,
			char gender, Stack<ToDo> toDo, Queue<Friend> friends) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.major = major;
		this.joinDate = joinDate;
		this.majorYears = majorYears;
		this.DOB = DOB;
		this.gender = gender;
		this.toDo = toDo;
		this.friends = friends;
	}

	public Stack<ToDo> getToDo() {
		return toDo;
	}

	public void setToDo(Stack<ToDo> toDo) {
		this.toDo = toDo;
	}

	public Queue<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Queue<Friend> friends) {
		this.friends = friends;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public int getMajorYears() {
		return majorYears;
	}

	public void setMajorYears(int majorYears) {
		this.majorYears = majorYears;
	}

	@Override
	public int compareTo(Student o) {

		return this.id - o.id;
	}

}
