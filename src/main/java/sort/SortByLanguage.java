package sort;

import cheatsheet.CheatSheet;

import java.util.Comparator;

public class SortByLanguage implements Comparator<CheatSheet> {
    public int compare(CheatSheet a, CheatSheet b) {
        Boolean cheatSheet1 = a.getIsFavourite();
        Boolean cheatSheet2 = b.getIsFavourite();
        int favComparator = cheatSheet2.compareTo(cheatSheet1);
        if (favComparator != 0) {
            return favComparator;
        }
        return a.getCheatSheetProgrammingLanguage().compareTo(b.getCheatSheetProgrammingLanguage());
    }
}
