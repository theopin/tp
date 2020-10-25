package storage;

import org.junit.jupiter.api.Test;
import ui.Printer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileDestroyerTest extends DataFileTest {

    Path sampleTest = Paths.get(userDir, data, "sample.xml");
    Path sampleTest2 = Paths.get(userDir, data, "sample2.xml");

    @Test
    void clearSingleFile_singleSampleTest_success() {
        Printer testPrinter = new Printer();
        DataFileDestroyer testDestroyer = new DataFileDestroyer(testPrinter);

        createSampleFile(sampleTest, empty);
        File sampleFile = sampleTest.toFile();
        testDestroyer.executeFunction("sample");

        boolean isSampleRemoved = !sampleFile.exists();
        if (!isSampleRemoved) {
            eraseFile(sampleTest);
        }

        assertTrue(isSampleRemoved);
    }

    @Test
    void clearDirectory_multipleSampleTest_success() {
        Printer testPrinter = new Printer();
        DataFileDestroyer testDestroyer = new DataFileDestroyer(testPrinter);

        createSampleFile(sampleTest, empty);
        createSampleFile(sampleTest2, empty);

        File sampleFile = sampleTest.toFile();
        File sampleFile2 = sampleTest2.toFile();
        testDestroyer.executeFunction();

        boolean isSampleRemoved = !(sampleFile.exists() || sampleFile2.exists());
        if (!isSampleRemoved) {
            eraseFile(sampleTest);
            eraseFile(sampleTest2);
        }

        assertTrue(isSampleRemoved);
    }

}


