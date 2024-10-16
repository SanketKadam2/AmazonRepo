package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{

	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountList;
	
	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement signInButton;
	
	@FindBy(xpath="//span[text()='Sign Out'] ")
	private WebElement logOutButton;
	
	@FindBy(xpath="//span[text()='Your Account']")
	private WebElement yourAccount;

	@FindBy(xpath="//input[@type='text']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement searchButton;
	
	@FindBy(xpath="(//div[@id='nav-flyout-searchAjax']//div[@role='button'])[1]")
	private WebElement suggestionOption;
	
	private Actions action;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		action=new Actions(driver);
	}
	
	public void clickOnAccountList()
	{
		accountList.click();
	}

	public void clickOnLoginButton()
	{
		action.moveToElement(accountList).moveToElement(signInButton).click().build().perform();
	}
	public void clickOnLogoutButton()
	{
		action.moveToElement(accountList).moveToElement(logOutButton).click().build().perform();
	}
	
	public void enterProductName(String productName)
	{
		searchTextBox.sendKeys(productName);
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public void clickOnFirstSuggestionOption()
	{
		suggestionOption.click();
	}
	public void clickOnYourAccount()
	{
		action.moveToElement(accountList).moveToElement(yourAccount).click().build().perform();
	}
	
	
}
