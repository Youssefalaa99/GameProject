import java.awt.image.BufferedImage;

public class Herbivorous extends Animal {
    private final int eatingRank=3;
    public Herbivorous(double w, BufferedImage[] g) {
        super(w, g);
    }

    public Herbivorous(BufferedImage[] g) {
        super(g);
    }

    @Override
    public int getEatingRank() {
        return eatingRank;
    }
}
