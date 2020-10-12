package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

import java.util.Scanner;

public class Ui {

    public Ui() {

    }

    public void displayWelcomeScreen() {
        String logo = "  /$$$$$$  /$$                             /$$     /$$                              \n" +
                " /$$__  $$| $$                            | $$    | $$                              \n" +
                "| $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$  | $$  /$$$$$$   /$$$$$$   /$$$$$$$\n" +
                "| $$      | $$__  $$ /$$__  $$ |____  $$|_  $$_/  | $$ /$$__  $$ /$$__  $$ /$$_____/\n" +
                "| $$      | $$  \\ $$| $$$$$$$$  /$$$$$$$  | $$    | $$| $$  \\ $$| $$  \\ $$|  $$$$$$ \n" +
                "| $$    $$| $$  | $$| $$_____/ /$$__  $$  | $$ /$$| $$| $$  | $$| $$  | $$ \\____  $$\n" +
                "|  $$$$$$/| $$  | $$|  $$$$$$$|  $$$$$$$  |  $$$$/| $$|  $$$$$$/|  $$$$$$$ /$$$$$$$/\n" +
                " \\______/ |__/  |__/ \\_______/ \\_______/   \\___/  |__/ \\______/  \\____  $$|_______/ \n" +
                "                                                                 /$$  \\ $$          \n" +
                "                                                                |  $$$$$$/          \n" +
                "                                                                 \\______/           ";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
    }

    public String askForUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
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
