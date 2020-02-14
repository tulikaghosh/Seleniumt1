package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public static WebDriver driver = null;

	@BeforeSuite
	public void initialize() throws IOException {
		System.out.println("BeforeSuite: calling initialize...");
		System.setProperty("webdriver.chrome.driver", ".Drivers\\chromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");
	}
	
	@AfterSuite
	//Test cleanup
	public void TeardownTest() {
		System.out.println("AfterSuite: calling TeardownTest...");
		TestBase.driver.quit();
	}
}
