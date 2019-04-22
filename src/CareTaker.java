import java.util.ArrayList;

public class CareTaker {
    private ArrayList<Memento> mementoList=new ArrayList<>();

    public void addMemento(Memento memento){
        mementoList.add(memento);
    }

    public void removeMemento(Memento memento){
        mementoList.remove(memento);
    }

    public Memento getMemento(int index){
        return mementoList.get(index);
    }
}
