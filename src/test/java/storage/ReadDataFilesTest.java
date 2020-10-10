package storage;

import exception.DirectoryIsEmptyException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(1,readTest.storedCheatSheets.getSize());
    }

    @Test
    void readDataFiles_emptyFolder_exceptionThrown() {
        ReadDataFiles readTest = new ReadDataFiles(String.valueOf(testEmptyFolder),
                testEmptyFolder);
        assertThrows(DirectoryIsEmptyException.class, readTest::insertStoredCheatSheets);
    }

    @Test
    void readFile_missingFolder_exceptionThrown() {
        ReadDataFiles readTest = new ReadDataFiles(String.valueOf(testMissingFolder),
                testMissingFolder);
        assertThrows(FileNotFoundException.class, readTest::insertStoredCheatSheets);
    }
}
