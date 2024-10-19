package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{
	@FindBy(xpath="(//a[@class='outline-none'])[2]")
	private WebElement search;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchTab;
	
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	public void searchPage()
	{
		search.click();
		searchTab.click();
	}
}
