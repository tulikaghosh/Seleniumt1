package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utility.ReadExcel;

public class EdurekaHome {
	public WebDriver driver;
	public String title;
	
	// Log In link
	By logInLink1 = By.linkText("Log In");
	By logInLink2 = By.xpath("//*[@id='header-II']/section/nav/div/a[2]");
	
	// email
	By email1 = By.id("si_popup_email");
	By email2 = By.xpath("//*[@id='si_popup_email']");
	
	// password
	By password1 = By.id("si_popup_passwd");
	By password2 = By.xpath("//*[@id='si_popup_passwd']");
	
	// Login button
	By loginBtn2 = By.id("new_sign_up_mode");
	By loginBtn1 = By.xpath("//*[@id='new_sign_up_mode']/div/div/div[2]/div[3]/form/button");
	
	// Community
	By communityLink = By.xpath("");

	// Blogs
	By blogLink = By.xpath("");


	public EdurekaHome(WebDriver driver) {
		this.driver = driver;
		//this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	// click Log In
	public void clickLogIn() {
		System.out.println("clicking Log In...");
		try {
			driver.findElement(logInLink1).click();
		} catch (Exception e1) {
			try {
				driver.findElement(logInLink2).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void enterEmailModal() throws IOException {
		System.out.println("entering email...");
		String[][] data = ReadExcel.getData("TestExcel.xls", "Sheet1");
		String username = data[1][0];
		System.out.println("username is " + username);
		
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(email1));
			actions.click();
			actions.sendKeys(username);
			actions.build().perform();
			
		} catch (Exception e1) {
			try {
				System.out.println("Came here...");
				driver.findElement(email2).sendKeys(username + Keys.TAB);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void enterPasswordModal() throws IOException {
		System.out.println("entering password...");
		String[][] data = ReadExcel.getData("TestExcel.xls", "Sheet1");
		String password = data[1][1];
		System.out.println("password is " + password);

		try {
			driver.findElement(password1).sendKeys(password);
		} catch (Exception e1) {
			try {
				driver.findElement(password2).sendKeys(password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clickLoginBtnModal() {
		System.out.println("clicking Login button on popup...");
		try {
			driver.findElement(loginBtn1).click();
		} catch (Exception e1) {
			try {
				System.out.println("First try didn't work (Login button)");
				driver.findElement(loginBtn2).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void goToBlogs() {
		System.out.println("clicking on Community...");
		try {
			String winHandleBefore = driver.getWindowHandle();
			driver.findElement(communityLink).click();
			Thread.sleep(2000);
			System.out.println("clicking on Blogs...");
			driver.findElement(blogLink).click();
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		} catch (Exception e1) {
			try {
				System.out.println("First try didn't work (Blogs)");
				driver.findElement(communityLink).click();
				driver.findElement(blogLink).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loginEdureka() throws InterruptedException, IOException {
		clickLogIn();
		enterEmailModal();
		enterPasswordModal();
		clickLoginBtnModal();
	}
}
