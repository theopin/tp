package command;

import parser.Parser;

public class ExitCommand extends Command {
    public ExitCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        isExitCommand = true;
    }
}
