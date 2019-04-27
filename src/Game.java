import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static void main(String[] args){
        //Test strategy
//        LevelOne levelOne=new LevelOne();
//        System.out.println(levelOne.getInstructions()[2]);

        ArrayList<ICrosser> leftlist=new ArrayList<>();
        ArrayList<ICrosser> rightlist=new ArrayList<>();
        ArrayList<ICrosser> boatlist=new ArrayList<>();
        CrosserFactory factory=new CrosserFactory();
//        ICrosser famer1=factory.createCrosseer("F1");
//        ICrosser famer2=factory.createCrosseer("F2");
//        rightlist.add(factory.createCrosseer("H"));
//        leftlist.add(factory.createCrosseer("C"));
//        rightlist.add(factory.createCrosseer("P"));
//        boatlist.add(famer1);
//        levelOne.isValid(rightlist,leftlist,boatlist);
//
//
//        boatlist.remove(famer1);
//        levelOne.isValid(rightlist,leftlist,boatlist);



        //Test GameEngine
//        GameEngine engine=GameEngine.getInstance();
//        LevelOne one=new LevelOne();
//        engine.newGame(one);
//        engine.printState();
//        List<ICrosser> crossers=engine.getCrossersOnLeftBank();
//        boatlist.add(crossers.get(0));
//        boatlist.add(crossers.get(2));
//        engine.removeLeft(crossers.get(0));
//        engine.removeLeft(crossers.get(1));
//        engine.doMove(boatlist,true);
//        engine.printState();
//        engine.undo();
//        engine.printState();
//        engine.undo();
//        engine.printState();
//        engine.redo();
//        engine.printState();
//        engine.redo();
//        engine.printState();

        //Test Memnto
//        Originator originator=new Originator();
//        CareTaker careTaker=new CareTaker();
//        ArrayList<ICrosser> leftList=new ArrayList<>();
//        ArrayList<ICrosser> rightList=new ArrayList<>();
//        ArrayList<ICrosser> leftList2=new ArrayList<>();
//        ArrayList<ICrosser> rightList2=new ArrayList<>();
//        ArrayList<ICrosser> boatList=new ArrayList<>();
//        State state1=new State();
//        State state2=new State();
//        CrosserFactory factory=new CrosserFactory();
//        ICrosser famer=factory.createCrosseer("F1");
//        ICrosser carnv=factory.createCrosseer("C");
//        ICrosser herb=factory.createCrosseer("H");
//        ICrosser plant=factory.createCrosseer("P");
//        leftList.add(famer);
//        leftList.add(carnv);
//        leftList.add(herb);
//        leftList.add(plant);
//        state1.setLeftBankCrossers(leftList);
//        state1.setRightBankCrossers(rightList);
//        state1.setBoatRiders(boatList);
//        originator.setState(state1);
//        careTaker.addMemento(originator.saveStateToMemento());
//        System.out.println(originator.getState().toString());
//        rightList2.add(famer);
//        rightList2.add(herb);
//        leftList2.add(carnv);
//        leftList2.add(plant);
//        state2.setRightBankCrossers(rightList2);
//        state2.setLeftBankCrossers(leftList2);
//        state2.setNumberOfMoves(1);
//        state2.setBoatOnTheLeftBank(false);
//        originator.setState(state2);
//        careTaker.addMemento(originator.saveStateToMemento());
//        System.out.println(originator.getState().toString());
//        System.out.println("Undo");
//        originator.getStateFromMemento(careTaker.getMemento(0));
//        System.out.println(originator.getState().toString());




    }
}
