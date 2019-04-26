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
            farmerOneLeft= ImageIO.read(new FileInputStream("800px_COLOURBOX19177957.jpg"));
            farmerOneRight=ImageIO.read(new FileInputStream("800px_COLOURBOX19177957.jpg"));
            farmerTwoLeft=ImageIO.read(new FileInputStream("images.jpg"));
            farmerTwoRight=ImageIO.read(new FileInputStream("images.jpg"));
            farmerThreeLeft=ImageIO.read(new FileInputStream("kisspng-farmer-cartoon-agriculture-happy-farmer-5aa91eb1c1c197.9041284315210328817936.jpg"));
            farmerThreeRight=ImageIO.read(new FileInputStream("kisspng-farmer-cartoon-agriculture-happy-farmer-5aa91eb1c1c197.9041284315210328817936.jpg"));
            farmerFourLeft=ImageIO.read(new FileInputStream("kisspng-farmer-cartoon-agriculture-holding-the-fork-of-the-uncle-5a8810f07dd964.9404825515188666725155.jpg"));
            farmerFourRight=ImageIO.read(new FileInputStream("kisspng-farmer-cartoon-agriculture-holding-the-fork-of-the-uncle-5a8810f07dd964.9404825515188666725155.jpg"));
            carnivoreOneLeft=ImageIO.read(new FileInputStream("images.jpg"));
            carnivoreOneRight=ImageIO.read(new FileInputStream("images.jpg"));
            carnivoreTwoLeft=ImageIO.read(new FileInputStream("images.jpg"));
            carnivoreTwoRight=ImageIO.read(new FileInputStream("images.jpg"));
            herbivoreOneLeft=ImageIO.read(new FileInputStream("images.jpg"));
            herbivoreOneRight=ImageIO.read(new FileInputStream("images.jpg"));
            herbivoreTwoLeft=ImageIO.read(new FileInputStream("images.jpg"));
            herbivoreTwoRight=ImageIO.read(new FileInputStream("images.jpg"));
            plantLeft=ImageIO.read(new FileInputStream("images.jpg"));
            plantRight=ImageIO.read(new FileInputStream("images.jpg"));

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
