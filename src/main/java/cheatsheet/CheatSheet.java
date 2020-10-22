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
        dateModified = LocalDateTime.now();
    }

    public void setCheatSheetProgrammingLanguage(String cheatSheetProgrammingLanguage) {
        this.cheatSheetProgrammingLanguage = cheatSheetProgrammingLanguage;
        dateModified = LocalDateTime.now();
    }

    public void setCheatSheetDetails(String cheatSheetDetails) {
        this.cheatSheetDetails = cheatSheetDetails;
        dateModified = LocalDateTime.now();
    }

    public boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
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

