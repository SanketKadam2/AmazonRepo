package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import modules.RecomendedAccessoriesModule;
import page.CartDetailsPage;
import page.HomePage;
import page.ProductDetailsPage;
import page.SearchResultPage;
import page.SigninPage;

public class ValidateCartAndBuy extends Browser
{
	private WebDriver driver;
	private HomePage homePage;
	private SigninPage signinPage;
	private SearchResultPage searchResultPage;
	private ProductDetailsPage productDetailsPage;
	private RecomendedAccessoriesModule recomendedAccessoriesModule;
	private CartDetailsPage cartDetailsPage;
	private List<String> browserAddr;
	
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
	    searchResultPage=new SearchResultPage(driver);
	    productDetailsPage=new ProductDetailsPage(driver);
	    recomendedAccessoriesModule=new RecomendedAccessoriesModule(driver);
	    cartDetailsPage=new CartDetailsPage(driver);

	}
	
	@BeforeMethod
	void loginToAmazon()
	{
        driver.get("https://www.amazon.in/");
	
		homePage.clickOnLoginButton();		
		
		signinPage.enterEmail("sanketk201@gmail.com");
		signinPage.clickOnContinue();
		signinPage.enterPassword("Test@12345");
		signinPage.ClickOnSignin();
		
	}
	
	@Test
    void verifyAddToCart() throws InterruptedException
    {
		Thread.sleep(2000);
        homePage.enterProductName("mobile");
		
		Thread.sleep(2000);
		homePage.clickOnFirstSuggestionOption();
		homePage.clickOnSearchButton();
		
		
		searchResultPage.clickOnSelectItem();
		
		//child browser
		browserAddr =new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserAddr.get(1));
		
		String expectedProductName = productDetailsPage.getProductName();
        String expectedProductPrice= productDetailsPage.getProductPrice();
//		productDetailsPage.scrollUntilAddToCartButton();
//		productDetailsPage.selectQuantity("3");
		productDetailsPage.clickOnAddToCart();
		
		Thread.sleep(2000);
		recomendedAccessoriesModule.goToCartPage();
		
		//cart page
		String actualProductName=cartDetailsPage.getFirstProductName();
		String actualProductPrice=cartDetailsPage.getFirstProductPrice();
		
		SoftAssert SoftAssert=new SoftAssert();
		SoftAssert.assertEquals(actualProductName, expectedProductName);
		SoftAssert.assertEquals(actualProductPrice, expectedProductPrice);
		
//		SoftAssert.assertEquals(actualQuantity,"3");
//		SoftAssert.assertAll();
    }
	
	@Test
	void verifyBuyProduct() throws InterruptedException
    {
		homePage.enterProductName("iphone 16 pro");
		
		Thread.sleep(2000);
		homePage.clickOnFirstSuggestionOption();
		homePage.clickOnSearchButton();
		
		searchResultPage.clickOnSelectItem();
		
		productDetailsPage.clickOnBuyNow();
		
//		SoftAssert SoftAssert=new SoftAssert();
		Assert.assertEquals("productName","ProductName");
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
		 searchResultPage=null;
		 productDetailsPage=null;
		 recomendedAccessoriesModule=null;
		 cartDetailsPage=null;
		 
		 System.gc();    //garbage collector
	    
	}
	
	@AfterTest
	void closeBrowser()
	{
		driver.quit();
	}

}
