package parser;

import ui.Ui;

import java.util.LinkedList;

public class UiStub extends Ui {
    private LinkedList<String> userInput;

    protected UiStub() {
        userInput = new LinkedList<>();
    }

    protected void pushUserInput(String userInput) {
        this.userInput.push(userInput);
    }

    public String getUserInput() {
        return userInput.pop();
    }

    protected void clearUserInput() {
        userInput.clear();
    }
}
