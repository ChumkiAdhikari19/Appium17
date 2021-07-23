package pac.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

public class JsonFileData {

	public static void main(String[] args, String key) throws IOException, ParseException {
		FileReader inputFile=new FileReader("./Data/commonDC.properties");
		
		//parse the json object into java data stream
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(inputFile);
		
		//type cast the object into hashmap and read the data in key value format
				HashMap jobj=(HashMap)obj;
				String value = jobj.get(key).toString();
				
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("deviceName", "\"deviceName\": \"POCO X3\"");
		
				
				
		
	}

}
