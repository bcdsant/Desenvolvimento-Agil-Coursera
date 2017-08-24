package br.com.coursera;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteConverterTemperatura {
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
	public void test1ConverterTemperatura() throws Exception {
		driver.get(baseUrl + "/converte-celsius-para-fahrenheit/");
		new Select(driver.findElement(By.name("conversao"))).selectByVisibleText("Celsius para Fahrenheit");
	    driver.findElement(By.name("valor-a-ser-convertido")).clear();
	    driver.findElement(By.name("valor-a-ser-convertido")).sendKeys("100");
	    driver.findElement(By.name("Converter")).click();
	    assertEquals(driver.findElement(By.xpath("//h1[2]")).getText(), "Resulado: 212 F");
	}

	@Test
	public void test2ConverterTemperatura() throws Exception {
		driver.get(baseUrl + "/converte-celsius-para-fahrenheit/");
		new Select(driver.findElement(By.name("conversao"))).selectByVisibleText("Fahrenheit para Celsius");
		driver.findElement(By.name("valor-a-ser-convertido")).clear();
		driver.findElement(By.name("valor-a-ser-convertido")).sendKeys("212");
		driver.findElement(By.name("Converter")).click();
		assertEquals(driver.findElement(By.xpath("//h1[2]")).getText(), "Resulado: 100 °C");
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
