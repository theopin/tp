package cheatsheet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheatSheetListTest {

    @Test
    void testGetSize() {
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(10, CheatSheetList.getSize());
    }

    @Test
    void testGetCheatSheetList() {
        // to be added
    }


    @Test
    void testClear() {
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        CheatSheetList.clear();
        assertEquals(0, CheatSheetList.getSize());
    }

    @Test
    void testPrintCheatSheetNames() {
        CheatSheetList.clear();
        StringBuilder print = new StringBuilder("Current list of cheat sheet:\n");
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
            print.append("Name").append(i).append("\n");
        }
        assertEquals(print.toString(), CheatSheetList.printCheatSheetNames());
    }

    @Test
    void testAdd() {
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(10, CheatSheetList.getSize());
    }

    @Test
    void testRemove() {
        // remove(String name);
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        CheatSheetList.remove("Name1");
        CheatSheetList.remove("Name3");
        CheatSheetList.remove("Name5");
        assertEquals(7, CheatSheetList.getSize());

        // remove(int index);
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        CheatSheetList.remove(1);
        CheatSheetList.remove(3);
        CheatSheetList.remove(5);
        assertEquals(7, CheatSheetList.getSize());
    }

    @Test
    void testGetCheatSheet() {
        CheatSheetList.clear();
        CheatSheet test = new CheatSheet("Name1", "Language1", "Details1");
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                CheatSheetList.add(test);
            } else {
                CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
            }
        }
        assertEquals(test, CheatSheetList.getCheatSheet(2));
        assertEquals(test, CheatSheetList.getCheatSheet("Name1"));
    }
}
