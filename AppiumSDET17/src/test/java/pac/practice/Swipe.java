package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Swipe {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", "TouchScreenTestActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//vertical swp
		driver.swipe(525, 721, 600, 1650, 1000);
		
		//horizontal swp
		driver.swipe(860, 870, 170, 1660, 1000);
		
		

	}

}
