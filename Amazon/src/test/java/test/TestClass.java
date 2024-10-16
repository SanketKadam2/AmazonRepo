package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import modules.RecomendedAccessoriesModule;
import page.CartDetailsPage;
import page.HomePage;
import page.ProductDetailsPage;
import page.SearchResultPage;
import page.SigninPage;

public class TestClass 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLoginButton();
		
		SigninPage signPage=new SigninPage(driver);
		signPage.enterEmail("sanketk201@gmail.com");
		signPage.clickOnContinue();
		signPage.enterPassword("Test@12345");
		signPage.ClickOnSignin();
		
		homePage=new HomePage(driver);
		homePage.enterProductName("mobile");
		Thread.sleep(2000);
		homePage.clickOnFirstSuggestionOption();
		homePage.clickOnSearchButton();
		
		SearchResultPage searchResultPage=new SearchResultPage(driver);
		searchResultPage.clickOnSelectItem();
		
		//child browser
		List<String>addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
		String expectedProductName = productDetailsPage.getProductName();
		String expectedProductPrice= productDetailsPage.getProductPrice();
		productDetailsPage.clickOnAddToCart();
		
		Thread.sleep(2000);
		RecomendedAccessoriesModule recomendedAccessoriesModule=new RecomendedAccessoriesModule(driver);
		recomendedAccessoriesModule.goToCartPage();
		
		//cart page
		CartDetailsPage cartDetailsPage=new CartDetailsPage(driver);
		String actualProductName=cartDetailsPage.getFirstProductName();
		String actualProductPrice=cartDetailsPage.getFirstProductPrice();
		
		if(expectedProductName.equals(actualProductName) && expectedProductPrice.equals(actualProductPrice))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		homePage.clickOnLogoutButton();
		driver.quit();
	}

}
