import java.util.ArrayList;
import java.util.Stack;

public class CareTaker {
    private Stack<Memento> mementoUndoList=new Stack<>();
    private Stack<Memento> mementoRedoList=new Stack<>();

    public void addMementoUndoList(Memento memento){
        mementoUndoList.push(memento);
    }

    public void addMementoRedoList(Memento memento){
        mementoRedoList.push(memento);
    }

    public void clearMementoUndoList(){
        while (!mementoUndoList.isEmpty()){
            mementoUndoList.pop();
        }
    }

    public void clearMementoRedoList(){
        while (!mementoRedoList.isEmpty()){
            mementoRedoList.pop();
        }
    }

    public Memento getMementoFromUndoList(){
        return mementoUndoList.pop();
    }

    public Memento getMementoFromRedoList(){
        return mementoRedoList.pop();
    }


    public Stack<Memento> getMementoUndoList() {
        return mementoUndoList;
    }

    public Stack<Memento> getMementoRedoList() {
        return mementoRedoList;
    }
}
