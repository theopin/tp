package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

import java.util.Scanner;

public class Ui {

    public Ui() {

    }

    public void displayWelcomeScreen() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
    }

    public String askForUserInput() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        return userInput;
    }

    public void printExitMessage() {
        System.out.println("Bye Friend");
    }

    public void printCheatSheet() {
        CheatSheetList cheatSheetList = new CheatSheetList();
        for (int i = 0; i < cheatSheetList.getSize(); i++) {
            System.out.println(cheatSheetList.getCheatSheet(i));
        }
    }
}
