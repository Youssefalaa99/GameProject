import java.util.ArrayList;
import java.util.List;

public class LevelThree implements ICrossingStrategy {
    private ICrosser braveKnight1;
    private ICrosser braveKnight2;
    private ICrosser lazyKnight;
    private ICrosser arrogantKnight;


    public LevelThree(){
        CrosserFactory factory = new CrosserFactory();
        braveKnight1 =factory.createCrosseer("BK");
        braveKnight2 =factory.createCrosseer("BK1");
        lazyKnight =factory.createCrosseer("LK");
        arrogantKnight =factory.createCrosseer("AK");
    }

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        if(boatRiders.isEmpty()){
            Alert.display("Boat is Empty!");
            return false;
        }

        for(ICrosser crosser : leftBankCrossers){
            if(crosser.canStayAlone()==false && leftBankCrossers.size()==1){
                Alert.display("Lazy Knight can't stay alone!");
                return false;
            }
        }

        for(ICrosser crosser : rightBankCrossers){
            if(crosser.canStayAlone()==false && rightBankCrossers.size()==1){
                Alert.display("Lazy Knight can't stay alone!");
                return false;
            }
        }

        for(ICrosser crosser : boatRiders){
            if(crosser.mustSailAccompanied()==true && boatRiders.size()==1){
                Alert.display("Lazy Knight can't raft the boat alone!");
                return false;
            }
        }

        for(ICrosser crosser : boatRiders){
            if(crosser.mustSailAccompanied()==false && crosser.canSailAccompanied()==false && boatRiders.size()>1){
                Alert.display("Arrogant Knight can't sail accompanied!");
                return false;
            }
        }

        return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> crossers=new ArrayList<>();
        crossers.add(braveKnight1);
        crossers.add(braveKnight2);
        crossers.add(lazyKnight);
        crossers.add(arrogantKnight);
        return crossers;
    }

    @Override
    public String[] getInstructions() {
        String[] instructions = new String[5];
        instructions[0] = "Two brave knights, one lazy knight and one arrogant knight want to cross the river.";
        instructions[1] = "1- The raft can hold a maximum of two soldiers.";
        instructions[2] = "2- The lazy soldier refuses to be alone either on the raft or on either bank.";
        instructions[3] = "3- The arrogant one refuses to be accompanied on the raft.";
        return instructions;
    }
}
