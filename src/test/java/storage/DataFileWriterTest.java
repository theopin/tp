package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataFileWriterTest extends DataFileTest {

    final String dummyFileContent = "Name: Sample1"
            + System.lineSeparator()
            + "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements.";

    @Test
    public void writeDataFiles_newCheatSheet_success() {
        createDataDir();
        CheatSheetList.add(new CheatSheet(fileName, fileProgrammingLanguage,
                fileDetails));

        testWriter.executeFunction();
        File createdFile = sampleFile.toFile();

        try {
            String actualFileContent = Files.readString(sampleFile);
            assertEquals(sampleFileContent, actualFileContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            createdFile.delete();
            CheatSheetList.clear();
            eraseDataDir();
        }
    }

    @Test
    public void writeDataFiles_existingCheatSheet_success() {
        createDataDir();
        createSampleFile(sampleFile, dummyFileContent);
        CheatSheetList.add(new CheatSheet(fileName, fileProgrammingLanguage,
                fileDetails));

        testWriter.executeFunction();
        File createdFile = sampleFile.toFile();

        try {
            String actualFileContent = Files.readString(sampleFile);
            assertEquals(sampleFileContent, actualFileContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            createdFile.delete();
            CheatSheetList.clear();
            eraseDataDir();
        }
    }

    @Test
    public void writeDataFiles_emptyCheatSheetList_success() {
        createDataDir();
        testWriter.executeFunction();

        String[] userDirectoryFiles = dataDir.toFile().list();
        eraseDataDir();

        int directoryFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;
        assertEquals(0, directoryFiles);
    }

}
