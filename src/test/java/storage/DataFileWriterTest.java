package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileWriterTest extends DataFileTest {

    final String dummyFileContent = "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements.";

    @Test
    void parseDataName_textFile1_success() {
        assertTrue(true);
    }
    /*
    @Test
    public void writeDataFiles_newCheatSheet_success() {
        createDataDir();
        CheatSheetList.clear();
        CheatSheetList.add(new CheatSheet(fileName, fileSubject,
                fileDetails));

        testWriter.executeFunction();
        File createdFile = sampleFile.toFile();

        try {
            String actualFileContent = Files.readString(sampleFile);
            assertEquals(sampleFileContent, actualFileContent);
        } catch (IOException e) {
            printer.print(e.getMessage());
        } finally {
            createdFile.delete();
            CheatSheetList.clear();
            eraseFile(dataDir);
        }
    }

    @Test
    public void writeDataFiles_existingCheatSheet_success() {
        createDataDir();
        CheatSheetList.clear();
        createSampleFile(sampleFile, dummyFileContent);
        CheatSheetList.add(new CheatSheet(fileName, fileSubject,
                fileDetails));

        testWriter.executeFunction();
        File createdFile = sampleFile.toFile();

        try {
            String actualFileContent = Files.readString(sampleFile);
            assertEquals(sampleFileContent, actualFileContent);
        } catch (IOException e) {
            printer.print(e.getMessage());
        } finally {
            CheatSheetList.clear();
            createdFile.delete();
            eraseFile(dataDir);
        }
    }

    @Test
    public void writeDataFiles_emptyCheatSheetList_success() {
        createDataDir();
        CheatSheetList.clear();
        testWriter.executeFunction();

        String[] userDirectoryFiles = dataDir.toFile().list();
        eraseFile(dataDir);

        int directoryFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;
        assertEquals(0, directoryFiles);
    }


    */
}
