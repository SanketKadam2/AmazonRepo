package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class Test1 
{
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private SearchPage searchPage;
	@BeforeClass
	void beforeClass()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	void beforeMethod()
	{
		driver.get("https://www.hotstar.com/");
		loginPage = new LoginPage(driver);
		loginPage.login();
	}
	@Test
	void test_A()
	{
		if(driver.getCurrentUrl().equals("actual URL Home page"))
		{
		  System.out.println("pass");	
		}
		else
		{
			System.out.println("fail");
		}
		
	}
	@AfterMethod
	void afterMethod()
	{
		homePage=new HomePage(driver);
		homePage.homeScreen();
	}
	@AfterClass
	void afterClass()
	{
		driver.quit();
	}
	

}
