package pac.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Android_KeyAction {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "POCO X3");
		dc.setCapability("automationName", "appium");
		//dc.setCapability("noReset", "true");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10 QKQ1.200512.002");
		dc.setCapability("UDID", "a548e7bb");
		dc.setCapability("appPackage", "com.android.camera");
		dc.setCapability("appActivity", ".VideoCamera");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.longPressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		
		driver.longPressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		Thread.sleep(1000);
		
		driver.longPressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		Thread.sleep(1000);
		driver.openNotifications();
		
		driver.longPressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		Thread.sleep(1000);
		
		driver.longPressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		
		
		
	}

}
