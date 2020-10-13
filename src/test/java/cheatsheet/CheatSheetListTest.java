package cheatsheet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheatSheetListTest {

    @Test
    void testGetSize() {
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(10, CheatSheetList.getSize());
        for (int i = 0; i < 10; i++) {
            CheatSheetList.remove("Name" + i);
        }
    }

    @Test
    void testGetCheatSheetList() {
        // to be added
    }


    @Test
    void testClear() {
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        CheatSheetList.clear();
        assertEquals(0, CheatSheetList.getSize());
    }

    @Test
    void testPrintCheatSheetNames() {
        StringBuilder print = new StringBuilder("Current list of cheat sheet:\n");
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
            print.append("Name").append(i).append("\n");
        }
        assertEquals(print.toString(), CheatSheetList.printCheatSheetNames());
        for (int i = 0; i < 10; i++) {
            CheatSheetList.remove("Name" + i);
        }
    }

    @Test
    void testAdd() {
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(10, CheatSheetList.getSize());
        for (int i = 0; i < 10; i++) {
            CheatSheetList.remove("Name" + i);
        }
    }

    @Test
    void testRemove() {
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        CheatSheetList.remove("Name1");
        CheatSheetList.remove("Name3");
        CheatSheetList.remove("Name5");
        assertEquals(7, CheatSheetList.getSize());
        for (int i = 0; i < 10; i++) {
            if (i == 1 || i == 3 || i == 5) {
                continue;
            }
            CheatSheetList.remove("Name" + i);
        }
    }

    @Test
    void testGetCheatSheet() {
        CheatSheet test = new CheatSheet("Name1", "Language1", "Details1");
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                CheatSheetList.add(test);
            } else {
                CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
            }
        }
        assertEquals(test, CheatSheetList.getCheatSheet(2));
        for (int i = 0; i < 10; i++) {
            CheatSheetList.remove("Name" + i);
        }
    }
}
