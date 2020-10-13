package storage;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataFileDestroyerTest {
    Path removeTestDirectory = Paths.get("src","test", "java", "storage",
            "data_one_file");
    Path clearTestDirectory = Paths.get("src","test", "java", "storage",
            "data_multiple_files");


    Path textFile5 = Paths.get("src","test", "java", "storage",
            "data_one_file", "testFile5");
    Path textFile6 = Paths.get("src","test", "java", "storage",
            "data_multiple_files", "testFile6");
    Path textFile7 = Paths.get("src","test", "java", "storage",
            "data_multiple_files", "testFile7");
    Path textFile8 = Paths.get("src","test", "java", "storage",
            "data_multiple_files", "testFile8");

    static final String MULTIPLE = "multiple";
    static final String SINGLE = "single";

    @Test
    void removeSingleFile_textFile5_success() {
        DataFileDestroyer removeTest = new DataFileDestroyer();
        File singleFileDirectory = new File(String.valueOf(removeTestDirectory));
        removeTest.executeFunction(textFile5, "single");

        String[] presentFiles = singleFileDirectory.list();
        try {
            Files.createFile(textFile5);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assert presentFiles != null;
        assertEquals(presentFiles.length, 0);
    }

    @Test
    void clearDirectory_textFiles_success() {
        DataFileDestroyer removeTest = new DataFileDestroyer();
        File multipleFileDirectory = new File(String.valueOf(clearTestDirectory));
        removeTest.executeFunction(clearTestDirectory, MULTIPLE);

        String[] presentFiles = multipleFileDirectory.list();

        try {
            Files.createFile(textFile6);
            Files.createFile(textFile7);
            Files.createFile(textFile8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assert presentFiles != null;
        assertEquals(presentFiles.length, 0);
    }
}
