package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class insCourseController {

	@FXML
	private Button insCourseRelatedAddCourse, insCourseRelatedDeleteCourse, insCourseRelatedFindCourse,
			insCourseRelatedShowCourses;

	@FXML
	private TextField insCourseRelatedInsId;

	@FXML
	private TableView<Course> courseTableView, CourseAddTableView;

	@FXML
	private TableColumn<Course, String> insCourseRelatedCourseNameColumn, CourseNameColumn;

	@FXML
	private TableColumn<Course, Integer> insCourseRelatedCourseIdColumn, insCourseRelatedCourseHoursColumn,
			CourseIdColumn, CourseHoursColumn;

	@FXML
	private Button insCourseRelatedCourseAdd, insCourseRelatedCourseAdd1, insCourseRelatedExit;

	@FXML
	private TextField insCourseRealtedCourseName, inCourseRelatedCourseId, inCourseRelatedCourseHours,
			insCourseRelatedCourseInsId, inCourseRelatedInsId1;

	@FXML
	private Label click;

	private Tree<Course> courses = new Tree<Course>();

	private ObservableList<Course> CourseAddTableViewData = FXCollections.observableArrayList();

	public void initialized1() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		CourseAddTableView.getItems().clear();

		CourseIdColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("id"));
		CourseNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
		CourseHoursColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Hours"));

		try {

			CourseAddTableView.setItems(data());

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("You Should Have Added Courses In the Main Interface!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();
		}

	}

	private ObservableList<Course> data() {

		Node<Course> temp = CourseInterfaceController.Courses.getFirst();

		while (temp != null) {

			CourseAddTableViewData.add(temp.Data);
			temp = temp.next;

		}

		return CourseAddTableViewData;
	}

	public void addCourseFromTableView() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (inCourseRelatedInsId1.getText().equals(""))
				throw new Exception();

			else {

				TNode<Instructor> temp = UniversityController.university.getInstructors()
						.Find(Integer.parseInt(inCourseRelatedInsId1.getText()));

				if (temp.Data.getCourses() == null)
					temp.Data.setCourses(courses);

				temp.Data.getCourses().insert(CourseAddTableView.getSelectionModel().getSelectedItem());

				AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
				iudio.play();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully Added!");
				alert.setTitle("Success!");
				alert.setHeaderText(null);
				alert.setResizable(false);

				alert.initModality(Modality.APPLICATION_MODAL);

				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
						.add(new Image("/application/confirm.png"));
				alert.showAndWait();

			}

		} catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please Select From Table! Or Check The Entries!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}
	}

	public void insCourseRelatedAddCourse() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (insCourseRealtedCourseName.getText().equals("") || inCourseRelatedCourseId.getText().equals("")
					|| inCourseRelatedCourseHours.getText().equals("")
					|| insCourseRelatedCourseInsId.getText().equals(""))
				throw new Exception();

			else {

				TNode<Instructor> temp = UniversityController.university.getInstructors()
						.Find(Integer.parseInt(insCourseRelatedCourseInsId.getText()));

				if (temp.Data.getCourses() == null)
					temp.Data.setCourses(courses);

				temp.Data.getCourses()
						.insert(new Course(insCourseRealtedCourseName.getText(),
								Integer.parseInt(inCourseRelatedCourseId.getText()),
								Integer.parseInt(inCourseRelatedCourseHours.getText()), null));

				AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
				iudio.play();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully Added!");
				alert.setTitle("Success!");
				alert.setHeaderText(null);
				alert.setResizable(false);

				alert.initModality(Modality.APPLICATION_MODAL);

				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
						.add(new Image("/application/confirm.png"));
				alert.showAndWait();

			}

		} catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Not Found! , please check the fields");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	public void insCourseRelatedExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage mainStage = (Stage) insCourseRelatedExit.getScene().getWindow();

		mainStage.close();
	}

	public void showInsCourseRelatedAdd() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/insCourseRelatedAddCourse.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 561, 390);

		Stage stage = new Stage();
		stage.setTitle("Add A Course To An Ins");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();
	}

	// ------------------------------------------Instructor Course Related Find
	// Course...

	@FXML
	private Button insCourseRelatedFindCourseExit, insCourseRelatedFindCourseFind;

	@FXML
	private TextField insCourseRelatedFindCourseId, insCourseRelatedFindInsId;

	public void insCourseRelatedFindCourse() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (insCourseRelatedFindCourseId.getText().equals("") || insCourseRelatedFindInsId.getText().equals(""))
				throw new Exception();

			else {

				TNode<Instructor> temp = UniversityController.university.getInstructors()
						.Find(Integer.parseInt(insCourseRelatedFindInsId.getText()));

				TNode<Course> course = temp.Data.getCourses()
						.Find(Integer.parseInt(insCourseRelatedFindCourseId.getText()));

				if (course == null)
					throw new Exception();

				AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
				iudio.play();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully Found! Course with Name: " + course.Data.getName() + " "
						+ " And Id: " + course.Data.getId());
				alert.setTitle("Success!");
				alert.setHeaderText(null);
				alert.setResizable(false);

				alert.initModality(Modality.APPLICATION_MODAL);

				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
						.add(new Image("/application/confirm.png"));
				alert.showAndWait();

			}

		} catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Not Found! , please check the fields");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	public void insCourseRelatedFindCourseExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) insCourseRelatedFindCourseExit.getScene().getWindow();
		main.close();
	}

	public void showInsCourseRelatedFindCourse() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/insCourseRelatedFindCourse.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 289);

		Stage stage = new Stage();
		stage.setTitle("Find A Course To An Ins");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	// ------------------------------------------------------ Instructor Related
	// Course Delete Course

	@FXML
	private Button insCourseRelatedDeleteDelete, insCourseRelatedDeleteExit;

	@FXML
	private TextField insCourseRelatedDeleteCourseId, insCourseRelatedDeleteCourseInsId;

	public void insCourseRelatedCourseDelete() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (insCourseRelatedDeleteCourseId.getText().equals("")
					|| insCourseRelatedDeleteCourseInsId.getText().equals(""))
				throw new Exception();

			else {

				TNode<Instructor> temp = UniversityController.university.getInstructors()
						.Find(Integer.parseInt(insCourseRelatedDeleteCourseInsId.getText()));

				TNode<Course> course = temp.Data.getCourses()
						.Delete(Integer.parseInt(insCourseRelatedDeleteCourseId.getText()));

				if (course == null)
					throw new Exception();

				AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
				iudio.play();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully Deleted! Course with Name: " + course.Data.getName() + " "
						+ " And Id: " + course.Data.getId());
				alert.setTitle("Success!");
				alert.setHeaderText(null);
				alert.setResizable(false);

				alert.initModality(Modality.APPLICATION_MODAL);

				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
						.add(new Image("/application/confirm.png"));
				alert.showAndWait();

			}

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Not Found! , please check the fields");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	public void insCourseRelatedDeleteCourseExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) insCourseRelatedDeleteExit.getScene().getWindow();

		main.close();

	}

	public void showInsCourseRelatedDeleteCourse() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/insCourseRelatedDeleteCourse.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 298);

		Stage stage = new Stage();
		stage.setTitle("Delete A Course To An Ins");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	// -----------------------------------Instructors Course Related Show Courses

	public void initialized() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		insCourseRelatedCourseNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
		insCourseRelatedCourseIdColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("id"));
		insCourseRelatedCourseHoursColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Hours"));

		try {
			data.clear();

			getData(UniversityController.university.getInstructors()
					.Find(Integer.parseInt(insCourseRelatedInsId.getText())).Data.getCourses().getRoot());

			courseTableView.setItems(data);

		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Empty!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	ObservableList<Course> data = FXCollections.observableArrayList();

	private void getData(TNode<Course> x) {

		if (x != null) {

			getData(x.getLeft());

			data.add(x.Data);

			getData(x.getRight());
		}

	}

	// ------------------------------------Students Related

	@FXML
	private Button insCourseRealtedStudentRelated;

	static Stage Students = new Stage();

	public void showStudentRelated() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/insCourseRelatedStudentRelated.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 916, 494);

		Students.setTitle("Students");
		Students.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		Students.setResizable(false);
		Students.setScene(s);

		Students.initModality(Modality.APPLICATION_MODAL);

		Students.show();

	}

	// -------------------------------------------main interface

	@FXML
	private TableView<Student> studentTableView, StudentTableView;

	@FXML
	private TableColumn<Student, String> studentNameColumn, studentAddressColumn, studentMajorColumn, StudentNameColumn,
			StudentAddressColumn, StudentMajorColumn;

	@FXML
	private TableColumn<Student, Integer> studentIdColumn, studentMajorYearsColumn, StudentIdColumn, StudentMajorYears;

	@FXML
	private TableColumn<Student, Character> studentGenderColumn, StudentGenderColumn;

	@FXML
	private TableColumn<Student, LocalDate> studentDOBColumn, studentJoinDateColumn, StudentDOBColumn,
			StudentJoinDateColumn;

	@FXML
	private TextField StudentRelatedCourseId;

	@FXML
	private Button studentRelatedShowStudent, studentRelatedAddStudent, studentRelatedFindStudent,
			studentRelatedDeleteStudent, studentRelatedToDo, studentRelatedFriends;

	// ---------------------------------Add

	public void showRelatedStudentAdd() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/AddStudent.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 929, 532);

		Stage stage = new Stage();
		stage.setTitle("Add A Student...");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	public void intializedStudent() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		StudentTableView.getItems().clear();

		StudentNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		StudentIdColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
		StudentAddressColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Address"));
		StudentMajorColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Major"));
		StudentJoinDateColumn.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("JoinDate"));
		StudentMajorYears.setCellValueFactory(new PropertyValueFactory<Student, Integer>("MajorYears"));
		StudentDOBColumn.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("DOB"));
		StudentGenderColumn.setCellValueFactory(new PropertyValueFactory<Student, Character>("Gender"));

		try {

			StudentTableView.setItems(dataStudent());

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("You Should Have Added Students In the main Interface!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();
		}
	}

	@FXML
	Label click1;

	ObservableList<Student> studentsData = FXCollections.observableArrayList();

	private ObservableList<Student> dataStudent() {

		Node<Student> temp = StudentInterfaceController.Students.getFirst();

		while (temp != null) {

			studentsData.add(temp.Data);
			temp = temp.next;

		}

		return studentsData;
	}

	public void addStudentFromTable() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (StudentAddInstructor1.getText().equals("") || StudentAddCourse1.getText().equals(""))
				throw new Exception();

			if (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(StudentAddInstructor1.getText())).Data.getCourses()
							.Find(Integer.parseInt(StudentAddCourse1.getText())).Data.getStudents() == null)

				UniversityController.university.getInstructors()
						.Find(Integer.parseInt(StudentAddInstructor1.getText())).Data.getCourses()
								.Find(Integer.parseInt(StudentAddCourse1.getText())).Data
										.setStudents(new Tree<Student>());

			UniversityController.university.getInstructors()
					.Find(Integer.parseInt(StudentAddInstructor1.getText())).Data.getCourses()
							.Find(Integer.parseInt(StudentAddCourse1.getText())).Data.getStudents()
									.insert(StudentTableView.getSelectionModel().getSelectedItem());

			AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Added Successfully!");
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please Select Row From Table If There's any Or Check The Entries!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}
	}

	@FXML
	private Button StudentAddExit, StudentAddAdd, StudentAddAdd1;

	@FXML
	private TextField StudentAddInstructor, StudentAddCourse, StudentAddName, StudentAddId, StudentAddAddress,
			StudentAddMajor, StudentAddStudentMajorYear, StudentAddInstructor1, StudentAddCourse1;

	@FXML
	private DatePicker StudentAddDOB, StudentAddStartDate;

	@FXML
	private RadioButton male, female;

	private char gender;

	public void addStudent() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		if (male.isSelected())
			gender = 'M';
		else if (female.isSelected())
			gender = 'F';

		try {

			if (StudentAddName.getText().equals("") || StudentAddId.getText().equals("")
					|| StudentAddAddress.getText().equals("") || StudentAddMajor.getText().equals("")
					|| StudentAddStudentMajorYear.getText().equals("") || StudentAddDOB.getValue() == null
					|| StudentAddStartDate.getValue() == null
					|| (male.isSelected() == false && female.isSelected() == false))
				throw new Exception();

			TNode<Course> temp = UniversityController.university.getInstructors()
					.Find(Integer.parseInt(StudentAddInstructor.getText())).Data.getCourses()
							.Find(Integer.parseInt(StudentAddCourse.getText()));

			if (temp.Data.getStudents() == null)
				temp.Data.setStudents(new Tree<Student>());

			temp.Data.getStudents()
					.insert(new Student(StudentAddName.getText(), Integer.parseInt(StudentAddId.getText()),
							StudentAddAddress.getText(), StudentAddMajor.getText(), StudentAddStartDate.getValue(),
							Integer.parseInt(StudentAddStudentMajorYear.getText()), StudentAddDOB.getValue(), gender,
							null, null));

			AudioClip Audio = new AudioClip("file:src/application/Success!.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully Added!");
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Error! , please check the fields");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}
	}

	public void StudentAddExit() {
		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) StudentAddExit.getScene().getWindow();
		main.close();

	}

	// -------------------------------------------Student Find

	@FXML
	private Button studentFindFind, studentFindExit;

	@FXML
	private TextField StudentFindInsId, StudentFindCourseId, StudentFindStudentId;

	public void StudentFind() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (StudentFindInsId.getText().equals("") || StudentFindCourseId.getText().equals("")
					|| StudentFindStudentId.getText().equals(""))
				throw new Exception();

			TNode<Student> temp = UniversityController.university.getInstructors()
					.Find(Integer.parseInt(StudentFindInsId.getText())).Data.getCourses()
							.Find(Integer.parseInt(StudentFindCourseId.getText())).Data.getStudents()
									.Find(Integer.parseInt(StudentFindStudentId.getText()));

			if (temp == null)
				throw new Exception();

			AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully Found! Student With Name: " + " " + temp.Data.getName() + " Id: "
					+ temp.Data.getId());
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Not Found! , please check the fields");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	public void showStudentFind() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/FindStudent.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 301);

		Stage stage = new Stage();
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setTitle("Find A Student...");
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	public void studentFindExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) studentFindExit.getScene().getWindow();
		main.close();
	}

	public void studentFindCLear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		StudentFindInsId.setText("");
		StudentFindCourseId.setText("");
		StudentFindStudentId.setText("");
	}

	// --------------------------------------------Delete Student

	@FXML
	Button studentDeleteDelete, studentDeleteExit;

	@FXML
	TextField studentDeleteInsId, studentDeleteCourseId, studentDeleteStudentId;

	public void showStudentDelete() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/DeleteStudent.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 312);

		Stage stage = new Stage();
		stage.setTitle("Delete A Student...");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();
	}

	public void studentDelete() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (studentDeleteInsId.getText().equals("") || studentDeleteCourseId.getText().equals("")
					|| studentDeleteStudentId.getText().equals(""))
				throw new Exception();

			TNode<Student> temp = UniversityController.university.getInstructors()
					.Find(Integer.parseInt(studentDeleteInsId.getText())).Data.getCourses()
							.Find(Integer.parseInt(studentDeleteCourseId.getText())).Data.getStudents()
									.Delete(Integer.parseInt(studentDeleteStudentId.getText()));

			if (temp == null)
				throw new Exception();

			AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully Deleted! Student With Name: " + " " + temp.Data.getName() + " Id: "
					+ temp.Data.getId());
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Not Found! , please check the fields");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	public void studentDeleteExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) studentDeleteExit.getScene().getWindow();

		main.close();
	}

	// --------------------------Show Students

	ObservableList<Student> studentData = FXCollections.observableArrayList();

	public void StudentsShow() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		studentNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		studentIdColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
		studentAddressColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
		studentMajorColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("major"));
		studentJoinDateColumn.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("joinDate"));
		studentMajorYearsColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("majorYears"));
		studentDOBColumn.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("DOB"));
		studentGenderColumn.setCellValueFactory(new PropertyValueFactory<Student, Character>("gender"));

		try {

			studentData.clear();

			getStudentData(UniversityController.university.getInstructors().getRoot().Data.getCourses()
					.Find(Integer.parseInt(StudentRelatedCourseId.getText())).Data.getStudents().getRoot());

			studentTableView.setItems(studentData);

		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Empty!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	private void getStudentData(TNode<Student> x) {

		if (x != null) {

			getStudentData(x.getLeft());

			studentData.add(x.Data);

			getStudentData(x.getRight());
		}

	}

	// --------------------------------Clears

	@FXML
	Circle courseClear, studentClear, insClear, courseFindClear, courseDeleteClear, courseRelatedAddCourseClear,
			studentFindClear, studentDeleteClear;

	public void clearCourseRelated() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		insCourseRelatedInsId.setText("");
		courseTableView.getItems().clear();
	}

	public void clearStudents() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		StudentRelatedCourseId.setText("");
		studentTableView.getItems().clear();
	}

	public void clearIns() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		StudentAddInstructor.setText("");
		StudentAddCourse.setText("");
		StudentAddName.setText("");
		StudentAddId.setText("");
		StudentAddAddress.setText("");
		StudentAddMajor.setText("");
		StudentAddStudentMajorYear.setText("");
		StudentAddDOB.setValue(null);
		StudentAddStartDate.setValue(null);
		male.setSelected(false);
		female.setSelected(false);
		StudentAddInstructor1.setText("");
		StudentAddCourse1.setText("");

	}

	public void courseFindClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		insCourseRelatedFindInsId.setText("");
		insCourseRelatedFindCourseId.setText("");
	}

	public void courseDeleteClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		insCourseRelatedDeleteCourseInsId.setText("");
		insCourseRelatedDeleteCourseId.setText("");

	}

	public void courseRelatedAddCourseClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		inCourseRelatedCourseId.setText("");
		insCourseRealtedCourseName.setText("");
		inCourseRelatedCourseHours.setText("");
		insCourseRelatedCourseInsId.setText("");
		inCourseRelatedInsId1.setText("");

	}

	public void studentDeleteClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		studentDeleteInsId.setText("");
		studentDeleteCourseId.setText("");
		studentDeleteStudentId.setText("");

	}

	// ----------------------------To Do's

	@FXML
	private TableView<ToDo> ToDoTableView;

	@FXML
	private TableColumn<ToDo, String> ToDoTypeColumn;

	@FXML
	private TableColumn<ToDo, LocalDate> ToDoStartDate, ToDoDueDate;

	public void showToDoInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/ToDoInterface.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 536, 391);

		Stage stage = new Stage();
		stage.setTitle("To Do");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	public void ToDoInterfaceClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		ToDoInsId.setText("");
		ToDoCourseId.setText("");
		ToDoStudentId.setText("");
		ToDoTableView.getItems().clear();
	}

	@FXML
	private TextField ToDoInsId, ToDoCourseId, ToDoStudentId;

	@FXML
	private Button ToDoShow, ToDoPush, ToDoPop;

	public void showToDo() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		ToDoTypeColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("type"));
		ToDoStartDate.setCellValueFactory(new PropertyValueFactory<ToDo, LocalDate>("startDate"));
		ToDoDueDate.setCellValueFactory(new PropertyValueFactory<ToDo, LocalDate>("dueDate"));

		try {

			toDo.clear();
			popData();
			ToDoTableView.setItems(toDo);
		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Empty!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}
	}

	// Show To Do Data ....

	ObservableList<ToDo> toDo = FXCollections.observableArrayList();

	private void popData() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			Stack<ToDo> symbol = (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(ToDoInsId.getText())).Data.getCourses()
							.Find(Integer.parseInt(ToDoCourseId.getText())).Data.getStudents()
									.Find(Integer.parseInt(ToDoStudentId.getText())).Data.getToDo());

			if (symbol != null) {

				Node<ToDo> temp = symbol.first;

				Stack<ToDo> stack = new Stack<>();

				while (temp != null) {

					Node<ToDo> res = symbol.Pop();

					toDo.add(res.Data);

					stack.push(res.Data);

					temp = temp.next;

				}

				Node<ToDo> temp1 = stack.first;
				while (temp1 != null) {

					symbol.Push(stack.Pop().Data);

					temp1 = temp1.next;

				}

			}

		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Empty!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}
	}

	//////// push a To Do

	@FXML
	private TextField ToDoAddType;

	@FXML
	private DatePicker ToDoAddStartDate, ToDoAddDueDate;

	@FXML
	private Button ToDoAddAdd, ToDoAddExit;

	public void showToDoPushInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/ToDo.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 396);

		Stage stage = new Stage();
		stage.setTitle("Push A ToDo...");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	@FXML
	TextField ToDoInsId1, ToDoCourseId1, ToDoStudentId1;

	public void pushToDo() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (ToDoAddStartDate == null || ToDoAddDueDate == null || ToDoAddType.getText().equals("")
					|| ToDoInsId1.getText().equals("") || ToDoCourseId1.getText().equals("")
					|| ToDoStudentId1.getText().equals(""))
				throw new Exception();

			Stack<ToDo> symbol = (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(ToDoInsId1.getText())).Data.getCourses()
							.Find(Integer.parseInt(ToDoCourseId1.getText())).Data.getStudents()
									.Find(Integer.parseInt(ToDoStudentId1.getText())).Data.getToDo());

			if (symbol == null)
				UniversityController.university.getInstructors().Find(Integer.parseInt(ToDoInsId1.getText())).Data
						.getCourses().Find(Integer.parseInt(ToDoCourseId1.getText())).Data.getStudents()
								.Find(Integer.parseInt(ToDoStudentId1.getText())).Data.setToDo(new Stack<ToDo>());

			symbol = (UniversityController.university.getInstructors().Find(Integer.parseInt(ToDoInsId1.getText())).Data
					.getCourses().Find(Integer.parseInt(ToDoCourseId1.getText())).Data.getStudents()
							.Find(Integer.parseInt(ToDoStudentId1.getText())).Data.getToDo());

			symbol.Push(new ToDo(ToDoAddType.getText(), ToDoAddStartDate.getValue(), ToDoAddDueDate.getValue()));

			AudioClip Audio = new AudioClip("file:src/application/Success!.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully Added!");
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Error! Please Try Again Or Check the Fields!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	public void ToDoAddExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) ToDoAddExit.getScene().getWindow();
		main.close();
	}

	public void ToDoAddClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		ToDoAddType.setText("");
		ToDoAddStartDate.setValue(null);
		ToDoAddDueDate.setValue(null);
		ToDoCourseId1.setText("");
		ToDoStudentId1.setText("");
		ToDoInsId1.setText("");

	}

	// ----------------------------------To Do pop

	public void ToDoPop() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			Stack<ToDo> symbol = (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(ToDoInsId.getText())).Data.getCourses()
							.Find(Integer.parseInt(ToDoCourseId.getText())).Data.getStudents()
									.Find(Integer.parseInt(ToDoStudentId.getText())).Data.getToDo());

			Node<ToDo> temp = symbol.Pop();

			if (temp == null)
				throw new Exception();

			AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully Deleted! ToDo With Type: " + temp.Data.getType());
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Not Found! please try again!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	// -------------------------------------Friends Queue ....

	@FXML
	private TextField FriendInsId, FriendCourseId, FriendStudentId;

	@FXML
	private Button FriendShowFriends, FriendEnqueueFriend, FriendDequeueFriend;

	@FXML
	private Circle FriendClear;

	@FXML
	private TableView<Friend> FriendTableView;

	@FXML
	private TableColumn<Friend, String> FriendName;

	@FXML
	private TableColumn<Friend, Integer> FriendId;

	@FXML
	private TableColumn<Friend, LocalDate> FriendDOB;

	@FXML
	private TableColumn<Friend, Character> FriendGender;

	// ------show Interface Method ,,,,,

	public void showFriendInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/FriendsInterface.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 606, 391);

		Stage stage = new Stage();
		stage.setTitle("Friends");
		stage.setResizable(false);
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setScene(s);

		stage.show();

	}

	public void clearFriend() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FriendInsId.setText("");
		FriendCourseId.setText("");
		FriendStudentId.setText("");
		FriendTableView.getItems().clear();
	}

	ObservableList<Friend> friends = FXCollections.observableArrayList();

	public void showFriends() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FriendName.setCellValueFactory(new PropertyValueFactory<Friend, String>("name"));
		FriendId.setCellValueFactory(new PropertyValueFactory<Friend, Integer>("id"));
		FriendGender.setCellValueFactory(new PropertyValueFactory<Friend, Character>("Gender"));
		FriendDOB.setCellValueFactory(new PropertyValueFactory<Friend, LocalDate>("DOB"));

		try {

			friends.clear();

			dequeueData();

			FriendTableView.setItems(friends);

		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Empty!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}
	}

	private void dequeueData() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			Queue<Friend> symbol = (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(FriendInsId.getText())).Data.getCourses()
							.Find(Integer.parseInt(FriendCourseId.getText())).Data.getStudents()
									.Find(Integer.parseInt(FriendStudentId.getText())).Data.getFriends());

			if (symbol != null) {

				Node<Friend> temp = symbol.first;

				Queue<Friend> queue = new Queue<>();

				while (temp != null) {

					Node<Friend> res = symbol.dequeue();

					friends.add(res.Data);

					queue.enqueue(res.Data);

					temp = temp.next;

				}

				Node<Friend> temp1 = queue.first;
				while (temp1 != null) {

					symbol.Enqueue(queue.dequeue().Data);
					temp1 = temp1.next;

				}

			}

		}

		catch (Exception e) {

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Empty!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}
	}

	// ----------Dequeue A friend...

	public void dequeueFriend() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			Queue<Friend> symbol = (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(FriendInsId.getText())).Data.getCourses()
							.Find(Integer.parseInt(FriendCourseId.getText())).Data.getStudents()
									.Find(Integer.parseInt(FriendStudentId.getText())).Data.getFriends());

			Node<Friend> temp = symbol.dequeue();

			if (temp == null)
				throw new Exception();

			AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully Deleted! Friend With Name: " + temp.Data.getName());
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Not Found! please try again!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	// ----------------------Enqueue A Friend...

	@FXML
	private TextField FriendInsId1, FriendCourseId1, FriendStudentId1, FriendAddName, FriendAddId;

	@FXML
	private RadioButton FriendMale, FriendFemale;

	@FXML
	private DatePicker FriendAddDOB;

	@FXML
	private Button FriendAddAdd, FriendAddExit;

	char G;

	public void showFriendEnqueueInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/EnqueueFriend.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 442);

		Stage stage = new Stage();
		stage.setTitle("Enqueue A Friend...");
		stage.setResizable(false);
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setScene(s);

		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	public void enqueueFriend() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if (FriendAddDOB == null || FriendAddName.getText().equals("") || FriendAddId.getText().equals("")
					|| (FriendMale.isSelected() == false && FriendFemale.isSelected() == false))
				throw new Exception();

			if (FriendMale.isSelected())
				G = 'M';
			else if (FriendFemale.isSelected())
				G = 'F';

			Queue<Friend> symbol = (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(FriendInsId1.getText())).Data.getCourses()
							.Find(Integer.parseInt(FriendCourseId1.getText())).Data.getStudents()
									.Find(Integer.parseInt(FriendStudentId1.getText())).Data.getFriends());

			if (symbol == null)
				UniversityController.university.getInstructors().Find(Integer.parseInt(FriendInsId1.getText())).Data
						.getCourses().Find(Integer.parseInt(FriendCourseId1.getText())).Data.getStudents()
								.Find(Integer.parseInt(FriendStudentId1.getText())).Data
										.setFriends(new Queue<Friend>());

			symbol = (UniversityController.university.getInstructors()
					.Find(Integer.parseInt(FriendInsId1.getText())).Data.getCourses()
							.Find(Integer.parseInt(FriendCourseId1.getText())).Data.getStudents()
									.Find(Integer.parseInt(FriendStudentId1.getText())).Data.getFriends());

			symbol.enqueue(new Friend(FriendAddName.getText(), Integer.parseInt(FriendAddId.getText()), G,
					FriendAddDOB.getValue()));

			AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully Added!");
			alert.setTitle("Success!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
					.add(new Image("/application/confirm.png"));

			alert.initModality(Modality.APPLICATION_MODAL);
			alert.showAndWait();

		}

		catch (Exception e) {

			AudioClip Audio = new AudioClip("file:src/application/Error.mp3");
			Audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Error! Please Try Again Or Check the Fields!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);

			alert.initModality(Modality.APPLICATION_MODAL);

			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();

		}

	}

	public void FriendAddExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) FriendAddExit.getScene().getWindow();
		main.close();
	}

	public void FriendAddClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FriendAddName.setText("");
		FriendAddDOB.setValue(null);
		FriendAddId.setText("");
		FriendMale.setSelected(false);
		FriendFemale.setSelected(false);
		FriendInsId1.setText("");
		FriendCourseId1.setText("");
		FriendStudentId1.setText("");

	}

}
