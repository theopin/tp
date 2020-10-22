package command;

import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class HelpCommand extends Command {
    public HelpCommand(ArrayList<ArgumentFlagEnum> argEnumSet, HashMap<ArgumentFlagEnum, String> descriptionMap) {
        super(argEnumSet, descriptionMap);
    }

    @Override
    public void execute() {
        Printer.printHelpSheet();
    }
}
