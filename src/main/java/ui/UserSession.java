package ui;

import parser.Parser;
import storage.ReadDataFile;
import command.CommandEnum;
import ui.Ui;

public class UserSession {

    public UserSession() {
        new ReadDataFile();
        runProgramSequence();
    }

    /**
     * Runs the program based on a given sequence.
     */
    private void runProgramSequence() {
        String action;
        Parser newUserCommand;
        Ui ui = new Ui();

        ui.displayWelcomeScreen();
        // Ask for new user input until user types an exit command
        /*
        do {
            newUserCommand = new Parser(ui.askForUserInput());
            action = newUserCommand.getCommandType().toString();
        } while (!action.equals(command));
        ui.printExitMessage();
    }
}
