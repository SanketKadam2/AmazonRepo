package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath="(//button[@type='button'])[2] ")
	private WebElement login;
	
	@FindBy(xpath="//input[@type='text'] ")
	private WebElement mobileno;
	
	@FindBy(xpath=" //i[@class='icon-close soul-icon _1_NA5fvEVp--uxNbR09uuo _10QtdfLpgjnmjRDFG3gw12']")
	private WebElement close;
	
//	@FindBy(xpath="(//button[@type='button'])[8] ")
//	private WebElement corntinueWithSupe;
//
//	@FindBy(xpath="//input[@Title='Mobile number'] ")
//	private WebElement mb;
//	
//	private Alert alt;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	//    alt=driver.switchTo().alert();
		
	}
	
	public void login()
	{
		login.click();
		mobileno.click();
		mobileno.sendKeys("9158171003");
//		close.click();
//		continueWithSuper.click();
//		mb.click();
//		alt.sendKeys("9158171003");
//		 
	}
}
