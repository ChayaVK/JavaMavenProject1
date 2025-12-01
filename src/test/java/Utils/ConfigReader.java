package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private Properties prop = new Properties();

    public ConfigReader() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (is != null) {
                prop.load(is);
            } else {
                System.out.println("config.properties not found in classpath → continuing.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
		
	

}
