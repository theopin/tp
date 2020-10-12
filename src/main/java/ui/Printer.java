package ui;

import cheatsheet.CheatSheetList;

/*
 * Handles printing of all outputs
 * */
public class Printer {
    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void printWelcomeScreen() {
        print(" ________  ___  ___  _______   ________  _________  ________  "
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
        print("-----------------------------------------------------------------------------------------");
        print("Please Enter a Command:");
    }

    public static void printCheatSheetList(CheatSheetList list) {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getCheatSheet(i));
        }
    }

    public static void printHelpSheet() {
        System.out.println("/add n/ CHEAT_SHEET_NAME d/ DESCRIPTION");
        System.out.println("\tAdds a new cheat sheet to the application and prompts user to include data "
                + "into the cheat sheet.");
        System.out.println("/clear");
        System.out.println("\tClears all entries from the cheat sheet.");
        System.out.println("/delete i/ <CHEAT_SHEET_INDEX>");
        System.out.println("\tTo be used after using /list, Deletes the cheat sheet at INDEX items down the list. "
                + "The first cheat sheet has an index of 1.");
        System.out.println("/find l/ <PROGRAMMING LANGUAGE> k/ <KEYWORD>");
        System.out.println("\tFinds a cheat sheet whose names contain any of the given keywords.");
        System.out.println("/view n/ <NAME>");
        System.out.println("\tView the contents of a cheat sheet either by the name or index");
        System.out.println("/list");
        System.out.println("\tLists all the possible commands that can be executed in the application.");
        System.out.println("/exit");
        System.out.println("\tExits the application.");
    }
}
