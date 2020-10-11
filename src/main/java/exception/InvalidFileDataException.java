package exception;

import java.io.File;

public class InvalidFileDataException extends Exception {

    private File cheatSheetDocument;

    public InvalidFileDataException(File cheatSheetDocument) {
        super();
        this.cheatSheetDocument = cheatSheetDocument;

    }

    @Override
    public String getMessage() {
        return "Data in " + cheatSheetDocument.getName() + " is Invalid!";
    }
}
