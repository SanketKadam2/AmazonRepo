package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartDetailsPage 
{
	@FindBy(xpath="//div[@data-item-index='1']//h4//span[@class='a-truncate-cut'] ")
	private WebElement firstProductName;
	
	@FindBy(xpath="(//div[@data-item-index='1']//div[@class='sc-item-price-block']//div/span)[3] ")
	private WebElement firstProductPrice;
	
	public CartDetailsPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public String getFirstProductName()
	{
		return firstProductName.getText().trim();
	}
	public String getFirstProductPrice()
	{
		return firstProductPrice.getText().trim();
	}

}
