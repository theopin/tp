package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataFileWriterTest extends DataFileTest{
    final String FILE_NAME = "Sample1";
    final String FILE_PROGRAMMING_LANGUAGE = "C++";
    final String FILE_DETAILS = "Use case statements to check multiple conditions.";

    final Path EXISTING_FILE = Paths.get(USER_DIR, DATA, FILE_NAME);

    final String DUMMY_FILE_CONTENT = "Name: Sample1"
            + System.lineSeparator()
            + "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements.";

    final String EXPECTED_FILE_CONTENT = "Name: Sample1"
            + System.lineSeparator()
            + "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements to check multiple conditions.";

    @Test
    public void writeDataFiles_newCheatSheet_success() {
        createUserDir();
        CheatSheetList.add(new CheatSheet(FILE_NAME, FILE_PROGRAMMING_LANGUAGE,
                FILE_DETAILS));

        testWriter.executeFunction();
        File createdFile = new File(String.valueOf(EXISTING_FILE));

        try {
            String actualFileContent = Files.readString(EXISTING_FILE);
            assertEquals(EXPECTED_FILE_CONTENT, actualFileContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            createdFile.delete();
            removeCheatSheet();
            eraseUserDir();
        }
    }

    @Test
    public void writeDataFiles_existingCheatSheet_success() {
        createUserDir();
        createSampleFile(EXISTING_FILE, DUMMY_FILE_CONTENT);
        CheatSheetList.add(new CheatSheet(FILE_NAME, FILE_PROGRAMMING_LANGUAGE,
                FILE_DETAILS));

        testWriter.executeFunction();
        File createdFile = new File(String.valueOf(EXISTING_FILE));

        try {
            String actualFileContent = Files.readString(EXISTING_FILE);
            assertEquals(EXPECTED_FILE_CONTENT, actualFileContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            createdFile.delete();
            removeCheatSheet();
            eraseUserDir();
        }
    }

    @Test
    public void writeDataFiles_emptyCheatSheetList_success() {
        createUserDir();

        testWriter.executeFunction();

        File userDirectory = new File(String.valueOf(DATA_DIR));
        String[] userDirectoryFiles = userDirectory.list();

        assert userDirectoryFiles != null;
        assertEquals(0, userDirectoryFiles.length);
        eraseUserDir();
    }

}
