package TestNGActivities;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	
	  WebDriver driver = new FirefoxDriver();
  @Test
  public void f() {
	 String title = driver.getTitle();
	 System.out.println("Title is:" + title);
	Assert.assertEquals(title,"Training Support");
	driver.findElement(By.xpath("//a[@id=\"about-link\"]")).click();
	String newtitle = driver.getTitle();
	System.out.println("New title is:"+newtitle);
	Assert.assertEquals(newtitle,"About Training Support");
	
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	
	  driver.get("https://www.training-support.net");
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
