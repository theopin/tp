package storage;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseDataFileTest {

    Path textFile = Paths.get("src","test", "java", "storage",
            "data_present", "testFile1");

    final String fileName = "Sample1";
    final String fileProgrammingLanguage = "C++";
    final String fileDetails = "Contents: Use case statements to check multiple conditions.";

    @Test
    void parseDataName_textFile1_success() {
        File textFile1 = new File(String.valueOf(textFile));
        ParseDataFile parseTest = new ParseDataFile(textFile1);
        assertEquals(fileName, parseTest.convertedCheatSheet.getCheatSheetName());
    }

    @Test
    void parseDataLanguage_textFile1_success() {
        File textFile1 = new File(String.valueOf(textFile));
        ParseDataFile parseTest = new ParseDataFile(textFile1);
        assertEquals(fileProgrammingLanguage, parseTest.convertedCheatSheet
                .getCheatSheetProgrammingLanguage());
    }

    @Test
    void parseDataDetails_textFile1_success() {
        File textFile1 = new File(String.valueOf(textFile));
        ParseDataFile parseTest = new ParseDataFile(textFile1);
        assertEquals(fileDetails, parseTest.convertedCheatSheet
                .getCheatSheetDetails());
    }
}
