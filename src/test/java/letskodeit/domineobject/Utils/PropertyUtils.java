package letskodeit.domineobject.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties readPropertiesFile(String filepath) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(filepath);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            throw  new  RuntimeException("properties file not found "+filepath);
        } catch(IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException("failed to load properties file "+filepath);
        } finally {
            fis.close();
        }
        return prop;
    }
}
