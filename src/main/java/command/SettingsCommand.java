package command;

import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

/**
 * Command to change the behavior of the application.
 * Currently only supports changing default color scheme.
 */
public class SettingsCommand extends Command {
    public static final String invoker = "/set";

    /**
     * Constructor for the SettingsCommand.
     * Required argument: COLORSCHEME.
     *
     * @param printer The printer object to handle user interaction
     */
    public SettingsCommand(Printer printer) {
        super(printer);
        flagsToDescriptions.put(CommandFlag.COLORSCHEME, null);
        alternativeArguments.add(CommandFlag.COLORSCHEME);
    }

    /**
     * Changes the color scheme by calling setColor method.
     *
     * @throws CommandException if the input cannot be parsed as integer
     */
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
