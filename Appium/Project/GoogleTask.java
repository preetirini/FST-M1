package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

public class GoogleTask {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void Act1() {
    	System.out.println("Google Task is Open Now!");
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	driver.findElementByAccessibilityId("Create new task").click();
    	System.out.println("Enter Task");
    	driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
    	driver.findElementById("add_task_done").click();
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	driver.findElementByAccessibilityId("Create new task").click();
    	System.out.println("Enter Task");
    	driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
    	driver.findElementById("add_task_done").click();
    	
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	driver.findElementByAccessibilityId("Create new task").click();
    	System.out.println("Enter Task");
    	driver.findElementById("add_task_title").sendKeys("Complete Second Activity Google Keep");
    	driver.findElementById("add_task_done").click();
    	
    	String Task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
    	System.out.println(Task3);
    	String Task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
    	System.out.println(Task2);
    	String Task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();
    	System.out.println(Task1);
    	
 Assert.assertEquals(Task1, "Complete Activity with Google Tasks");
    	
 Assert.assertEquals(Task2, "Complete Activity with Google Keep");
	      
    Assert.assertEquals(Task3, "Complete Second Activity Google Keep");
 
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}