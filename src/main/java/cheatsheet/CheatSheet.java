package cheatsheet;

import java.time.LocalDateTime;

public class CheatSheet {
    private String cheatSheetName;
    private String cheatSheetProgrammingLanguage;
    private String cheatSheetDetails;
    private boolean isFavourite;
    private boolean isModifiable;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    public CheatSheet(String cheatSheetName, String cheatSheetProgrammingLanguage, String cheatSheetDetails) {
        this.cheatSheetName = cheatSheetName;
        this.cheatSheetProgrammingLanguage = cheatSheetProgrammingLanguage;
        this.cheatSheetDetails = cheatSheetDetails;
        this.isFavourite = false;
        this.dateCreated = LocalDateTime.now();
    }

    public String getCheatSheetName() {
        return cheatSheetName;
    }

    public String getCheatSheetProgrammingLanguage() {
        return cheatSheetProgrammingLanguage;
    }

    public boolean getIsFavourite() {
        return isFavourite;
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

    public boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
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

