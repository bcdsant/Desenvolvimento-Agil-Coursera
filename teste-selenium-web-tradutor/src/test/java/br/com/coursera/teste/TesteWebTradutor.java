package br.com.coursera.teste;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteWebTradutor {
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
	public void primeiroTesteWebTradutor() throws Exception {
		driver.get(baseUrl + "/web-tradutor/");
		driver.findElement(By.name("traduzir")).clear();
		driver.findElement(By.name("traduzir")).sendKeys("carro casa");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("car, house",driver.findElement(By.cssSelector("h2")).getText());
	}

	@Test
	public void segundoTesteWebTradutor() throws Exception {
		driver.get(baseUrl + "/web-tradutor/");
		driver.findElement(By.name("traduzir")).clear();
		driver.findElement(By.name("traduzir")).sendKeys("pessoa avião");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("person, airplane",driver.findElement(By.cssSelector("h2")).getText());
	}

	@Test
	public void terceiroTesteWebTradutor() throws Exception {
		driver.get(baseUrl + "/web-tradutor/");
		driver.findElement(By.name("traduzir")).clear();
		driver.findElement(By.name("traduzir")).sendKeys("quadrado floresta");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("quadrado, floresta",driver.findElement(By.cssSelector("h2")).getText());
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
