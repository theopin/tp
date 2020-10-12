package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.InvalidFileDataException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParseDataFileTest {
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
        ParseDataFile parseTest = new ParseDataFile(textFile);
        assertEquals(fileName, parseTest.convertedCheatSheet.getCheatSheetName());
        removeCheatSheet();
    }

    @Test
    void parseDataLanguage_textFile1_success() {
        File textFile = new File(String.valueOf(this.textFile1));
        ParseDataFile parseTest = new ParseDataFile(textFile);
        assertEquals(fileProgrammingLanguage, parseTest.convertedCheatSheet
                .getCheatSheetProgrammingLanguage());
        removeCheatSheet();
    }

    @Test
    void parseDataDetails_textFile1_success() {
        File textFile = new File(String.valueOf(this.textFile1));
        ParseDataFile parseTest = new ParseDataFile(textFile);
        assertEquals(fileDetails, parseTest.convertedCheatSheet
                .getCheatSheetDetails());
        removeCheatSheet();
    }

    private void removeCheatSheet() {
        int cheatSheetIndex = CheatSheetList.getSize();
        System.out.println(cheatSheetIndex);
        CheatSheet testCheatSheet = CheatSheetList.getCheatSheet(cheatSheetIndex);
        CheatSheetList.remove(testCheatSheet.getCheatSheetName());
    }

    @Test
    void parseEmptyDataName_textFile2_failure() {
        File textFile = new File(String.valueOf(this.textFile2));
        ParseDataFile parseTest = new ParseDataFile();
        assertThrows(InvalidFileDataException.class, () -> {
            parseTest.parseCheatSheet(textFile);
        });
    }

    @Test
    void parseEmptyProgrammingLanguage_textFile3_failure() {
        File textFile = new File(String.valueOf(this.textFile3));
        ParseDataFile parseTest = new ParseDataFile();
        assertThrows(InvalidFileDataException.class, () -> {
            parseTest.parseCheatSheet(textFile);
        });
    }

    @Test
    void parseEmptyDetails_textFile4_failure() {
        File textFile = new File(String.valueOf(this.textFile4));
        ParseDataFile parseTest = new ParseDataFile();
        assertThrows(InvalidFileDataException.class, () -> {
            parseTest.parseCheatSheet(textFile);
        });
    }

}
