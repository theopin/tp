package storage;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;

import java.io.IOException;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static storage.DataFileParser.NAME;
import static storage.DataFileParser.PROGRAMMING_LANGUAGE;
import static storage.DataFileParser.DETAILS;

/**
 * Allows the user to write data based on the cheatSheets currently present
 * in the list of cheatSheets into individual files.
 */
public class DataFileWriter extends DataFile {
    private ArrayList<CheatSheet> cheatSheets;

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
            for (CheatSheet cheatSheet : cheatSheets) {
                convertStringToFile(cheatSheet);
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
        cheatSheetFileBuild.append(NAME)
                .append(cheatSheet.getCheatSheetName())
                .append(System.lineSeparator())
                .append(PROGRAMMING_LANGUAGE)
                .append(cheatSheet.getCheatSheetProgrammingLanguage())
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
