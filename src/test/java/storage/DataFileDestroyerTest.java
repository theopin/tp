package storage;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataFileDestroyerTest extends DataFileTest {
    Path secondFile = Paths.get(userDir, data, "Sample2");

    final String secondFileContent = "Name: Sample2"
            + System.lineSeparator()
            + "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements.";


    @Test
    void clearDirectory_allFiles_success() {
        createDataDir();

        createSampleFile(existingFile, sampleFileContent);
        createSampleFile(secondFile, secondFileContent);
        testDestroyer.executeFunction();

        String[] userDirectoryFiles = dataDir.toFile().list();
        eraseUserDir();

        int directoryFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;
        assertEquals(0, directoryFiles);

    }

    @Test
    public void clearDirectory_singleFile_success() {
        createDataDir();
        createSampleFile(existingFile, sampleFileContent);
        testDestroyer.executeFunction(fileName);

        String[] userDirectoryFiles = dataDir.toFile().list();
        eraseUserDir();

        int directoryFiles = userDirectoryFiles != null ? userDirectoryFiles.length : 0;
        assertEquals(0, directoryFiles);
    }

    @Test
    public void clearDirectory_notExistentFile_exceptionThrown() {
        createDataDir();

        eraseUserDir();
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

}
