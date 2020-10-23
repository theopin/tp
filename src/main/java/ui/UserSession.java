package ui;

import command.Command;
import exception.CommandException;
import parser.Parser;
import storage.DataFileReader;
import storage.DataFileWriter;
import storage.DataFileDestroyer;

public class UserSession {
    /*
     * These are objects that will be injected to command subclasses
     * that allow them to execute.
     */
    Printer printer;
    DataFileReader fileReader;
    DataFileWriter fileWriter;
    DataFileDestroyer fileDestroyer;
    Ui ui;
    Parser userCommandParser;

    public UserSession() {
        printer = new Printer();
        fileReader = new DataFileReader(printer);
        fileWriter = new DataFileWriter(printer);
        fileDestroyer = new DataFileDestroyer(printer);
        ui = new Ui();
        userCommandParser = new Parser(fileDestroyer, printer, ui);
    }

    /**
     * Runs the program based on a given user commands.
     */
    public void runProgramSequence() {
        fileReader.executeFunction();
        printer.printWelcomeScreen();

        // Ask for new user input and executes it until user types an exit command
        do {
            printer.printUserInputPrompt();
            String userInput = ui.getUserInput();
            try {
                Command parsedUserCommand = userCommandParser.parse(userInput);
                parsedUserCommand.execute();
            } catch (CommandException c) {
                printer.print(c.getMessage());
                continue;
            }
            fileWriter. executeFunction();
        } while (!Command.isExitCommand);

        ui.closeScanner();
        printer.printExitLogo();
    }
}
