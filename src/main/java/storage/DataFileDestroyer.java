package storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataFileDestroyer extends DataFile {

    @Override
    public void executeFunction() {
        try {
            clearDirectory();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            createNewDirectory();
        }
    }

    public void executeFunction(String unwantedFile) {
        try {
            deleteFile(unwantedFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void deleteFile(String unwantedFile) throws IOException {
        Path unwantedFilePath = Paths.get(USER_DIR, DATA, unwantedFile);
        Files.delete(unwantedFilePath);
    }

    protected void clearDirectory() throws IOException {
        Stream<Path> dataDirectoryFiles = Files.list(DataFile.DATA_DIR);
        dataDirectoryFiles.forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

}
