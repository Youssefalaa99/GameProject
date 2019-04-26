import java.util.ArrayList;
import java.util.List;

public class State {
    private List<ICrosser> rightBankCrossers;
    private List<ICrosser> leftBankCrossers;
    private List<ICrosser> boatRiders;
    private String numberOfMoves;
    private boolean isBoatOnTheLeftBank;

    public State(){
        rightBankCrossers=new ArrayList<>();
        leftBankCrossers=new ArrayList<>();
        boatRiders=new ArrayList<>();
    }

    public List<ICrosser> getRightBankCrossers() {
        return rightBankCrossers;
    }

    public void setRightBankCrossers(List<ICrosser> rightBankCrossers) {
        this.rightBankCrossers = rightBankCrossers;
    }

    public List<ICrosser> getLeftBankCrossers() {
        return leftBankCrossers;
    }

    public void setLeftBankCrossers(List<ICrosser> leftBankCrossers) {
        this.leftBankCrossers = leftBankCrossers;
    }

    public List<ICrosser> getBoatRiders() {
        return boatRiders;
    }

    public void setBoatRiders(List<ICrosser> boatRiders) {
        this.boatRiders = boatRiders;
    }

    public String getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(String numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public boolean isBoatOnTheLeftBank() {
        return isBoatOnTheLeftBank;
    }

    public void setBoatOnTheLeftBank(boolean boatOnTheLeftBank) {
        isBoatOnTheLeftBank = boatOnTheLeftBank;
    }
}
