package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EdurekaBlogsPage {
	public WebDriver driver;
	public String title;
	
	static // Search text field
	By searchTxt = By.xpath("");
	
	// Search button
	By searchBtn = By.xpath("");
		
	By interviewQuestionsBtn = By.xpath(""); 
		
			
	public EdurekaBlogsPage(WebDriver driver) {
		this.driver = driver;
		//this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	// click Log In
	public void searchForSelenium() throws InterruptedException {
		System.out.println("searching for Selenium...");
		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
			driver.findElement(EdurekaBlogsPage.searchTxt).sendKeys("selenium");
			System.out.println("clicking Search...");
			driver.findElement(searchBtn).click();
		} catch (Exception e1) {
			try {
				System.out.println("Oops, didn't work...");
				driver.findElement(searchTxt).sendKeys("selenium");
				driver.findElement(searchBtn).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clickInterviewQuestions() {
		driver.findElement(interviewQuestionsBtn).click();
	}
}	
