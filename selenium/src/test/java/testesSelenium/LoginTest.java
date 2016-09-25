package testesSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest  {
    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new EdgeDriver();
    	
        driver.get("http://localhost:8080/selenium/login.xhtml");
        
        WebElement element = driver.findElement(By.xpath("//*[contains(@id, 'inputLogin')]"));
        element.sendKeys("admin");
        
        element = driver.findElement(By.xpath("//*[contains(@id, 'inputSenha')]"));
        element.sendKeys("321");

        element.submit();
        
        Thread.sleep(1500);
        driver.quit();
    }
}
