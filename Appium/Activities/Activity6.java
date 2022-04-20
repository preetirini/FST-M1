package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity6 {
 
	  
		
	  AppiumDriver<MobileElement> driver = null;
	  WebDriverWait wait;
	      
	      @BeforeClass
	      public void beforeClass() throws MalformedURLException  {
	          // Set the Desired Capabilities
	          DesiredCapabilities caps = new DesiredCapabilities();
	          caps.setCapability("deviceName", "PixelEmulator");
	          caps.setCapability("platformName", "android");
	          caps.setCapability("appPackage", "com.google.android.apps.messaging");
	          caps.setCapability("appActivity", ".ui.ConversationListActivity");
	          caps.setCapability("noReset", true);

	          // Instantiate Appium Driver
	          URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	          driver = new AndroidDriver<MobileElement>(appServer, caps);
	      }
  
  
  @Test
  public void chrome() {
  
    
   driver.findElementById("").click();
  }
  
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
  
  
  
  }

