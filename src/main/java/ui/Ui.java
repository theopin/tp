package ui;

import java.util.Scanner;

public class Ui {
    Scanner in = new Scanner(System.in);

    public Ui() {
    }

    public String getUserInput()    {
        return in.nextLine();
    }

    public void closeScanner() {
        in.close();
    }
}
