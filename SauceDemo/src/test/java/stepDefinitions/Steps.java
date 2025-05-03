package stepDefinitions;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CheckoutPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class Steps
{
	LoginPage lp;
	HomePage hp ;
	CheckoutPage cp;
	@Given("I am on the Sauce Demo login page")
	public void i_am_on_the_sauce_demo_login_page() 
	{	
		lp = new LoginPage(Hooks.driver);
		System.out.println("Driver is: " + Hooks.driver);
		System.out.println("Username field: " + lp.txt_username);
	}


	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() 
	{
		lp.enterUserName("standard_user");
		lp.enterPassword("secret_sauce");
	}

	@And("I click the login button")
	public void i_click_the_login_button() 
	{
		lp.btn_Login();
	}


	@And("I should be redirected to the products page")
	public void i_should_be_redirected_to_the_products_page() 
	{
		Assert.assertTrue(lp.HomePageTitle());

	}


	@Then("I click logout button")
	public void i_click_logout_button() throws InterruptedException {
		lp.btn_Logout();
	}


	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() 
	{
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.btn_Login();
	}

	@And("I should see an error message")
	public void i_should_see_an_error_message() 
	{
		Assert.assertTrue(lp.validaterrorMSG());
	}

	@Given("I am logged in to Sauce Demo")
	public void i_am_logged_in_to_sauce_demo() {

		lp = new LoginPage(Hooks.driver);
		lp.login("standard_user","secret_sauce");
		hp = new HomePage(Hooks.driver);

	}

	@When("I add a product to the cart")
	public void i_add_a_product_to_the_cart() 
	{
		hp.clk_addtoCart();
	}

	@Then("the cart badge should display 1 item")
	public void the_cart_badge_should_display_1_item() {
		Assert.assertEquals("1", hp.batchCount.getText());

	}

	@Given("I have added a product to the cart")
	public void i_have_added_a_product_to_the_cart() {
		lp = new LoginPage(Hooks.driver);
		lp.login("standard_user","secret_sauce");
		hp = new HomePage(Hooks.driver);
		hp.clk_addtoCart();
	}

	@When("I remove the product from the cart")
	public void i_remove_the_product_from_the_cart() {
		hp.iconCart();
		hp.clearCart();
	}

	@Then("the cart should be empty")
	public void the_cart_should_be_empty() throws InterruptedException {

		Assert.assertFalse(hp.validateBatch());

	}
	@Given("I have a product in the cart")
	public void i_have_a_product_in_the_cart() 
	{
		cp = new CheckoutPage(Hooks.driver);
		lp = new LoginPage(Hooks.driver);
		lp.login("standard_user","secret_sauce");
		hp = new HomePage(Hooks.driver);
		hp.clk_addtoCart();
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() 
	{
		hp.iconCart();
		cp.checkOut();
	}

	@When("I enter valid personal information")
	public void i_enter_valid_personal_information() 
	{
		cp.personalInfo("keerthi","vasan","60015");
	}

	@When("I finish the checkout")
	public void i_finish_the_checkout() 
	{
		cp.clk_continue();
		cp.finish();
	}

	@Then("I should see the order confirmation message")
	public void i_should_see_the_order_confirmation_message() 
	{
		Assert.assertEquals(cp.confirmationMsg(),true);
	}

}
