package command;

import exception.CommandException;
import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;

public class SettingsCommand extends Command {
    public SettingsCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        super(descriptionMap, printer);
    }

    @Override
    public void execute() throws CommandException {
    }
}
