package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver ();
		driver.get("https://training-support.net/selenium/simple-form");
		String title = driver.getTitle();
		System.out.println("Title is:"+ title);
		WebElement fn = driver.findElement(By.id("firstName"));
		fn.sendKeys("Preeti");
	
		WebElement ln = driver.findElement(By.id("lastName"));
		
		ln.sendKeys("Rini");
		Thread.sleep(100);
		WebElement email =  driver.findElement(By.id("email"));
		email.sendKeys("preeti@gmail.com");
		WebElement num = driver.findElement(By.id("number"));
		num.sendKeys("7259789666");
		  driver.findElement(By.cssSelector(".ui.green.button")).click();
		  System.out.println("Click Perfomed");
		    
	        //Close the browser
	        driver.close();
		
		
		

	}

}
