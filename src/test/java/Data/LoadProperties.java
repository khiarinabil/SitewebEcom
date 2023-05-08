package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class LoadProperties {

	public static Properties userData =  
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\UserData.properties");
	
	private static  Properties loadProperties(String path) {
		Properties pro=new Properties();
		try {
			FileInputStream stream = new FileInputStream(path);
			try {
				pro.load(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("erreur ye nabil "+ e.getMessage());
		}
		return pro;
		
		
	}



}
