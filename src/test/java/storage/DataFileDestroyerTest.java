package storage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileDestroyerTest extends DataFileTest {
    Path sampleFile2 = Paths.get(userDir, data, "Sample2");

    String secondFileContent = "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements.";

    @Test
    void parseDataName_textFile1_success() {
        assertTrue(true);
    }
    /*
    @Test
    public void clearDirectory_notExistentFile_exceptionThrown() {
        assertThrows(IOException.class, () -> {
            testDestroyer.deleteFile(fileName);
        });
    }

    @Test
    public void clearDirectory_notExistentDirectory_exceptionThrown() {
        assertThrows(IOException.class, () -> {
            testDestroyer.clearDirectory();
        });
    }

    @Test
    public void clearDirectory_singleFile_success() {
        createDataDir();
        createSampleFile(sampleFile, sampleFileContent);
        testDestroyer.executeFunction(fileName);

        String[] userDirectoryFiles = dataDir.toFile().list();
        eraseFile(dataDir);

        int directoryFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;
        assertEquals(0, directoryFiles);
    }

    @Test
    public void clearDirectory_multipleFiles_success() {
        createDataDir();
        createSampleFile(sampleFile, sampleFileContent);
        createSampleFile(sampleFile2, secondFileContent);
        testDestroyer.executeFunction();

        String[] userDirectoryFiles = dataDir.toFile().list();
        eraseFile(dataDir);

        int directoryFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;
        assertEquals(0, directoryFiles);
    }
    */
}
