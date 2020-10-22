package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import org.junit.jupiter.api.Test;
import parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DeleteCommandTest {
    @Test
    void execute_validIndex_success() {
        final String userInput = "/delete /i 2";
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            Parser parser = new Parser(userInput);
            DeleteCheatSheet deleteCommand = new DeleteCheatSheet(parser);
            deleteCommand.execute();
            assertEquals(9, CheatSheetList.getSize());
        } catch (CommandException e) {
            fail();
        }
    }

    @Test
    void execute_validName_success() {
        final String userInput = "/delete /n Name3";
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            Parser parser = new Parser(userInput);
            DeleteCheatSheet deleteCommand = new DeleteCheatSheet(parser);
            deleteCommand.execute();
            assertEquals(9, CheatSheetList.getSize());
        } catch (CommandException e) {
            fail();
        }
    }

    @Test
    void execute_invalidIndex_exceptionThrown() {
        final String userInput = "/delete /i dummy";
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            Parser parser = new Parser(userInput);
            DeleteCheatSheet deleteCommand = new DeleteCheatSheet(parser);
            deleteCommand.execute();
            fail();
        } catch (CommandException e) {
            assertEquals("Enter a valid index", e.getMessage());
        }
    }

    @Test
    void execute_indexOutOfBound_exceptionThrown() {
        final String userInput = "/delete /i -1";
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            Parser parser = new Parser(userInput);
            DeleteCheatSheet deleteCommand = new DeleteCheatSheet(parser);
            deleteCommand.execute();
            fail();
        } catch (CommandException e) {
            assertEquals("Enter a valid argument or name", e.getMessage());
        }
    }

    @Test
    void execute_deleteByName_success() {
        final String userInput = "/delete /n dummy";
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            Parser parser = new Parser(userInput);
            DeleteCheatSheet deleteCommand = new DeleteCheatSheet(parser);
            deleteCommand.execute();
            fail();
        } catch (CommandException e) {
            assertEquals("Enter a valid argument or name", e.getMessage());
        }
    }
}
