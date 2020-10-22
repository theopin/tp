package command;

import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;

public class ExitCommand extends Command {
    public ExitCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        super(descriptionMap, printer);
    }

    @Override
    public void execute() {
        isExitCommand = true;
    }
}
