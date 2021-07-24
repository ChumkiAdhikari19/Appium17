package pac.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class JsonFileData {

	static AndroidDriver driver;
	
	public static void main(String[] args, String key) throws IOException, ParseException {
		FileReader inputFile=new FileReader("./Data/commonDC.json");
		
		//parse the json object into java data stream
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(inputFile);
		
		//type cast the object into hashmap and read the data in key value format
				HashMap jobj=(HashMap)obj;
				String value = jobj.get(key).toString();
				
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("deviceName", "deviceName");
			dc.setCapability("platformName", "platformName");
			dc.setCapability("platformVersion", "platformVersion");
			dc.setCapability("UDID", "UDID");
			dc.setCapability("appPackage", "appPackage");
			dc.setCapability("appActivity", "appActivity");
		
			
			dc.setCapability("appActivity", "appActivity");
			
			driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			
				
		
	}

}
