package application;

import java.time.LocalDate;

public class ToDo {

	private String type;
	private LocalDate startDate;
	private LocalDate dueDate;

	public ToDo() {

	}

	public ToDo(String type, LocalDate startDate, LocalDate dueDate) {
		super();
		this.type = type;
		this.startDate = startDate;
		this.dueDate = dueDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
