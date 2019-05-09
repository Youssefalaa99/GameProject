import java.util.List;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class GameEngine implements IRiverCrossingController, Initializable {
	private Animation ani;
	private static GameEngine instance;
	private State model;
	private String username;
	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();
	private Invoker invoker = new Invoker();
	private LoadGame loadGame;
	private SaveGame saveGame;
	private Image image;
	private Media media;
	@FXML
	private Label scoreLabel;
	@FXML
	private Button startGame;
	@FXML
	private Button resetBtn;
	@FXML
	private Button exitBtn;
	@FXML
	private ImageView boatImg;
	@FXML
	private ImageView plantImg;
	@FXML
	private ImageView farmerImg;
	@FXML
	private ImageView herbiImg;
	@FXML
	private ImageView carniImg;
	@FXML
	private Button moveBtn;
	@FXML
	private Button SolveBtn;
	@FXML
	private Button undoBtn;
	@FXML
	private Button redoBtn;
	@FXML
	private ImageView farmer1Img;
	@FXML
	private ImageView farmer2Img;
	@FXML
	private ImageView farmer3Img;
	@FXML
	private ImageView farmer4Img;
	@FXML
	private ImageView animalImg;
	@FXML
	private Button instBtn;
	@FXML
	private ImageView lazyImg;
	@FXML
	private ImageView arrogentImg;
	@FXML
	private ImageView braveImg1;
	@FXML
	private ImageView braveImg2;
	@FXML
	private Button saveBtn;

	public static synchronized GameEngine getInstance() {
		if (instance == null)
			instance = new GameEngine();

		return instance;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		model = new State();
		model.setStrategy(gameStrategy);
		model.setRightBankCrossers(model.getStrategy().getInitialCrossers());
		saveGame = new SaveGame(model);
		State modelCopy = new State();
		model.copyState(modelCopy);
		originator.setState(modelCopy);
		ani = new Animation(model);
		redoBtn.setDisable(true);
		undoBtn.setDisable(true);
		RenderImg(model.getRightBankCrossers(), model.getLeftBankCrossers(), model.getBoatRiders(),
				model.getIsBoatOnTheLeftBank());
	}

	@Override
	public void resetGame() {

		model.clearBoatRiders();
		model.clearLeftBank();
		model.clearRightBank();
		model.setNumberOfMoves(0);
		model.setBoatOnTheLeftBank(false);
		model.setRightBankCrossers(model.getStrategy().getInitialCrossers());
		careTaker.clearMementoUndoList();
		careTaker.clearMementoRedoList();
		State modelCopy = new State();
		model.copyState(modelCopy);
		originator.setState(modelCopy);
		redoBtn.setDisable(true);
		undoBtn.setDisable(true);
		scoreLabel.setText("Score : " + getNumberOfSails());
		ani.setModel(model);
		RenderImg(model.getRightBankCrossers(), model.getLeftBankCrossers(), model.getBoatRiders(),
				model.getIsBoatOnTheLeftBank());
	}

	@Override
	public String[] getInstructions() {
		return model.getStrategy().getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return model.getRightBankCrossers();
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return model.getLeftBankCrossers();
	}

	public List<ICrosser> getCrossersOnBoat() {
		return model.getBoatRiders();
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
		if (model.getStrategy().isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers)) {
			return true;
		} else {
			return false;
		}
	}

	public void Instructions() {
		InstructionsBox.displayInstructions(getInstructions());
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if (canMove(crossers, fromLeftToRightBank)) {
			careTaker.addMementoUndoList(originator.saveStateToMemento());
			if (!careTaker.getMementoRedoList().isEmpty()) {
				careTaker.clearMementoRedoList();

			}
			undoBtn.setDisable(false);
			if (fromLeftToRightBank == true) {
				for (ICrosser crosser : crossers) {
					model.addRightCrosser(crosser);
				}
				model.clearBoatRiders();
				model.setBoatOnTheLeftBank(false);
				model.setNumberOfMoves(model.getNumberOfMoves() + 1);
			} else {
				for (ICrosser crosser : crossers) {
					model.addLeftCrosser(crosser);
				}
				model.clearBoatRiders();
				model.setBoatOnTheLeftBank(true);
				model.setNumberOfMoves(model.getNumberOfMoves() + 1);
			}
			State modelCopy = new State();
			model.copyState(modelCopy);
			originator.setState(modelCopy);
			RenderImg(model.getRightBankCrossers(), model.getLeftBankCrossers(), model.getBoatRiders(),
					model.getIsBoatOnTheLeftBank());

			scoreLabel.setText("Score : " + getNumberOfSails());
		}
		if (model.getStrategy() instanceof LevelTwo && model.getLeftBankCrossers().size() == 5)
			levelComplete("Well Done Level Two Complete");
		else if (model.getStrategy() instanceof LevelOne && model.getLeftBankCrossers().size() == 4)
			levelComplete("Well Done Level One Complete");
		else if (model.getStrategy() instanceof LevelThree && model.getLeftBankCrossers().size() == 4)
			levelComplete("Well Done Level Three Complete");
	}

	@Override
	public boolean canUndo() {
		if (careTaker.getMementoUndoList().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean canRedo() {
		if (careTaker.getMementoRedoList().isEmpty()) {
			return false;
			// Might use it later(savedState-1) > currentState, true
		} else {
			return true;
		}
	}

	@Override
	public void undo() {
		if (canUndo()) {
			careTaker.addMementoRedoList(originator.saveStateToMemento());
			State state = originator.getStateFromMemento(careTaker.getMementoFromUndoList());
			model = state;
			State modelCopy = new State();
			model.copyState(modelCopy);
			originator.setState(modelCopy);
			ani.setModel(model);
			RenderImg(model.getRightBankCrossers(), model.getLeftBankCrossers(), model.getBoatRiders(),
					model.getIsBoatOnTheLeftBank());
			redoBtn.setDisable(false);
			scoreLabel.setText("Score : " + getNumberOfSails());
		} else {
			undoBtn.setDisable(true);
			Alert.display("Can't undo");
		}

	}

	@Override
	public void redo() {
		if (canRedo()) {
			careTaker.addMementoUndoList(originator.saveStateToMemento());
			State state = originator.getStateFromMemento(careTaker.getMementoFromRedoList());
			model = state;
			State modelCopy = new State();
			model.copyState(modelCopy);
			originator.setState(modelCopy);
			ani.setModel(model);
			RenderImg(model.getRightBankCrossers(), model.getLeftBankCrossers(), model.getBoatRiders(),
					model.getIsBoatOnTheLeftBank());
			undoBtn.setDisable(false);
			scoreLabel.setText("Score : " + getNumberOfSails());

		} else {
			redoBtn.setDisable(true);
			Alert.display("Can't redo");
		}
	}

	@Override
	public void saveGame() {
		UsernameBox save = new UsernameBox();
		save.saveBox(model);
	}

	@Override
	public void loadGame() {
		model = new State();
		model.setUserName(username);
		loadGame = new LoadGame(model);
		ani = new Animation(model);
		careTaker.clearMementoUndoList();
		careTaker.clearMementoRedoList();
		invoker.setCommand(loadGame);
		invoker.executeCommand();
		State modelCopy = new State();
		model.copyState(modelCopy);
		originator.setState(modelCopy);
		undoBtn.setDisable(true);
		redoBtn.setDisable(true);
		scoreLabel.setText("Score : " + getNumberOfSails());
		RenderImg(model.getRightBankCrossers(), model.getLeftBankCrossers(), model.getBoatRiders(),
				model.getIsBoatOnTheLeftBank());
	}

	public void levelComplete(String str) {
		Alert.display(str);

	}

	public void startBtnAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Start.fxml"));
		Parent GameGUI = loader.load();

		Scene GameScene = new Scene(GameGUI);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(GameScene);
		window.show();
	}

	public void btnAction() {

		doMove(getCrossersOnBoat(), isBoatOnTheLeftBank());
	}

	public void RenderImg(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> BoatCrossers, boolean postition) {

		for (int i = 0; i < rightBankCrossers.size(); i++) {
			if (rightBankCrossers.get(i) instanceof Farmer) {
				if (rightBankCrossers.get(i).getWeight() == 0) {
					image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
					farmerImg.setImage(image);
					farmerImg.setLayoutX(683 - ani.getNewXFarmer());
					farmerImg.setLayoutY(490 - ani.getNewYFarmer());
				} else if (rightBankCrossers.get(i).getWeight() == 90) {
					image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
					farmer1Img.setImage(image);
					farmer1Img.setLayoutX(770 - ani.getNewXFarmer1());
					farmer1Img.setLayoutY(510 - ani.getNewYFarmer1());
				} else if (rightBankCrossers.get(i).getWeight() == 80) {
					image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
					farmer2Img.setImage(image);
					farmer2Img.setLayoutX(618 - ani.getNewXFarmer2());
					farmer2Img.setLayoutY(471 - ani.getNewYFarmer2());
				} else if (rightBankCrossers.get(i).getWeight() == 60) {
					image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
					farmer3Img.setImage(image);
					farmer3Img.setLayoutX(840 - ani.getNewXFarmer3());
					farmer3Img.setLayoutY(545 - ani.getNewYFarmer3());
				} else if (rightBankCrossers.get(i).getWeight() == 40) {
					image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
					farmer4Img.setImage(image);
					farmer4Img.setLayoutX(690 - ani.getNewXFarmer4());
					farmer4Img.setLayoutY(500 - ani.getNewYFarmer4());
				}

			} else if (rightBankCrossers.get(i) instanceof Carnivorous) {
				image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
				carniImg.setImage(image);
				carniImg.setLayoutX(744 - ani.getNewXCarni());
				carniImg.setLayoutY(524 - ani.getNewYCarni());
			} else if (rightBankCrossers.get(i) instanceof Herbivorous) {
				if (rightBankCrossers.get(i).getWeight() == 0) {
					image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
					herbiImg.setImage(image);
					herbiImg.setLayoutX(618 - ani.getNewXHerbi());
					herbiImg.setLayoutY(471 - ani.getNewYHerbi());
				} else if (rightBankCrossers.get(i).getWeight() == 20) {
					image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
					animalImg.setImage(image);
					animalImg.setLayoutX(549 - ani.getNewXAnimal());
					animalImg.setLayoutY(462 - ani.getNewYAnimal());
				}
			} else if (rightBankCrossers.get(i) instanceof Plant) {
				image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
				plantImg.setImage(image);
				plantImg.setLayoutX(825 - ani.getNewXPlant());
				plantImg.setLayoutY(539 - ani.getNewYPlant());
			}

			else if (model.getRightBankCrossers().get(i).getLabelToBeShown().equals("Arrogant")) {
				image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
				arrogentImg.setImage(image);
				arrogentImg.setLayoutX(744 - ani.getNewXArrogent());
				arrogentImg.setLayoutY(524 - ani.getNewYArrogent());

			} else if (model.getRightBankCrossers().get(i).getLabelToBeShown().equals("Brave1")) {

				image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
				braveImg1.setImage(image);
				braveImg1.setLayoutX(618 - ani.getNewXBrave1());
				braveImg1.setLayoutY(471 - ani.getNewYBrave1());
			} else if (model.getRightBankCrossers().get(i).getLabelToBeShown().equals("Brave2")) {
				image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
				braveImg2.setImage(image);
				braveImg2.setLayoutX(683 - ani.getNewXBrave2());
				braveImg2.setLayoutY(490 - ani.getNewYBrave2());
			} else if (model.getRightBankCrossers().get(i).getLabelToBeShown().equals("Lazy")) {
				image = SwingFXUtils.toFXImage(rightBankCrossers.get(i).getImages()[0], null);
				lazyImg.setImage(image);
				lazyImg.setLayoutX(825 - ani.getNewXLazy());
				lazyImg.setLayoutY(539 - ani.getNewYLazy());
			}
		}
		for (int i = 0; i < leftBankCrossers.size(); i++) {
			if (leftBankCrossers.get(i) instanceof Farmer) {
				if (leftBankCrossers.get(i).getWeight() == 0) {
					image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
					farmerImg.setImage(image);
					farmerImg.setLayoutX(195 - ani.getNewXFarmer());
					farmerImg.setLayoutY(510 - ani.getNewYFarmer());
				} else if (leftBankCrossers.get(i).getWeight() == 90) {
					image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
					farmer1Img.setImage(image);
					farmer1Img.setLayoutX(200 - ani.getNewXFarmer1());
					farmer1Img.setLayoutY(490 - ani.getNewYFarmer1());
				} else if (leftBankCrossers.get(i).getWeight() == 80) {
					image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
					farmer2Img.setImage(image);
					farmer2Img.setLayoutX(130 - ani.getNewXFarmer2());
					farmer2Img.setLayoutY(505 - ani.getNewYFarmer2());
				} else if (leftBankCrossers.get(i).getWeight() == 60) {
					image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
					farmer3Img.setImage(image);
					farmer3Img.setLayoutX(60 - ani.getNewXFarmer3());
					farmer3Img.setLayoutY(557 - ani.getNewYFarmer3());
				} else if (leftBankCrossers.get(i).getWeight() == 40) {
					image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
					farmer4Img.setImage(image);
					farmer4Img.setLayoutX(0 - ani.getNewXFarmer4());
					farmer4Img.setLayoutY(550 - ani.getNewYFarmer4());
				}
			} else if (leftBankCrossers.get(i) instanceof Carnivorous) {
				image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
				carniImg.setImage(image);
				carniImg.setLayoutX(100 - ani.getNewXCarni());
				carniImg.setLayoutY(550 - ani.getNewYCarni());
			} else if (leftBankCrossers.get(i) instanceof Herbivorous) {
				if (leftBankCrossers.get(i).getWeight() == 0) {
					image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
					herbiImg.setImage(image);
					herbiImg.setLayoutX(280 - ani.getNewXHerbi());
					herbiImg.setLayoutY(480 - ani.getNewYHerbi());
				} else if (leftBankCrossers.get(i).getWeight() == 20) {
					image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
					animalImg.setImage(image);
					animalImg.setLayoutX(262 - ani.getNewXAnimal());
					animalImg.setLayoutY(462 - ani.getNewYAnimal());
				}
			} else if (leftBankCrossers.get(i) instanceof Plant) {
				image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
				plantImg.setImage(image);
				plantImg.setLayoutX(40 - ani.getNewXPlant());
				plantImg.setLayoutY(539 - ani.getNewYPlant());
			} else if (model.getLeftBankCrossers().get(i).getLabelToBeShown().equals("Arrogant")) {
				image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
				arrogentImg.setImage(image);
				arrogentImg.setLayoutX(100 - ani.getNewXArrogent());
				arrogentImg.setLayoutY(550 - ani.getNewYArrogent());
			} else if (model.getLeftBankCrossers().get(i).getLabelToBeShown().equals("Brave1")) {
				image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
				braveImg1.setImage(image);
				braveImg1.setLayoutX(280 - ani.getNewXBrave1());
				braveImg1.setLayoutY(480 - ani.getNewYBrave1());
			} else if (model.getLeftBankCrossers().get(i).getLabelToBeShown().equals("Brave2")) {
				image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
				braveImg2.setImage(image);
				braveImg2.setLayoutX(195 - ani.getNewXBrave2());
				braveImg2.setLayoutY(510 - ani.getNewYBrave2());
			} else if (model.getLeftBankCrossers().get(i).getLabelToBeShown().equals("Lazy")) {
				image = SwingFXUtils.toFXImage(leftBankCrossers.get(i).getImages()[1], null);
				lazyImg.setImage(image);
				lazyImg.setLayoutX(40 - ani.getNewXLazy());
				lazyImg.setLayoutY(539 - ani.getNewYLazy());
			}
		}
		if (!postition) {

			boatImg.setLayoutX(667);
			boatImg.setLayoutY(692);

		} else {

			boatImg.setLayoutX(67);
			boatImg.setLayoutY(692);

		}
	}

	public ImageView getinBoat(int i) {

		int j = model.getBoatRiders().get(i).toString().indexOf("@");
		switch (model.getBoatRiders().get(i).toString().substring(0, j)) {

		case "Farmer":
			return farmerImg;

		case "Carnivorous":
			return carniImg;

		case "Herbivorous":
			return herbiImg;

		case "Plant":
			return plantImg;

		default:
			return null;
		}

	}

	public void initialize(URL location, ResourceBundle resources) {

		scoreLabel.setText("Score : 0");

		Tooltip.install(farmerImg, new Tooltip("Character : Farmer \n Eating Rank : Non"));
		Tooltip.install(plantImg, new Tooltip("Character : Plant \n Eating Rank : 0"));
		Tooltip.install(herbiImg, new Tooltip("Character : Herbivorous \n Eating Rank : 1"));
		Tooltip.install(carniImg, new Tooltip("Character : Carnivorous \n Eating Rank : 2"));
		Tooltip.install(farmer1Img, new Tooltip("Character : Farmer 1 \n Weight : 90"));
		Tooltip.install(farmer2Img, new Tooltip("Character : Farmer 2 \n Weight : 80"));
		Tooltip.install(farmer3Img, new Tooltip("Character : Farmer 3 \n Weight : 60"));
		Tooltip.install(farmer4Img, new Tooltip("Character : Farmer 4 \n Weight : 40"));
		Tooltip.install(animalImg, new Tooltip("Character : Animal \n Weight : 20"));
		Tooltip.install(lazyImg, new Tooltip("Character : Lazy Soldier"));
		Tooltip.install(arrogentImg, new Tooltip("Character : Arrogent Soldier"));
		Tooltip.install(braveImg1, new Tooltip("Character : Brave Soldier"));
		Tooltip.install(braveImg2, new Tooltip("Character : Brave Soldier"));

		plantImg.setOnMouseClicked(e -> {
			ani.movePlant(plantImg);
		});

		carniImg.setOnMouseClicked(e -> {
			ani.moveCarni(carniImg);
		});

		herbiImg.setOnMouseClicked(e -> {
			ani.moveHerbi(herbiImg);
		});

		farmerImg.setOnMouseClicked(e -> {
			ani.moveFarmer(farmerImg);
		});
		farmer1Img.setOnMouseClicked(e -> {
			ani.moveFarmer1(farmer1Img);
		});
		farmer2Img.setOnMouseClicked(e -> {
			ani.moveFarmer2(farmer2Img);
		});
		farmer3Img.setOnMouseClicked(e -> {
			ani.moveFarmer3(farmer3Img);
		});
		farmer4Img.setOnMouseClicked(e -> {
			ani.moveFarmer4(farmer4Img);
		});
		animalImg.setOnMouseClicked(e -> {
			ani.moveAnimal(animalImg);
		});
		lazyImg.setOnMouseClicked(e -> {
			ani.moveLazy(lazyImg);
		});
		braveImg1.setOnMouseClicked(e -> {
			ani.moveBrave1(braveImg1);
		});
		braveImg2.setOnMouseClicked(e -> {
			ani.moveBrave2(braveImg2);
		});
		arrogentImg.setOnMouseClicked(e -> {
			ani.moveArrogent(arrogentImg);
		});
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		if(model.getStrategy() instanceof LevelOne) {
		media = new Media("file:///G:/JavaProjects/GameProject2/GameProject/LevelOne.mp4");
		}
		else if(model.getStrategy() instanceof LevelTwo) {
		media = new Media("file:///G:/JavaProjects/GameProject2/GameProject/LevelTwo.mp4");
			}
		else if(model.getStrategy() instanceof LevelThree) {
		media = new Media("file:///G:/JavaProjects/GameProject2/GameProject/LevelThree.mp4");
			}
		MediaController.playVideo(media);
		return null;
	}

	public void setUsername(String name) {
		username = name;
	}
}
