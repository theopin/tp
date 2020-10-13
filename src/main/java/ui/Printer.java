package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

/*
 * Handles printing of all outputs
 * */
public class Printer {
    private static final String RED_TEXT = "\u001b[31m";
    private static final String GREEN_TEXT = "\u001b[32;1m";
    private static final String CYAN_TEXT = "\u001b[36m";
    private static final String RESET_TEXT = "\u001b[0m";
    private static final String LINE = "----------------------------------------------------------------"
            + "----------------------------------------";

    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void printWelcomeScreen() {
        System.out.println(CYAN_TEXT + " ________  ___  ___  _______   ________  _________  ________  "
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
        System.out.println(" ________  ________  ________  ________  ________      ___    ___ _______\n"
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
        System.out.println(LINE + '\n');
        System.out.println("Please Enter a Command:");
    }

    public static void printWhiteSpace() {
        System.out.println(" ");
    }

    public static void printHelpSheet() {
        System.out.println("/add /n <CHEAT_SHEET_NAME> /l <PROGRAMMING_LANGUAGE> /d <DESCRIPTION> ");
        System.out.println("\tAdds a new cheat sheet to the application and prompts user to include data "
                + "into the cheat sheet.");
        System.out.println("/clear");
        System.out.println("\tClears all entries from the cheat sheet.");
        System.out.println("/delete /i <CHEAT_SHEET_INDEX>");
        System.out.println("\tTo be used after using /list, Deletes the cheat sheet at INDEX items down the list. "
                + "The first cheat sheet has an index of 1.");
        System.out.println("/find /l <PROGRAMMING LANGUAGE> k/ <KEYWORD>");
        System.out.println("\tFinds a cheat sheet whose names contain any of the given keywords.");
        System.out.println("/view /i <CHEAT_SHEET_INDEX>");
        System.out.println("\tView the contents of a cheat sheet either by the name or index");
        System.out.println("/list");
        System.out.println("\tLists all the possible commands that can be executed in the application.");
        System.out.println("/exit");
        System.out.println("\tExits the application.");
    }

    public static void printCheatSheet(CheatSheet cheatSheet) {
        System.out.println("\tName: " + cheatSheet.getCheatSheetName());
        System.out.println("\tProgramming Language: " + cheatSheet.getCheatSheetProgrammingLanguage());
        System.out.println("\tDetails: " + cheatSheet.getCheatSheetDetails());
    }

    public static void printCheatSheetList() {
        for (int i = 1; i <= CheatSheetList.getSize(); i++) {
            System.out.println("\t"
                    + i + ". " + CheatSheetList.getCheatSheet(i).getCheatSheetName()
                    + " (Language: " + CheatSheetList.getCheatSheet(i).getCheatSheetProgrammingLanguage() + ")"
                    + " (Details: " + CheatSheetList.getCheatSheet(i).getCheatSheetDetails() + ")");
        }
    }

    public static void printAddNewCheatSheetMessage(CheatSheet cheatSheet) {
        System.out.println("Added new cheat sheet: ");
        printCheatSheet(cheatSheet);
        System.out.println(LINE);
        System.out.println("Now you have " + CheatSheetList.getSize() + " cheatsheet(s)");
    }

    public static void printClearCheatSheetMessage(int number) {
        System.out.println("Cleared total of " + number + " cheat sheets");
        System.out.println(LINE);
        System.out.println("Now you have no cheatsheets");
    }

    public static void printDeleteCheatSheetMessage(CheatSheet cheatSheet) {
        System.out.println("This cheat sheet has been deleted: ");
        printCheatSheet(cheatSheet);
        System.out.println(LINE);
        System.out.println("Now you have " + CheatSheetList.getSize() + " cheatsheet(s)");
    }

    public static void printViewCheatSheetMessage(CheatSheet cheatSheet) {
        System.out.println("This is your content for " + cheatSheet.getCheatSheetName() + ": ");
        printCheatSheet(cheatSheet);
    }
}
