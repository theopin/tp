package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

/*
 * This class manages the output of text
 * */
public final class Printer {
    private static final String LINE = "----------------------------------------------------------------"
            + "----------------------------------------";

    private Printer(){
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void printWelcomeScreen() {
        print(ConsoleColorsEnum.CYAN_TEXT
                + " ________  ___  ___  _______   ________  _________  ________  "
                + "___  ___  _______   _______  _________" + System.lineSeparator()
                + "|\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\   __  \\|\\___   ___\\"
                + "\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\  ___ \\|\\___   ___\\\\" + System.lineSeparator()
                + "\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\|\\  \\|___ \\  "
                + "\\_\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\   __/\\|___ \\  \\_|" + System.lineSeparator()
                + " \\ \\  \\    \\ \\   __  \\ \\  \\_|/_\\ \\   __  \\   \\ \\  \\ "
                + "\\ \\_____  \\ \\   __  \\ \\  \\_|/_\\ \\  \\_|/__  \\ \\  \\" + System.lineSeparator()
                + "  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\ \\  \\   \\ \\  "
                + "\\ \\|____|\\  \\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\_|\\ \\  \\ \\  \\" + System.lineSeparator()
                + "   \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\__\\ \\__\\   \\ \\__"
                + "\\  ____\\_\\  \\ \\__\\ \\__\\ \\_______\\ \\_______\\  \\ \\__\\" + System.lineSeparator()
                + "    \\|_______|\\|__|\\|__|\\|_______|\\|__|\\|__|    \\|__| |\\____"
                + "_____\\|__|\\|__|\\|_______|\\|_______|   \\|__|" + System.lineSeparator()
                + "                                      ___       ________  ________" + System.lineSeparator()
                + "                                     |\\  \\     |\\   __  \\|\\   ____\\" + System.lineSeparator()
                + "                                     \\ \\  \\    \\ \\  \\|\\  \\ \\  \\___|" + System.lineSeparator()
                + "                                      \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\  ___" + System.lineSeparator()
                + "                                       \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\|\\  \\" + System.lineSeparator()
                + "                                        \\ \\_______\\ \\_______\\ \\_______\\" + System.lineSeparator()
                + "                                         \\|_______|\\|_______|\\|_______|" + System.lineSeparator()
                + LINE + System.lineSeparator()
                + "Welcome to CheatLogs, the one stop cheat sheet management systems" + System.lineSeparator()
                + "Your CAP is our upmost priority"
                + ConsoleColorsEnum.RESET_TEXT
        );
    }

    public static void printExitLogo() {
        print(ConsoleColorsEnum.CYAN_TEXT
                + " ________  ________  ________  ________  ________      ___    ___ _______" + System.lineSeparator()
                + "|\\   ____\\|\\   __  \\|\\   __  \\|\\   ___ \\|\\   __  "
                + "\\    |\\  \\  /  /|\\  ___ \\" + System.lineSeparator()
                + "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  "
                + "\\|\\ /_   \\ \\  \\/  / | \\   __/|" + System.lineSeparator()
                + " \\ \\  \\  __\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\ "
                + "\\   __  \\   \\ \\    / / \\ \\  \\_|/__" + System.lineSeparator()
                + "  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\"
                + " \\  \\|\\  \\   \\/  /  /   \\ \\  \\_|\\ \\" + System.lineSeparator()
                + "   \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\"
                + "__/  / /      \\ \\_______\\" + System.lineSeparator()
                + "    \\|_______|\\|_______|\\|_______|\\|_______|\\|_______|\\___"
                + "/ /        \\|_______|" + System.lineSeparator()
                + "                                                     \\|___|/" + System.lineSeparator()
                + ConsoleColorsEnum.RESET_TEXT
        );
    }

    public static void printUserInputPrompt() {
        print(LINE + "" + System.lineSeparator() + System.lineSeparator() + "Please Enter a Command:");
    }

    public static void printWhiteSpace() {
        print(" ");
    }

    public static void printHelpSheet() {
        print(ConsoleColorsEnum.BOLD + "/add /n <CHEAT_SHEET_NAME> /l <PROGRAMMING_LANGUAGE> /d <DESCRIPTION>"
                + ConsoleColorsEnum.RESET_TEXT + System.lineSeparator()
                + "\tAdds a new cheat sheet to the application and prompts user to include data" + System.lineSeparator()
                + "\tinto the cheat sheet." + System.lineSeparator()
                + ConsoleColorsEnum.BOLD + "/delete /i <CHEAT_SHEET_INDEX>"
                + ConsoleColorsEnum.RESET_TEXT + System.lineSeparator()
                + "\tTo be used after using /list, Deletes the cheat sheet at INDEX items down the list." + System.lineSeparator()
                + "\tThe first cheat sheet has an index of 1." + System.lineSeparator()
                + ConsoleColorsEnum.BOLD + "/find /l <PROGRAMMING LANGUAGE> k/ <KEYWORD>"
                + ConsoleColorsEnum.RESET_TEXT + System.lineSeparator()
                + "\tFinds a cheat sheet whose names contain any of the given keywords." + System.lineSeparator()
                + ConsoleColorsEnum.BOLD + "/view /i <CHEAT_SHEET_INDEX>"
                + ConsoleColorsEnum.RESET_TEXT + System.lineSeparator()
                + "\tView the contents of a cheat sheet either by the name or index" + System.lineSeparator()
                + ConsoleColorsEnum.BOLD + "/list"
                + ConsoleColorsEnum.RESET_TEXT + System.lineSeparator()
                + "\tLists all the possible commands that can be executed in the application." + System.lineSeparator()
                + ConsoleColorsEnum.BOLD + "/clear"
                + ConsoleColorsEnum.RESET_TEXT + System.lineSeparator()
                + "\tClears all entries from the cheat sheet." + System.lineSeparator()
                + ConsoleColorsEnum.BOLD + "/exit"
                + ConsoleColorsEnum.RESET_TEXT + System.lineSeparator()
                + "\tExits the application." + System.lineSeparator());
    }

    public static void printCheatSheet(CheatSheet cheatSheet) {
        print("\tName: " + cheatSheet.getCheatSheetName() + System.lineSeparator()
            + "\tProgramming Language: " + cheatSheet.getCheatSheetProgrammingLanguage() + System.lineSeparator()
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
                    + (cs.getFavorite() ? "(Favorited)" : ""));
        }
    }

    public static void printCheatSheetSize(){
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

    public static void printFavoritedCheatSheetMessage(CheatSheet cheatSheet) {
        print("This cheat sheet has been favorited: ");
        printCheatSheet(cheatSheet);
    }
}
