public class LoadGame implements Command {
    private State state;

    public LoadGame(State state){
        this.state=state;
    }

    @Override
    public void execute() {
        state.load();
    }
}
