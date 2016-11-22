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
  private String strUrlLogin = "https://enterprise-demo.orangehrmlive.com/auth/login";

  @Before
  public void setUp() throws Exception {
    //this.driver = new HtmlUnitDriver();
    this.driver = new FirefoxDriver();
    this.driver.manage().window().maximize();
  }

  @Test
  public void testLoginSucesso() {
    this.driver.get(this.strUrlLogin);

    WebElement login = this.driver.findElement(By.id("txtUsername"));
    login.clear();
    login.sendKeys("linda.anderson");

    WebElement senha = this.driver.findElement(By.name("txtPassword"));
    senha.clear();
    senha.sendKeys("linda.anderson");
    
    WebElement submit = this.driver.findElement(By.id("btnLogin"));
    submit.click();

    WebDriverWait wait = new WebDriverWait(this.driver, 10);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
    boolean existeTxtBemvindo = this.driver.getPageSource().contains("Welcome");
    Assert.assertTrue(existeTxtBemvindo);

  }

  @Test
  public void testLoginErro() {
    this.driver.get(this.strUrlLogin);

    WebElement login = this.driver.findElement(By.name("txtUsername"));
    login.clear();
    login.sendKeys("sysadmin");

    WebElement senha = this.driver.findElement(By.name("txtPassword"));
    senha.clear();
    senha.sendKeys("");
    
    WebElement submit = this.driver.findElement(By.id("btnLogin"));
    submit.click();

    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    boolean existeMsgErro = this.driver.getPageSource().contains("Password cannot be empty");
    Assert.assertTrue(existeMsgErro);
  }


  @Test
  public void testAtualizarDadosPessoais() {
    this.driver.get(this.strUrlLogin);

    WebElement login = this.driver.findElement(By.name("txtUsername"));
    login.clear();
    login.sendKeys("linda.anderson");

    WebElement senha = this.driver.findElement(By.name("txtPassword"));
    senha.clear();
    senha.sendKeys("linda.anderson");
    
    WebElement submit = this.driver.findElement(By.id("btnLogin"));
    submit.click();

    //Navegar para a tela de atualizacao
    WebElement elemento = this.driver.findElement(By.id("menu_pim_viewMyDetails"));
    elemento.click();

    elemento = this.driver.findElement(By.id("btnSave"));
    elemento.click();

    elemento = this.driver.findElement(By.id("personal_txtEmpFirstName"));
    elemento.clear();
    elemento.sendKeys("Joana");

    Select select = new Select(driver.findElement(By.id("personal_cmbMarital")));
                  
    select.selectByValue("Single");

    elemento = this.driver.findElement(By.id("btnSave"));
    elemento.click();

    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    boolean existeMsgSucesso = this.driver.getPageSource().contains("Successfully Saved");
    Assert.assertTrue(existeMsgSucesso);
  }


  @After
  public void tearDown() throws Exception {
    this.driver.quit();
  }
}
