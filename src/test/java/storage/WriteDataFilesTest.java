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

public class WriteDataFilesTest {

    final String fileName = "Sample1";
    final String fileProgrammingLanguage = "C++";
    final String fileDetails = "Use case statements to check multiple conditions.";

    Path textFile = Paths.get("src","test", "java", "storage",
            "data_present", "testFile1");
    Path textCompareFile = Paths.get("src","test", "java", "storage",
            "data_present", "Sample1");

    @Test
    public void writeDataFiles_cheatSheetObject_success() {

        CheatSheetList.add(new CheatSheet(fileName, fileProgrammingLanguage,
                fileDetails));
        new WriteDataFiles(textCompareFile);
        File createdFile = new File(String.valueOf(textCompareFile));
        createdFile.deleteOnExit();

        try {
            String referenceFile = Files.readString(textFile);
            String actualFile = Files.readString(textCompareFile);
            assertEquals(referenceFile, actualFile);
        } catch (IOException e) {
            System.out.println(222 + e.getMessage());
        }
    }
}
