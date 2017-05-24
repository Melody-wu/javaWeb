package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class properties {
	
	public static  Properties config(String path) {
		InputStream inputStream =properties.class.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		try {
		    p.load(inputStream);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return p;
	}
}
