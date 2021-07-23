package apiDemoApp;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ApiDemoVerify {

	public static void main(String[] args) throws InterruptedException, IOException {
		/*DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");*/
		//Reading data from propertyFile
		FileInputStream fis=new FileInputStream("./Data/commonDC.properties");
		Properties p=new Properties();
		p.load(fis);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", p.getProperty("deviceN"));
		dc.setCapability("automationName", p.getProperty("automationN"));
		dc.setCapability("platformName", p.getProperty("platformN"));
		dc.setCapability("platformVersion", p.getProperty("platformV"));
		dc.setCapability("UDID", p.getProperty("adb"));
		dc.setCapability("appPackage", p.getProperty("APIAppPkge"));
		dc.setCapability("appActivity", p.getProperty("APIappAct"));
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Thread.sleep(1000);
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("android:id/button1")).click();
		//Thread.sleep(1000);
		driver.findElementByAccessibilityId("Views").click();
		driver.findElementByAccessibilityId("Controls").click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"2. Dark Theme\"]")).click();
		
		//verify textbox
		WebElement textBox = driver.findElement(By.id("io.appium.android.apis:id/edit"));
		textBox.sendKeys("HelloAppium");
		String actualText=textBox.getText();
		String expectedText="HelloAppium";
		Assert.assertEquals(actualText, expectedText);
		
		//verify CheckBox
		WebElement Selectcheckbox = driver.findElement(By.id("io.appium.android.apis:id/check1"));
		Selectcheckbox.click();
		boolean checkBoxActual=Selectcheckbox.isSelected();
		boolean checkboxExpected = true;
		Assert.assertTrue(checkboxExpected);
		
		
		
		//verify radioButton
		WebElement radioButton = driver.findElement(By.id("io.appium.android.apis:id/radio1"));
		
		//Assert.assertEquals(true, radioButton.isSelected());
		boolean SelectradioButton = radioButton.isSelected();
		if(SelectradioButton==false) {
			radioButton.click();
		}
		
		//Hide keybord
		driver.hideKeyboard();
		Thread.sleep(1000);
		
		//Mercury
		driver.findElement(By.id("android:id/text1")).click();
		List<WebElement> alltext = driver.findElementsByClassName("android.widget.CheckedTextView");
		for(int i=1; i<alltext.size(); i++)
		 {
			 System.out.println(alltext.get(i).getText());
		 }
		
		
		
		
		//Earth
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@checked='true']")).click();
		
		Thread.sleep(5000);
		System.out.println("expected text : " +expectedText);
		System.out.println("checkbox Selected : " +checkboxExpected);
		System.out.println("radiobutton selected : " +radioButton);
		
		
		
		
	}

}
