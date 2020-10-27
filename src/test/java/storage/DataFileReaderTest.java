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

    Path sampleTest4 = Paths.get(userDir, data, test, "sample4.xml");
    String sample4 = "sample4";

    @Test
    void readFile_name_success() {
        testCheatSheetList.clear();
        createDirectory(sampleTestDir);
        createSampleFile(sampleTest4, fileInput);

        testReader.executeFunction();
        eraseFile(sampleTest4);
        eraseFile(sampleTestDir);

        String testName = testCheatSheetList.getList().get(0).getName();
        testCheatSheetList.clear();

        assertEquals(sample4, testName);
    }

    @Test
    void readFile_subject_success() {
        testCheatSheetList.clear();
        createDirectory(sampleTestDir);
        createSampleFile(sampleTest4, fileInput);

        testReader.executeFunction();
        eraseFile(sampleTest4);
        eraseFile(sampleTestDir);

        String testSubject = testCheatSheetList.getList().get(0).getSubject();
        testCheatSheetList.clear();

        assertEquals("Test", testSubject);
    }

    @Test
    void readFile_details_success() {
        testCheatSheetList.clear();
        createDirectory(sampleTestDir);
        createSampleFile(sampleTest4, fileInput);

        testReader.executeFunction();
        eraseFile(sampleTest4);
        eraseFile(sampleTestDir);

        String testSubject = testCheatSheetList.getList().get(0).getDetails();
        testCheatSheetList.clear();

        assertEquals("Test Success!", testSubject);
    }

}
