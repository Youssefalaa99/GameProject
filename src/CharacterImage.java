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
            farmerOneLeft= ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            farmerOneRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            farmerTwoLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            farmerTwoRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            farmerThreeLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            farmerThreeRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            farmerFourLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            farmerFourRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            carnivoreOneLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            carnivoreOneRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            carnivoreTwoLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            carnivoreTwoRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            herbivoreOneLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            herbivoreOneRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            herbivoreTwoLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            herbivoreTwoRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            plantLeft=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));
            plantRight=ImageIO.read(new FileInputStream("0daaf84bd3b5131848363609de6868d5.jpg"));

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
