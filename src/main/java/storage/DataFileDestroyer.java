package storage;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataFileDestroyer extends DataFile {

    private static final String MULTIPLE = "multiple";
    private Path debugPath = null;

    @Override
    public void executeFunction() {
        try {
            clearDirectory(DATA_DIR);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeFunction(String unwantedFile) {
        try {
            deleteFile(unwantedFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeFunction(Path unwantedFilePath, String function) {
        this.debugPath = unwantedFilePath;
        try {
            if (function.equals(MULTIPLE)) {
                clearDirectory(unwantedFilePath);
            } else {
                deleteFile(null);
            }
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

    private void clearDirectory(Path intendedDirectory) throws IOException {
        Stream<Path> dataDirectoryFiles = Files.list(intendedDirectory);
        dataDirectoryFiles.forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

}
