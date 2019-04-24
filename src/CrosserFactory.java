import java.awt.image.BufferedImage;

public class CrosserFactory {

    public ICrosser createCrosseer(String crType,double weight,BufferedImage[] gif){

        switch (crType) {
            case "F":
                return new Farmer(weight, gif);
            case "C":
                return new Carnivorous(weight, gif);
            case "H":
                return new Herbivorous(weight, gif);
            case "P":
                return new Plant(gif);
        }
        return null;
    }

    public ICrosser createCrosseer(String crType,BufferedImage[] gif){

        switch (crType) {
            case "F":
                return new Farmer(gif);
            case "C":
                return new Carnivorous(gif);
            case "H":
                return new Herbivorous(gif);
            case "P":
                return new Plant(gif);
        }
        return null;
    }
}
