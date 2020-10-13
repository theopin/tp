package storage;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class DataFileDestroyerTest {
    Path removeTestDirectory = Paths.get("src","test", "java", "storage",
            "data_one_file");
    Path textFile5 = Paths.get("src","test", "java", "storage",
            "data_one_file", "testFile5");



    @Test
    void removeSingleFile_textFile5_success() {
        DataFileDestroyer removeTest = new DataFileDestroyer();
        File singleFileDirectory = new File(String.valueOf(removeTestDirectory));
        removeTest.executeFunction(textFile5);

        String[] presentFiles = singleFileDirectory.list();
        try {
            Files.createFile(textFile5);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assert presentFiles != null;
        assertEquals(presentFiles.length, 0);
    }
    /*
        @Test
        void clearDirectory_textFiles_success() {
            File textFile = new File(String.valueOf(this.textFile1));
            DataFileParser parseTest = new DataFileParser(textFile);
            assertEquals(fileName, parseTest.convertedCheatSheet.getCheatSheetName());
        }

    */
}
