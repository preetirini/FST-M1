package SeleniumPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWebDriverVerification {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        Thread.sleep(10000);
        driver.close();
    }
}