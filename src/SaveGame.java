public class SaveGame implements Command {
    private State state;

    public SaveGame(State state){
        this.state=state;
    }

    @Override
    public void execute() {
        state.save();
    }
}