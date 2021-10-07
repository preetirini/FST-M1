package JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class JobBoard {
	
	 WebDriver driver =  new FirefoxDriver();
	 @BeforeTest
	  public void beforeMethod() {
		 driver.get("https://alchemy.hguy.co/jobs/");
		
		
		  
		  
	  }
	
	 @AfterTest
	  public void afterMethod() {
		 driver.close();
		
		
		  
		  
	  }
	
	
	
	 
  @Test
  public void act1() {
	 
	  String title = driver.getTitle();
	  System.out.println("Title fo the Page:" + title);
 Assert.assertEquals("Alchemy Jobs – Job Board Application", title);

	 
  }
  @Test
  public void act2() {
	 
	WebElement element = driver.findElement(By.xpath("//h1[@class=\"entry-title\"]"));	 
 String heading = element.getText();
 System.out.println("Heading:"+heading);
 Assert.assertEquals(heading, "Welcome to Alchemy Jobs");


  }
  @Test
  public void act3() {
	 
	WebElement element1 = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/div/img"));
	System.out.println("Image url is "+ element1.getAttribute("src"));



  }
  
  @Test
  public void act4() {
	 
	WebElement h2 = driver.findElement(By.xpath("//div/h2"));
	String heading2 = h2.getText();
	System.out.println("heading 2:" + heading2);
	Assert.assertEquals(heading2, "Quia quis non");



  }
  @Test
  public void act5() throws Exception {
	 
	WebElement jobs = driver.findElement(By.xpath("//div/ul/li[1]/a"));
	jobs.click();
	Thread.sleep(1000);
	String title = driver.getTitle();
	System.out.println("Title of jobs Page:"+ title);
	assertEquals(title, "Jobs – Alchemy Jobs");
	
	


  }
	  
  @Test
  public void act6() throws Exception {
	 
	WebElement jobs = driver.findElement(By.xpath("//div/ul/li[1]/a"));
	jobs.click();
	
WebElement e = driver.findElement(By.xpath("//div/input[@id='search_keywords']"));
	e.sendKeys("Virtual Manufacturing Engineer");

	e.sendKeys(Keys.RETURN);

	Thread.sleep(10000);
	
driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/div")).click();
Thread.sleep(100);
driver.findElement(By.xpath("//div/div/div[3]/input")).click();
String email = driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();

System.out.println("email:" +email);



  }
  
  @Test
  public void act7() throws Exception {
	  
	  driver.findElement(By.xpath("//div/ul/li[3]/a")).click() ;
	  
	  driver.findElement(By.xpath("//form/fieldset[2]/div/input[@id='create_account_email']")).sendKeys("pre1e2q@gmail.com");
	  driver.findElement(By.xpath("//form/fieldset[3]/div/input[@id='job_title']")).sendKeys("TestSpecialist_Automation");
	  driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys("Chennai");
	 Select element = new Select(driver.findElement(By.xpath("//select[@id='job_type']")));
	 element.selectByVisibleText("Internship");
	 Thread.sleep(100);
	 WebElement frame = driver.findElement(By.xpath("//div/div[2]/iframe"));
	
//	 driver.switchTo().frame(frame);

	 frame.sendKeys("test");
	
	 
	 driver.switchTo().defaultContent();
	 driver.findElement(By.xpath("//input[@name='application']")).sendKeys("pre1e2q@gmail.com");

	  
driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("IBM");
	  driver.findElement(By.xpath("//input[@class='button']")).click();
	  driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
	
	  driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click() ;
	  Thread.sleep(10000);
	  WebElement txt= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li[3]/a/div[1]"));
	  

		
	
  }
  
  @Test
  public void act8() throws Exception {
	  
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  Thread.sleep(100000);
  }
	  

}

 


