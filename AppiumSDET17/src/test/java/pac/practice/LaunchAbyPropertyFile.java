package pac.practice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LaunchAbyPropertyFile  {
	static AndroidDriver driver;	
		
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./Data/commonDC.properties");
		Properties p=new Properties();
		p.load(fis);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", p.getProperty("deviceN"));
		dc.setCapability("automationName", p.getProperty("automationN"));
		dc.setCapability("platformName", p.getProperty("platformN"));
		dc.setCapability("platformVersion", p.getProperty("platformV"));
		dc.setCapability("UDID", p.getProperty("adb"));
		dc.setCapability("appPackage", p.getProperty("appPkge"));
		dc.setCapability("appActivity", p.getProperty("appAct"));
		
		//URL url=new URL(p.getProperty("url2"));
		//driver=new AndroidDriver(url,dc);
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}
	}












