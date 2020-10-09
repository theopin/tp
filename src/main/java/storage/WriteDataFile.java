package storage;

import cheatsheet.CheatSheet;

import java.io.IOException;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static storage.ParseCheatSheetFile.*;

/**
 * Allows the user to write data based on the tasks currently present in the
 * list of tasks into duke.txt.
 */
public class WriteDataFile extends DataFile {
    private static final String FILE_EXTENSION = ".txt";

    // WriteDataFile Constructor
    public WriteDataFile() {
        executeFunction();
    }

    /**
     * Converts the tasks present in the list of tasks into
     * a string. This string is then saved in a form of .txt file
     * into documentTracker.txt.
     */
    @Override
    public void executeFunction() {
        storeCheatSheet();
    }

    /**
     * Converts the tasks present in the list of tasks into
     * a string.
     */
    private void storeCheatSheet() {
        /*for(CheatSheet cheatSheet : cheatSheets) {
            convertStringToFile(cheatSheet);
        }

        */
    }

    /**
     * Converts the cheatSheet into a file format.
     *
     * @param cheatSheet The cheatSheet that is currently being converted into a file.
     */
    private void convertStringToFile(CheatSheet cheatSheet) {

        StringBuilder cheatSheetFileBuild = new StringBuilder();

        // build cheatsheet content
        //cheatSheet
        buildFileContents(cheatSheetFileBuild, cheatSheet);

        String fileName = cheatSheet.getCheatSheetName() + FILE_EXTENSION;
        Path textFileDirectory = Paths.get(USER_DIR, DATA, fileName);

        try {
            if(!Files.exists(textFileDirectory)) {
                Files.createFile(textFileDirectory);
            }
            writeToFile(String.valueOf(textFileDirectory), cheatSheetFileBuild.toString());
        }
        catch (IOException e) {
            System.out.println("\tSomething went wrong: " + e.getMessage());
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
     * Writes the values of textContent into duke.txt
     *
     * @param directory Name of the file
     * @param fileContents Contents of the file
     * @throws IOException Thrown if there are issues with writing the string
     *                     into duke.txt
     */
    private void writeToFile(String directory, String fileContents) throws IOException {
        FileWriter fileEditor = new FileWriter(directory);
        fileEditor.write(fileContents);
        fileEditor.close();
    }
}
