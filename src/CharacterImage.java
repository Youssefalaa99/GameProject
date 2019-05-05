import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class CharacterImage {
    private BufferedImage farmerOneLeft;
    private BufferedImage farmerOneRight;
    private BufferedImage farmerTwoLeft;
    private BufferedImage farmerTwoRight;
    private BufferedImage farmerThreeLeft;
    private BufferedImage farmerThreeRight;
    private BufferedImage farmerFourLeft;
    private BufferedImage farmerFourRight;
    private BufferedImage carnivoreOneLeft;
    private BufferedImage carnivoreOneRight;
    private BufferedImage carnivoreTwoLeft;
    private BufferedImage carnivoreTwoRight;
    private BufferedImage herbivoreOneLeft;
    private BufferedImage herbivoreOneRight;
    private BufferedImage herbivoreTwoLeft;
    private BufferedImage herbivoreTwoRight;
    private BufferedImage plantLeft;
    private BufferedImage plantRight;

    public CharacterImage(){
        try{
            farmerOneLeft= ImageIO.read(new FileInputStream("Farmer_Left.jpg"));
            farmerOneRight=ImageIO.read(new FileInputStream("Farmer_Right.jpg"));
            farmerTwoLeft=ImageIO.read(new FileInputStream("Farmer1_Left.png"));
            farmerTwoRight=ImageIO.read(new FileInputStream("Farmer1_Right.png"));
            farmerThreeLeft=ImageIO.read(new FileInputStream("Farmer2.png"));
            farmerThreeRight=ImageIO.read(new FileInputStream("Farmer2.png"));
            farmerFourLeft=ImageIO.read(new FileInputStream("Farmer3_Left.png"));
            farmerFourRight=ImageIO.read(new FileInputStream("Farmer3_Right.png"));
            carnivoreOneLeft=ImageIO.read(new FileInputStream("Carnivor1_Left.png"));
            carnivoreOneRight=ImageIO.read(new FileInputStream("Carnivor1_Right.png"));
            carnivoreTwoLeft=ImageIO.read(new FileInputStream("Carnivor2_Left.jpg"));
            carnivoreTwoRight=ImageIO.read(new FileInputStream("Carnivor2_Right.jpg"));
            herbivoreOneLeft=ImageIO.read(new FileInputStream("herbivore1_Left.png"));
            herbivoreOneRight=ImageIO.read(new FileInputStream("herbivore1_Right.png"));
            herbivoreTwoLeft=ImageIO.read(new FileInputStream("herbivore2_Left.png"));
            herbivoreTwoRight=ImageIO.read(new FileInputStream("herbivore2_Right.png"));
            plantLeft=ImageIO.read(new FileInputStream("Carrot.png"));
            plantRight=ImageIO.read(new FileInputStream("Carrot.png"));

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public BufferedImage[] getFarmerOneImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=farmerOneLeft;
        farmerImages[1]=farmerOneRight;
        return farmerImages;

    }

    public BufferedImage[] getFarmerTwoImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=farmerTwoLeft;
        farmerImages[1]=farmerTwoRight;
        return farmerImages;

    }

    public BufferedImage[] getFarmerThreeImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=farmerThreeLeft;
        farmerImages[1]=farmerThreeRight;
        return farmerImages;

    }

    public BufferedImage[] getFarmerFourImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=farmerFourLeft;
        farmerImages[1]=farmerFourRight;
        return farmerImages;

    }

    public BufferedImage[] getCarnivoreOneImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=carnivoreOneLeft;
        farmerImages[1]=carnivoreOneRight;
        return farmerImages;

    }

    public BufferedImage[] getCarnivoreTwoImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=carnivoreTwoLeft;
        farmerImages[1]=carnivoreTwoRight;
        return farmerImages;

    }


    public BufferedImage[] getHerbivoreOneImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=herbivoreOneLeft;
        farmerImages[1]=herbivoreOneRight;
        return farmerImages;

    }

    public BufferedImage[] getHerbivoreTwoImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=herbivoreTwoLeft;
        farmerImages[1]=herbivoreTwoRight;
        return farmerImages;

    }


    public BufferedImage[] getPlantImages(){
        BufferedImage[] farmerImages=new BufferedImage[2];
        farmerImages[0]=plantLeft;
        farmerImages[1]=plantRight;
        return farmerImages;

    }
}
