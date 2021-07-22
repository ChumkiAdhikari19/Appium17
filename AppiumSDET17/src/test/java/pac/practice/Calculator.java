package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Calculator {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", ".cal.AllInOneCalculatorActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.id("com.miui.calculator:id/btn_8_s")).click();
		//Thread.sleep(1000);
		
		driver.findElementByAccessibilityId("multiply").click();
		 //Thread.sleep(1000);
		 
		driver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
		 //Thread.sleep(1000);
		 
		driver.findElementByAccessibilityId("equals").click();
		 //Thread.sleep(1000);
		 
		
		String result = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
		 //Thread.sleep(1000);
		 
		System.out.println(result);
		
		
		
		
		

	}

}
