package Common.Common;

import java.io.File;
import java.io.IOException;

public class Utilities {
    public static String getProjectPath() throws IOException {
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());

        return currentDir;
    }
}
