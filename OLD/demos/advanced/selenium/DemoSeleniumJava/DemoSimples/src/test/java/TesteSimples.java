import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class TesteSimples {

  private WebDriver driver;
  private String strUrlLogin = "https://www.amazon.com/";

  @Before
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver();
    //driver = new FirefoxDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void testLoginSucesso() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.get(this.strUrlLogin);

    WebElement deals = driver.findElement(By.id("Today's deals"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Deals and Promotion")));

    WebElement books = driver.findElement(By.name("Books"));
    books.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results for Books")));    

    WebElement addtocart = driver.findElement(By.name("Add to Cart"));
    addtocart.click();

    WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div[2]/div/a[4]/span[1]"));
    cart.click();
    
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}
