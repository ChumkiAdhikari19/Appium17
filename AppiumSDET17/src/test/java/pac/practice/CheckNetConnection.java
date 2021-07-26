package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class CheckNetConnection {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		dc.setCapability("noReset", "true");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		Connection currentstate = driver.getConnection();
		System.out.println(currentstate);
		
		driver.setConnection(Connection.WIFI);
		
		System.out.println(driver.getConnection());
		
		driver.setConnection(Connection.DATA);
		System.out.println(driver.getConnection());
		
		driver.setConnection(Connection.AIRPLANE);
		System.out.println(driver.getConnection());
	}

}
