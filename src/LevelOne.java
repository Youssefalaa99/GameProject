import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LevelOne implements ICrossingStrategy {
    private ICrosser farmer;
    private ICrosser carnivore;
    private ICrosser herbivore;
    private ICrosser plant;

    public LevelOne(){
        CrosserFactory factory=new CrosserFactory();
        farmer=factory.createCrosseer("F1");
        carnivore=factory.createCrosseer("C");
        herbivore=factory.createCrosseer("H");
        plant=factory.createCrosseer("P");
    }


    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        if(boatRiders.isEmpty()){
            System.out.println("Empty boat");
            return false;
        }

        int flag=0;
        for(ICrosser crosser : boatRiders){
            if(crosser.canSail()){
                System.out.println("Farmer exist");
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("No farmer on boat");
            return false;
        }

        for(int i=0;i<leftBankCrossers.size();i++){
            ICrosser crosser1=leftBankCrossers.get(i);
            for(int j=0;j<leftBankCrossers.size();j++){
                ICrosser crosser2=leftBankCrossers.get(j);
                if(crosser1.getEatingRank() == crosser2.getEatingRank()+1){
                    System.out.println("Harm happened");
                    return false;
                }
            }
        }

        for(int i=0;i<rightBankCrossers.size();i++){
            ICrosser crosser1=rightBankCrossers.get(i);
            for(int j=0;j<rightBankCrossers.size();j++){
                ICrosser crosser2=rightBankCrossers.get(j);
                if(crosser1.getEatingRank() == crosser2.getEatingRank()+1){
                    System.out.println("Harm happened");
                    return false;
                }
            }
        }

        System.out.println("Valid move!");
        return true;

    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> initialCrossers=new ArrayList<>();
        initialCrossers.add(farmer);
        initialCrossers.add(carnivore);
        initialCrossers.add(herbivore);
        initialCrossers.add(plant);
        return initialCrossers;

    }

    @Override
    public String[] getInstructions() {
        String[] instructions=new String[5];
        instructions[0]="A farmer wants to cross a river and take with him a carnivorous, a herbivorous and a plant.";
        instructions[1]="Rules: ";
        instructions[2]="1- The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself.";
        instructions[3]="2- You can not leave any two crossers on the same bank if they can harm(eat) each other";
        return instructions;
    }
}
