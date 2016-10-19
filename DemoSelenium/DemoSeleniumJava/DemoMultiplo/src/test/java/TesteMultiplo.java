import java.util.*;
//import org.junit.*;
//import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import org.testng.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TesteMultiplo {
  private WebDriver driver;
  private String strUrlLogin = "https://enterprise-demo.orangehrmlive.com/auth/login";

  @Parameters({"browser"})
  @BeforeTest
  public void setUp(String browser) throws Exception {
      if (browser.equalsIgnoreCase("firefox")) {
         this.driver = new FirefoxDriver();
      } else if (browser.equalsIgnoreCase("chrome")) {
         System.setProperty("webdriver.chrome.driver", "/home/curso/Downloads/chromedriver");
         this.driver = new ChromeDriver();
      }
      this.driver.get(strUrlLogin);
  }

  @Test
  public void testLoginSucesso() {
    WebElement login = this.driver.findElement(By.id("txtUsername"));
    login.sendKeys("linda.anderson");

    WebElement senha = this.driver.findElement(By.name("txtPassword"));
    senha.sendKeys("linda.anderson");
	
    WebElement submit = this.driver.findElement(By.id("btnLogin"));
    submit.click();
  } 

  @AfterTest
  public void tearDown() throws Exception {
    this.driver.quit();
  }

}
