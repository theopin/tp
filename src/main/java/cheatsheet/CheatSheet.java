package cheatsheet;

public class CheatSheet {
    private String cheatSheetName;
    private String cheatSheetProgrammingLanguage;
    private String cheatSheetDetails;

    public CheatSheet(String cheatSheetName, String cheatSheetProgrammingLanguage, String cheatSheetDetails) {
        this.cheatSheetName = cheatSheetName;
        this.cheatSheetProgrammingLanguage = cheatSheetProgrammingLanguage;
        this.cheatSheetDetails = cheatSheetDetails;
    }

    public String getCheatSheetName() {
        return cheatSheetName;
    }

    public void setCheatSheetName(String cheatSheetName) {
        this.cheatSheetName = cheatSheetName;
    }

    public String getCheatSheetProgrammingLanguage() {
        return cheatSheetProgrammingLanguage;
    }

    public void setCheatSheetProgrammingLanguage(String cheatSheetProgrammingLanguage) {
        this.cheatSheetProgrammingLanguage = cheatSheetProgrammingLanguage;
    }

    public String getCheatSheetDetails() {
        return cheatSheetDetails;
    }

    public void setCheatSheetDetails(String cheatSheetDetails) {
        this.cheatSheetDetails = cheatSheetDetails;
    }

    @Override
    public String toString() {
        return "CheatSheet{"
                + "cheatSheetName='" + cheatSheetName + '\''
                + ", cheatSheetProgrammingLanguage='" + cheatSheetProgrammingLanguage + '\''
                + ", cheatSheetDetails='" + cheatSheetDetails + '\''
                + '}';
    }
}

