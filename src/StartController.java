import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StartController extends GameEngine implements Initializable {

	@FXML
	ChoiceBox<String> chooseLevel;
	@FXML
	private Button startBtn;
	@FXML
	private Button loadBtn;
	@FXML
	private Button exitBtn;
	@FXML
	public ListView<String> chooseLoad;

	public void startGame(ActionEvent event) throws IOException {

		ICrossingStrategy gameStrategy = getLevel(chooseLevel.getValue());

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Game.fxml"));
		Parent GameGUI = loader.load();

		Scene GameScene = new Scene(GameGUI);

//		ManagerController controller = loader.getController();
//		controller.initData();
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(GameScene);
		GameEngine instance = GameEngine.getInstance();

		instance = loader.getController();
		instance.newGame(gameStrategy);

		window.show();

	}

	public void loadGame(ActionEvent event) throws IOException {
		ObservableList<String> productSelected, allProducts;
		allProducts = chooseLoad.getItems();
		productSelected = chooseLoad.getSelectionModel().getSelectedItems();
		String str = productSelected.get(0);
		ICrossingStrategy gameStrategy = getLevel(chooseLevel.getValue());

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Game.fxml"));
		Parent GameGUI = loader.load();

		Scene GameScene = new Scene(GameGUI);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(GameScene);
		GameEngine instance = GameEngine.getInstance();

		instance = loader.getController();
		instance.setUsername(str);
		instance.loadGame();
		window.show();

	}

	public void setList() {
		ArrayList<String> usernames = (new XmlFile()).getUserNames();
		chooseLoad.getItems().clear();
		for (int i = 0; i < usernames.size(); i++) {
			chooseLoad.getItems().add(usernames.get(i));
		}

	}

	public void exitGame() {
		Stage stage = (Stage) exitBtn.getScene().getWindow();
		// do what you have to do
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chooseLevel.getItems().addAll("Story One", "Story Two" , "Story Three");
		chooseLevel.setValue("Story One");
	}

	public ICrossingStrategy getLevel(String str) {
		if (str.equals("Story One")) {
			return new LevelOne();
		} else if (str.equals("Story Two")) {
			return new LevelTwo();
		}
		else
			return new LevelThree();

	}
}
