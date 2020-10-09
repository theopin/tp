package seedu.duke.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Allows the user to read data from documentTracker.txt and use it
 * to insert the cheatsheets present in the folder to the application.
 */
public class ReadDataFile extends DataFile {

    // ReadDataFile Constructor
    public ReadDataFile() {
        executeFunction();
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
        } catch (NullPointerException e) {
            createNewDirectory();
        }
    }

    /**
     * Converts the data obtained from the /data folder into cheatsheets and adds
     * them to the application.
     *
     * @throws NullPointerException Thrown if the /data folder is not found or is empty
     */
    private void insertStoredCheatSheets() throws NullPointerException {
        // create a File for the given file path
        File[] cheatSheetFiles = new File(String.valueOf(DATA_DIR)).listFiles();

        assert cheatSheetFiles != null : "No files found! Loading Application!";
        for (File cheatSheetFile : cheatSheetFiles) {
            extractCheatSheet(cheatSheetFile);
        }
    }

    /**
     * Creates a new directory and file at the specified location
     * if it currently does not exist.
     */
    private void createNewDirectory()  {
        if (!Files.exists(DATA_DIR)) {
            try {
                Files.createDirectories(DATA_DIR);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetDocument File of the cheatSheet
     */
    private void extractCheatSheet(File cheatSheetDocument)  {
        try {
            new ParseCheatSheetFile(cheatSheetDocument);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }




}
