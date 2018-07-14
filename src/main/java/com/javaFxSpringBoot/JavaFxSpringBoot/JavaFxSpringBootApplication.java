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

	@Override
	public void init() {

		try {

			System.out.println(
					"**************************************************INIT*****************************************");
			springContext = SpringApplication.run(JavaFxSpringBootApplication.class);

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

			FileService fileRepo = new FileService();
			
			String path1 = "C:/EDIT/MyEdits/Shobha.mp4";
			String path = "C:/EDIT/MyEdits/RhodesPark.mp4";

			// String path = "/home/pi/niranjan/Shobha.mp4";
			System.out.println(
					"**************************************************START*****************************************");

			playVideo(primaryStage, path1);	
			
			
			
			//playVideo(primaryStage, path);	
		
//			MyPlayer player = new MyPlayer(path);
//
//			Scene scene = new Scene(player, 1920, 1080, Color.BLACK);
//
//			primaryStage.setScene(scene);
//
//			primaryStage.show();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}

	public static void playVideo(Stage primaryStage, String path) {

		try {

			MyPlayer player = new MyPlayer(path);

			Scene scene = new Scene(player, 1920, 1080, Color.BLACK);

			primaryStage.setScene(scene);

			primaryStage.show();
			
			
			//primaryStage.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
