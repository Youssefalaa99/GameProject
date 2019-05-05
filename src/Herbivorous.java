import java.awt.image.BufferedImage;

public class Herbivorous extends Animal {
    private final int eatingRank=1;
    public Herbivorous(double w, BufferedImage[] g,String lbl) {
        super(w, g,lbl);
    }

    public Herbivorous(BufferedImage[] g,String label) {
        super(g,label);
    }

    @Override
    public int getEatingRank() {
        return eatingRank;
    }
}
