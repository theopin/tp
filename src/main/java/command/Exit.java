package command;

public class Exit extends Command {

    @Override
    public void execute() {
        isExitCommand = true;
    }
}
