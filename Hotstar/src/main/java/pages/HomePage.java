package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	@FindBy(xpath="(//button[@type='button'])[9] ")
	private WebElement subscribeToWatch;
	
	@FindBy(xpath="//h2[text()='Latest Releases']")
	private WebElement latestRelease;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		
	}
	
	public void homeScreen()
	{
		subscribeToWatch.click();
		latestRelease.click();
	}

}
