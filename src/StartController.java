import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StartController extends GameEngine implements Initializable  {

	@FXML
	private Button startBtn;
	@FXML
	private Button loadBtn;
	@FXML
	private Button exitBtn;
	@FXML
	private ListView<String> loadList;

	public void startGame(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Game.fxml"));
		Parent GameGUI = loader.load();

		Scene GameScene = new Scene(GameGUI);

//		ManagerController controller = loader.getController();
//		controller.initData();
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(GameScene);
		window.show();
		newGame(null);
		System.out.println("ssss");

	}
	public void loadGame() {
		
	}
	public void exitGame() {
		 Stage stage = (Stage) exitBtn.getScene().getWindow();
		    // do what you have to do
		    stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
