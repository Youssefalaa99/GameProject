import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {
	private Stage stage = new Stage();

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("Start.fxml"));
//		Parent GameGUI = loader.load();
//
//		Scene GameScene = new Scene(GameGUI);
//
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(GameScene);
//		
//		StartController instance = new StartController();
//
//		instance = loader.getController();
//
//		instance.setList((new XmlFile()).getUserNames());
//		
//		window.show();
//		
//		
		stage = primaryStage;
		Parent LoginUserGUI = FXMLLoader.load(getClass().getResource("Start.fxml"));
		primaryStage.setTitle("River Crossing");
		primaryStage.setScene(new Scene(LoginUserGUI, 500, 500));

		primaryStage.show();
	}

}