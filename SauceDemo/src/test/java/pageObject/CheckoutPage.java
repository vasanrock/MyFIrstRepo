package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BaseClass{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// locators
	

@FindBy(xpath="//input[@id='first-name']") public WebElement txt_firstName;
@FindBy(xpath="//input[@id='last-name']") public WebElement txt_lastName;
@FindBy(xpath="//input[@id='postal-code']") public  WebElement txt_PostalCode;
@FindBy(xpath="//input[@id='continue']")  public WebElement btn_continue;

@FindBy(xpath="//button[@id='finish']")public WebElement finish;
@FindBy(xpath="//h2[normalize-space()='Thank you for your order!']")public WebElement ConfirmeMessage;

@FindBy(xpath="//button[@id='checkout']") public WebElement checkouts;


//Actions

public void checkOut()
{
	
	checkouts.click();
}


public void personalInfo(String first , String last , String zipcode)
{
	txt_firstName.sendKeys(first);
	txt_lastName.sendKeys(last);
	txt_PostalCode.sendKeys(zipcode);
}

public void clk_continue()
{
	btn_continue.click();
}

public void finish()
{
	finish.click();
}

public boolean confirmationMsg()
{
	return ConfirmeMessage.isDisplayed();
}








}
