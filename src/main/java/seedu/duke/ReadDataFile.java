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
     * from missing file and/or directory at the specified location.
     */
    @Override
    public void executeFunction() {
        insertStoredCheatSheets();
    }

    /**
     * Creates a new  directory and file at the specified location
     * if it currently does not exist.
     *
     * @throws IOException Thrown if errors arise when creating the directory
     * and/or file.
     */
    private void createNewFile() throws IOException {
        if(!Files.exists(DATA_DIR)) {
            Files.createDirectories(DATA_DIR);
        }
    }

    /**
     * Converts the data obtained from the /data folder into cheatsheets and adds
     * them to the application.
     *
     */
    private void insertStoredCheatSheets() {
        // create a File for the given file path
        File[] cheatSheetFiles = new File(String.valueOf(DATA_DIR)).listFiles();

        assert cheatSheetFiles != null : "No files found! Loading Application!";
        for(File cheatSheetFile : cheatSheetFiles) {
            extractCheatSheet(cheatSheetFile);
        }
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetDocument File of the cheatSheet
     */
    private void extractCheatSheet(File cheatSheetDocument)  {
        try {
            parseCheatSheet(cheatSheetDocument);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Parses the given cheatSheet file.
     *
     * @param cheatSheetDocument cheatSheet file to be parsed.
     * @throws FileNotFoundException Thrown if the file is not found in
     *                               the user directory.
     */
    private void parseCheatSheet(File cheatSheetDocument) throws FileNotFoundException {
        Scanner componentScanner = new Scanner(cheatSheetDocument);
        while (componentScanner.hasNextLine()) {
            extractCheatSheetComponents(componentScanner.nextLine());
        }
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetFile Name of the .txt file
     */
    private void extractCheatSheetComponents(String cheatSheetFile) {
    }


}
