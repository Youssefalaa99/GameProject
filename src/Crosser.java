import java.awt.image.BufferedImage;

public class Crosser implements ICrosser {


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
        return 0;
    }

    @Override
    public BufferedImage[] getImages() {
        return new BufferedImage[0];
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {

    }

    @Override
    public String getLabelToBeShown() {
        return null;
    }
}
