import java.awt.image.BufferedImage;

public class Farmer implements ICrosser {

    private double weight=0.0;
    private BufferedImage[] gif;
    private String lbl;

    @Override
    public boolean canSailAccompanied() {
        return false;
    }

    @Override
    public boolean canStayAlone() {
        return false;
    }

    @Override
    public boolean mustSailAccompanied() {
        return false;
    }

    private final int eatingRank=4;

    public Farmer (double w,BufferedImage[] g,String label){
        weight=w;
        gif=g;
        lbl=label;
    }

    public Farmer (BufferedImage[] g,String label){
        gif=g;
        lbl=label;
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
