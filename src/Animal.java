import java.awt.image.BufferedImage;

public abstract class Animal implements ICrosser{

    private double weight=0.0;
    private BufferedImage[] gif;
    private String lbl;

    public Animal (double w,BufferedImage[] g,String label){
        weight=w;
        gif=g;
        lbl=label;
    }

    public Animal (BufferedImage[] g,String label){
        gif=g;
        lbl=label;
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
    public abstract int getEatingRank();

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
