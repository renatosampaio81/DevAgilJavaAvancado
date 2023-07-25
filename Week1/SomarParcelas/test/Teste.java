/*
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SomarParcelasTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void somarParcelas() {
    driver.get("http://localhost:8080/SomarParcelas/");
    driver.manage().window().setSize(new Dimension(996, 698));
    driver.findElement(By.name("p1")).click();
    driver.findElement(By.name("p1")).sendKeys("13");
    driver.findElement(By.name("p2")).click();
    driver.findElement(By.name("p2")).sendKeys("13");
    driver.findElement(By.name("calcular")).click();
    driver.findElement(By.cssSelector("html")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("O resultado foi 26"));
  }
}
*/