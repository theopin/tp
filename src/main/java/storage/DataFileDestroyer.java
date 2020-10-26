package storage;

import cheatsheet.CheatSheetList;
import exception.CommandException;
import ui.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFileDestroyer extends DataFile {

    private CheatSheetList cheatSheetList;

    public DataFileDestroyer(Printer printer, CheatSheetList cheatSheetList) {
        this.printer = printer;
        this.cheatSheetList = cheatSheetList;
    }

    /**
     * Constructor that executes the operation to delete all cheatsheet files.
     */
    @Override
    public void executeFunction() {
        try {
            clearDataDirectory();
        } catch (IOException e) {
            printer.print(e.getMessage());
        }
    }

    /**
     * Constructor that executes the operation to delete a
     * specific cheatsheet file.
     *
     * @param unwantedFile Name of the cheatsheet to be deleted.
     */
    public void executeFunction(String unwantedFile) {
        try {
            deleteFile(unwantedFile);
        } catch (IOException | CommandException e) {
            printer.print(e.getMessage());
        }
    }

    /**
     * Deletes a specified cheatsheet file from the /data directory.
     *
     * @param unwantedFile Name of the cheatsheet to be deleted.
     * @throws IOException Thrown if the path of the unwanted file specified
     *                     is not existent.
     */
    private void deleteFile(String unwantedFile) throws IOException, CommandException {
        String subjectDirectory = cheatSheetList
                .get(unwantedFile)
                .getSubject();
        Path unwantedFilePath = Paths.get(USER_DIR,
                DATA,
                subjectDirectory,
                unwantedFile + XML_EXTENSION);
        Files.delete(unwantedFilePath);
    }

    /**
     * Deletes all cheatsheet files from the /data directory in a recursive manner.
     *
     * @throws IOException Thrown if the /data directory is missing or empty.
     */
    private void clearDataDirectory() throws IOException {
        clearDirectory(DATA_DIR);
    }

    /**
     * Deletes all cheatsheet files from the given directory.
     *
     * @throws IOException Thrown if the /data directory is missing or empty.
     */
    private void clearDirectory(Path directoryPath) throws IOException {
        String[] dataDirectoryFiles = directoryPath.toFile().list();
        if (dataDirectoryFiles == null) {
            throw new IOException();
        }
        for (String dataDirectoryFile : dataDirectoryFiles) {
            Path filePath = Paths.get(USER_DIR, DATA, dataDirectoryFile);

            if (Files.isDirectory(filePath)) {
                if (!filePath.toFile().getName().equals(PRELOADED)) {
                    clearDirectory(filePath);
                }
                continue;
            }

            try {
                deleteFile(dataDirectoryFile.replace(XML_EXTENSION, EMPTY));
            } catch (CommandException e) {
                printer.print(e.getMessage());
            }
        }
        directoryPath.toFile().delete();
    }

}
