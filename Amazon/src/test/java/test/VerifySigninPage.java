package test;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import page.HomePage;
import page.SigninPage;
import page.YourAccountResultPage;

public class VerifySigninPage extends Browser
{
	private WebDriver driver;
	private HomePage homePage;
	private SigninPage signinPage;
	private YourAccountResultPage yourAccountResultPage;
	
	@Parameters("Browser")
	@BeforeTest
	void openBrowser(String expectedBrowser)
	{
		System.out.println(expectedBrowser);
		
		driver = launchBrowser(expectedBrowser);
		
	
	}
	
	@BeforeClass
	void pomClasses()
	{
		 homePage=new HomePage(driver);
		 signinPage=new SigninPage(driver);
		 yourAccountResultPage=new YourAccountResultPage(driver);

	}
	
	@BeforeMethod
	void loginToAmazon()
	{
        driver.get("https://www.amazon.in/");
		
    }
	 
	@Test
	void verifyLogin()
	{
		homePage.clickOnLoginButton();
		signinPage.enterEmail("sanketk201@gmail.com");
		signinPage.clickOnContinue();
		signinPage.enterPassword("Test@12345");
		signinPage.ClickOnSignin();
		
		SoftAssert SoftAssert=new SoftAssert();
		SoftAssert.assertEquals("SignUp","SignUp");
	}
	
	@Test
    void verifyYourAccount() throws InterruptedException
    {
		homePage.clickOnAccountList();
		homePage.clickOnYourAccount();
		
		yourAccountResultPage.clickOnYourOrders();
		
		SoftAssert SoftAssert=new SoftAssert();
		SoftAssert.assertEquals("SignUp","SignUp");
//		SoftAssert.assertAll();
    }
	
	@AfterMethod
	void logoutFromAmazon()
	{
		homePage.clickOnLogoutButton();
	}
	
	@AfterClass
	void removePom()
	{
		 homePage=null;
		 signinPage=null;
		 yourAccountResultPage=null;
	
		 System.gc();    //garbage collector
	    
	}
	
	@AfterTest
	void closeBrowser()
	{
		driver.quit();
	}

}
