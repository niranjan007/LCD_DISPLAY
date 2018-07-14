package com.javaFxSpringBoot.JavaFxSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@SpringBootApplication
public class JavaFxSpringBootApplication extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent root;

	@Override
	public void init() {

		try {

			System.out.println(
					"**************************************************INIT*****************************************");
			springContext = SpringApplication.run(JavaFxSpringBootApplication.class);
			System.out.println(1);
			System.out.println(4);
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		System.out.println(
				"**************************************************MAIN*****************************************");
		launch(JavaFxSpringBootApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) {

		try {

			// Player player = new Player("file:C:/EDIT/MyEdits/Shobha.mp4");

			System.out.println("**************************************************START*****************************************");
			System.out.println(0);
			MyPlayer player = new MyPlayer("file:C:/EDIT/MyEdits/Shobha.mp4");
			System.out.println(1);
			Scene scene = new Scene(player, 1920, 1080, Color.BLACK);
			System.out.println(2);
			primaryStage.setScene(scene);
			System.out.println(3);
			primaryStage.show();
			System.out.println(4);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}

}
