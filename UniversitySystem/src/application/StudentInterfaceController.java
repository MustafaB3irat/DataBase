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

public class StudentInterfaceController {

	public static LinkedList<Student> Students;

	@FXML
	private Button addStudent, deleteStudent, showStudents, StudentExit;

	@FXML
	private TableView<Student> StudentTableView;

	@FXML
	private TableColumn<Student, String> StudentNameColumn, StudentAddressColumn, StudentMajorColumn;

	@FXML
	private TableColumn<Student, Integer> StudentIdColumn, StudentMajorYears;

	@FXML
	private TableColumn<Student, LocalDate> StudentDOBColumn, StudentJoinDateColumn;

	@FXML
	private TableColumn<Student, Character> StudentGenderColumn;

	ObservableList<Student> data = FXCollections.observableArrayList();

	public void showStudent() {

		AudioClip iudio = new AudioClip("file:src/application/ButtonClick.mp3");
		iudio.play();

		StudentNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		StudentIdColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
		StudentAddressColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Address"));
		StudentMajorColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Major"));
		StudentJoinDateColumn.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("JoinDate"));
		StudentMajorYears.setCellValueFactory(new PropertyValueFactory<Student, Integer>("MajorYears"));
		StudentDOBColumn.setCellValueFactory(new PropertyValueFactory<Student, LocalDate>("DOB"));
		StudentGenderColumn.setCellValueFactory(new PropertyValueFactory<Student, Character>("Gender"));

		try {
			data.clear();
			showData();
			StudentTableView.setItems(data);

		}

		catch (Exception e) {

			AudioClip audio = new AudioClip("file:src/application/Error.mp3");
			audio.play();

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

	private void showData() throws Exception {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Node<Student> temp = Students.getFirst();

		if (temp == null)
			throw new Exception();

		while (temp != null) {

			data.add(temp.Data);
			temp = temp.next;

		}
	}

	public void mainExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) StudentExit.getScene().getWindow();
		main.close();

	}

	// Add Course InterFace

	@FXML
	private Button StudentAddAdd, StudentAddExit;

	@FXML
	private TextField StudentAddName, StudentAddId, StudentAddAddress, StudentAddMajor, StudentAddMajorYears;

	@FXML
	private RadioButton male, female;

	@FXML
	private DatePicker StudentAddDOB, StudentAddJoinDate;

	@FXML
	private Circle StudentAddClear;

	public void showStudentAddInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/AddStudentMain.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 330, 470);

		Stage stage = new Stage();
		stage.setTitle("Add Student!");
		stage.setResizable(false);
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setScene(s);
		
		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();

	}

	char G;

	public void addStudent() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			if ((male.isSelected() == false && female.isSelected() == false) || StudentAddName.getText().equals("")
					|| StudentAddId.getText().equals("") || StudentAddAddress.getText().equals("")
					|| StudentAddMajor.getText().equals("") || StudentAddJoinDate.getValue() == null
					|| StudentAddMajorYears.getText().equals("") || StudentAddDOB.getValue() == null)
				throw new Exception();

			if (male.isSelected())
				G = 'M';
			else if (female.isSelected())
				G = 'F';

			if (Students == null)
				Students = new LinkedList<Student>();

			Students.addFirst(new Student(StudentAddName.getText(), Integer.parseInt(StudentAddId.getText()),
					StudentAddAddress.getText(), StudentAddMajor.getText(), StudentAddJoinDate.getValue(),
					Integer.parseInt(StudentAddMajorYears.getText()), StudentAddDOB.getValue(), G, null, null));

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
			alert.setContentText("Error! please try again!");
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

	public void StudentAddClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		StudentAddAddress.setText("");
		StudentAddDOB.setValue(null);
		StudentAddId.setText("");
		StudentAddJoinDate.setValue(null);
		StudentAddMajor.setText("");
		StudentAddMajorYears.setText("");
		StudentAddName.setText("");
		male.setSelected(false);
		female.setSelected(false);

	}

	public void deleteStudent() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			Student student = StudentTableView.getSelectionModel().getSelectedItem();

			Students.remove(student);

			AudioClip iudio = new AudioClip("file:src/application/Success!.mp3");
			iudio.play();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Deleted SuccessFully!");
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
			alert.setContentText("Please Select Valid Row From the Table Below!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);
			
			alert.initModality(Modality.APPLICATION_MODAL);


			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();
			

		}

	}

}
