package cheatlogs;

import command.Command;
import command.CommandExecutor;
import parser.Parser;
import ui.Printer;
import ui.Ui;

public class CheatLogs {
    // Main Function
    public static void main(String[] args) {
        //new UserSession();
        Ui ui = new Ui();
        Printer.printWelcomeScreen();
        while (!Command.isExitCommand) {
            Printer.printUserInputPrompt();
            String input = ui.getUserInput();
            Parser parser = new Parser(input);
            //CommandExecutor.execute(parser);
        }
/*
        UserSession session = new UserSession();
        session.runProgramSequence();
*/
    }
}
