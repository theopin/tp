package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import ui.Printer;

import java.io.IOException;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static storage.DataFileParser.PROGRAMMING_LANGUAGE;
import static storage.DataFileParser.FAVOURITE;
import static storage.DataFileParser.DETAILS;
import static storage.DataFileParser.FAVOURITE_FILE;
import static storage.DataFileParser.NOT_FAVOURITE_FILE;

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
     * Converts the cheatSheets present in the list of cheatSheets into
     * a string.
     */
    private void storeCheatSheet() {
        int cheatSheetsSize = cheatSheets.size();
        if (cheatSheetsSize > 0) {
            for (CheatSheet cs : cheatSheets) {
                convertStringToFile(cs);
            }
        }
    }

    /**
     * Converts the cheatSheet into a file format.
     *
     * @param cheatSheet The cheatSheet that is currently being converted into a file.
     */
    public void convertStringToFile(CheatSheet cheatSheet) {
        Path textFile;
        StringBuilder cheatSheetFileBuild = new StringBuilder();

        // Build cheatsheet content
        buildFileContents(cheatSheetFileBuild, cheatSheet);

        String fileName = cheatSheet.getCheatSheetName();
        textFile = Paths.get(USER_DIR, DATA, fileName);

        try {
            if (!Files.exists(textFile)) {
                Files.createFile(textFile);
            }
            writeToFile(textFile.toString(), cheatSheetFileBuild.toString());
        } catch (IOException e) {
            printer.print(e.getMessage());
        }
    }

    /**
     * Sets the contents for the respective cheatSheet file.
     *
     * @param cheatSheetFileBuild the stringBuilder used to connect the contents of the file.
     * @param cheatSheet The cheatSheet that is currently being converted into a file.
     */
    private void buildFileContents(StringBuilder cheatSheetFileBuild, CheatSheet cheatSheet) {
        String favouriteStatus = cheatSheet.getIsFavourite() ? FAVOURITE_FILE : NOT_FAVOURITE_FILE;
        cheatSheetFileBuild.append(PROGRAMMING_LANGUAGE)
                .append(cheatSheet.getCheatSheetProgrammingLanguage())
                .append(System.lineSeparator())
                .append(FAVOURITE)
                .append(favouriteStatus)
                .append(System.lineSeparator())
                .append(DETAILS)
                .append(cheatSheet.getCheatSheetDetails());
    }

    /**
     * Writes the values of textContent into a File.
     *
     * @param directory    Name of the file.
     * @param fileContents Contents of the file
     * @throws IOException Thrown if there are issues with writing the string
     *                     into a file.
     */
    private void writeToFile(String directory, String fileContents) throws IOException {
        FileWriter fileEditor = new FileWriter(directory);
        fileEditor.write(fileContents);
        fileEditor.close();
    }
}
