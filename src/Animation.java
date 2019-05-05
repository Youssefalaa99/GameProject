import java.util.List;

import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Animation {
	private TranslateTransition move1;
	private TranslateTransition move2;
	private TranslateTransition move3;
	private State model;
	private int newXPlant;
	private int newYPlant;
	private int newXCarni;
	private int newYCarni;
	private int newXFarmer;
	private int newYFarmer;
	private int newXHerbi;
	private int newYHerbi;
	private int newXFarmer1;
	private int newYFarmer1;
	private int newXFarmer2;
	private int newYFarmer2;
	private int newXFarmer3;
	private int newYFarmer3;
	private int newXFarmer4;
	private int newYFarmer4;
	private int newXAnimal;
	private int newYAnimal;

	public Animation(State model) {
		this.model = model;
		move1 = new TranslateTransition();
		move2 = new TranslateTransition();
		move3 = new TranslateTransition();
		move1.setDuration(Duration.millis(200));
		move2.setDuration(Duration.millis(200));
		move3.setDuration(Duration.millis(200));
		newXPlant = 0;
		newYPlant = 0;
		newXCarni = 0;
		newYCarni = 0;
		newXFarmer = 0;
		newYFarmer = 0;
		newXHerbi = 0;
		newYHerbi = 0;
		newXFarmer1 = 0;
		newYFarmer1 = 0;
		newXFarmer2 = 0;
		newYFarmer2 = 0;
		newXFarmer3 = 0;
		newYFarmer3 = 0;
		newXFarmer4 = 0;
		newYFarmer4 = 0;
		newXAnimal = 0;
		newYAnimal = 0;
	}

	public void movePlant(ImageView plantImg) {
		move1.setNode(plantImg);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i) instanceof Plant && model.getBoatRiders().size() < 2) {
				newXPlant += -51;
				newYPlant += 105;
				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				move1.setByX(-51);
				move1.setByY(105);

				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i) instanceof Plant) {
				if (!model.getIsBoatOnTheLeftBank()) {
					newXPlant += 51;
					newYPlant += -105;
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					move1.setByX(51);
					move1.setByY(-105);
					move1.play();
					return;
				} else {
					newXPlant += -123;
					newYPlant += -87;
					move1.setByX(-123);
					move1.setByY(-87);
					move1.play();
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Plant && model.getBoatRiders().size() < 2) {
				newXPlant += 123;
				newYPlant += 87;
				move1.setByX(123);
				move1.setByY(87);
				move1.play();
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				return;
			}
		}
	}

	public void moveCarni(ImageView carniImg) {

		move1.setNode(carniImg);

		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i) instanceof Carnivorous && model.getBoatRiders().size() < 2) {
				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				newXCarni += 28;
				newYCarni += 134;
				move1.setByX(28);
				move1.setByY(134);
				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i) instanceof Carnivorous) {
				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXCarni += -28;
					newYCarni += -134;
					move1.setByX(-28);
					move1.setByY(-134);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXCarni += -55;
					newYCarni += -109;
					move1.setByX(-55);
					move1.setByY(-109);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Carnivorous && model.getBoatRiders().size() < 2) {

				newXCarni += 55;
				newYCarni += 109;
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				move1.setByX(55);
				move1.setByY(109);
				move1.play();
				return;
			}
		}
	}

	public void moveHerbi(ImageView herbiImg) {

		move1.setNode(herbiImg);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++)

			if (model.getRightBankCrossers().get(i) instanceof Herbivorous && model.getBoatRiders().size() < 2) {

				newXHerbi += 158;
				newYHerbi += 165;

				move1.setByX(158);
				move1.setByY(165);
				move1.play();

				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				return;
			}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i) instanceof Herbivorous) {
				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXHerbi += -158;
					newYHerbi += 165;
					move1.setByX(-158);
					move1.setByY(-165);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXHerbi += 63;
					newYHerbi += -143;
					move1.setByX(63);
					move1.setByY(-143);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Herbivorous && model.getBoatRiders().size() < 2) {
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				newXHerbi += -90;
				newYHerbi += 143;
				move1.setByX(-90);
				move1.setByY(143);
				move1.play();
				return;
			}
		}
	}

	public void moveFarmer(ImageView farmerImg) {
		move1.setNode(farmerImg);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i) instanceof Farmer && model.getBoatRiders().size() < 2) {

				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				newXFarmer += 31;
				newYFarmer += 145;
				move1.setByX(31);
				move1.setByY(145);
				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i) instanceof Farmer ) {

				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer += -31;
					newYFarmer += -145;
					move1.setByX(-31);
					move1.setByY(-145);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer += 60;
					newYFarmer += -142;
					move1.setByX(60);
					move1.setByY(-142);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Farmer && model.getBoatRiders().size() < 2) {

				newXFarmer += -75;
				newYFarmer += 142;
				move1.setByX(-75);
				move1.setByY(142);
				move1.play();
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				return;
			}
		}
	}

	public void moveFarmer1(ImageView farmer1Img) {

		move1.setNode(farmer1Img);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i).getWeight() == 90 && model.getBoatRiders().size() < 2) {

				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				newXFarmer1 += -49;
				newYFarmer1 += 101;
				move1.setByX(-49);
				move1.setByY(101);
				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i).getWeight() == 90 ) {

				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer1 += 49;
					newYFarmer1 += -101;
					move1.setByX(49);
					move1.setByY(-101);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer1 += 89;
					newYFarmer1 += -121;
					move1.setByX(89);
					move1.setByY(-121);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Farmer && model.getBoatRiders().size() < 2) {

				newXFarmer1 += -89;
				newYFarmer1 += 121;
				move1.setByX(-89);
				move1.setByY(121);
				move1.play();
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				return;
			}
		}

	}

	public void moveFarmer2(ImageView farmer2Img) {

		move1.setNode(farmer2Img);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i).getWeight() == 80 && model.getBoatRiders().size() < 2) {

				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				newXFarmer2 += 103;
				newYFarmer2 += 140;
				move1.setByX(103);
				move1.setByY(140);
				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i).getWeight() == 80 ) {

				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer2 += -103;
					newYFarmer2 += -140;
					move1.setByX(-103);
					move1.setByY(-140);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer2 += 19;
					newYFarmer2 += -106;
					move1.setByX(19);
					move1.setByY(-106);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Farmer && model.getBoatRiders().size() < 2) {

				newXFarmer2 += -19;
				newYFarmer2 += 106;
				move1.setByX(-19);
				move1.setByY(106);
				move1.play();
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				return;
			}
		}

	}

	public void moveFarmer3(ImageView farmer3Img) {

		move1.setNode(farmer3Img);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i).getWeight() == 60 && model.getBoatRiders().size() < 2) {

				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				newXFarmer3 += -119;
				newYFarmer3 += 66;
				move1.setByX(-119);
				move1.setByY(66);
				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i).getWeight() == 60 ) {

				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer3 += 119;
					newYFarmer3 += -66;
					move1.setByX(119);
					move1.setByY(-66);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer3 += -51;
					newYFarmer3 += -54;
					move1.setByX(-51);
					move1.setByY(-54);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Farmer && model.getBoatRiders().size() < 2) {

				newXFarmer3 += 51;
				newYFarmer3 += 54;
				move1.setByX(51);
				move1.setByY(54);
				move1.play();
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				return;
			}
		}

	}

	public void moveFarmer4(ImageView farmer4Img) {

		move1.setNode(farmer4Img);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i).getWeight() == 40 && model.getBoatRiders().size() < 2) {

				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				newXFarmer4 += 31;
				newYFarmer4 += 111;
				move1.setByX(31);
				move1.setByY(111);
				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i).getWeight() == 40 ) {

				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer4 += -31;
					newYFarmer4 += -111;
					move1.setByX(-31);
					move1.setByY(-111);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXFarmer4 += -111;
					newYFarmer4 += -61;
					move1.setByX(-111);
					move1.setByY(-61);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i) instanceof Farmer && model.getBoatRiders().size() < 2) {

				newXFarmer4 += 111;
				newYFarmer4 += 61;
				move1.setByX(111);
				move1.setByY(61);
				move1.play();
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				return;
			}
		}
	}

	public void moveAnimal(ImageView AnimalImg) {

		move1.setNode(AnimalImg);
		for (int i = 0; i < model.getRightBankCrossers().size(); i++) {
			if (model.getRightBankCrossers().get(i).getWeight() == 20 && model.getBoatRiders().size() < 2) {

				model.getBoatRiders().add(model.getRightBankCrossers().get(i));
				model.getRightBankCrossers().remove(i);
				newXAnimal += 223;
				newYAnimal += 149;
				move1.setByX(223);
				move1.setByY(149);
				move1.play();
				return;
			}
		}
		for (int i = 0; i < model.getBoatRiders().size(); i++) {
			if (model.getBoatRiders().get(i).getWeight() == 20 ) {

				if (!model.getIsBoatOnTheLeftBank()) {
					model.getRightBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXAnimal += -223;
					newYAnimal += -149;
					move1.setByX(-223);
					move1.setByY(-149);
					move1.play();
					return;
				} else {
					model.getLeftBankCrossers().add(model.getBoatRiders().get(i));
					model.getBoatRiders().remove(i);
					newXAnimal += 75;
					newYAnimal += -149;
					move1.setByX(75);
					move1.setByY(-149);
					move1.play();
					return;
				}
			}
		}
		for (int i = 0; i < model.getLeftBankCrossers().size(); i++) {
			if (model.getLeftBankCrossers().get(i).getWeight() == 20  && model.getBoatRiders().size() < 2) {

				newXAnimal += -75;
				newYAnimal += 149;
				move1.setByX(-75);
				move1.setByY(149);
				move1.play();
				model.getBoatRiders().add(model.getLeftBankCrossers().get(i));
				model.getLeftBankCrossers().remove(i);
				return;
			}
		}

	}

	public int getNewXPlant() {
		return newXPlant;
	}

	public int getNewYPlant() {
		return newYPlant;
	}

	public int getNewXCarni() {
		return newXCarni;
	}

	public int getNewYCarni() {
		return newYCarni;
	}

	public int getNewXFarmer() {
		return newXFarmer;
	}

	public int getNewYFarmer() {
		return newYFarmer;
	}

	public int getNewXHerbi() {
		return newXHerbi;
	}

	public int getNewYHerbi() {
		return newYHerbi;
	}
	public int getNewXFarmer1() {
		return newXFarmer1;
	}

	public int getNewYFarmer1() {
		return newYFarmer1;
	}
	public int getNewXFarmer2() {
		return newXFarmer2;
	}

	public int getNewYFarmer2() {
		return newYFarmer2;
	}
	public int getNewXFarmer3() {
		return newXFarmer3;
	}

	public int getNewYFarmer3() {
		return newYFarmer3;
	}
	public int getNewXFarmer4() {
		return newXFarmer4;
	}

	public int getNewYFarmer4() {
		return newYFarmer4;
	}
	public int getNewXAnimal() {
		return newXAnimal;
	}

	public int getNewYAnimal() {
		return newYAnimal;
	}

}
