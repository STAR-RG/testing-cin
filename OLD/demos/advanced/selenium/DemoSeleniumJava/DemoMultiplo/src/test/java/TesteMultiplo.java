import java.util.*;
//import org.junit.*;
//import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import org.testng.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TesteMultiplo {
  private WebDriver driver;
  private String strUrlLogin = "";

  @Parameters({"browser"})
  @BeforeTest
  public void setUp(String browser) throws Exception {
      
      if (browser.equalsIgnoreCase("firefox")) {
         this.driver = new FirefoxDriver();
      } else if (browser.equalsIgnoreCase("chrome")) {
         System.setProperty("webdriver.chrome.driver", "chromedriver");
         this.driver = new ChromeDriver();
      }
      String workingDir = System.getProperty("user.dir");
      strUrlLogin = "file:///"+workingDir+"/webdevacademy/ux/bootstrap-crud/index.html";
      this.driver.get(strUrlLogin);
  }

  @Test
  public void testNovoCadastroSucesso() {
    WebElement elemento = this.driver.findElement(By.cssSelector("a[href*='add.html']"));
    elemento.click();
    

    elemento = this.driver.findElement(By.id("input14"));
    elemento.clear();
    elemento.sendKeys("teste@teste.com");
   this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    elemento = this.driver.findElement(By.className("btn-primary"));
    elemento.click();
    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    boolean telaInicial = this.driver.getPageSource().contains("Itens");
    Assert.assertTrue(telaInicial);
  } 


  @AfterTest
  public void tearDown() throws Exception {
    this.driver.quit();
  }

}
