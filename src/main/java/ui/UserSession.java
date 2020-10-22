package ui;

import command.Command;
//import command.CommandExecutor;
import exception.CommandException;
import parser.Parser;
import storage.DataFileReader;
import storage.DataFileWriter;
import storage.DataFileDestroyer;

public class UserSession {
    /*
     * These are objects that will be passed to command subclasses
     * that allow them to execute helper functions.
     */
    DataFileReader fileReader;
    DataFileWriter fileWriter;
    DataFileDestroyer fileDestroyer;
    Ui ui;
    Parser userCommandParser;

    public UserSession() {
        fileReader = new DataFileReader();
        fileWriter = new DataFileWriter();
        fileDestroyer = new DataFileDestroyer();
        ui = new Ui();
        userCommandParser = new Parser(fileDestroyer);
    }

    /**
     * Runs the program based on a given user commands.
     */
    public void runProgramSequence() {
        fileReader.executeFunction();
        Printer.printWelcomeScreen();

        // Ask for new user input and executes it until user types an exit command
        do {
            Printer.printUserInputPrompt();
            String userInput = ui.getUserInput();
            try {
                Command parsedUserCommand = userCommandParser.parse(userInput);
                parsedUserCommand.execute();
            } catch (CommandException c) {
                System.out.println(c.getMessage());
                continue;
            }
            fileWriter.executeFunction();
        } while (!Command.isExitCommand);

        ui.closeScanner();
        Printer.printExitLogo();
    }
}
