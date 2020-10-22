package ui;

public enum ConsoleColorsEnum {
    BLACK_TEXT("\u001B[30m"),
    RED_TEXT("\u001B[31m"),
    GREEN_TEXT("\u001B[32m"),
    YELLOW_TEXT("\u001B[33m"),
    BLUE_TEXT("\u001B[34m"),
    MAGENTA_TEXT("\u001B[35m"),
    CYAN_TEXT("\u001B[36m"),
    WHITE_TEXT("\u001B[37m"),

    BLACK_TEXT_BG("\u001B[40m"),
    RED_TEXT_BG("\u001B[41m"),
    GREEN_TEXT_BG("\u001B[42m"),
    YELLOW_TEXT_BG("\u001B[43m"),
    BLUE_TEXT_BG("\u001B[44m"),
    MAGENTA_TEXT_BG("\u001B[45m"),
    CYAN_TEXT_BG("\u001B[46m"),
    WHITE_TEXT_BG("\u001B[47m"),

    BOLD("\u001B[1m"),

    RESET_TEXT("\u001b[0m");

    private String ansiCode = null;

    ConsoleColorsEnum(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return ansiCode;
    }
}
