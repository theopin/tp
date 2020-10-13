package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;
import parser.ArgumentFlagEnum;
import parser.Parser;
import ui.Printer;

public class AddCommand extends Command {
    public AddCommand(Parser parser) {
        super(parser);
    }

    @Override
    public void execute() throws CommandException {
        String name = parser.getDescriptionMap().get(ArgumentFlagEnum.NAME);
        String programmingLanguage = parser.getDescriptionMap().get(ArgumentFlagEnum.PROGRAMMINGLANGUAGE);
        String description = parser.getDescriptionMap().get(ArgumentFlagEnum.DESCRIPTION);

        if (name == null) {
            throw new CommandException("Please enter a name");
        }

        CheatSheet cheatSheet = new CheatSheet(name, programmingLanguage, description);
        CheatSheetList.add(cheatSheet);
        Printer.printAddNewCheatSheetMessage(cheatSheet);
    }
}
