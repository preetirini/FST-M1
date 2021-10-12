package JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class JobBoard2 {
	
	WebDriver driver = new FirefoxDriver ();
 
  @BeforeTest
  public void beforeMethod() {
	  
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }

  @AfterTest
  public void afterMethod() {
	  driver.close();
	  
  }
  
  @Test
  public void act8() {
	  
	  driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
	  driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
   driver.findElement(By.xpath("//input[@id='wp-submit']")).click() ;
   String dash =  driver.findElement(By.xpath("//div[@class='wp-menu-name']")).getText();
   Assert.assertEquals(dash, "Dashboard");
   
  }
  
  @Test
  public void act9() throws Exception {
	  
	 // driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
	  //driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
   //driver.findElement(By.xpath("//input[@id='wp-submit']")).click() ;
  driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]")).click() ;
driver.findElement(By.xpath("//div/a[contains(text(),'Add New')]")).click();
 Thread.sleep(100);
 driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys("test");
 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
 
  
   
  }

}
