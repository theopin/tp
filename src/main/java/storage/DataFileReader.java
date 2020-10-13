package storage;

import cheatsheet.CheatSheetList;
import exception.DirectoryIsEmptyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Allows the user to read data from the data directory and use it
 * to insert the cheatsheets present in the folder to the application.
 */
public class DataFileReader extends DataFile {
    private String folderPath = String.valueOf(DATA_DIR);
    private Path dataFolder = DATA_DIR;

    // Main Constructor
    public DataFileReader() {
        executeFunction();
    }

    // Constructor for debugging purposes
    public DataFileReader(String folderPath, Path dataFolder) {
        this.folderPath = folderPath;
        this.dataFolder = dataFolder;
    }

    /**
     * Converts the file contents into tasks that can be added into
     * the list of tasks. Also handles an exception arising
     * from missing directory at the specified location.
     */
    @Override
    public void executeFunction() {
        try {
            insertStoredCheatSheets();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            createNewDirectory();
        } catch (DirectoryIsEmptyException d) {
            System.out.println(d.getMessage());
        }
    }

    /**
     * Converts the data obtained from the /data folder into cheatsheets and adds
     * them to the application.
     *
     * @throws FileNotFoundException     Thrown if the /data folder is not found
     * @throws DirectoryIsEmptyException Thrown if the /data folder is empty
     */
    protected void insertStoredCheatSheets() throws FileNotFoundException,
            DirectoryIsEmptyException {
        if (!Files.exists(dataFolder)) {
            throw new FileNotFoundException();
        }

        File dataDirectory = new File(folderPath);
        String[] directoryItems = dataDirectory.list();

        assert directoryItems != null;
        if (directoryItems.length == 0) {
            throw new DirectoryIsEmptyException();
        }

        File[] cheatSheetFiles = dataDirectory.listFiles();
        assert cheatSheetFiles != null : "File Empty!";
        for (File cheatSheetFile : cheatSheetFiles) {
            extractCheatSheet(cheatSheetFile);
        }
    }

    /**
     * Creates a new directory and file at the specified location
     * if it currently does not exist.
     */
    private void createNewDirectory() {
        try {
            Files.createDirectories(DATA_DIR);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetDocument File of the cheatSheet
     */
    private void extractCheatSheet(File cheatSheetDocument) {
        DataFileParser parsedData = new DataFileParser(cheatSheetDocument);
        if (parsedData.convertedCheatSheet != null) {
            CheatSheetList.add(parsedData.convertedCheatSheet);
        }
    }
}
