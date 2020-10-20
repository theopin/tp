package ui;

import ui.ConsoleColorsEnum;
import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
/*
 * Handles printing of all outputs
 * */
public final class Printer {
    private static final String RESET_TEXT = "\u001b[0m";
    private static final String LINE = "----------------------------------------------------------------"
            + "----------------------------------------";

    private Printer(){
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void printWelcomeScreen() {
        print("\u001B[5m"
                + " ________  ___  ___  _______   ________  _________  ________  "
                + "___  ___  _______   _______  _________\n"
                + "|\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\   __  \\|\\___   ___\\"
                + "\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\  ___ \\|\\___   ___\\\n"
                + "\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\|\\  \\|___ \\  "
                + "\\_\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\   __/\\|___ \\  \\_|\n"
                + " \\ \\  \\    \\ \\   __  \\ \\  \\_|/_\\ \\   __  \\   \\ \\  \\ "
                + "\\ \\_____  \\ \\   __  \\ \\  \\_|/_\\ \\  \\_|/__  \\ \\  \\\n"
                + "  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\ \\  \\   \\ \\  "
                + "\\ \\|____|\\  \\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\_|\\ \\  \\ \\  \\\n"
                + "   \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\__\\ \\__\\   \\ \\__"
                + "\\  ____\\_\\  \\ \\__\\ \\__\\ \\_______\\ \\_______\\  \\ \\__\\\n"
                + "    \\|_______|\\|__|\\|__|\\|_______|\\|__|\\|__|    \\|__| |\\____"
                + "_____\\|__|\\|__|\\|_______|\\|_______|   \\|__|\n"
                + "                                      ___       ________  ________\n"
                + "                                     |\\  \\     |\\   __  \\|\\   ____\\\n"
                + "                                     \\ \\  \\    \\ \\  \\|\\  \\ \\  \\___|\n"
                + "                                      \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\  ___\n"
                + "                                       \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\|\\  \\\n"
                + "                                        \\ \\_______\\ \\_______\\ \\_______\\\n"
                + "                                         \\|_______|\\|_______|\\|_______|\n"
                + LINE + "\n"
                + "Welcome to CheatLogs, the one stop cheat sheet management systems\n"
                + "Your CAP is our upmost priority"
                + RESET_TEXT
        );
    }

    public static void printExitLogo() {
        print(" ________  ________  ________  ________  ________      ___    ___ _______\n"
                + "|\\   ____\\|\\   __  \\|\\   __  \\|\\   ___ \\|\\   __  "
                + "\\    |\\  \\  /  /|\\  ___ \\\n"
                + "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  "
                + "\\|\\ /_   \\ \\  \\/  / | \\   __/|\n"
                + " \\ \\  \\  __\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\ "
                + "\\   __  \\   \\ \\    / / \\ \\  \\_|/__\n"
                + "  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\"
                + " \\  \\|\\  \\   \\/  /  /   \\ \\  \\_|\\ \\\n"
                + "   \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\"
                + "__/  / /      \\ \\_______\\\n"
                + "    \\|_______|\\|_______|\\|_______|\\|_______|\\|_______|\\___"
                + "/ /        \\|_______|\n"
                + "                                                     \\|___|/\n"
        );
    }

    public static void printUserInputPrompt() {
        print(LINE + '\n');
        print("Please Enter a Command:");
    }

    public static void printWhiteSpace() {
        print(" ");
    }

    public static void printHelpSheet() {
        print("/add /n <CHEAT_SHEET_NAME> /l <PROGRAMMING_LANGUAGE> /d <DESCRIPTION> ");
        print("\tAdds a new cheat sheet to the application and prompts user to include data "
                + "into the cheat sheet.");
        print("/clear");
        print("\tClears all entries from the cheat sheet.");
        print("/delete /i <CHEAT_SHEET_INDEX>");
        print("\tTo be used after using /list, Deletes the cheat sheet at INDEX items down the list. "
                + "The first cheat sheet has an index of 1.");
        print("/find /l <PROGRAMMING LANGUAGE> k/ <KEYWORD>");
        print("\tFinds a cheat sheet whose names contain any of the given keywords.");
        print("/view /i <CHEAT_SHEET_INDEX>");
        print("\tView the contents of a cheat sheet either by the name or index");
        print("/list");
        print("\tLists all the possible commands that can be executed in the application.");
        print("/exit");
        print("\tExits the application.");
    }

    public static void printCheatSheet(CheatSheet cheatSheet) {
        print("\tName: " + cheatSheet.getCheatSheetName());
        print("\tProgramming Language: " + cheatSheet.getCheatSheetProgrammingLanguage());
        print("\tDetails: " + cheatSheet.getCheatSheetDetails());
    }

    public static void printCheatSheetList() {
        for (int i = 1; i <= CheatSheetList.getSize(); i++) {
            print("\t"
                    + i + ". " + CheatSheetList.getCheatSheet(i).getCheatSheetName()
                    + " (Language: " + CheatSheetList.getCheatSheet(i).getCheatSheetProgrammingLanguage() + ")"
                    + " (Details: " + CheatSheetList.getCheatSheet(i).getCheatSheetDetails() + ")");
        }
    }

    public static void printAddNewCheatSheetMessage(CheatSheet cheatSheet) {
        print("Added new cheat sheet:");
        printCheatSheet(cheatSheet);
        print(LINE);
        print("Now you have " + CheatSheetList.getSize() + " cheatsheet(s)");
    }

    public static void printClearCheatSheetMessage(int number) {
        print("Cleared total of " + number + " cheat sheets");
        print(LINE);
        print("Now you have no cheatsheets");
    }

    public static void printDeleteCheatSheetMessage(CheatSheet cheatSheet) {
        print("This cheat sheet has been deleted: ");
        printCheatSheet(cheatSheet);
        print(LINE);
        print("Now you have " + CheatSheetList.getSize() + " cheatsheet(s)");
    }

    public static void printViewCheatSheetMessage(CheatSheet cheatSheet) {
        print("This is your content for " + cheatSheet.getCheatSheetName() + ": ");
        printCheatSheet(cheatSheet);
    }
}
