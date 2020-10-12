package ui;

import command.CommandExecutor;
import parser.Parser;
import storage.DataFileReader;
import command.CommandEnum;
import storage.DataFileWriter;
import ui.Ui;

public class UserSession {
    /*
     * These are objects that will be passed to command subclasses
     * that allow them to execute helper functions.
     */
    DataFileReader fileReader;
    DataFileWriter fileWriter;
    Ui ui;
    CommandExecutor commandExecutor;

    public UserSession() {
        fileReader = new DataFileReader();
        fileWriter = new DataFileWriter();
        ui = new Ui();
        commandExecutor = new CommandExecutor();
    }

    /**
     * Runs the program based on a given user commands.
     */
    public void runProgramSequence() {
        Parser userCommandParser;
        Boolean exitProgram = false;

        Printer.printWelcomeScreen();
        // Ask for new user input and executes it until user types an exit command
        do {
            String userInput = ui.getUserInput();
            Parser parsedUserCommand = new Parser(userInput);
            exitProgram = commandExecutor.execute(parsedUserCommand,
                                                    fileReader,
                                                    fileWriter
                                                    );
        } while (!exitProgram);

        Printer.printExitLogo();
    }
}
