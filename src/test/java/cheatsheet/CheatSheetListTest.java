package cheatsheet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheatSheetListTest {


    @Test
    void testGetSize() {
        CheatSheetList cheatSheets = new CheatSheetList();
        for (int i = 0; i < 10; i++) {
            cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(cheatSheets.getSize(), 10);
    }

    @Test
    void testGetCheatSheetList() {
        // to be added
    }

    @Test
    void testPrintCheatSheetNames() {
        // to be added
    }

    @Test
    void testAdd() {
        CheatSheetList cheatSheets = new CheatSheetList();
        for (int i = 0; i < 10; i++) {
            cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(cheatSheets.getSize(), 10);
    }

    @Test
    void testRemove() {
        CheatSheetList cheatSheets = new CheatSheetList();
        for (int i = 0; i < 10; i++) {
            cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        cheatSheets.remove("Name1");
        cheatSheets.remove("Name3");
        cheatSheets.remove("Name5");
        assertEquals(cheatSheets.getSize(), 7);
    }

    @Test
    void testGetCheatSheet() {
        CheatSheetList cheatSheets = new CheatSheetList();
        CheatSheet test = new CheatSheet("Name1", "Language1", "Details1");
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                cheatSheets.add(test);
            } else {
                cheatSheets.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
            }
        }
        assertEquals(cheatSheets.getCheatSheet(2), test);
    }
}
