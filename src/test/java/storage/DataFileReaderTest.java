package storage;

import cheatsheet.CheatSheetList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataFileReaderTest extends DataFileTest {

    @Test
    void readDataFiles_missingFolder_exceptionThrown() {
        eraseDataDir();
        assertThrows(FileNotFoundException.class, testReader::insertStoredCheatSheets);
    }

    @Test
    void readDataFiles_nonEmptyFolder_success() {
        CheatSheetList.clear();
        createDataDir();

        createSampleFile(sampleFile, sampleFileContent);
        testReader.executeFunction();

        int listSize = CheatSheetList.getSize();

        CheatSheetList.clear();
        eraseFile(sampleFile);
        eraseDataDir();

        assertEquals(1, listSize);
    }
}
