package application;

import javafx.scene.media.AudioClip;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/university.fxml"));
			Pane root = loader.load();
			Scene scene = new Scene(root, 219, 416);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			AudioClip audio = new AudioClip("file:src/application/Welcome.wav");
			audio.play();

			primaryStage.setScene(scene);
			primaryStage.setTitle("BirZeit");
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("ritaj-logo.png")));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}
}
