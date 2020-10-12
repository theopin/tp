package cheatlogs;

import command.Command;
import command.ExecuteCommand;
import parser.Parser;
import ui.Ui;
import ui.UserSession;

public class CheatLogs {
    // Main Function
    public static void main(String[] args) {
        //new UserSession();
        Ui ui = new Ui();
        ui.displayWelcomeScreen();
        while (!Command.isExitCommand) {
            String input = ui.askForUserInput();
            Parser parser = new Parser(input);
            ExecuteCommand.executeCommand(parser);
        }
    }
}
