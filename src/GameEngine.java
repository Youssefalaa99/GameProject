import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;

import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.event.ActionEvent;

public class GameEngine implements IRiverCrossingController, Initializable {

	private ArrayList<String> boatList;
	private ArrayList<String> leftList;
	private ArrayList<String> rightList;

	@FXML
	private ImageView boat;
	@FXML
	private ImageView plant;
	@FXML
	private ImageView farmer;
	@FXML
	private ImageView herbi;
	@FXML
	private ImageView carni;
	@FXML
	private Button moveBtn;

	private String[] imgArray = new String[] { "Farmer", "Plant", "Boat", "Herbi", "Carni" };

	private TranslateTransition move1;
	private TranslateTransition move2;
	private TranslateTransition move3;

	private static GameEngine instance;

	private int counter;

	public static synchronized GameEngine getInstance() {
		if (instance == null)
			instance = new GameEngine();

		return instance;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {

	}

	@Override
	public void resetGame() {

	}

	@Override
	public String[] getInstructions() {
		return new String[0];
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return null;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return null;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		if (counter % 2 == 0)
			return true;
		else
			return false;

	}

	@Override
	public int getNumberOfSails() {
		return counter;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		return false;
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

		carni.setOnMouseClicked((MouseEvent e) -> {
			moveCarni();
		});
		
		herbi.setOnMouseClicked((MouseEvent e) -> {
			moveHerbi();
		});
		
		farmer.setOnMouseClicked((MouseEvent e) -> {
			moveFarmer();
		});
		
		plant.setOnMouseClicked((MouseEvent e) -> {
			movePlant();
		});
		

	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public boolean canRedo() {
		return false;
	}

	@Override
	public void undo() {

	}

	@Override
	public void redo() {

	}

	@Override
	public void saveGame() {

	}

	@Override
	public void loadGame() {

	}

	@Override
	public List<List<ICrosser>> solveGame() {
		return null;
	}

	public void startGame(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Game.fxml"));
		Parent ManagerGUI = loader.load();

		Scene ManagerScene = new Scene(ManagerGUI);

//		ManagerController controller = loader.getController();
//		controller.initData();

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ManagerScene);
		window.show();
	}
	
	public void btnAction() {

		if (boatList.contains("Farmer")) {
			try {

				move1.setNode(boat);
				move2.setNode(getinBoat(0));
				move3.setNode(getinBoat(1));
			} catch (Exception e) {
				move3.setNode(null);
			}
			counter++;

			if (!isBoatOnTheLeftBank()) {

				move1.setByX(-600);
				move1.setByY(0);
				move1.play();

				move2.setByX(-600);
				move2.setByY(0);
				move2.play();

				move3.setByX(-600);
				move3.setByY(0);
				move3.play();

			} else {

				move1.setByX(600);
				move1.setByY(0);
				move1.play();

				move2.setByX(600);
				move2.setByY(0);
				move2.play();

				move3.setByX(600);
				move3.setByY(0);
				move3.play();

			}
		} else
			Alert.display("Boat can't sail without the Farmer");
	}

	public void initialize(URL location, ResourceBundle resources) {
		counter = 0;

		boatList = new ArrayList<String>();
		leftList = new ArrayList<String>();
		rightList = new ArrayList<String>();
		rightList.addAll(Arrays.asList(imgArray));
		move1 = new TranslateTransition();
		move2 = new TranslateTransition();
		move3 = new TranslateTransition();
		move1.setDuration(Duration.millis(200));
		move2.setDuration(Duration.millis(200));
		move3.setDuration(Duration.millis(200));

	}


	public void movePlant() {

		move1.setNode(plant);
		if (rightList.contains("Plant")) {
			rightList.remove("Plant");
			boatList.add("Plant");
			move1.setByX(-51);
			move1.setByY(105);
			move1.play();

		} else if (boatList.contains("Plant")) {
			if (isBoatOnTheLeftBank()) {
				boatList.remove("Plant");
				rightList.add("Plant");
				System.out.println(boatList);
				move1.setByX(51);
				move1.setByY(-105);
				move1.play();
			} else {

			}
		}

	}

	public void moveCarni() {

		move1.setNode(carni);
		if (rightList.contains("Carni")) {
			rightList.remove("Carni");
			boatList.add("Carni");
			move1.setByX(28);
			move1.setByY(134);
			move1.play();

		} else if (boatList.contains("Carni")) {
			if (isBoatOnTheLeftBank()) {
				boatList.remove("Carni");
				rightList.add("Carni");
				move1.setByX(-28);
				move1.setByY(-134);
				move1.play();
			} else {

			}
		}
	}

	public void moveHerbi() {

		move1.setNode(herbi);
		if (rightList.contains("Herbi")) {
			rightList.remove("Herbi");
			boatList.add("Herbi");
			move1.setByX(158);
			move1.setByY(165);
			move1.play();

		} else if (boatList.contains("Herbi")) {
			if (isBoatOnTheLeftBank()) {
				boatList.remove("Herbi");
				rightList.add("Herbi");
				move1.setByX(-158);
				move1.setByY(-165);
				move1.play();
			} else {

			}
		}
	}

	public void moveFarmer() {
		move1.setNode(farmer);
		if (rightList.contains("Farmer")) {
			rightList.remove("Farmer");
			boatList.add("Farmer");
			move1.setByX(31);
			move1.setByY(145);
			move1.play();

		} else if (boatList.contains("Farmer")) {
			if (isBoatOnTheLeftBank()) {
				boatList.remove("Farmer");
				rightList.add("Farmer");
				move1.setByX(-31);
				move1.setByY(-145);
				move1.play();
			} else {

			}
		}
	}

	public ImageView getinBoat(int i) {

		switch (boatList.get(i)) {

		case "Farmer":
			return farmer;

		case "Carni":
			return carni;

		case "Herbi":
			return herbi;

		case "Plant":
			System.out.println("plant");
			return plant;

		default:
			System.out.println("noo");
			return null;
		}

	}

}
