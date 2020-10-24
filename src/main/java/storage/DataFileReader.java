package storage;

import cheatsheet.CheatSheetList;
import exception.DirectoryIsEmptyException;
import ui.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

/**
 * Allows the user to read data from the data directory and use it
 * to insert the cheatsheets present in the folder to the application.
 */
public class DataFileReader extends DataFile {
    public DataFileReader(Printer printer) {
        this.printer = printer;
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
            printer.print(e.getMessage());
            createNewDirectory();
        } catch (DirectoryIsEmptyException d) {
            printer.print(d.getMessage());
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
        if (!Files.exists(DATA_DIR)) {
            throw new FileNotFoundException();
        }

        File dataDirectory = new File(DATA_DIR.toString());
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
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetDocument File of the cheatSheet
     */
    private void extractCheatSheet(File cheatSheetDocument) {
        DataFileParser parsedData = new DataFileParser(printer);
        parsedData.handleOperation(cheatSheetDocument);
        if (parsedData.convertedCheatSheet != null) {
            CheatSheetList.add(parsedData.convertedCheatSheet);
        }

    }
}
