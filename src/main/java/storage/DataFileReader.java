package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.DirectoryIsEmptyException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ui.Printer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Allows the user to read data from the data directory and use it
 * to insert the cheatsheets present in the folder to the application.
 */
public class DataFileReader extends DataFile {
    private CheatSheetList cheatSheetList;
    private Logger logger = Logger.getLogger("Foo");

    public DataFileReader(Printer printer, CheatSheetList cheatSheetList) {
        this.printer = printer;
        this.cheatSheetList = cheatSheetList;
    }

    /**
     * Converts the file contents into cheatsheets that can be added into
     * the list of cheatsheets. Also handles an exception arising
     * from missing directory at the specified location.
     */
    @Override
    public void executeFunction() {
        try {
            shiftPreloadedCheatsheets();
            insertStoredCheatSheets();
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "processing error");
            printer.print(e.getMessage());
            createNewDirectory();
        } catch (DirectoryIsEmptyException | IOException d) {
            printer.print(d.getMessage());
        }
    }

    /**
     * Shifts the preloaded cheatSheet directory to the user defined
     * /data folder once the application is run for the first time.
     *
     * @throws IOException Thrown if there are issues detected during
     *                     the I/O operation.
     */
    private void shiftPreloadedCheatsheets() throws IOException {
        if (!Files.exists(PRELOADED_ORIG_DIR)) {
            return;
        }
        if (!Files.exists(DATA_DIR)) {
            new File(DATA_DIR.toString());
        }
        //Files.move(PRELOADED_ORIG_DIR, DATA_PRELOADED_DIR);
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

        try {
            extractFromDirectory(DATA_DIR);
        } catch (IOException e) {
            printer.print(e.getMessage());
        }
    }

    /**
     * Extracts all cheatsheet files from the given directory.
     *
     * @throws IOException Thrown if the /data directory is missing or empty.
     */
    private void extractFromDirectory(Path directoryPath) throws IOException {
        File[] dataDirectoryFiles = directoryPath.toFile().listFiles();
        if (dataDirectoryFiles == null) {
            throw new IOException();
        }
        for (File dataDirectoryFile : dataDirectoryFiles) {
            Path filePath = dataDirectoryFile.toPath();

            if (Files.isDirectory(filePath)) {
                extractFromDirectory(filePath);
                continue;
            }
            boolean isPreloadedFile = dataDirectoryFile
                    .getParentFile()
                    .getParentFile()
                    .getName()
                    .equals(PRELOADED);

            if (isPreloadedFile) {
                preloadedCheatSheets.add(dataDirectoryFile.toPath());
            }

            try {
                extractCheatSheet(dataDirectoryFile);
            } catch (ParserConfigurationException | SAXException e) {
                printer.print(e.getMessage());
            }
        }
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetDocument File of the cheatSheet
     * @throws IOException                  Thrown if an I/O error prevents the file from being fully parsed.
     * @throws ParserConfigurationException Thrown if a serious configuration error is caught.
     * @throws SAXException                 Thrown if a basic error or warning information from either
     *                                      the XML parser or the application is caught.
     */
    private void extractCheatSheet(File cheatSheetDocument) throws IOException,
            ParserConfigurationException,
            SAXException {

        Node favouriteElement = null;
        Node subjectElement = null;
        Node contentElement = null;

        DocumentBuilder documentBuilder = getDocumentBuilder();
        Document cheatSheetXml = documentBuilder.parse(cheatSheetDocument);
        cheatSheetXml.getDocumentElement().normalize();

        NodeList sectionNodes = cheatSheetXml.getDocumentElement().getChildNodes();

        int numSections = sectionNodes.getLength();
        for (int i = 0; i < numSections; i++) {
            switch (sectionNodes.item(i).getNodeName()) {
            case FAVOURITE_ELEMENT:
                favouriteElement = sectionNodes.item(i);
                break;
            case SUBJECT_ELEMENT:
                subjectElement = sectionNodes.item(i);
                break;
            case CONTENTS_ELEMENT:
                contentElement = sectionNodes.item(i);
                break;
            default:
                break;
            }
        }
        bundleCheatSheetComponents(cheatSheetDocument, favouriteElement, subjectElement, contentElement);
    }

    /**
     * Extracts and bundles components together to create a new cheatSheet.
     *
     * @param cheatSheetDocument  File of the cheatSheet
     * @param favouriteElement    Node containing the favourite status
     *                            of the cheatsheet.
     * @param subjectElement      Node containing the subject of the
     *                            cheatsheet.
     * @param contentElement      Node containing the details of the
     *                            cheatsheet.
     */
    private void bundleCheatSheetComponents(File cheatSheetDocument,
                                            Node favouriteElement,
                                            Node subjectElement,
                                            Node contentElement) {
        String cheatSheetName = cheatSheetDocument
                .getName()
                .replace(XML_EXTENSION, EMPTY);

        boolean isMarkedFavourite = extractFavouriteStatus(favouriteElement);
        String cheatSheetSubject = extractCheatSheetSection(subjectElement);
        String cheatSheetContent = extractCheatSheetSection(contentElement);

        createNewCheatSheet(isMarkedFavourite,
                cheatSheetName,
                cheatSheetSubject,
                cheatSheetContent);
    }

    /**
     * Extracts the favourite status of the referenced cheatSheet.
     *
     * @param favouriteElement   Node containing the favourite status of the cheatSheet.
     * @return isMarkedFavourite Boolean indicating if the cheatSheet should be marked as
     *                           a favourite.
     */
    private boolean extractFavouriteStatus(Node favouriteElement) {
        boolean isMarkedFavourite;
        try {
            isMarkedFavourite = favouriteElement
                    .getFirstChild()
                    .getTextContent()
                    .equals(YES);
        } catch (NullPointerException e) {
            isMarkedFavourite = false;
        }
        return isMarkedFavourite;
    }

    /**
     * Extracts the section of the referenced cheatSheet.
     *
     * @param relevantElement Node containing the contents of the cheatSheet.
     * @return cheatsheetContent String containing the contents of the cheatSheet.
     */
    private String extractCheatSheetSection(Node relevantElement) {
        String cheatSheetSection;
        try {
            cheatSheetSection = relevantElement
                    .getFirstChild()
                    .getTextContent();
        } catch (NullPointerException e) {
            cheatSheetSection = EMPTY;
        }
        return cheatSheetSection;
    }

    /**
     * Creates a new cheatsheet based on the parameters provided
     * and adds it to CheatSheetList.
     *
     * @param isMarkedFavourite Indicator of the favourite status of the cheatSheet.
     * @param cheatSheetName    Name of the cheatSheet.
     * @param cheatSheetContent Contents of the cheatSheet.
     */
    private void createNewCheatSheet(boolean isMarkedFavourite,
                                     String cheatSheetName,
                                     String cheatSheetSubject,
                                     String cheatSheetContent) {
        CheatSheet newCheatSheet = new CheatSheet(cheatSheetName,
                cheatSheetSubject,
                cheatSheetContent);

        newCheatSheet.setFavourite(isMarkedFavourite);
        cheatSheetList.add(newCheatSheet);
    }
}
