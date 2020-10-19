package storage;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataFileDestroyer extends DataFile {

    /**
     * Constructor that executes the operation to delete all cheatsheet files.
     */
    @Override
    public void executeFunction() {
        try {
            clearDirectory();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Constructor that executes the operation to delete a
     * specific cheatsheet file.
     *
     * @param unwantedFile Name of the cheatsheet to be deleted.
     */
    public void executeFunction(String unwantedFile) {
        try {
            deleteFile(unwantedFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deletes a specified cheatsheet file from the /data directory.
     *
     * @param unwantedFile Name of the cheatsheet to be deleted.
     * @throws IOException Thrown if the path of the unwanted file specified
     *                     is not existent.
     */
    protected void deleteFile(String unwantedFile) throws IOException {
        Path unwantedFilePath = Paths.get(USER_DIR, DATA, unwantedFile);
        Files.delete(unwantedFilePath);
    }

    /**
     * Deletes all cheatsheet files from the /data directory.
     *
     * @throws IOException Thrown if the /data directory is missing or empty.
     */
    protected void clearDirectory() throws IOException {
        Stream<Path> dataDirectoryFiles = Files.list(DATA_DIR);
        dataDirectoryFiles.forEach(path -> {
            path.toFile().delete();
        });
        assert Files.list(DATA_DIR).count() == 0;
    }

}
