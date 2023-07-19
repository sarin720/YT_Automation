package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;


public class Utility_Functions {
	static Random rand = new Random();

	// Generate random integers in range 0 to 999
	static int rand_int1 = rand.nextInt(1000);
	static int rand_int2 = rand.nextInt(1000);
	static Properties prop;
	static File propFile;
	static FileInputStream dataFis;
	public static String randomize(String valToBeRandomized, String replacement)
	{
		try {
			return valToBeRandomized = valToBeRandomized.replace(replacement,rand_int1+"" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valToBeRandomized;
	}

	public static void loadPropertyFile() throws IOException 
	{
		prop = new Properties();
		propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\utils\\data");
		dataFis = new FileInputStream(propFile);
		prop.load(dataFis);

	}

	public static String getData(String key) throws IOException
	{
		// get data from properties file
		loadPropertyFile();
		return prop.getProperty(key);
	}

	public static void setData(String key, String value) throws IOException
	{
		// get data from properties file
		loadPropertyFile();
		prop.setProperty(key, value);
		prop.store(new FileOutputStream(propFile), null);
	}



}
