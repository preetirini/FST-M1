package appiumtest;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.interactions.touch.TouchActions;
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

public class GoogleChrome {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 100);
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void googlekeep() throws InterruptedException {
    	
    	  try {
              driver.findElement(MobileBy.AndroidUIAutomator(
                      "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
          } catch (InvalidSelectorException e) {
              // ignore
          }
    		
    		
          wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View"))).click();
        	      }
    
    
    

    	

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}