import java.awt.image.BufferedImage;

public class Herbivorous extends Animal {
    public Herbivorous(float w, BufferedImage[] g) {
        super(w, g);
    }

    public Herbivorous(BufferedImage[] g) {
        super(g);
    }

    @Override
    public int getEatingRank() {
        return 3;
    }
}
