package storage;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataFileReaderTest extends DataFileTest {

    String fileInput = "<main>"
            + System.lineSeparator()
            + "<favourite>Yes</favourite>"
            + System.lineSeparator()
            + "<subject>Test</subject>"
            + System.lineSeparator()
            + "<contents>Test Success!</contents>"
            + System.lineSeparator()
            + "</main>";
    String invalidFileInput  = "garble garble garble ";
    Path sampleTest4 = Paths.get(userDir, data, test, "sample4.xml");
    String sample4 = "sample4";

    @Test
    void readFile_name_success() {
        final boolean isDataDirPresent = checkDataDirectoryExistence();
        if (isDataDirPresent) {
            shiftExistingDataFiles();
        }
        testCheatSheetList.clear();

        createDirectory(sampleTestDir);
        createSampleFile(sampleTest4, fileInput);

        testReader.executeFunction();
        eraseFile(sampleTest4);
        eraseFile(sampleTestDir);
        eraseFile(dataDir);

        if (isDataDirPresent) {
            restoreDataDir();
        }

        String testName = testCheatSheetList.getList().get(0).getName();
        testCheatSheetList.clear();

        assertEquals(sample4, testName);
    }

    @Test
    void readFile_subject_success() {
        final boolean isDataDirPresent = checkDataDirectoryExistence();
        if (isDataDirPresent) {
            shiftExistingDataFiles();
        }

        testCheatSheetList.clear();
        createDirectory(sampleTestDir);
        createSampleFile(sampleTest4, fileInput);

        testReader.executeFunction();
        eraseFile(sampleTest4);
        eraseFile(sampleTestDir);
        eraseFile(dataDir);
        if (isDataDirPresent) {
            restoreDataDir();
        }

        String testSubject = testCheatSheetList.getList().get(0).getSubject();
        testCheatSheetList.clear();
        assertEquals("Test", testSubject);
    }

    @Test
    void readFile_details_success() {
        final boolean isDataDirPresent = checkDataDirectoryExistence();
        if (isDataDirPresent) {
            shiftExistingDataFiles();
        }

        testCheatSheetList.clear();
        createDirectory(sampleTestDir);
        createSampleFile(sampleTest4, fileInput);

        testReader.executeFunction();
        eraseFile(sampleTest4);
        eraseFile(sampleTestDir);
        eraseFile(dataDir);

        if (isDataDirPresent) {
            restoreDataDir();
        }

        String testSubject = testCheatSheetList.getList().get(0).getDetails();
        testCheatSheetList.clear();
        assertEquals("Test Success!", testSubject);
    }

    @Test
    void readFile_invalidFile_notAdded() {
        final boolean isDataDirPresent = checkDataDirectoryExistence();
        if (isDataDirPresent) {
            shiftExistingDataFiles();
        }

        testCheatSheetList.clear();

        createDirectory(sampleTestDir);
        createSampleFile(sampleTest4, invalidFileInput);

        testReader.executeFunction();
        eraseFile(sampleTest4);
        eraseFile(sampleTestDir);
        eraseFile(dataDir);

        if (isDataDirPresent) {
            restoreDataDir();
        }

        int finalListSize = testCheatSheetList.getSize();
        assertEquals(0, finalListSize);
    }
}
