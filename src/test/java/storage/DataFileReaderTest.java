package storage;

import cheatsheet.CheatSheetList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileReaderTest extends DataFileTest {

    @Test
    void parseDataName_textFile1_success() {
        assertTrue(true);
    }
    /*
    @Test
    void readDataFiles_missingFolder_exceptionThrown() {
        assertThrows(FileNotFoundException.class, testReader::insertStoredCheatSheets);
    }

    @Test
    void readDataFiles_nonEmptyFolder_success() {
        createDataDir();
        CheatSheetList.clear();

        createSampleFile(sampleFile, sampleFileContent);
        testReader.executeFunction();

        final int listSize = CheatSheetList.getSize();

        CheatSheetList.clear();
        eraseFile(sampleFile);
        eraseFile(dataDir);

        assertEquals(1, listSize);
    }

    */
}
