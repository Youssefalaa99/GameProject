public class Originator {
    private State state;

    public void setState(State state){
        this.state=state;
    }

    //To be removed if not used
    public State getState(){
        return this.state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public State getStateFromMemento(Memento memento){
        state=memento.getState();
        return state;
    }

}
