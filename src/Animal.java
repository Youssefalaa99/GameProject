import java.awt.image.BufferedImage;

public abstract class Animal implements ICrosser{

    private double weight;
    private BufferedImage[] gif;
    private String lbl;

    public Animal (double w,BufferedImage[] g){
        weight=w;
        gif=g;
    }

    public Animal (BufferedImage[] g){
        gif=g;
    }


    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getEatingRank(){ return 2;}

    @Override
    public BufferedImage[] getImages() {
        return gif;
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {
        lbl=label;

    }

    @Override
    public String getLabelToBeShown() {
        return lbl;
    }
}
