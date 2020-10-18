package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFileTest {

    String userDir = System.getProperty("user.dir");
    String data = "data";

    String fileName = "Sample1";
    String fileProgrammingLanguage = "C++";
    String fileDetails = "Use case statements to check multiple conditions.";

    String sampleFileContent = "Name: Sample1"
            + System.lineSeparator()
            + "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements to check multiple conditions.";

    final Path dataDir = Paths.get(userDir, data);
    final Path existingFile = Paths.get(userDir, data, fileName);

    DataFileWriter testWriter = new DataFileWriter();
    //DataFileReader testReader = new DataFileReader();
    DataFileDestroyer testDestroyer = new DataFileDestroyer();

    void createDataDir() {
        try {
            Files.createDirectories(dataDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void createSampleFile(Path fileName, String fileContent) {
        try {
            Files.createFile(fileName);
            Files.writeString(fileName, fileContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void eraseUserDir() {
        try {
            Files.delete(dataDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void removeCheatSheet() {
        int cheatSheetIndex = CheatSheetList.getSize();
        CheatSheet testCheatSheet = CheatSheetList.getCheatSheet(cheatSheetIndex);
        CheatSheetList.remove(testCheatSheet.getCheatSheetName());
    }
}
