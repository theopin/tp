package cheatsheet;

import java.util.ArrayList;

public class CheatSheetList {
    private static ArrayList<CheatSheet> cheatSheets = new ArrayList<>();

    public CheatSheetList() {
    }

    /**
     * Gets the number of cheat sheet currently in the CheatSheetList.
     *
     * @return size of cheatSheets
     */
    public static int getSize() {
        return cheatSheets.size();
    }

    /**
     * Gets all the cheat sheets in the cheatSheetList.
     *
     * @return cheatSheets The current list of cheat sheets
     */
    public static ArrayList<CheatSheet> getCheatSheetList() {
        return cheatSheets;
    }

    /**
     * Converts the cheatSheetName attribute for each cheat sheet into a string.
     * The string will be used by UI for printing
     *
     * @return printedByUI The string to be printed by UI
     */
    public static String printCheatSheetNames() {
        StringBuilder printedByUI = new StringBuilder("Current list of cheat sheet:\n");
        for (CheatSheet cs : cheatSheets) {
            printedByUI.append(cs.getCheatSheetName()).append("\n");
        }
        return printedByUI.toString();
    }

    /**
     * Adds a new cheat sheet to the list.
     */
    public static void add(CheatSheet cheatSheet) {
        cheatSheets.add(cheatSheet);
    }

    /**
     * Deletes a cheat sheet from the list.
     * Prints an error message if name is not found.
     *
     * @param name The name attribute of the desired cheat sheet
     */
    public static void remove(String name) throws IndexOutOfBoundsException {
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
            // todo: add error message in UI
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * Removes all cheat sheet in the list.
     */
    public static void clear() {
        cheatSheets.clear();
    }

    /**
     * Retrieves a cheat sheet from the list using its index.
     *
     * @param index The index of desired cheat sheet
     * @return size of cheatSheets
     */
    public static CheatSheet getCheatSheet(int index) throws IndexOutOfBoundsException {
        CheatSheet cheatSheet;
        try {
            cheatSheet = cheatSheets.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            // todo: add error message in UI
            throw new IndexOutOfBoundsException();
        }
        return cheatSheet;
    }

}
