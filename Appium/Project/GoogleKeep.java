package appiumtest;

import static org.testng.Assert.assertEquals;

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

public class GoogleKeep {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void googlekeep() {
    	System.out.println("Google Task is Open Now!");
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	driver.findElementByAccessibilityId("New text note").click();
    	System.out.println("Enter Note");
    	driver.findElementById("editable_title").sendKeys("Note 1");
    	driver.findElementById("edit_note_text").sendKeys("Adding note 1");
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	driver.findElementByAccessibilityId("Open navigation drawer").click();
    	driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
    	System.out.println("Note Created");
    	String Notetitle = driver.findElementById("index_note_title").getText();
    	System.out.println(Notetitle);
    	String Notedescription = driver.findElementById("index_note_text_description").getText();
    	System.out.println(Notedescription);
    	Assert.assertEquals(Notetitle, "Note 1");
    	Assert.assertEquals(Notedescription, "Adding note 1");
    	
    }
    
    
    

    @Test
    public void googlekeepReminder() {
    	
     	driver.findElementById("browse_note_interior_content").click();
     	driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
     	 driver.findElementById("menu_reminder").click();
     	driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[1]").click();
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        
        driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Test. Test. \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]").click();
        
    	driver.findElementByXPath("(//androidx.cardview.widget.CardView[@content-desc=\"Note 1. Adding note 1. \"])[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout").click();
    	driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
    	Boolean test = driver.findElementById("reminder_chip").isDisplayed() ;
    	if(test==true) {
    		System.out.println("Reminder added to Note");
    	};
    	    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}