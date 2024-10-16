package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage 
{
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signIn;
	
	public SigninPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	public void enterEmail(String userId)
	{
		emailId.sendKeys(userId);
	}
	
	public void enterPassword(String userPassword)
	{
		password.sendKeys(userPassword);	
	}
	
    public void clickOnContinue()
    {
    	continueButton.click();	
    }
    
    public void ClickOnSignin() 
    {
    	signIn.click();
    }
	
}
