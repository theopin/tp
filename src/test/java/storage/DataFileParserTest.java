package storage;

import exception.InvalidFileDataException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataFileParserTest {
    Path textFile1 = Paths.get("src","test", "java", "storage",
            "data_present", "testFile1");
    Path textFile2 = Paths.get("src","test", "java", "storage",
            "data_missing_parameter", "testFile2");
    Path textFile3 = Paths.get("src","test", "java", "storage",
            "data_missing_parameter", "testFile3");
    Path textFile4 = Paths.get("src","test", "java", "storage",
            "data_missing_parameter", "testFile4");

    final String fileName = "Sample1";
    final String fileProgrammingLanguage = "C++";
    final String fileDetails = "Use case statements to check multiple conditions.";

    @Test
    void parseDataName_textFile1_success() {
        File textFile = new File(String.valueOf(this.textFile1));
        DataFileParser parseTest = new DataFileParser(textFile);
        assertEquals(fileName, parseTest.convertedCheatSheet.getCheatSheetName());
    }

    @Test
    void parseDataLanguage_textFile1_success() {
        File textFile = new File(String.valueOf(this.textFile1));
        DataFileParser parseTest = new DataFileParser(textFile);
        assertEquals(fileProgrammingLanguage, parseTest.convertedCheatSheet
                .getCheatSheetProgrammingLanguage());
    }

    @Test
    void parseDataDetails_textFile1_success() {
        File textFile = new File(String.valueOf(this.textFile1));
        DataFileParser parseTest = new DataFileParser(textFile);
        assertEquals(fileDetails, parseTest.convertedCheatSheet
                .getCheatSheetDetails());
    }

    @Test
    void parseEmptyDataName_textFile2_failure() {
        File textFile = new File(String.valueOf(this.textFile2));
        DataFileParser parseTest = new DataFileParser();
        assertThrows(InvalidFileDataException.class, () -> {
            parseTest.parseCheatSheet(textFile);
        });
    }

    @Test
    void parseEmptyProgrammingLanguage_textFile3_failure() {
        File textFile = new File(String.valueOf(this.textFile3));
        DataFileParser parseTest = new DataFileParser();
        assertThrows(InvalidFileDataException.class, () -> {
            parseTest.parseCheatSheet(textFile);
        });
    }

    @Test
    void parseEmptyDetails_textFile4_failure() {
        File textFile = new File(String.valueOf(this.textFile4));
        DataFileParser parseTest = new DataFileParser();
        assertThrows(InvalidFileDataException.class, () -> {
            parseTest.parseCheatSheet(textFile);
        });
    }

}
