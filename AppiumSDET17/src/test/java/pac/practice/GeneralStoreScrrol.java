package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class GeneralStoreScrrol {

	static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {

		//common dc
		DesiredCapabilities dc= new DesiredCapabilities();
		dc= new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		dc.setCapability("app", "E:\\app_pkg");
		URL url=new URL("http://localhost:4723/wd/hub");
		
		driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.Spinner[@id=\"com.androidsample.generalstore:id/spinnerCountry\"]")).click();
		scrollToElement(driver, "text", "Hong Kong");
		

	}
	private static void scrollToElement(AndroidDriver driver2, String an, String av) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
		
		
	}

}
