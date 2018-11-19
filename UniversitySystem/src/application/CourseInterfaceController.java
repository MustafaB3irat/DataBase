package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

public class CourseInterfaceController {

	public static LinkedList<Course> Courses;

	@FXML
	private Button addCourse, deleteCourse, showCourses, CourseExit;

	@FXML
	private TableView<Course> CourseTableView;

	@FXML
	private TableColumn<Course, String> CourseNameColumn;

	@FXML
	private TableColumn<Course, Integer> CourseIdColumn, CourseHoursColumn;

	ObservableList<Course> data = FXCollections.observableArrayList();

	public void showCourses() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		CourseNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
		CourseIdColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("id"));
		CourseHoursColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Hours"));

		try {
			data.clear();
			showData();
			CourseTableView.setItems(data);

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

	private void showData() throws Exception {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Node<Course> temp = Courses.getFirst();

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

		Stage main = (Stage) CourseExit.getScene().getWindow();
		main.close();

	}

	// Add Course InterFace

	@FXML
	private Button CourseAddAdd, CourseAddExit;

	@FXML
	private TextField CourseAddName, CourseAddId, CourseAddHours;

	@FXML
	private Circle CourseAddClear;

	public void showCourseAddInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/AddCourse.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 335, 331);

		Stage stage = new Stage();
		stage.setTitle("Add Course!");
		stage.setResizable(false);
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setScene(s);
		
		stage.initModality(Modality.APPLICATION_MODAL);


		stage.show();

	}

	public void addCourse() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {
			if (Courses == null)
				Courses = new LinkedList<Course>();

			Courses.addFirst(new Course(CourseAddName.getText(), Integer.parseInt(CourseAddId.getText()),
					Integer.parseInt(CourseAddHours.getText()), null));

			AudioClip Audio = new AudioClip("file:src/application/Success!.mp3");
			Audio.play();

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

			AudioClip iudio = new AudioClip("file:src/application/Error.mp3");
			iudio.play();

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

	public void CourseAddExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) CourseAddExit.getScene().getWindow();
		main.close();
	}

	public void CourseAddClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		CourseAddHours.setText("");
		CourseAddId.setText("");
		CourseAddName.setText("");

	}

	public void deleteCourse() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		try {

			Course course = CourseTableView.getSelectionModel().getSelectedItem();

			Courses.remove(course);

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
