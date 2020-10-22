package command;

import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingsCommand extends Command {
    public SettingsCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        super(argEnumSet, descriptionMap);
    }

    @Override
    public void execute() throws CommandException {
    }
}
