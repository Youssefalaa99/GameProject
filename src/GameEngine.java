import java.util.ArrayList;
import java.util.List;

public class GameEngine implements IRiverCrossingController {
    private static GameEngine instance;
    private ICrossingStrategy strategy;



    private GameEngine(){
    }

    //Singleton Designed
    public static synchronized GameEngine getInstance(){
        if(instance==null)
            instance=new GameEngine();

        return instance;
    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        this.strategy=gameStrategy;
    }

    @Override
    public void resetGame() {

    }

    @Override
    public String[] getInstructions() {
        return strategy.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        List<ICrosser> rightCrossers=new ArrayList<>();
        return rightCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        List<ICrosser> leftCrossers=new ArrayList<>();
        return leftCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return false;
    }

    @Override
    public int getNumberOfSails() {
        return 0;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        if(strategy.isValid(getCrossersOnRightBank(),getCrossersOnLeftBank(),crossers)){
            System.out.println("Can move");
            return true;
        }
        else {
            System.out.println("Can't move");
            return false;
        }
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        if(canMove(crossers,fromLeftToRightBank)){
            //Test
            System.out.println("Doing move");

        }

    }

    @Override
    public boolean canUndo() {
        return false;
    }

    @Override
    public boolean canRedo() {
        return false;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }
}
