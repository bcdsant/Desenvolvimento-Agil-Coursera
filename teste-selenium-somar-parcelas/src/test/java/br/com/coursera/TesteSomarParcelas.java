package br.com.coursera;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSomarParcelas {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testESomarParcelas() throws Exception {
    driver.get(baseUrl + "/somar-parcelas/");
    driver.findElement(By.name("p1")).clear();
    driver.findElement(By.name("p1")).sendKeys("12");
    driver.findElement(By.name("p2")).clear();
    driver.findElement(By.name("p2")).sendKeys("15");
    driver.findElement(By.name("calcular")).click();
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "O resultado foi: 27");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
