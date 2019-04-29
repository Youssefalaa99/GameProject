import java.util.List;

public class GameEngine implements IRiverCrossingController {
    private static GameEngine instance;
    private State model;
    private int currentState=0;
    private int savedState=0;
    private Originator originator=new Originator();
    private CareTaker careTaker=new CareTaker();
    private Invoker invoker=new Invoker();
    private LoadGame loadGame;
    private SaveGame saveGame;




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
        model=new State();
        model.setStrategy(gameStrategy);
        model.setRightBankCrossers(model.getStrategy().getInitialCrossers());
        //Memento setup
        originator.setState(model.copyState());
        careTaker.addMemento(originator.saveStateToMemento());
        savedState++;
        //Command setup
        loadGame=new LoadGame(model);
        saveGame=new SaveGame(model);
        //Rendering happens here
    }

    @Override
    public void resetGame() {
        model.clearBoatRiders();
        model.clearLeftBank();
        model.clearRightBank();
        model.setNumberOfMoves(0);
        model.setBoatOnTheLeftBank(false);
        model.setRightBankCrossers(model.getStrategy().getInitialCrossers());
        currentState=0;
        savedState=0;
        careTaker.clearMemento();
        originator.setState(model.copyState());
        careTaker.addMemento(originator.saveStateToMemento());
        savedState++;
        //Undo & Redo buttons disabled here
    }

    @Override
    public String[] getInstructions() {
        return model.getStrategy().getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return model.getRightBankCrossers();
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return model.getLeftBankCrossers();
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return model.getIsBoatOnTheLeftBank();
    }

    @Override
    public int getNumberOfSails() {
        return model.getNumberOfMoves();
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        if(model.getStrategy().isValid(getCrossersOnRightBank(),getCrossersOnLeftBank(),crossers)){
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
//            if(fromLeftToRightBank==true){
//                for(ICrosser crosser : crossers){
//                    model.removeLeftCrosser(crosser);
//                    model.addRightCrosser(crosser);
//                }
//                model.setBoatOnTheLeftBank(false);
//                model.setNumberOfMoves(model.getNumberOfMoves()+1);
//            }
//            else {
//                for(ICrosser crosser : crossers){
//                    model.removeRightCrosser(crosser);
//                    model.addLeftCrosser(crosser);
//                }
//                model.setBoatOnTheLeftBank(true);
//                model.setNumberOfMoves(model.getNumberOfMoves()+1);
//            }

            //Write code moving here and change model

            originator.setState(model.copyState());
            careTaker.addMemento(originator.saveStateToMemento());
            savedState++;
            currentState++;
            //Undo button set enabled here
        }
        else {

        }

    }

    @Override
    public boolean canUndo() {
        if(currentState >= 1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean canRedo() {
        if((savedState-1) > currentState){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void undo() {
        if(canUndo()){
            currentState--;
            model=originator.getStateFromMemento(careTaker.getMemento(currentState));
            //Rendering new view in scene builder
            //Redo button enabled here
            System.out.println("Undo done");
        }
        else{
            //Undo button disabled here
            System.out.println("Can't undo");
        }

    }

    @Override
    public void redo() {
        if(canRedo()){
            currentState++;
            model=originator.getStateFromMemento(careTaker.getMemento(currentState));
            //Rendering new view in scene builder
            //Undo button enabled here
            System.out.println("Redo done");
        }
        else {
            //Redo button disabled here
            System.out.println("Can't Redo");
        }
    }

    @Override
    public void saveGame() {
        invoker.setCommand(saveGame);
        invoker.executeCommand();
    }

    @Override
    public void loadGame() {
        invoker.setCommand(loadGame);
        invoker.executeCommand();
    }

    public void levelOneComplete(){
        /**MessageBox with restart button and nextLevel button
         * if pressed restart call restart method
         * if pressd next level do ICrossingStrategy strategy=new LevelTwo();
         * then call newGame(strategy);
        **/
    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    //Test to be removed:
    public void printState(){
        System.out.println(model.toString());
    }
    //Test to be removed:
    public void removeLeft(ICrosser crosser){
        model.removeLeftCrosser(crosser);
    }
    //Test to be removed:
    public void removeRight(ICrosser crosser){
        model.removeRightCrosser(crosser);
    }
    //Test to be removed:
    public void addRider(ICrosser crosser){
        model.addRider(crosser);
    }
}
