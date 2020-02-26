package testca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tc0001 {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\rpa\\chromeDriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@Test
	public void Login() {
		
		driver.get("https://www.edureka.co/");
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("si_popup_email")).sendKeys("");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("");
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")).click();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
