package storage;

import ui.Printer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * A general class that stores certain constants regarding the
 * file location of the /data directory, as well as a method that can be
 * executed based on the type of class that is a child of this class.
 */
public abstract class DataFile {
    protected static final String USER_DIR = System.getProperty("user.dir");
    protected static final String DATA = "data";
    protected static final String SRC = "src";
    protected static final String MAIN = "main";
    protected static final String PRELOADED = "preloaded";
    protected static final String XML_EXTENSION = ".xml";

    protected static final String MAIN_ELEMENT = "main";
    protected static final String FAVOURITE_ELEMENT = "favourite";
    protected static final String SUBJECT_ELEMENT = "subject";
    protected static final String CONTENTS_ELEMENT = "contents";

    protected static final String YES = "Yes";
    protected static final String NO = "No";
    protected static final String EMPTY = "";

    protected static final Path DATA_DIR = Paths.get(USER_DIR, DATA);
    protected static final Path DATA_PRELOADED_DIR = Paths.get(USER_DIR, DATA, PRELOADED);
    protected static final Path PRELOADED_ORIG_DIR = Paths.get(SRC, MAIN, PRELOADED);

    protected Printer printer;
    protected static ArrayList<Path> preloadedCheatSheets = new ArrayList<>();

    /**
     * A method that is to be run based on its subclass.
     */
    public abstract void executeFunction();

    /**
     * Creates a new directory and file at the specified location
     * if it currently does not exist.
     */
    protected void createNewDirectory() {
        if (!Files.exists(DATA_DIR)) {
            try {
                Files.createDirectories(DATA_DIR);
            } catch (IOException e) {
                printer.print(e.getMessage());
            }
        }
    }

    /**
     * Creates a new document builder to be used for the particular instance of
     * reading or writing a file.
     *
     * @return                                A new document builder.
     * @throws ParserConfigurationException   Throws when a serious
     *                                        configuration error has been caught.
     */
    protected DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        return DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder();
    }
}
