package yu.facade.pagemaker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Database {
	private Database(){
		//单例
	}
	
	public static Properties getProperties(String dbname){
		String filename = dbname+".txt";
		System.out.println("FILENAME:"+filename);
		Properties prop = new Properties();
		System.out.println("PROP:"+prop);
		try {
			System.out.println("HELLO");
			System.out.println("FILENIPUTSTREAM:"+(new FileInputStream(filename)));
			prop.load(new FileInputStream(filename));
		}  catch (IOException e) {
			System.out.println("Warning: "+filename+" is not found.");
		}
		
		return prop;
	}
}
