package cheatsheet;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CheatSheetListTest {
    private static Logger logger = Logger.getLogger("Tester");

    @Test
    void testGetSize() {

        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(10, CheatSheetList.getSize());
        logger.log(Level.INFO, "Finished GetSize test");
    }


    @Test
    void testClear() {
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        CheatSheetList.clear();
        assertEquals(0, CheatSheetList.getSize());
        logger.log(Level.INFO, "Finished Clear test");
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
        logger.log(Level.INFO, "Finished PrintCheatSheetName test");
    }

    @Test
    void testAdd() {
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        assertEquals(10, CheatSheetList.getSize());
        logger.log(Level.INFO, "Finished Add test");
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
        logger.log(Level.INFO, "Finished Remove test");
    }

    @Test
    void remove_negativeIndex_exceptionThrown() {
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            CheatSheetList.remove(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // todo: add error message
        }
    }

    @Test
    void remove_nonExistentName_exceptionThrown() {
        CheatSheetList.clear();
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            CheatSheetList.remove("dummy");
            fail();
        } catch (IndexOutOfBoundsException e) {
            // todo: add error message
        }
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
        // test to get cheatsheet by index and by name
        assertEquals(test, CheatSheetList.getCheatSheet(2));
        assertEquals(test, CheatSheetList.getCheatSheet("Name1"));
        logger.log(Level.INFO, "Finished GetCheatSheet test");
    }

    @Test
    void getCheatSheet_negativeIndex_exceptionThrown() {
        CheatSheetList.clear();
        CheatSheet test;
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            test = CheatSheetList.getCheatSheet(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // todo: add and check error message
        }
    }

    @Test
    void getCheatSheet_nonExistentName_exceptionThrown() {
        CheatSheetList.clear();
        CheatSheet test;
        for (int i = 0; i < 10; i++) {
            CheatSheetList.add(new CheatSheet("Name" + i, "Language" + i, "Details" + i));
        }
        try {
            test = CheatSheetList.getCheatSheet("cheatlogs");
            fail();
        } catch (IndexOutOfBoundsException e) {
            // todo: add and check error message
        }
    }
}
