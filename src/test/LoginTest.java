package test;


import java.io.IOException;

import org.testng.annotations.Test;

import page.EdurekaHome;
import page.EdurekaBlogsPage;


public class LoginTest extends TestBase {


	@Test(priority= 1)
	public void loginEdureka() throws InterruptedException, IOException {
		EdurekaHome objHomePage = new EdurekaHome(driver);

		objHomePage.clickLogIn();
		Thread.sleep(2000);
		objHomePage.enterPasswordModal();
		Thread.sleep(3000);
		objHomePage.enterEmailModal();
		objHomePage.clickLoginBtnModal();
		objHomePage.goToBlogs();
		EdurekaBlogsPage objBlogsPage = new EdurekaBlogsPage(driver);
		objBlogsPage.searchForSelenium();
		objBlogsPage.clickInterviewQuestions();
		String expectedTitle = "Interview Questions Archive - Edureka";
		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("Test case successful!");
		
			
		}
		else {
			System.out.println("Test Failed");
			
		}
	}
}
