import java.awt.image.BufferedImage;

public class Carnivorous extends Animal {

    public Carnivorous(double w, BufferedImage[] g) {
        super(w, g);
    }

    public Carnivorous(BufferedImage[] g) {
        super(g);
    }

    @Override
    public int getEatingRank() {
        return 2;
    }
}
