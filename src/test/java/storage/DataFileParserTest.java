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

public class DataFileParserTest extends DataFileTest {

    String fileProgrammingLanguage = "C++";
    String fileDetails = "Use case statements to check multiple conditions.";

    int firstCheatSheetIndex = 1;

    @Test
    void parseDataName_textFile1_success() {
        createDataDir();
        CheatSheetList.clear();

        createSampleFile(sampleFile, sampleFileContent);
        DataFileParser testParser = new DataFileParser(sampleFile.toFile());
        CheatSheetList.add(testParser.convertedCheatSheet);

        final String cheatSheetName = CheatSheetList
                .getCheatSheet(firstCheatSheetIndex)
                .getCheatSheetName();

        CheatSheetList.clear();
        eraseFile(dataDir);
        eraseFile(sampleFile);
        assertEquals(fileName, cheatSheetName);
    }

    @Test
    void parseDataLanguage_textFile1_success() {
        createDataDir();
        CheatSheetList.clear();
        createSampleFile(sampleFile, sampleFileContent);
        DataFileParser testParser = new DataFileParser(sampleFile.toFile());
        CheatSheetList.add(testParser.convertedCheatSheet);

        final String cheatSheetProgrammingLanguage =
                CheatSheetList
                .getCheatSheet(firstCheatSheetIndex)
                .getCheatSheetProgrammingLanguage();

        CheatSheetList.clear();
        eraseFile(sampleFile);
        eraseFile(dataDir);
        assertEquals(fileProgrammingLanguage, cheatSheetProgrammingLanguage);
    }

    @Test
    void parseDataDetails_textFile1_success() {
        createDataDir();
        CheatSheetList.clear();
        createSampleFile(sampleFile, sampleFileContent);
        DataFileParser testParser = new DataFileParser(sampleFile.toFile());
        CheatSheetList.add(testParser.convertedCheatSheet);

        final String cheatSheetDetails = CheatSheetList
                .getCheatSheet(firstCheatSheetIndex)
                .getCheatSheetDetails();

        CheatSheetList.clear();
        eraseFile(sampleFile);
        eraseFile(dataDir);
        assertEquals(fileDetails, cheatSheetDetails);
    }

}
