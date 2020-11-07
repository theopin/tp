package exception;

public class DirectoryIsEmptyException extends Exception {

    @Override
    public String getMessage() {
        return "Folder is Empty.";
    }
}
