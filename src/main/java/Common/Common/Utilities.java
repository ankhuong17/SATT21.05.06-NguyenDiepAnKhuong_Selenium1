package Common.Common;

import java.io.File;
import java.io.IOException;

public class Utilities {
    public static String getProjectPath() throws IOException {

        String currentDir = System.getProperty("user.dir");

        return currentDir;
    }
}
