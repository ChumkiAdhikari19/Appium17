package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ApiDemo2 {
	@Test
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(1000);
		MobileElement button = (MobileElement) driver.findElement(By.id("android:id/button1"));
		Thread.sleep(1000);
		
		 List<WebElement> options = driver.findElements(By.className("android.widget.TextView"));
		 for(int i=1; i<options.size(); i++)
		 {
			 System.out.println(options.get(i).getText());
		 }
		
		
		
		
		
	}

}
