package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

import java.io.IOException;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static storage.ParseDataFile.NAME;
import static storage.ParseDataFile.PROGRAMMING_LANGUAGE;
import static storage.ParseDataFile.DETAILS;

/**
 * Allows the user to write data based on the cheatSheets currently present
 * in the list of cheatSheets into individual files.
 */
public class WriteDataFiles extends DataFile {
    private ArrayList<CheatSheet> cheatSheets;
    private Path debugPath = null;

    // Main Constructor
    public WriteDataFiles() {
        executeFunction();
    }

    // Constructor for debugging purposes
    public WriteDataFiles(CheatSheetList debugCheatSheets, Path textFilePath) {
        this.cheatSheets = debugCheatSheets.getCheatSheetList();
        this.debugPath = textFilePath;
    }

    /**
     * Converts the cheatSheets present in the list of cheatSheet into
     * a string. This string is then saved in a file, 1 file
     * for each cheatSheet.
     */
    @Override
    public void executeFunction() {
        storeCheatSheet();
    }

    /**
     * Converts the cheatSheets present in the list of cheatSheets into
     * a string.
     */
    private void storeCheatSheet() {
        for (CheatSheet cheatSheet : cheatSheets) {
            convertStringToFile(cheatSheet);
        }
    }

    /**
     * Converts the cheatSheet into a file format.
     *
     * @param cheatSheet The cheatSheet that is currently being converted into a file.
     */
    public void convertStringToFile(CheatSheet cheatSheet) {
        Path textFileDirectory;
        StringBuilder cheatSheetFileBuild = new StringBuilder();

        // Build cheatsheet content
        buildFileContents(cheatSheetFileBuild, cheatSheet);

        String fileName = cheatSheet.getCheatSheetName();
        textFileDirectory = (debugPath == null) ? Paths.get(USER_DIR, DATA, fileName) : debugPath;

        try {
            if (!Files.exists(textFileDirectory)) {
                Files.createFile(textFileDirectory);
            }
            writeToFile(String.valueOf(textFileDirectory), cheatSheetFileBuild.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets the contents for the respective cheatSheet file.
     *
     * @param cheatSheetFileBuild the stringBuilder used to connect the contents of the file.
     * @param cheatSheet The cheatSheet that is currently being converted into a file.
     */
    private void buildFileContents(StringBuilder cheatSheetFileBuild, CheatSheet cheatSheet) {
        cheatSheetFileBuild.append(NAME).append(
                cheatSheet.getCheatSheetName());
        cheatSheetFileBuild.append(System.lineSeparator());

        cheatSheetFileBuild.append(PROGRAMMING_LANGUAGE).append(
                cheatSheet.getCheatSheetProgrammingLanguage());
        cheatSheetFileBuild.append(System.lineSeparator());

        cheatSheetFileBuild.append(DETAILS).append(cheatSheet.getCheatSheetDetails());
    }

    /**
     * Writes the values of textContent into a File.
     *
     * @param directory Name of the file.
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
