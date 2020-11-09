package exception;

public class InvalidParamException extends Exception {

    String contentSection;
    public InvalidParamException(String contentSection) {
        this.contentSection = contentSection;
    }

    @Override
    public String getMessage() {
        return "This section of the XML file cannot be parsed due to invalid characters: "
                + contentSection;
    }
}
