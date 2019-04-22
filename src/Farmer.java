import java.awt.image.BufferedImage;

public class Farmer implements ICrosser {

    private double weight;
    private BufferedImage[] gif;
    private String lbl;


    public Farmer (double w,BufferedImage[] g){
        weight=w;
        gif=g;
    }

    public Farmer (BufferedImage[] g){
        gif=g;
    }
    /**
     * @return whether the crosser can sail the boat or not
     */
    public boolean canSail(){
        return true;
    }

    /**
     * @return get the weight of the crosser
     */
    public double getWeight(){
        return weight;
    }

    /**
     * @return get the eating rank of the crosser
     * this rank can be used to detect if one
     * crosser can eat/harm another crosser
     */
    public int getEatingRank(){

        return 1;
    }

    /**
     * @return images of the crosser
     * each crosser must have at least two images, each one
     * is used on one bank of the river
     */
    public BufferedImage[] getImages(){
        return gif;
    }

    /**
     * @return exact copy of the crosser
     */
    public ICrosser makeCopy(){

        return  null;
    }

    /**
     * this field is used by the game strategy to set the label which
     * will be shown beside the crosser in the game view
     * to inform the user about the criteria of the current level
     * e.g. crosser eating rank
     */
    public void setLabelToBeShown(String label){
        lbl=label;
    }

    public String getLabelToBeShown() {
        return lbl;
    }

}
