package cheatsheet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheatSheetListTest {


    @Test
    void getSize() {
        CheatSheetList cheatSheets = new CheatSheetList();
        for(int i = 0; i < 10; i++){
            cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(cheatSheets.getSize(), 10);
    }

    @Test
    void getCheatSheetList() {
        // to be added
    }

    @Test
    void printCheatSheetNames() {
        // to be added
    }

    @Test
    void add() {
        CheatSheetList cheatSheets = new CheatSheetList();
        for(int i = 0; i < 10; i++){
            cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(cheatSheets.getSize(), 10);
    }

    @Test
    void remove() {
        CheatSheetList cheatSheets = new CheatSheetList();
        for(int i = 0; i < 10; i++){
            cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        cheatSheets.remove("Name1");
        cheatSheets.remove("Name3");
        cheatSheets.remove("Name5");
        assertEquals(cheatSheets.getSize(), 7);
    }

    @Test
    void getCheatSheet() {
        CheatSheetList cheatSheets = new CheatSheetList();
        CheatSheet test = new CheatSheet("Name1", "Language1", "Details1");
        for(int i = 0; i < 10; i++){
            if (i == 1) {
                cheatSheets.add(test);
            } else {
                cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
            }
        }
        assertEquals(cheatSheets.getCheatSheet(2), test);
    }
}