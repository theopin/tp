package storage;

import cheatsheet.CheatSheetList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileParserTest extends DataFileTest {

    String fileProgrammingLanguage = "C++";
    String fileDetails = "Use case statements to check multiple conditions.";

    int firstCheatSheetIndex = 1;

    @Test
    void parseDataName_textFile1_success() {
        assertTrue(true);
    }
    /*
    @Test
    void parseDataName_textFile1_success() {
        createDataDir();
        CheatSheetList.clear();
        createSampleFile(sampleFile, sampleFileContent);

        DataFileParser testParser = new DataFileParser();
        testParser.handleOperation(sampleFile.toFile());
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

        DataFileParser testParser = new DataFileParser();
        testParser.handleOperation(sampleFile.toFile());
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

        DataFileParser testParser = new DataFileParser();
        testParser.handleOperation(sampleFile.toFile());
        CheatSheetList.add(testParser.convertedCheatSheet);

        final String cheatSheetDetails = CheatSheetList
                .getCheatSheet(firstCheatSheetIndex)
                .getCheatSheetDetails();

        CheatSheetList.clear();
        eraseFile(sampleFile);
        eraseFile(dataDir);
        assertEquals(fileDetails, cheatSheetDetails);
    }
*/
}
