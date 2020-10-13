package ui;

import java.util.Scanner;

public class Ui {
    public Ui() {
    }

    public String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
