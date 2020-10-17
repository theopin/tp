package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFileTest {

    final String USER_DIR = System.getProperty("user.dir");
    final String DATA = "data";
    final Path DATA_DIR = Paths.get(USER_DIR, DATA);

    DataFileWriter testWriter = new DataFileWriter();

    void createUserDir() {
        try {
            Files.createDirectories(DATA_DIR);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void createSampleFile(Path fileName, String fileContent) {
        try {
            Files.createFile(fileName);
            if (fileContent != null) {
                Files.writeString(fileName, fileContent);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void eraseUserDir() {
        try {
            Files.delete(DATA_DIR);
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
