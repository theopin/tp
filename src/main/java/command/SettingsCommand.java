package command;

import exception.CommandException;
import parser.Parser;

public class SettingsCommand extends Command {
    public SettingsCommand(Parser parser) {
        super(parser);
    }
    @Override
    public void execute() throws CommandException {
    }
}
