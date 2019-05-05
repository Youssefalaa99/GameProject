import java.awt.image.BufferedImage;

public class Carnivorous extends Animal {
    private final int eatingRank=2;

    public Carnivorous(BufferedImage[] g,String label) {
        super(g,label);
    }

    @Override
    public int getEatingRank() {
        return eatingRank;
    }
}
