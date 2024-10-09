package Pkg_maven.Amz_project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amz_shopping_cart_page {
	@FindBy(partialLinkText="Go to Cart")
	WebElement GoToCart_button;
	
	@FindBy(xpath="(//select[@id='quantity'])[1]")
	WebElement quantity;
	
	@FindBy(xpath="//span[@class='a-button a-button-dropdown quantity']//span[@class='a-dropdown-prompt']")
	WebElement quantity_value;
	
	@FindBy(xpath="(//span[@data-action='delete'])[1]//input")
	WebElement delete_button;
	
	@FindBy(name="proceedToRetailCheckout")
	WebElement proceed_to_buy;
	
	@FindBy(xpath="//h2[contains(text(),'Shopping Cart')]")
	WebElement shopping_cart;
	
	
	
	public void goto_cart(WebDriver driver)
	{
		WebDriverWait ewait=new WebDriverWait(driver, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(GoToCart_button));
		GoToCart_button.click();
		Assert.assertTrue(shopping_cart.isDisplayed(), "user has not navigated to cart page succesfully");
	}
	
	public void enter_quantity()
	{
		Select quantity_dropdown=new Select(quantity);
		quantity_dropdown.selectByValue("2");
		Assert.assertTrue(quantity_value.getText().equals("2"), null);
		
		
	}
	
	public void delete_product()
	{
		delete_button.click();
		
	}
	
	public void proceedtobuy()
	{
		proceed_to_buy.click();
	}
	
	public Amz_shopping_cart_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
