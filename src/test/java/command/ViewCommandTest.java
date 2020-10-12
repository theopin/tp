package command;

import org.junit.jupiter.api.Test;
import parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ViewCommandTest {

    @Test
    void testViewCommand() {
        Parser input = new Parser("/view");
        ViewCommand vs = new ViewCommand(input);


    }
}