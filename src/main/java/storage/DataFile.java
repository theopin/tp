package storage;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A general class that stores certain constants regarding the
 * file location of the /data directory, as well as a method that can be
 * executed based on the type of class that is a child of this class.
 */
public abstract class DataFile {
    protected static final String USER_DIR = System.getProperty("user.dir");
    protected static final String DATA = "data";

    protected static final Path DATA_DIR = Paths.get(USER_DIR, DATA);

    /**
     * A method that is to be run when its subclass is created.
     */
    public abstract void executeFunction();

}
