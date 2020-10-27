package parser;

import cheatsheet.CheatSheetList;
import command.AddCommand;
import command.Command;
import editor.Editor;
import exception.CommandException;
import ui.Printer;

import java.util.LinkedHashMap;


public class test {
    private static final String FLAG_REGEX = "(?=(/[a-z]))";

    public static void main(String[] args) {
        String str = "/add /n asd    /a                sd";
        try {
            LinkedHashMap<CommandFlag, String>  asd = parseFlagDescriptions(new AddCommand(new Printer(), new CheatSheetList(), new Editor()), str);

            System.out.println(asd);
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
    }



    private static int getDescriptionStartIdx(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
