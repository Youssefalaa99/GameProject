import java.util.ArrayList;
import java.util.List;

public class State {
    private List<ICrosser> rightBankCrossers;
    private List<ICrosser> leftBankCrossers;
    private List<ICrosser> boatRiders;
    private int numberOfMoves;
    private boolean isBoatOnTheLeftBank;

    public State(){
        rightBankCrossers=new ArrayList<>();
        leftBankCrossers=new ArrayList<>();
        boatRiders=new ArrayList<>();
        isBoatOnTheLeftBank=true;
        numberOfMoves=0;
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

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public boolean isBoatOnTheLeftBank() {
        return isBoatOnTheLeftBank;
    }

    public void setBoatOnTheLeftBank(boolean boatOnTheLeftBank) {
        isBoatOnTheLeftBank = boatOnTheLeftBank;
    }

    public void addLeftCrosser(ICrosser crosser){
        leftBankCrossers.add(crosser);
    }

    public void removeLeftCrosser(ICrosser crosser){
            leftBankCrossers.remove(crosser);
    }

    public void addRightCrosser(ICrosser crosser){
        rightBankCrossers.add(crosser);
    }

    public void removeRightCrosser(ICrosser crosser){
        rightBankCrossers.remove(crosser);
    }

    public void addRider(ICrosser crosser){
        boatRiders.add(crosser);
    }

    public void removeRider(ICrosser crosser){
        boatRiders.remove(crosser);
    }

    public void clearBoatRiders(){
        boatRiders.clear();
    }

    public void clearLeftBank(){
        leftBankCrossers.clear();
    }

    public void clearRightBank(){
        rightBankCrossers.clear();
    }

    public State copyState(){
        State state=new State();
        List<ICrosser> leftCrossers=new ArrayList<>();
        List<ICrosser> rightCrossers=new ArrayList<>();
        List<ICrosser> boatRiders=new ArrayList<>();
        for(ICrosser crosser : this.getLeftBankCrossers()){
            leftCrossers.add(crosser);
        }
        for(ICrosser crosser : this.getRightBankCrossers()){
            rightCrossers.add(crosser);
        }
        for(ICrosser crosser : this.getBoatRiders()){
            boatRiders.add(crosser);
        }

        state.setBoatOnTheLeftBank(this.isBoatOnTheLeftBank());
        state.setNumberOfMoves(this.getNumberOfMoves());
        state.setLeftBankCrossers(leftCrossers);
        state.setRightBankCrossers(rightCrossers);
        state.setBoatRiders(boatRiders);

        return state;
    }

    @Override
    public String toString() {
        return "State{" +
                "rightBankCrossers=" + rightBankCrossers +
                ", leftBankCrossers=" + leftBankCrossers +
                ", boatRiders=" + boatRiders +
                ", numberOfMoves=" + numberOfMoves +
                ", isBoatOnTheLeftBank=" + isBoatOnTheLeftBank +
                '}';
    }
}
