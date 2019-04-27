import java.awt.image.BufferedImage;

public class Farmer implements ICrosser {

    private double weight;
    private BufferedImage[] gif;
    private String lbl;
    private final int eatingRank=5;

    public Farmer (double w,BufferedImage[] g){
        weight=w;
        gif=g;
    }

    public Farmer (BufferedImage[] g){
        gif=g;
    }

    public boolean canSail(){
        return true;
    }


    public double getWeight(){
        return weight;
    }

    public int getEatingRank(){

        return eatingRank;
    }


    public BufferedImage[] getImages(){
        return gif;
    }


    public ICrosser makeCopy(){

        return  null;
    }


    public void setLabelToBeShown(String label){
        lbl=label;
    }

    public String getLabelToBeShown() {
        return lbl;
    }

}
