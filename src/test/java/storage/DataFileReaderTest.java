package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataFileReaderTest {
    Path testNonEmptyFolder = Paths.get("src", "test", "java", "storage",
            "data_present");
    Path testMissingFolder = Paths.get("src", "test", "java", "storage",
            "missing_folder");

    @Test
    void readDataFiles_nonEmptyFolder_success() {
        DataFileReader readTest = new DataFileReader(String.valueOf(testNonEmptyFolder),
                testNonEmptyFolder);
        readTest.executeFunction();
        assertEquals(1, CheatSheetList.getSize());
        removeCheatSheet();
    }

    private void removeCheatSheet() {
        int cheatSheetIndex = CheatSheetList.getSize();
        CheatSheet testCheatSheet = CheatSheetList.getCheatSheet(cheatSheetIndex);
        CheatSheetList.remove(testCheatSheet.getCheatSheetName());
    }

    @Test
    void readDataFiles_missingFolder_exceptionThrown() {
        DataFileReader readTest = new DataFileReader(String.valueOf(testMissingFolder),
                testMissingFolder);
        assertThrows(FileNotFoundException.class, readTest::insertStoredCheatSheets);
    }
}
