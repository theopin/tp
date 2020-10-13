package ui;

import command.Command;
import command.CommandExecutor;
import exception.CommandException;
import parser.Parser;
import storage.DataFileDestroyer;
import storage.DataFileReader;
import storage.DataFileWriter;


public class UserSession {
    /*
     * These are objects that will be passed to command subclasses
     * that allow them to execute helper functions.
     */
    DataFileReader fileReader;
    DataFileWriter fileWriter;
    DataFileDestroyer fileDestroyer;
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
            try {
                Parser parsedUserCommand = new Parser(userInput);
                CommandExecutor.execute(parsedUserCommand);
            } catch (CommandException c) {
                System.out.println(c.getMessage());
                continue;
            }
            fileWriter.executeFunction();
        } while (!Command.isExitCommand);

        Printer.printExitLogo();
    }
}
