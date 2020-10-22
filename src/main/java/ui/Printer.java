package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

/*
 * This class manages the output of text
 * */
public final class Printer {
    private static final String LINE = "----------------------------------------------------------------"
            + "----------------------------------------";
    private static final String NEWLINE = System.lineSeparator();

    public Printer() {
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void printWelcomeScreen() {
        print(ConsoleColorsEnum.CYAN_TEXT
                + " ________  ___  ___  _______   ________  _________  ________  "
                + "___  ___  _______   _______  _________" + NEWLINE
                + "|\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\   __  \\|\\___   ___\\"
                + "\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\  ___ \\|\\___   ___\\" + NEWLINE
                + "\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\|\\  \\|___ \\  "
                + "\\_\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\   __/\\|___ \\  \\_|" + NEWLINE
                + " \\ \\  \\    \\ \\   __  \\ \\  \\_|/_\\ \\   __  \\   \\ \\  \\ "
                + "\\ \\_____  \\ \\   __  \\ \\  \\_|/_\\ \\  \\_|/__  \\ \\  \\" + NEWLINE
                + "  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\ \\  \\   \\ \\  "
                + "\\ \\|____|\\  \\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\_|\\ \\  \\ \\  \\" + NEWLINE
                + "   \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\__\\ \\__\\   \\ \\__"
                + "\\  ____\\_\\  \\ \\__\\ \\__\\ \\_______\\ \\_______\\  \\ \\__\\" + NEWLINE
                + "    \\|_______|\\|__|\\|__|\\|_______|\\|__|\\|__|    \\|__| |\\____"
                + "_____\\|__|\\|__|\\|_______|\\|_______|   \\|__|" + NEWLINE
                + "                                      ___       ________  ________" + NEWLINE
                + "                                     |\\  \\     |\\   __  \\|\\   ____\\" + NEWLINE
                + "                                     \\ \\  \\    \\ \\  \\|\\  \\ \\  \\___|" + NEWLINE
                + "                                      \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\  ___" + NEWLINE
                + "                                       \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\|\\  \\" + NEWLINE
                + "                                        \\ \\_______\\ \\_______\\ \\_______\\" + NEWLINE
                + "                                         \\|_______|\\|_______|\\|_______|" + NEWLINE
                + LINE + NEWLINE
                + "Welcome to CheatLogs, the one stop cheat sheet management systems" + NEWLINE
                + "Your CAP is our upmost priority"
                + ConsoleColorsEnum.RESET_TEXT
        );
    }

    public static void printExitLogo() {
        print(ConsoleColorsEnum.CYAN_TEXT
                + " ________  ________  ________  ________  ________      ___    ___ _______" + NEWLINE
                + "|\\   ____\\|\\   __  \\|\\   __  \\|\\   ___ \\|\\   __  "
                + "\\    |\\  \\  /  /|\\  ___ \\" + NEWLINE
                + "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  "
                + "\\|\\ /_   \\ \\  \\/  / | \\   __/|" + NEWLINE
                + " \\ \\  \\  __\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\ "
                + "\\   __  \\   \\ \\    / / \\ \\  \\_|/__" + NEWLINE
                + "  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\"
                + " \\  \\|\\  \\   \\/  /  /   \\ \\  \\_|\\ \\" + NEWLINE
                + "   \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\"
                + "__/  / /      \\ \\_______\\" + NEWLINE
                + "    \\|_______|\\|_______|\\|_______|\\|_______|\\|_______|\\___"
                + "/ /        \\|_______|" + NEWLINE
                + "                                                     \\|___|/" + NEWLINE
                + ConsoleColorsEnum.RESET_TEXT
        );
    }

    public static void printUserInputPrompt() {
        print(LINE + "" + NEWLINE + NEWLINE + "Please Enter a Command:");
    }

    public static void printWhiteSpace() {
        print(" ");
    }

    public static void printHelpSheet() {
        print(ConsoleColorsEnum.BOLD + "/add /n <CHEAT_SHEET_NAME> /l <PROGRAMMING_LANGUAGE> /d <DESCRIPTION>"
                + ConsoleColorsEnum.RESET_TEXT + NEWLINE
                + "\tAdds a new cheat sheet to the application and prompts user to include data" + NEWLINE
                + "\tinto the cheat sheet." + NEWLINE
                + ConsoleColorsEnum.BOLD + "/delete /i <CHEAT_SHEET_INDEX>"
                + ConsoleColorsEnum.RESET_TEXT + NEWLINE
                + "\tTo be used after using /list, Deletes the cheat sheet at INDEX items down the list." + NEWLINE
                + "\tThe first cheat sheet has an index of 1." + NEWLINE
                + ConsoleColorsEnum.BOLD + "/find /l <PROGRAMMING LANGUAGE> k/ <KEYWORD>"
                + ConsoleColorsEnum.RESET_TEXT + NEWLINE
                + "\tFinds a cheat sheet whose names contain any of the given keywords." + NEWLINE
                + ConsoleColorsEnum.BOLD + "/view /i <CHEAT_SHEET_INDEX>"
                + ConsoleColorsEnum.RESET_TEXT + NEWLINE
                + "\tView the contents of a cheat sheet either by the name or index" + NEWLINE
                + ConsoleColorsEnum.BOLD + "/list"
                + ConsoleColorsEnum.RESET_TEXT + NEWLINE
                + "\tLists all the possible commands that can be executed in the application." + NEWLINE
                + ConsoleColorsEnum.BOLD + "/clear"
                + ConsoleColorsEnum.RESET_TEXT + NEWLINE
                + "\tClears all entries from the cheat sheet." + NEWLINE
                + ConsoleColorsEnum.BOLD + "/exit"
                + ConsoleColorsEnum.RESET_TEXT + NEWLINE
                + "\tExits the application." + NEWLINE);
    }

    public static void printCheatSheet(CheatSheet cheatSheet) {
        print("\tName: " + cheatSheet.getCheatSheetName() + NEWLINE
            + "\tProgramming Language: " + cheatSheet.getCheatSheetProgrammingLanguage() + NEWLINE
            + "\tDetails: " + cheatSheet.getCheatSheetDetails());
    }

    public static void printCheatSheetList() {
        int i = 0;
        for (CheatSheet cs : CheatSheetList.getCheatSheetList()) {
            i++;
            print("\t"
                    + i + ". " + cs.getCheatSheetName()
                    + " (Language: " + cs.getCheatSheetProgrammingLanguage() + ")"
                    + " (Details: " + cs.getCheatSheetDetails() + ")"
                    + (cs.getFavourite() ? "(Favourited)" : ""));
        }
    }

    public static void printCheatSheetSize() {
        print("Now you have " + CheatSheetList.getSize() + " cheatsheet(s)");
    }

    public static void printAddNewCheatSheetMessage(CheatSheet cheatSheet) {
        print("Added new cheat sheet:");
        printCheatSheet(cheatSheet);
        print(LINE);
        printCheatSheetSize();
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
        printCheatSheetSize();
    }

    public static void printViewCheatSheetMessage(CheatSheet cheatSheet) {
        print("This is your content for " + cheatSheet.getCheatSheetName() + ": ");
        printCheatSheet(cheatSheet);
    }

    public static void printFavouritedCheatSheetMessage(CheatSheet cheatSheet) {
        print("This cheat sheet has been favourited: ");
        printCheatSheet(cheatSheet);
    }
}
