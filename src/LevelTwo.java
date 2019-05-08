import java.util.ArrayList;
import java.util.List;

public class LevelTwo implements ICrossingStrategy {
    private ICrosser farmer1;
    private ICrosser farmer2;
    private ICrosser farmer3;
    private ICrosser farmer4;
    private ICrosser animal;

    public LevelTwo(){
        CrosserFactory factory=new CrosserFactory();
        farmer1=factory.createCrosseer("F1",90.0);
        farmer2=factory.createCrosseer("F2",80.0);
        farmer3=factory.createCrosseer("F3",60.0);
        farmer4=factory.createCrosseer("F4",40.0);
        animal=factory.createCrosseer("H",20.0);
    }


    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        if(boatRiders.isEmpty()){
        	(new Alert()).display("Empty boat");
            return false;
        }
        int flag=0;
        for(ICrosser crosser : boatRiders){
            if (crosser.canSail()){
                System.out.println("Farmer on boat");
                flag=1;
                break;
            }
        }

        if(flag==0){
        	(new Alert()).display("No Farmer on the boat");

            return false;
        }

        if(boatRiders.size()==1)
            return true;
        else {


            int i = 0;
            ICrosser crosser1 = boatRiders.get(i);
            ICrosser crosser2 = boatRiders.get(i + 1);

            if (crosser1.getWeight() + crosser2.getWeight() > 100) {
                (new Alert()).display("Overweight boat will sink!");
                return false;
            }
        }

        return true;

    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> initialCrossers=new ArrayList<>();
        initialCrossers.add(farmer1);
        initialCrossers.add(farmer2);
        initialCrossers.add(farmer3);
        initialCrossers.add(farmer4);
        initialCrossers.add(animal);
        return initialCrossers;
    }

    @Override
    public String[] getInstructions() {
        String[] instructions=new String[5];
        instructions[0]="Four farmers and their animal need to cross a river in a small boat.";
        instructions[1]="The weights of the farmers are 90 kg, 80 kg,60 kg and 40 kg, and the weight of the animal is 20 kg.";
        instructions[2]="Rules:";
        instructions[3]="1- The boat cannot bear a load heavier than 100 kg.";
        instructions[4]="2- All farmers can raft, while the animal cannot.";
        return instructions;
    }
}
