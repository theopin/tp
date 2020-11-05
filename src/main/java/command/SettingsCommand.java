package command;

import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

import java.util.concurrent.ConcurrentMap;

public class SettingsCommand extends Command {
    public static final String invoker = "/set";


    public SettingsCommand(Printer printer) {
        super(printer);
        flagsToDescriptions.put(CommandFlag.COLORSCHEME, null);
        flagsToDescriptions.put(CommandFlag.HELPMESSAGE, null);
        alternativeArguments.add(CommandFlag.COLORSCHEME);
        alternativeArguments.add(CommandFlag.HELPMESSAGE);
    }

    @Override
    public void execute() throws CommandException {
        if (flagsToDescriptions.get(CommandFlag.COLORSCHEME) != null) {
            try {
                int option = Integer.parseInt(flagsToDescriptions.get(CommandFlag.COLORSCHEME));
                printer.setColor(option);
            } catch (NumberFormatException e) {
                throw new CommandException("Please enter a valid option");
            }
        }
        if (flagsToDescriptions.get(CommandFlag.HELPMESSAGE) != null) {
            String option = flagsToDescriptions.get(CommandFlag.HELPMESSAGE);
            if (option.equals("remove")) {
                printer.setDisplayingHelpMessages(false);
            } else if (option.equals("include")) {
                printer.setDisplayingHelpMessages(true);
            } else {
                throw new CommandException("Please enter a valid option (\"remove\" or \"include\")");
            }
        }
    }
}
