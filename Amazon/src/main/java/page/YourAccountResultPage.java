package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountResultPage 
{
	@FindBy(xpath="//div[@data-card-identifier='YourOrders']")
	private WebElement yourOrders;
	
	public YourAccountResultPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public void clickOnYourOrders()
	{
		yourOrders.click();
	}

}
