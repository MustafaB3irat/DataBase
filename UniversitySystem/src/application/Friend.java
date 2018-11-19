package application;

import java.time.LocalDate;

public class Friend {

	private String name;
	private int id;
	private char gender;
	private LocalDate DOB;

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public Friend() {

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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Friend(String name, int id, char gender, LocalDate DOB) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.DOB = DOB;
	}

}
