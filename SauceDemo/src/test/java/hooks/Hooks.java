package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks 
{

public static WebDriver driver;
	
	@Before
	public void startUp()
	{
		ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");

		driver = new ChromeDriver(options)	;
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
				
	}
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		 if (driver != null) {
	            driver.quit();
	        }
	}

}
