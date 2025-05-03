package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) 
	{
		super(driver);

	}

	//locator  
	@FindBy(xpath="//button[contains(text(),'Remove')]")public WebElement removeCart;
	@FindBy(xpath="//a[@class='shopping_cart_link']") public WebElement cartIcon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") public WebElement batchCount;
	@FindBy(xpath="(//button[text()='Add to cart'])[1]") public WebElement addToCart;
	


	// Actions

	public void clk_addtoCart()
	{
		addToCart.click();
	}

	public boolean validateBatch()
	{
		return driver.findElements(By.xpath("batchCount")).size()> 0;
		
	}
	
	public void iconCart()
	{
		cartIcon.click();
	}
		
	public void clearCart()
	{
		removeCart.click();
	}










}
