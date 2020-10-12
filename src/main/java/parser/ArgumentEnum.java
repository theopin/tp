package parser;

public enum ArgumentEnum {
    NAME("/n"),
    DESCRIPTION("/d"),
    INDEX("/i"),
    PROGRAMMINGLANGUAGE("/l"),
    SECTIONKEYWORD("/k");

    private final String associatedKeyWord;

    ArgumentEnum(String associatedKeyword) {
        this.associatedKeyWord = associatedKeyword;
    }

    public String getAssociatedKeyWord() {
        return this.associatedKeyWord;
    }
}
