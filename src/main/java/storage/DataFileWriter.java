package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import ui.Printer;


/**
 * Allows the user to write data based on the cheatSheets currently present
 * in the list of cheatSheets into individual files.
 */
public class DataFileWriter extends DataFile {
    private ArrayList<CheatSheet> cheatSheets;

    public DataFileWriter(Printer printer) {
        this.printer = printer;
    }

    /**
     * Converts the cheatSheets present in the list of cheatSheet into
     * a string. This string is then saved in a file, 1 file
     * for each cheatSheet.
     */
    @Override
    public void executeFunction() {
        cheatSheets = CheatSheetList.getCheatSheetList();
        storeCheatSheet();
    }

    /**
     * Converts each cheatSheet present in the list of cheatSheets into
     * a file, provided it its modifiable.
     */
    private void storeCheatSheet() {
        int cheatSheetsSize = cheatSheets.size();
        if (cheatSheetsSize > 0) {
            for (CheatSheet cheatSheet : cheatSheets) {
                convertCheatSheetToFile(cheatSheet);
            }
        }
    }

    /**
     * Converts the cheatSheet into a file format.
     *
     * @param cheatSheet The cheatSheet that is currently being converted into a file.
     */
    public void convertCheatSheetToFile(CheatSheet cheatSheet) {
        String fileName = cheatSheet.getCheatSheetName() + ".xml";
        Path textFile = Paths.get(USER_DIR, DATA, fileName);

        try {
            if (!Files.exists(textFile)) {
                Files.createFile(textFile);
            }
            Document cheatSheetFile = buildFileContents(cheatSheet);

            writeToFile(textFile.toString(), cheatSheetFile);
        } catch (IOException e) {
            printer.print(e.getMessage());
        }
    }

    /**
     * Sets the contents for the respective cheatSheet file.
     *
     * @param cheatSheet The cheatSheet that is currently being converted into a file.
     * @return xmlFileStructure A document containing relevant data of the cheatsheet
     *                          in a .xml file format.
     */
    private Document buildFileContents(CheatSheet cheatSheet) {
        Element mainRoot = new Element("main");
        Document xmlFileStructure = new Document(mainRoot);

        String favouriteStatus = cheatSheet.getIsFavourite()
                ? FAVOURITE_FILE
                : NOT_FAVOURITE_FILE;
        Element favouriteElement = new Element(FAVOURITE_ELEMENT);
        favouriteElement.setText(favouriteStatus);
        xmlFileStructure.getRootElement().addContent(favouriteElement);

        String fileContent = cheatSheet.getCheatSheetDetails();
        Element fileContentElement = new Element(CONTENTS_ELEMENT);
        fileContentElement.setText(fileContent);
        xmlFileStructure.getRootElement().addContent(fileContentElement);

        return xmlFileStructure;
    }

    /**
     * Writes the values of textContent into a File.
     *
     * @param directory       Name of the file.
     * @param xmlFileContents Contents of the file in xml format.
     * @throws IOException    Thrown if there are issues with writing the string
     *                        into a file.
     */
    private void writeToFile(String directory, Document xmlFileContents) throws IOException {
        FileWriter fileEditor = new FileWriter(directory);

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(xmlFileContents, fileEditor);

        fileEditor.close();
    }
}
