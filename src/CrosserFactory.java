import java.awt.image.BufferedImage;
import java.util.Random;

public class CrosserFactory {
    private CharacterImage characterImage;


    public CrosserFactory(){
        characterImage=new CharacterImage();
    }

    public ICrosser createCrosseer(String crType,double weight){
        Random random=new Random();
        int randomNumber= random.nextInt(2);

        switch (crType) {
            case "F1":
                return new Farmer(weight, characterImage.getFarmerOneImages());
            case "F2":
                return new Farmer(weight, characterImage.getFarmerTwoImages());
            case "F3":
                return new Farmer(weight, characterImage.getFarmerThreeImages());
            case "F4":
                return new Farmer(weight, characterImage.getFarmerFourImages());
            case "C":
                if(randomNumber==0)
                    return new Carnivorous(weight, characterImage.getCarnivoreOneImages());
                else return new Carnivorous(weight, characterImage.getCarnivoreTwoImages());
            case "H":
                if(randomNumber==0)
                    return new Herbivorous(weight, characterImage.getHerbivoreOneImages());
                else return new Herbivorous(weight, characterImage.getHerbivoreTwoImages());
            case "P":
                return new Plant(characterImage.getPlantImages());
            default:
                return null;
        }

    }

    public ICrosser createCrosseer(String crType){
        Random random=new Random();
        int randomNumber= random.nextInt(2);

        switch (crType) {
            case "F1":
                return new Farmer(characterImage.getFarmerOneImages());
            case "F2":
                return new Farmer(characterImage.getFarmerTwoImages());
            case "F3":
                return new Farmer(characterImage.getFarmerThreeImages());
            case "F4":
                return new Farmer(characterImage.getFarmerFourImages());
            case "C":
                if(randomNumber==0)
                    return new Carnivorous(characterImage.getCarnivoreOneImages());
                else return new Carnivorous(characterImage.getCarnivoreTwoImages());
            case "H":
                if(randomNumber==0)
                    return new Herbivorous(characterImage.getHerbivoreOneImages());
                else return new Herbivorous(characterImage.getHerbivoreTwoImages());
            case "P":
                return new Plant(characterImage.getPlantImages());
            default:
                return null;
        }
    }
}
