package seedu.duke.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseCheatSheetFile {
    private final static String NAME = "Name: ";
    private final static String PROGRAMMNG_LANGUAGE = "Programming Language: ";

    private String cheatSheetName;
    private String cheatSheetProgrammingLanguage;
    private String cheatSheetDetails;

    public ParseCheatSheetFile(File cheatSheetDocument) throws FileNotFoundException {
        parseCheatSheet(cheatSheetDocument);
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
    }

    /**
     * Extracts the contents of the cheatsheet from the specified file.
     *
     * @param cheatSheetLine Line of the file being analyzed
     */
    private void extractCheatSheetComponents(String cheatSheetLine) {
        
    }
}
