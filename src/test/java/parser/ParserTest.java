package parser;

import command.AddCommand;
import command.Command;
import exception.CommandException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ParserTest {

    @Test
    void parser_completeInput_success() {
        final String userInput = "/add /n name /l language /d details";

        ArrayList<ArgumentFlagEnum> argEnumList = new ArrayList<>();
        argEnumList.add(ArgumentFlagEnum.NAME);
        argEnumList.add(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        argEnumList.add(ArgumentFlagEnum.DESCRIPTION);

        ArrayList<String> detailsList = new ArrayList<>();
        detailsList.add("name");
        detailsList.add("language");
        detailsList.add("details");

        HashMap<ArgumentFlagEnum, String> descriptionMap = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            descriptionMap.put(argEnumList.get(i - 1), detailsList.get(i - 1));
        }

        try {
            Parser parser = new Parser();
            Command command = parser.parse(userInput);
            assertEquals(AddCommand.class, command.getClass());
            assertEquals(descriptionMap, command.getDescriptionMap());
        } catch (CommandException e) {
            fail();
        }
    }

    @Test
    void parser_incompleteInput_exceptionThrown() {
        String userInput = "dummy command";
        try {
            Parser parser = new Parser();
            parser.parse(userInput);
            fail();
        } catch (CommandException e) {
            assertEquals("Please enter a valid command", e.getMessage());
        }
    }
}
