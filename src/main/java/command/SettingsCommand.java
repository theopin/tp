package command;

import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

public class SettingsCommand extends Command {
    public static final String invoker = "/set";


    public SettingsCommand(Printer printer) {
        super(printer);
        flagsToDescriptions.put(CommandFlag.COLORSCHEME, null);
        alternativeArguments.add(CommandFlag.COLORSCHEME);
    }

    @Override
    public void execute() throws CommandException {
        try {
            int option = Integer.parseInt(flagsToDescriptions.get(CommandFlag.COLORSCHEME));
            printer.setColor(option);
        } catch (NumberFormatException e) {
            throw new CommandException("Please enter a valid option");
        }
    }
}
