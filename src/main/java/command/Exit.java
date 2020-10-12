package command;

import parser.Parser;

public class Exit extends Command {
    public Exit(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() {
        isExitCommand = true;
    }
}
