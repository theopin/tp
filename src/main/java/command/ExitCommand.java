package command;

import parser.ArgumentFlagEnum;

import java.util.ArrayList;
import java.util.HashMap;

public class ExitCommand extends Command {
    public ExitCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        super(argEnumSet, descriptionMap);
    }

    @Override
    public void execute() {
        isExitCommand = true;
    }
}
