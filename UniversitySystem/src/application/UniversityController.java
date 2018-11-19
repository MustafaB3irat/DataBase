package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UniversityController {

	public static University university = new University();

	@FXML
	Button Instructor, Courses, Students, Exit;

	public static Stage mainInterface;

	public void exit() {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		mainInterface = (Stage) Exit.getScene().getWindow();

		mainInterface.close();
	}

	public static Stage insInterface = new Stage();

	public void InstructorInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/insInterface.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 786, 446);

		insInterface.setScene(s);
		insInterface.setTitle("Instructors");
		insInterface.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
		insInterface.setResizable(false);

		//insInterface.initModality(Modality.APPLICATION_MODAL);

		insInterface.show();

	}

	public static Stage CourInterface = new Stage();

	public void CoursesInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/CourseInterface.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 490, 400);

		CourInterface.setScene(s);
		CourInterface.setTitle("Courses");
		CourInterface.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));

		//CourInterface.initModality(Modality.APPLICATION_MODAL);

		CourInterface.show();

	}

	public static Stage StuInterface = new Stage();

	public void StudentsInterface() throws IOException {

		AudioClip audio = new AudioClip("file:src/application/ButtonClick.mp3");
		audio.play();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/StudentInterface.fxml"));

		Pane p = loader.load();

		Scene s = new Scene(p, 894, 400);

		StuInterface.setScene(s);
		StuInterface.setTitle("Students");
		StuInterface.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));

		//StuInterface.initModality(Modality.APPLICATION_MODAL);

		StuInterface.show();

	}

	@FXML
	private ImageView image;

	private int changer = 2;

	AudioClip audio = new AudioClip("file:src/application/Music.mp3");

	public void initialize() {

		audio.play();

	}

	public void imageChanger() {

		AudioClip iudio = new AudioClip("file:src/application/ButtonClick.mp3");
		iudio.play();

		if (changer % 2 == 0) {
			image.setImage(new Image(getClass().getResourceAsStream("/application/mute.png")));
			audio.stop();
		}

		else {
			image.setImage(new Image(getClass().getResourceAsStream("/application/sound.png")));
			audio = new AudioClip("file:src/application/Music.mp3");
			audio.play();

		}

		changer++;

	}

}
