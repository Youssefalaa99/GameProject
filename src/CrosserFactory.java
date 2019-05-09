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
                return new Farmer(weight, characterImage.getFarmerOneImages(),"90");
            case "F2":
                return new Farmer(weight, characterImage.getFarmerTwoImages(),"80");
            case "F3":
                return new Farmer(weight, characterImage.getFarmerThreeImages(),"60");
            case "F4":
                return new Farmer(weight, characterImage.getFarmerFourImages(),"40");
            case "C":
                if(randomNumber==0)
                    return new Carnivorous(characterImage.getCarnivoreOneImages(),"20");
                else return new Carnivorous(characterImage.getCarnivoreTwoImages(),"20");
            case "H":
                if(randomNumber==0)
                    return new Herbivorous(weight, characterImage.getHerbivoreOneImages(),"20");
                else return new Herbivorous(weight, characterImage.getHerbivoreTwoImages(),"20");
            default:
                return null;
        }

    }

    public ICrosser createCrosseer(String crType){
        Random random=new Random();
        int randomNumber= random.nextInt(2);

        switch (crType) {
            case "F1":
                return new Farmer(characterImage.getFarmerOneImages(),"4");
            case "F2":
                return new Farmer(characterImage.getFarmerTwoImages(),"4");
            case "F3":
                return new Farmer(characterImage.getFarmerThreeImages(),"4");
            case "F4":
                return new Farmer(characterImage.getFarmerFourImages(),"4");
            case "C":
                if(randomNumber==0)
                    return new Carnivorous(characterImage.getCarnivoreOneImages(),"2");
                else return new Carnivorous(characterImage.getCarnivoreTwoImages(),"2");
            case "H":
                if(randomNumber==0)
                    return new Herbivorous(characterImage.getHerbivoreOneImages(),"1");
                else return new Herbivorous(characterImage.getHerbivoreTwoImages(),"1");
            case "P":
                return new Plant(characterImage.getPlantImages(),"0");
            case "BK":
                return new Knight(characterImage.getBraveKnightImages(),"Brave1",true,true,false);
            case "BK1":
                return new Knight(characterImage.getBraveKnightImages(),"Brave2",true,true,false);
            case "LK":
                return new Knight(characterImage.getLazyKnightImages(),"Lazy",true,false,true);
            case "AK":
                return new Knight(characterImage.getArrogantKnightImages(),"Arrogant",false,true,false);
            default:
                return null;
        }
    }
}
