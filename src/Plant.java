import java.awt.image.BufferedImage;

public class Plant implements ICrosser {

    private BufferedImage[] gif;
    private String lbl;
    private final int eatingRank=0;


    public  Plant (BufferedImage[] g,String label){
        gif=g;
        lbl=label;
    }

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

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public int getEatingRank() {
        return eatingRank;
    }

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
