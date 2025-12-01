package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop ;
		// TODO Auto-generated method stub
		public ConfigReader() throws IOException
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("config.properties");
			prop.load(fis);
		}
		
		public String getProperty(String key)
		{
			return prop.getProperty(key);
		}
		
	

}
