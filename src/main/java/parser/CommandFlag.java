package parser;

public enum CommandFlag {
    NAME("/n"),
    DESCRIPTION("/d"),
    INDEX("/i"),
    SUBJECT("/s"),
    SECTIONKEYWORD("/k"),
    COLORSCHEME("/c");
    private final String flag;

    CommandFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return this.flag;
    }
}
