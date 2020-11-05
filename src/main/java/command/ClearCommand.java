package command;

import cheatsheet.CheatSheetList;
import storage.DataFileDestroyer;
import ui.Printer;

import java.util.Scanner;

public class ClearCommand extends Command {
    protected DataFileDestroyer fileDestroyer;

    public static final String invoker = "/clear";

    public ClearCommand(Printer printer, CheatSheetList cheatSheetList, DataFileDestroyer fileDestroyer) {
        super(printer);
        this.cheatSheetList = cheatSheetList;
        this.fileDestroyer = fileDestroyer;
        if (printer.getDisplayingHelpMessages()) {
            printer.printClearCommandHelpMessage();
        }
    }

    @Override
    public void execute() {
        if (isClearCommandConfirmed()) {
            fileDestroyer.executeFunction();
            printer.printClearCheatSheetMessage(cheatSheetList.getSize());
            cheatSheetList.clear();
        } else {
            System.out.println("CLEAR command aborted.");
        }
    }

    private boolean isClearCommandConfirmed() {
        while (true) {
            System.out.print("\nDo you wish to continue (y/n): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
            case "y":
                return true;
            case "n":
                return false;
            default:
                System.out.println("Please enter either \"y\" or \"n\"");
            }
        }
    }
}
