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

public class insController {

	@FXML
	Button add, delete, find, courses, show;

	@FXML
	private TableView<Instructor> tableView;

	@FXML
	private TableColumn<Instructor, String> name, address, field, department;

	@FXML
	private TableColumn<Instructor, Integer> id;

	@FXML
	private TableColumn<Instructor, Double> salary;

	@FXML
	private TableColumn<Instructor, LocalDate> DOB, StartDate;

	public void initialized() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		name.setCellValueFactory(new PropertyValueFactory<Instructor, String>("Name"));
		id.setCellValueFactory(new PropertyValueFactory<Instructor, Integer>("id"));
		address.setCellValueFactory(new PropertyValueFactory<Instructor, String>("Address"));
		salary.setCellValueFactory(new PropertyValueFactory<Instructor, Double>("Salary"));
		StartDate.setCellValueFactory(new PropertyValueFactory<Instructor, LocalDate>("StartDate"));
		DOB.setCellValueFactory(new PropertyValueFactory<Instructor, LocalDate>("DOB"));
		field.setCellValueFactory(new PropertyValueFactory<Instructor, String>("Field"));
		department.setCellValueFactory(new PropertyValueFactory<Instructor, String>("Department"));

		try {

			data.clear();

			getData(UniversityController.university.getInstructors().getRoot());
			tableView.setItems(data);

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

	ObservableList<Instructor> data = FXCollections.observableArrayList();

	private void getData(TNode<Instructor> x) {

		if (x != null) {

			getData(x.getLeft());

			data.add(x.Data);

			getData(x.getRight());
		}

	}

	// -----------------------------------Instructor Add interFace

	@FXML
	private Button insADD, insAddExit, insExit;

	@FXML
	private TextField insName, insId, insAddress, insSalary, insField, insDep;

	@FXML
	private DatePicker insStartDate, insDOB;

	Tree<Instructor> ins = new Tree<>();

	public void insExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage main = (Stage) insExit.getScene().getWindow();
		main.close();

	}

	public void insAdd() {

		AudioClip iudio = new AudioClip("file:src/application/ButtonClick.mp3");
		iudio.play();

		try {

			if (UniversityController.university.getInstructors() == null)
				UniversityController.university.setInstructors(ins);

			if (insName.getText().equals("") || insId.getText().equals("") || insAddress.getText().equals("")
					|| insSalary.getText().equals("") || insStartDate.getValue() == null || insDOB.getValue() == null
					|| insField.getText().equals("") || insDep.getText().equals("")) {

				throw new Exception();

			}

			UniversityController.university.getInstructors()
					.insert(new Instructor(insName.getText(), Integer.parseInt(insId.getText()), insAddress.getText(),
							Double.parseDouble(insSalary.getText()), insStartDate.getValue(), insDOB.getValue(),
							insField.getText(), insDep.getText(), null));

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
			

		} catch (Exception e) {

			AudioClip audio = new AudioClip("file:src/application/Error.mp3");
			audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Error! Something went Wrong Check the Enterd Values!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);
			
			alert.initModality(Modality.APPLICATION_MODAL);


			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();
			
			

		}

		// ---------------------------------------------------------------------------

	}

	public void insAddExit() {

		AudioClip iudio = new AudioClip("file:src/application/ButtonClick.mp3");
		iudio.play();

		Stage mainStage = (Stage) insAddExit.getScene().getWindow();

		mainStage.close();
	}

	public void showInsAdd() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/AddIns.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 330, 453);

		Stage stage = new Stage();
		stage.setTitle("Add");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setScene(s);
		stage.setResizable(false);
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();

	}

	// --------------------------------------insDelete

	@FXML
	Button insDeleteDelete, insDeleteExit;

	@FXML
	TextField insDeleteId;

	public void insDelete() {

		AudioClip iudio = new AudioClip("file:src/application/ButtonClick.mp3");
		iudio.play();

		try {

			if (insDeleteId.getText().equals(""))
				throw new Exception();

			else {

				UniversityController.university.getInstructors().Delete(Integer.parseInt(insDeleteId.getText()));

				AudioClip audio = new AudioClip("file:src/application/Success!.mp3");
				audio.play();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully Deleted!");
				alert.setTitle("Deleted!!");
				alert.setHeaderText(null);
				alert.setResizable(false);
				
				alert.initModality(Modality.APPLICATION_MODAL);


				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
						.add(new Image("/application/confirm.png"));
				alert.showAndWait();
				

			}

		} catch (Exception e) {

			AudioClip audio = new AudioClip("file:src/application/Error.mp3");
			audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Error Not Found Check the Entries!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);
			
			alert.initModality(Modality.APPLICATION_MODAL);


			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();
			

		}
	}

	public void showinsDelete() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/DeleteIns.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 298);

		Stage stage = new Stage();
		stage.setTitle("Delete");
		stage.setScene(s);
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();

	}

	public void insDeleteExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage stage = (Stage) insDeleteExit.getScene().getWindow();
		stage.close();
	}

	// -------------------------------insFind

	@FXML
	Button insFindFind, insFindExit;

	@FXML
	TextField insFindId;

	public void insFind() {

		AudioClip iudio = new AudioClip("file:src/application/ButtonClick.mp3");
		iudio.play();

		try {

			if (insFindId.getText().equals(""))
				throw new Exception();

			else {

				TNode<Instructor> temp = UniversityController.university.getInstructors()
						.Find(Integer.parseInt(insFindId.getText()));

				AudioClip audio = new AudioClip("file:src/application/Success!.mp3");
				audio.play();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully Found! ... The Instructor with Name: " + (temp).Data.getName()
						+ " And Id: " + (temp).Data.getId());
				alert.setTitle("Found!!");
				alert.setHeaderText(null);
				alert.setResizable(false);
				
				alert.initModality(Modality.APPLICATION_MODAL);


				((Stage) alert.getDialogPane().getScene().getWindow()).getIcons()
						.add(new Image("/application/confirm.png"));
				alert.showAndWait();
				

			}

		} catch (Exception e) {

			AudioClip audio = new AudioClip("file:src/application/Error.mp3");
			audio.play();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Error Not Found Check the Entries!");
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setResizable(false);
			
			alert.initModality(Modality.APPLICATION_MODAL);


			((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/application/Error.png"));
			alert.showAndWait();
			
			

		}

	}

	public void showInsFind() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/FindIns.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 325, 298);

		Stage stage = new Stage();
		stage.setTitle("Find");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setScene(s);
		stage.setResizable(false);
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();

	}

	public void insFindExit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		Stage stage = (Stage) insFindExit.getScene().getWindow();
		stage.close();
	}

	public void showInsCourseRelated() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/CoursesRelatedIns.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 533, 445);

		Stage stage = new Stage();
		stage.setTitle("Courses Related To An Instructor!");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		stage.setResizable(false);
		stage.setScene(s);
		
		stage.initModality(Modality.APPLICATION_MODAL);

		stage.show();
	}

	///// Clears

	@FXML
	private Circle insDeleteClear, insFindClear, insAddInsClear;

	public void insDeleteClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		insDeleteId.setText("");
	}

	public void insFindClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		insFindId.setText("");
	}

	public void insAddInsClear() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		insName.setText("");
		insId.setText("");
		insAddress.setText("");
		insSalary.setText("");
		insDep.setText("");
		insDOB.setValue(null);
		insField.setText("");
		insStartDate.setValue(null);
	}

}
