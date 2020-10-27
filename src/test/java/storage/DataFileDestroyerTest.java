package storage;

import cheatsheet.CheatSheet;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileDestroyerTest extends DataFileTest {
    Path sampleTest2 = Paths.get(userDir, data, test, "sample2.xml");
    Path sampleTest3 = Paths.get(userDir, data, test, "sample3.xml");
    String sample2 = "sample2";
    String sample3 = "sample3";
    /*
    @Test
    void clearSingleFile_singleSampleTest_success() {
        testCheatSheetList.clear();
        createDirectory(sampleTestDir);
        CheatSheet testCheatSheet = new CheatSheet(sample3,
                "Test",
                "Test Success!");
        testCheatSheetList.add(testCheatSheet);

        createSampleFile(sampleTest3, empty);
        File sampleFile3 = sampleTest3.toFile();
        testDestroyer.executeFunction(sample3);

        boolean isSampleRemoved = !sampleFile3.exists();
        if (!isSampleRemoved) {
            eraseFile(sampleTest3);
            eraseFile(sampleTestDir);
        }
        testCheatSheetList.clear();
        assertTrue(isSampleRemoved);
    }

    @Test
    void clearDirectory_multipleSampleTest_success() {
        testCheatSheetList.clear();
        createDirectory(sampleTestDir);

        CheatSheet testCheatSheet2 = new CheatSheet(sample2,
                "Test",
                "Test Success!");
        CheatSheet testCheatSheet3 = new CheatSheet(sample3,
                "Test",
                "Test Success!");

        testCheatSheetList.add(testCheatSheet2);
        testCheatSheetList.add(testCheatSheet3);

        createSampleFile(sampleTest2, empty);
        createSampleFile(sampleTest3, empty);

        File sampleFile2 = sampleTest2.toFile();
        File sampleFile3 = sampleTest3.toFile();
        testDestroyer.executeFunction();

        boolean isSampleRemoved = !(sampleFile2.exists() || sampleFile3.exists());
        if (!isSampleRemoved) {
            eraseFile(sampleTest2);
            eraseFile(sampleTest3);
            eraseFile(sampleTestDir);
        }
        testCheatSheetList.clear();
        assertTrue(isSampleRemoved);
    }

    */
}
