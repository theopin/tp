package parser;

public enum ArgumentEnum {
    NAME("/n"),
    DESCRIPTION("/d"),
    INDEX("/i");

    private final String associatedKeyWord;

    ArgumentEnum(String associatedKeyword) {
        this.associatedKeyWord = associatedKeyword;
    }

    public String getAssociatedKeyWord() {
        return this.associatedKeyWord;
    }
}
