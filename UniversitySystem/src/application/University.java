package application;

import java.time.LocalDate;

public class University {

	private String name;
	private String ID;
	private String location;
	private String mailBox;
	private LocalDate establishDate;
	private Tree<Instructor> instructors;

	public University(String name, String iD, String location, String mailBox, LocalDate establishDate,
			Tree<Instructor> instructors) {
		super();
		this.name = name;
		ID = iD;
		this.location = location;
		this.mailBox = mailBox;
		this.establishDate = establishDate;
		this.instructors = instructors;
	}

	public University() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMailBox() {
		return mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}

	public LocalDate getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(LocalDate establishDate) {
		this.establishDate = establishDate;
	}

	public Tree<Instructor> getInstructors() {
		return instructors;
	}

	public  void setInstructors(Tree<Instructor> instructors) {
		this.instructors = instructors;
	}

	

}
