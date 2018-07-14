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
	static boolean playing = false;

	public MyPlayer(String sfile) {

		try {

			// String file = new File("C:/EDIT/MyEdits/RhodesPark.mp4").toURI().toString();
			String file = new File(sfile).toURI().toString();
			System.out.println("**********" + file + "***********************************");
			media = new Media(file);

			player = new MediaPlayer(media);

			view = new MediaView(player);

			// view.setMediaPlayer(player);
			pane = new Pane();

			pane.getChildren().add(view);

			setCenter(pane);
         
			 if( !playing ) {
				   System.out.println("Now i am about to play");
			   }
						
			player.play();
			
			
			player.setOnEndOfMedia(new Runnable() {
		
				public void run() {
					playing = true;
				
				}
				
			});
			
		   if( playing ) {
			   System.out.println("Now i am not playing");
		   }

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

}
