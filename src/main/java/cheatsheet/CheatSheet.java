package cheatsheet;

import java.time.LocalDateTime;

public class CheatSheet {
    private String cheatSheetName;
    private String cheatSheetProgrammingLanguage;
    private String cheatSheetDetails;
    private boolean isFavorite;
    private boolean isModifiable;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    public CheatSheet(String cheatSheetName, String cheatSheetProgrammingLanguage, String cheatSheetDetails) {
        this.cheatSheetName = cheatSheetName;
        this.cheatSheetProgrammingLanguage = cheatSheetProgrammingLanguage;
        this.cheatSheetDetails = cheatSheetDetails;
        this.isFavorite = false;
        this.dateCreated = LocalDateTime.now();
    }

    public String getCheatSheetName() {
        return cheatSheetName;
    }

    public String getCheatSheetProgrammingLanguage() {
        return cheatSheetProgrammingLanguage;
    }

    public String getCheatSheetDetails() {
        return cheatSheetDetails;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setCheatSheetName(String cheatSheetName) {
        this.cheatSheetName = cheatSheetName;
        updateCheatSheet();
    }

    public void setCheatSheetProgrammingLanguage(String cheatSheetProgrammingLanguage) {
        this.cheatSheetProgrammingLanguage = cheatSheetProgrammingLanguage;
        updateCheatSheet();
    }

    public void setCheatSheetDetails(String cheatSheetDetails) {
        this.cheatSheetDetails = cheatSheetDetails;
        updateCheatSheet();
    }

    public void setFavorite() {
        isFavorite = true;
        updateCheatSheet();
    }

    public void updateCheatSheet() {
        this.dateModified = LocalDateTime.now();
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

