package storage;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataFileDestroyer extends DataFile {

    private Path debugPath = null;

    @Override
    public void executeFunction() {
    /*        try {
                clearDirectory();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    */
    }

    public void executeFunction(String unwantedFile) {
        try {
            deleteFile(unwantedFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeFunction(Path unwantedFilePath) {
        this.debugPath = unwantedFilePath;
        try {
            deleteFile(null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteFile(String unwantedFile) throws IOException {
        Path unwantedFilePath = (debugPath == null)
                ? Paths.get(USER_DIR, DATA, unwantedFile)
                : debugPath;
        Files.delete(unwantedFilePath);
    }
    /*
        private void clearDirectory() throws IOException {
            Files.list(DATA_DIR).forEach(Files::delete);
        }
    */
}
