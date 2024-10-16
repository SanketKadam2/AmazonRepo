package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser
{
	public static WebDriver launchChromeBrowser()
	{
		WebDriver driver=new ChromeDriver();
		return null;
	}
	
	public static WebDriver launchFirefoxBrowser()
	{
		WebDriver driver=new FirefoxDriver();
		return null;
	}
	
	public static WebDriver launchEdgeBrowser()
	{
		WebDriver driver=new EdgeDriver();
		return null;
	}
	
	public static WebDriver launchBrowser(String expectedBrowser)
	{
		WebDriver driver = null;
	
		if(expectedBrowser.equals("Chrome"))
		{
	    	driver=launchChromeBrowser();    	
	    }
		if(expectedBrowser.equals("Firefox"))
		{
		    driver=launchFirefoxBrowser();
        }
		if(expectedBrowser.equals("Edge"))
		{
		    driver=launchEdgeBrowser();
	    }

		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
}
