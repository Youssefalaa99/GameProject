import java.util.ArrayList;

public class CareTaker {
    private ArrayList<Memento> mementoList=new ArrayList<>();

    public void addMemento(Memento memento){
        mementoList.add(memento);
    }

    public void clearMemento(){
        mementoList.clear();
    }

    public Memento getMemento(int index){
        return mementoList.get(index);
    }
}
