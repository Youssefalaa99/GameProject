import java.util.List;

public class GameEngine implements IRiverCrossingController {
    private static GameEngine instance;

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

    }

    @Override
    public void resetGame() {

    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return null;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return null;
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
        return false;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

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