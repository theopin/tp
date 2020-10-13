package ui;

import command.Command;
import command.CommandExecutor;
import parser.Parser;
import storage.DataFileReader;
import storage.DataFileWriter;


public class UserSession {
    /*
     * These are objects that will be passed to command subclasses
     * that allow them to execute helper functions.
     */
    DataFileReader fileReader;
    DataFileWriter fileWriter;
    Ui ui;

    public UserSession() {
        fileReader = new DataFileReader();
        fileWriter = new DataFileWriter();
        ui = new Ui();
    }

    /**
     * Runs the program based on a given user commands.
     */
    public void runProgramSequence() {
        Parser userCommandParser;

        Printer.printWelcomeScreen();
        // Ask for new user input and executes it until user types an exit command
        do {
            Printer.printUserInputPrompt();
            String userInput = ui.getUserInput();
            Parser parsedUserCommand = new Parser(userInput);
            CommandExecutor.execute(parsedUserCommand);
            fileWriter.executeFunction();
        } while (!Command.isExitCommand);

        Printer.printExitLogo();

    }
}
