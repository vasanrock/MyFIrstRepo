package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass
{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators: //input[@id='user-name']
	@FindBy(xpath="//input[@id='password']") public  WebElement txt_password;
	@FindBy(xpath="//input[@id='user-name']") public WebElement txt_username;
	@FindBy(xpath="//input[@id='login-button']") public  WebElement clk_login;
	@FindBy(xpath="//span[@class='title']") public  WebElement validateTiltle;
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Username and password do not match a')]") public WebElement validateInvalidInput;
	@FindBy(xpath="//a[@id='logout_sidebar_link']") public WebElement clk_logout;


	//Actions

	public void enterUserName(String name)
	{
		txt_username.sendKeys(name);
	}

	public void enterPassword(String pass)
	{
		txt_password.sendKeys(pass);
	}
	public void btn_Login()
	{
		clk_login.click();
	}

	public boolean HomePageTitle()
	{
		return validateTiltle.isDisplayed();
	}

	public boolean validaterrorMSG()
	{
		boolean displayed = validateInvalidInput.isDisplayed();
		return displayed;
	}
	public void btn_Logout() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",clk_logout);
	}

	public void login(String name , String pass)
	{
		enterUserName(name);
		enterPassword(pass);
		btn_Login();
	}


}



