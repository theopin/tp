package command;

import exception.CommandException;
import ui.Printer;

public class SettingsCommand extends Command {
    public SettingsCommand(Printer printer) {
        super(printer);

        initCommandDetails(null);
    }

    @Override
    public boolean hasAllRequiredArguments() {
        return true;
    }

    @Override
    public void execute() throws CommandException {
    }
}
