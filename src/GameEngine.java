import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.event.ActionEvent;

public class GameEngine implements IRiverCrossingController, Initializable {

	private ArrayList<String> boatList;
	private ArrayList<String> leftList;
	private ArrayList<String> rightList;
	private static GameEngine instance;
	private ICrossingStrategy strategy;
	private State model;
	private int currentState = 0;
	private int savedState = 0;
	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();

	@FXML
	private ImageView boat = new ImageView();
	
	private ImageView plant;

	private ImageView farmer;

	private ImageView herbi;

	private ImageView carni;

	@FXML
	private Button moveBtn;

	private String[] imgArray = new String[] { "Farmer", "Plant", "Boat", "Herbi", "Carni" };

	private TranslateTransition move1;
	private TranslateTransition move2;
	private TranslateTransition move3;

	private int counter;

	public static synchronized GameEngine getInstance() {
		if (instance == null)
			instance = new GameEngine();

		return instance;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
        this.strategy=gameStrategy;
        model=new State();
        model.setLeftBankCrossers(strategy.getInitialCrossers());
        originator.setState(model.copyState());
        careTaker.addMemento(originator.saveStateToMemento());
        savedState++;
    	
		boat.setImage();
		boat.setLayoutX(667);
		boat.setLayoutY(692);

	}

	@Override
	public void resetGame() {
		model.clearBoatRiders();
		model.clearLeftBank();
		model.clearRightBank();
		model.setNumberOfMoves(0);
		model.setBoatOnTheLeftBank(true);
		model.setLeftBankCrossers(strategy.getInitialCrossers());
		currentState = 0;
		savedState = 0;
		careTaker.clearMemento();
		originator.setState(model.copyState());
		careTaker.addMemento(originator.saveStateToMemento());
		savedState++;
		// Undo & Redo buttons disabled here
	}

	@Override
	public String[] getInstructions() {
		return strategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return model.getRightBankCrossers();
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return model.getLeftBankCrossers();
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return model.getIsBoatOnTheLeftBank();
	}

	@Override
	public int getNumberOfSails() {
		return model.getNumberOfMoves();
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if (strategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers)) {
			System.out.println("Can move");
			return true;
		} else {
			System.out.println("Can't move");
			return false;
		}
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
//		if (canMove(crossers, fromLeftToRightBank)) {
//            if(fromLeftToRightBank==true){
//                for(ICrosser crosser : crossers){
//                    model.removeLeftCrosser(crosser);
//                    model.addRightCrosser(crosser);
//                }
//                model.setBoatOnTheLeftBank(false);
//                model.setNumberOfMoves(model.getNumberOfMoves()+1);
//            }
//            else {
//                for(ICrosser crosser : crossers){
//                    model.removeRightCrosser(crosser);
//                    model.addLeftCrosser(crosser);
//                }
//                model.setBoatOnTheLeftBank(true);
//                model.setNumberOfMoves(model.getNumberOfMoves()+1);
//            }
//
//			// Write code moving here and change model
//
//			originator.setState(model.copyState());
//			careTaker.addMemento(originator.saveStateToMemento());
//			savedState++;
//			currentState++;
////			 Undo button set enabled here
//		} else {
//
//		}

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

	@Override
	public boolean canUndo() {
		if (currentState >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean canRedo() {
		if ((savedState - 1) > currentState) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void undo() {
		if (canUndo()) {
			currentState--;
			model = originator.getStateFromMemento(careTaker.getMemento(currentState));
			// Rendering new view in scene builder
			// Redo button enabled here
			System.out.println("Undo done");
		} else {
			// Undo button disabled here
			System.out.println("Can't undo");
		}
	}

	public void redo() {
		if (canRedo()) {
			currentState++;
			model = originator.getStateFromMemento(careTaker.getMemento(currentState));
			// Rendering new view in scene builder
			// Undo button enabled here
			System.out.println("Redo done");
		} else {
			// Redo button disabled here
			System.out.println("Can't Redo");
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		counter = 0;

		newGame(LevelOne);
		
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

	
	public void btnAction() {
		
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
			return plant;

		default:
			return null;
		}

	}

	// Test to be removed:
	public void printState() {
		System.out.println(model.toString());
	}

	// Test to be removed:
	public void removeLeft(ICrosser crosser) {
		model.removeLeftCrosser(crosser);
	}

	// Test to be removed:
	public void removeRight(ICrosser crosser) {
		model.removeRightCrosser(crosser);
	}

	// Test to be removed:
	public void addRider(ICrosser crosser) {
		model.addRider(crosser);
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

}
