package apiDemoApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ApiDemoNotification {

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
		
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("android:id/button1")).click();
		//Thread.sleep(1000);
		driver.findElementByAccessibilityId("App").click();
		
		driver.findElementByAccessibilityId("Notification").click();
		driver.findElementByAccessibilityId("IncomingMessage").click();
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Show App Notification").click();
		Thread.sleep(1000);
		driver.openNotifications();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/app_name_text\"]")).click();
		
		Thread.sleep(5000);
		
		
		
		
		
	}

}
