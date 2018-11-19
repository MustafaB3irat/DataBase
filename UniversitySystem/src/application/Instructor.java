package application;

import java.time.LocalDate;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Instructor implements Comparable<Instructor> {

	private SimpleStringProperty name;
	private SimpleIntegerProperty id;
	private SimpleStringProperty address;
	private SimpleDoubleProperty salary;
	private LocalDate startDate;
	private LocalDate DOB;
	private SimpleStringProperty Field;
	private SimpleStringProperty department;
	private Tree<Course> courses;

	public Instructor(String name, int id, String address, double salary, LocalDate startDate, LocalDate dOB,
			String field, String department, Tree<Course> courses) {
		super();
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleIntegerProperty(id);
		this.address = new SimpleStringProperty(address);
		this.salary = new SimpleDoubleProperty(salary);
		this.startDate = startDate;
		DOB = dOB;
		Field = new SimpleStringProperty(field);
		this.department = new SimpleStringProperty(department);
		this.courses = courses;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public Instructor() {
		super();
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
		;
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
		;
	}

	public String getAddress() {
		return address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
		;
	}

	public double getSalary() {
		return salary.get();
	}

	public void setSalary(double salary) {
		this.salary.set(salary);
		;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getField() {
		return Field.get();
	}

	public void setField(String field) {
		Field.set(field);
		;
	}

	public String getDepartment() {
		return department.get();
	}

	public void setDepartment(String department) {
		this.department.set(department);
		;
	}

	public Tree<Course> getCourses() {
		return courses;
	}

	public void setCourses(Tree<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int compareTo(Instructor o) {

		if (this.name.toString().compareTo(o.name.toString()) > 0)
			return 1;

		else if (this.name.toString().compareTo(o.name.toString()) < 0)
			return -1;
		else
			return 0;

	}

}
