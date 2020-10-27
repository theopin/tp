package storage;

import cheatsheet.CheatSheetList;
import ui.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFileTest {

    String userDir = System.getProperty("user.dir");
    String data = "data";
    String test = "test";
    String empty = "";
    String sample = "sample";

    Path sampleTestDir = Paths.get(userDir, data, test);
    Path dataDir = Paths.get(userDir, data);

    Printer printer = new Printer();
    CheatSheetList testCheatSheetList = new CheatSheetList();
    DataFileReader testReader = new DataFileReader(printer, testCheatSheetList);
    DataFileWriter testWriter = new DataFileWriter(printer, testCheatSheetList);
    DataFileDestroyer testDestroyer = new DataFileDestroyer(printer, testCheatSheetList);

    void createDirectory(Path directoryPath) {
        try {
            Files.createDirectories(directoryPath);
        } catch (IOException e) {
            printer.print(e.getMessage());

        }
    }

    void createSampleFile(Path fileName, String fileContent) {
        try {
            Files.createFile(fileName);
            Files.writeString(fileName, fileContent);
        } catch (IOException e) {
            printer.print(e.getMessage());
        }
    }

    void eraseFile(Path fileName) {
        fileName.toFile().delete();
    }
}
