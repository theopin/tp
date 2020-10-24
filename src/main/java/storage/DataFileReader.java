package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.DirectoryIsEmptyException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import ui.Printer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

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
            try {
                if (!cheatSheetFile.isDirectory()) {
                    extractCheatSheet(cheatSheetFile);
                }
            } catch (IOException | SAXException | ParserConfigurationException e) {
                printer.print(e.getMessage());
            }
        }
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetDocument            File of the cheatSheet
     * @throws IOException                  Thrown if an I/O error prevents the file from being fully parsed.
     * @throws ParserConfigurationException Thrown if a serious configuration error is caught.
     * @throws SAXException                 Thrown if a basic error or warning information from either
     *                                      the XML parser or the application is caught.
     */
    private void extractCheatSheet(File cheatSheetDocument) throws IOException,
            ParserConfigurationException,
            SAXException {
        DocumentBuilder documentBuilder = getDocumentBuilder();
        Document cheatSheetXml = documentBuilder.parse(cheatSheetDocument);
        cheatSheetXml.getDocumentElement().normalize();

        Element mainRoot = cheatSheetXml.getDocumentElement();
        Node favouriteElement = mainRoot.getFirstChild();
        Node contentElement = mainRoot.getLastChild();
        // todo: handle null cheatsheet field
        String cheatSheetName = cheatSheetDocument
                .getName()
                .replace(XML_EXTENSION, EMPTY);
        String cheatSheetContent = contentElement
                .getFirstChild()
                .getTextContent();

        boolean isMarkedFavourite = favouriteElement
                .getFirstChild()
                .getTextContent()
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
