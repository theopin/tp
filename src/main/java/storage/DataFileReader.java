package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.DirectoryIsEmptyException;


import ui.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    /*
        try {
            insertStoredCheatSheets();
        } catch (FileNotFoundException e) {
            printer.print(e.getMessage());
            createNewDirectory();
        } catch (DirectoryIsEmptyException d) {
            printer.print(d.getMessage());
        }
    */
    }

}
/*
    /**
     * Converts the data obtained from the /data folder into cheatsheets and adds
     * them to the application.
     *
     * @throws FileNotFoundException     Thrown if the /data folder is not found
     * @throws DirectoryIsEmptyException Thrown if the /data folder is empty
     */
    /*
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
            try {
                if(!cheatSheetFile.isDirectory()) {
                    extractCheatSheet(cheatSheetFile);
                }
            } catch (JDOMException | IOException e) {
                printer.print(e.getMessage());
            }
        }
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetDocument File of the cheatSheet
     * @throws JDOMException Thrown if errors occur when parsing the file.
     * @throws IOException Thrown if an I/O error prevents the file from being fully parsed.
     */
    /*
    private void extractCheatSheet(File cheatSheetDocument) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document cheatSheetXml = saxBuilder.build(cheatSheetDocument);
        Element mainRoot = cheatSheetXml.getRootElement();

        Element favouriteElement = mainRoot.getChild(FAVOURITE_ELEMENT);
        Element contentElement = mainRoot.getChild(CONTENTS_ELEMENT);

        String cheatSheetName = cheatSheetDocument
                .getName()
                .replace(XML_EXTENSION, "");
        String cheatSheetContent = contentElement.getText();

        boolean isMarkedFavourite = favouriteElement
                .getText()
                .equals(FAVOURITE_FILE);

        createNewCheatSheet(isMarkedFavourite, cheatSheetName, cheatSheetContent);

    }

    /**
     * Creates a new cheatsheet based on the parameters provided
     * and adds it to CheatSheetList.
     *
     * @param isMarkedFavourite Indicator of the favourite status of the cheatSheet.
     * @param cheatSheetName Name of the cheatSheet.
     * @param cheatSheetContent Contents of the cheatSheet.
     */
    /*
    private void createNewCheatSheet(boolean isMarkedFavourite,
                                     String cheatSheetName,
                                     String cheatSheetContent) {
        CheatSheet newCheatSheet = new CheatSheet(cheatSheetName,
                "C",
                cheatSheetContent);

        newCheatSheet.setFavourite(isMarkedFavourite);
        CheatSheetList.add(newCheatSheet);
    }
}
*/