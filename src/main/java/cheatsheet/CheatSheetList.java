package cheatsheet;

import java.util.ArrayList;

public class CheatSheetList {
    private ArrayList<CheatSheet> cheatSheets = new ArrayList<>();

    public CheatSheetList() {
    }

    /**
     * Gets the number of cheat sheet currently in the CheatSheetList
     *
     * @return size of cheatSheets
     */
    public int getSize() {
        return cheatSheets.size();
    }

    /**
     * Gets all the cheat sheets in the cheatSheetList
     *
     * @return cheatSheets The current list of cheat sheets
     */
    public ArrayList<CheatSheet> getCheatSheetList() {
        return cheatSheets;
    }

    /**
     * Prints the cheatSheetName attribute for each cheat sheet
     */
    public void printCheatSheetNames() {
        // todo: replace with UI.printCheatSheetNames
        System.out.println("Current list of cheat sheet:");
        for (CheatSheet cs : cheatSheets) {
            System.out.println(cs.getCheatSheetName());
        }
    }

    /**
     * Adds a new cheat sheet to the list
     */
    public void add(CheatSheet cheatSheet) {
        cheatSheets.add(cheatSheet);
    }

    /**
     * Deletes a cheat sheet from the list
     * Prints an error message if name is not found
     *
     * @param name The name attribute of the desired cheat sheet
     */
    public void remove(String name) {
        int index = 0;
        for (CheatSheet cs : cheatSheets) {
            if (cs.getCheatSheetName().equals(name)) {
                break;
            }
            index++;
        }

        try {
            cheatSheets.remove(index);
        } catch (IndexOutOfBoundsException e) {
            // todo: replace with UI.indexOutOfBound
            System.out.println("Index out of bound!");
        }

    }

    /**
     * Retrieves a cheat sheet from the list using its index
     *
     * @param index The index of desired cheat sheet
     * @return size of cheatSheets
     */
    public CheatSheet getCheatSheet(int index) {
        CheatSheet cheatSheet;
        try {
            cheatSheet = cheatSheets.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            // todo: replace with UI.indexOutOfBound
            System.out.println("Index out of bound");
            // todo: replace this statement with throw instead
            return null;
        }
        return cheatSheet;
    }

}
