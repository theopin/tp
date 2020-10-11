package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.DirectoryIsEmptyException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static storage.ParseDataFile.NAME;

public class ReadDataFilesTest {
    
    Path testNonEmptyFolder = Paths.get("src","test", "java", "storage",
            "data_present");
    Path testEmptyFolder = Paths.get("src","test", "java", "storage",
            "data_empty");
    Path testMissingFolder = Paths.get("src","test", "java", "storage",
            "missing_folder");

    @Test
    void readDataFiles_nonEmptyFolder_success() {
        ReadDataFiles readTest = new ReadDataFiles(String.valueOf(testNonEmptyFolder),
                testNonEmptyFolder);
        readTest.executeFunction();
        int cheatSheetIndex = CheatSheetList.getSize();
        CheatSheet testCheatSheet = CheatSheetList.getCheatSheet(cheatSheetIndex);
        assertEquals("Sample1", testCheatSheet.getCheatSheetName());
    }

    @Test
    void readDataFiles_emptyFolder_exceptionThrown() {
        ReadDataFiles readTest = new ReadDataFiles(String.valueOf(testEmptyFolder),
                testEmptyFolder);
        assertThrows(DirectoryIsEmptyException.class, readTest::insertStoredCheatSheets);
    }

    @Test
    void readDataFiles_missingFolder_exceptionThrown() {
        ReadDataFiles readTest = new ReadDataFiles(String.valueOf(testMissingFolder),
                testMissingFolder);
        assertThrows(FileNotFoundException.class, readTest::insertStoredCheatSheets);
    }
}
