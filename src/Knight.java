import java.awt.image.BufferedImage;

public class Knight implements ICrosser {
    private BufferedImage[] bufferedImages;
    private String label;
    private boolean canSailAccompanied;
    private boolean mustSailAccompanied;
    private boolean canStayAlone;


    public Knight(BufferedImage[] bufferedImages, String label, boolean canSailAccompanied, boolean canStayAlone, boolean mustSailAccopanied) {
        this.bufferedImages = bufferedImages;
        this.label = label;
        this.canSailAccompanied = canSailAccompanied;
        this.canStayAlone = canStayAlone;
        this.mustSailAccompanied =mustSailAccopanied;
    }

    @Override
    public boolean canSail() {
        return true;
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
        return bufferedImages;
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.label=label;
    }

    @Override
    public String getLabelToBeShown() {
        return this.label;
    }

    public boolean canSailAccompanied() {
        return canSailAccompanied;
    }

    public boolean canStayAlone() {
        return canStayAlone;
    }

    public boolean mustSailAccompanied() {
        return mustSailAccompanied;
    }
}
