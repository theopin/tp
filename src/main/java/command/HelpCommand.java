package command;

import parser.ArgumentFlagEnum;
import ui.Printer;

import java.util.HashMap;

public class HelpCommand extends Command {
    public HelpCommand(HashMap<ArgumentFlagEnum, String> descriptionMap, Printer printer) {
        super(descriptionMap, printer);
    }

    @Override
    public void execute() {
        printer.printHelpSheet();
    }
}
