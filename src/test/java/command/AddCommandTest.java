package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import org.junit.jupiter.api.Test;
import parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AddCommandTest {
    @Test
    void execute_completeInput_success() {
        final String userInput = "/add /n name /l language /d details";
        CheatSheetList.clear();
        try {
            Parser parser = new Parser(userInput);
            AddCommand addCommand = new AddCommand(parser);
            addCommand.execute();
            assertEquals(1, CheatSheetList.getSize());
        } catch (CommandException e) {
            fail();
        }
    }

    @Test
    void execute_noName_exceptionThrown() {
        final String userInput = "/add";
        CheatSheetList.clear();
        try {
            Parser parser = new Parser(userInput);
            AddCommand addCommand = new AddCommand(parser);
            addCommand.execute();
            fail();
        } catch (CommandException e) {
            assertEquals("Please enter a name", e.getMessage());
        }
    }
}
