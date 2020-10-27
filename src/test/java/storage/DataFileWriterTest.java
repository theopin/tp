package storage;

import cheatsheet.CheatSheet;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileWriterTest extends DataFileTest {

    String fileInput = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
            + System.lineSeparator()
            + "<main>"
            + System.lineSeparator()
            + "    <favourite>No</favourite>"
            + System.lineSeparator()
            + "    <subject>Test</subject>"
            + System.lineSeparator()
            + "    <contents>Test Success!</contents>"
            + System.lineSeparator()
            + "</main>"
            + System.lineSeparator();

    Path sampleTest = Paths.get(userDir, data, test, "sample.xml");
    /*
    @Test
    public void writeDataFiles_emptyTestCheatSheetList_success() {
        testCheatSheetList.clear();
        String[] userDirectoryFiles = dataDir.toFile().list();
        final int expectedFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;

        testWriter.executeFunction();

        userDirectoryFiles = dataDir.toFile().list();

        testCheatSheetList.clear();
        int directoryFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;
        assertEquals(expectedFiles, directoryFiles);
    }

    @Test
    void writeFileExists_sampleCheatsheet_success() {
        testCheatSheetList.clear();
        CheatSheet testCheatSheet = new CheatSheet(sample,
                "Test",
                "Test Success!");
        testCheatSheetList.add(testCheatSheet);

        testWriter.executeFunction();
        boolean isSampleAdded = sampleTest.toFile().exists();
        if (isSampleAdded) {
            eraseFile(sampleTest);
            eraseFile(sampleTestDir);
        }

        testCheatSheetList.clear();
        assertTrue(isSampleAdded);
    }

    @Test
    void writeFileContents_sampleCheatsheet_success() {
        testCheatSheetList.clear();

        CheatSheet testCheatSheet = new CheatSheet(sample,
                "Test",
                "Test Success!");
        testCheatSheetList.add(testCheatSheet);

        testWriter.executeFunction();

        String writtenFile = empty;
        try {
            writtenFile = Files.readString(sampleTest);
        } catch (IOException e) {
            printer.print(e.getMessage());
        } finally {
            if (sampleTest.toFile().exists()) {
                eraseFile(sampleTest);
                eraseFile(sampleTestDir);
            }
            testCheatSheetList.clear();
            assertEquals(fileInput, writtenFile);
        }
    }
    */
}
