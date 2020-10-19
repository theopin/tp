package storage;

import cheatsheet.CheatSheet;
import exception.InvalidFileDataException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataFileParser {
    protected static final String NAME = "Name: ";
    protected static final String PROGRAMMING_LANGUAGE = "Programming Language: ";
    protected static final String DETAILS = "Contents: ";
    protected static final String EMPTY = "";

    protected CheatSheet convertedCheatSheet;
    private final StringBuilder cheatSheetDetails = new StringBuilder();
    private String cheatSheetProgrammingLanguage = "";


    /**
     * Parses the given cheatSheet file and handles any exceptions
     * thrown while attempting to parse this file.
     *
     * @param cheatSheetDocument cheatSheet file to be parsed.
     */
    protected void handleOperation(File cheatSheetDocument) {
        try {
            parseCheatSheet(cheatSheetDocument);
        } catch (FileNotFoundException | InvalidFileDataException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Parses the given cheatSheet file.
     *
     * @param cheatSheetDocument cheatSheet file to be parsed.
     * @throws FileNotFoundException Thrown if the file is not found in
     *                               the user directory.
     * @throws InvalidFileDataException Thrown if the file contains
     *                                  parameters that cannot be parsed.
     */
    protected void parseCheatSheet(File cheatSheetDocument) throws FileNotFoundException,
            InvalidFileDataException {
        Scanner componentScanner = new Scanner(cheatSheetDocument);

        String cheatSheetName = cheatSheetDocument.getName();
        while (componentScanner.hasNextLine()) {
            extractCheatSheetComponents(componentScanner.nextLine());
        }
        if (this.cheatSheetProgrammingLanguage.isEmpty()
                || cheatSheetDetails.toString().trim().isEmpty()) {
            throw new InvalidFileDataException(cheatSheetDocument);
        }

        this.convertedCheatSheet = new CheatSheet(cheatSheetName,
                cheatSheetProgrammingLanguage, cheatSheetDetails.toString().trim());
        componentScanner.close();
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetLine Line of the file being analyzed.
     */
    private void extractCheatSheetComponents(String cheatSheetLine) {

        if (cheatSheetLine.startsWith(PROGRAMMING_LANGUAGE)) {
            this.cheatSheetProgrammingLanguage = cheatSheetLine
                    .replace(PROGRAMMING_LANGUAGE, EMPTY)
                    .trim();
        } else if (cheatSheetLine.startsWith(DETAILS)) {
            String detailsFirstLine = cheatSheetLine
                    .replace(DETAILS, EMPTY)
                    .trim();
            this.cheatSheetDetails
                    .append(detailsFirstLine)
                    .append(System.lineSeparator());
        } else if (this.cheatSheetDetails.length() > 0) {
            this.cheatSheetDetails
                    .append(cheatSheetLine.trim())
                    .append(System.lineSeparator());
        }
    }
}
