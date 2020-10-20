package sort;

import cheatsheet.CheatSheet;

import java.util.Comparator;

public class sortByName implements Comparator<CheatSheet> {
    public int compare(CheatSheet a, CheatSheet b)
    {
        return a.getCheatSheetName().compareTo(b.getCheatSheetName());
    }
}
