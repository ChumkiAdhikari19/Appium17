package apiDemoApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDrop {
		static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		URL url=new URL("http://localhost:4723/wd/hub");
		
		
		driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement continueBtn = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		TapOnElement(continueBtn);
		
		WebElement popUp = driver.findElement(By.id("android:id/button1"));
		TapOnElement(popUp);
		
		WebElement Viwes = driver.findElementByAccessibilityId("Views");
		TapOnElement(Viwes);
		
		WebElement dNd = driver.findElementByAccessibilityId("Drag and Drop");
		TapOnElement(dNd);
		
		WebElement src = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement dest = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		
		TouchAction touch=new TouchAction(driver);
		touch.longPress(dest).waitAction(1000).moveTo(dest).release().perform();
		
	
		
	}

	public static void TapOnElement(WebElement element) {
		driver.tap(1, element, 1000);
		
	}

}
