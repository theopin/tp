package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

import java.util.Scanner;

public class Ui {

    public Ui() {
    }

    public void displayWelcomeScreen() {
        String logo = "  /$$$$$$  /$$                             /$$     /$$                              \n"
                + " /$$__  $$| $$                            | $$    | $$                              \n"
                + "| $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$  | $$  /$$$$$$   /$$$$$$   /$$$$$$$\n"
                + "| $$      | $$__  $$ /$$__  $$ |____  $$|_  $$_/  | $$ /$$__  $$ /$$__  $$ /$$_____/\n"
                + "| $$      | $$  \\ $$| $$$$$$$$  /$$$$$$$  | $$    | $$| $$  \\ $$| $$  \\ $$|  $$$$$$ \n"
                + "| $$    $$| $$  | $$| $$_____/ /$$__  $$  | $$ /$$| $$| $$  | $$| $$  | $$ \\____  $$\n"
                + "|  $$$$$$/| $$  | $$|  $$$$$$$|  $$$$$$$  |  $$$$/| $$|  $$$$$$/|  $$$$$$$ /$$$$$$$/\n"
                + " \\______/ |__/  |__/ \\_______/ \\_______/   \\___/  |__/ \\______/  \\____  $$|_______/ \n"
                + "                                                                 /$$  \\ $$          \n"
                + "                                                                |  $$$$$$/          \n"
                + "                                                                 \\______/           ";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
    }

    public String askForUserInput() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Please Enter a Command:");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void printExitLogo() {
        String exitLogo =  " ________  ________  ________  ________  ________      ___    ___ _______\n"
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
                + "                                                     \\|___|/\n";
        System.out.println(exitLogo);
    }

    public void printCheatSheet() {
        CheatSheetList cheatSheetList = new CheatSheetList();
        for (int i = 0; i < cheatSheetList.getSize(); i++) {
            System.out.println(cheatSheetList.getCheatSheet(i));
        }
    }

    public void printExitText() {
        System.out.println("Thank you for using CheatLogs. See you soon");
    }
}
