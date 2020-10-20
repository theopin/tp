package sort;

import cheatsheet.CheatSheet;

import java.util.Comparator;

public class sortByLanguage implements Comparator<CheatSheet> {
    public int compare(CheatSheet a, CheatSheet b)
    {
        return a.getCheatSheetProgrammingLanguage().compareTo(b.getCheatSheetProgrammingLanguage());
    }
}
