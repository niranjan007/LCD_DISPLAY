package com.javaFxSpringBoot.JavaFxSpringBoot;

import java.io.File;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MyPlayer extends BorderPane {

	Media media;
	MediaPlayer player;
	MediaView view;
	Pane pane;

	public MyPlayer(String sfile) {

		try {

			System.out.println(0.1);
			String file = new File("C:/EDIT/MyEdits/RhodesPark.mp4").toURI().toString();
			System.out.println("**********" + file +"***********************************");
			media = new Media(file);
			System.out.println(0.2);
			player = new MediaPlayer(media);
			System.out.println(0.3);
			view = new MediaView(player);
			System.out.println(0.4);
			// view.setMediaPlayer(player);
            pane = new Pane();
			System.out.println(0.5);
			pane.getChildren().add(view);
			System.out.println(0.6);
			setCenter(pane);
			System.out.println(0.7);
			player.play();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
