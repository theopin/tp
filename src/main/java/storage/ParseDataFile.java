package storage;

import cheatsheet.CheatSheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseDataFile {
    protected static final String NAME = "Name: ";
    protected static final String PROGRAMMING_LANGUAGE = "Programming Language: ";
    protected static final String DETAILS = "Details: ";
    protected static final String EMPTY = "";
    protected CheatSheet convertedCheatSheet;

    private final StringBuilder cheatSheetDetails = new StringBuilder();
    private String cheatSheetName;
    private String cheatSheetProgrammingLanguage;

    public ParseDataFile(File cheatSheetDocument) {
        try {
            parseCheatSheet(cheatSheetDocument);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Parses the given cheatSheet file.
     *
     * @param cheatSheetDocument cheatSheet file to be parsed.
     * @throws FileNotFoundException Thrown if the file is not found in
     *                               the user directory.
     */
    private void parseCheatSheet(File cheatSheetDocument) throws FileNotFoundException {
        Scanner componentScanner = new Scanner(cheatSheetDocument);

        while (componentScanner.hasNextLine()) {
            extractCheatSheetComponents(componentScanner.nextLine());
        }
        this.convertedCheatSheet = new CheatSheet(cheatSheetName,
                cheatSheetProgrammingLanguage, cheatSheetDetails.toString().trim());
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetLine Line of the file being analyzed.
     */
    private void extractCheatSheetComponents(String cheatSheetLine) {
        if (cheatSheetLine.startsWith(NAME)) {
            this.cheatSheetName = cheatSheetLine.replace(NAME, EMPTY).trim();
        } else if (cheatSheetLine.startsWith(PROGRAMMING_LANGUAGE)) {
            this.cheatSheetProgrammingLanguage = cheatSheetLine.replace(PROGRAMMING_LANGUAGE,
                    EMPTY).trim();
        } else if (cheatSheetLine.startsWith(DETAILS)) {
            this.cheatSheetDetails.append(cheatSheetLine.replace(DETAILS,
                    EMPTY).trim());
            this.cheatSheetDetails.append(System.lineSeparator());
        } else {
            this.cheatSheetDetails.append(cheatSheetLine.trim());
            this.cheatSheetDetails.append(System.lineSeparator());
        }
    }
}
