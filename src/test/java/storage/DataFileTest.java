package storage;

import ui.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFileTest {

    String userDir = System.getProperty("user.dir");
    String data = "data";

    String fileName = "Sample1";
    String fileSubject = "C++";
    String fileDetails = "Use case statements to check multiple conditions.";

    String sampleFileContent = "Programming Language: C++"
            + System.lineSeparator()
            + "Contents: Use case statements to check multiple conditions.";

    Path dataDir = Paths.get(userDir, data);
    Path sampleFile = Paths.get(userDir, data, fileName);

    Printer printer = new Printer();
    DataFileWriter testWriter = new DataFileWriter(printer);
    DataFileReader testReader = new DataFileReader(printer);
    DataFileDestroyer testDestroyer = new DataFileDestroyer(printer);

    void createDataDir() {
        try {
            Files.createDirectories(dataDir);
        } catch (IOException e) {
            printer.print(e.getMessage());

        }
    }

    void createSampleFile(Path fileName, String fileContent) {
        try {
            //Files.createFile(fileName);
            Files.writeString(fileName, fileContent);
        } catch (IOException e) {
            printer.print(e.getMessage());
        }
    }

    void eraseFile(Path fileName) {
        fileName.toFile().delete();
    }

}
