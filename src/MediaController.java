import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaController {

	static MediaPlayer mediaplayer;

	public static void playVideo(Media videoFile) {
		
		Stage stage = new Stage();
		mediaplayer = new MediaPlayer(videoFile);
		mediaplayer.setAutoPlay(true);
		mediaplayer.setVolume(0);
		
		MediaView mediaView = new MediaView(mediaplayer);

		VBox root = new VBox();
		root.getChildren().add(mediaView);

		Scene scene = new Scene(root, 900, 800);
		stage.setScene(scene);

		stage.show();
	}

}