package Pkg_maven.Amz_project;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amz_product_details_page {
	WebDriver driver;
	@FindBy(xpath="//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price-whole']")
	WebElement selected_product_price;
	
	@FindBy(xpath="//h2[text()='Product Description']")
	WebElement selected_product_derscription;
	
	@FindBy(xpath="//div[@id='averageCustomerReviews']//span[@id='acrPopover']")
	WebElement selected_product_reviews;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCart_Button;
	
	@FindBy(partialLinkText="Add to Cart")
	WebElement addToCart_button1;
	
	@FindBy(name="proceedToRetailCheckout")
	WebElement proceedtobuy;
	public void check_price_displayed()
	{
		Assert.assertTrue(selected_product_price.isDisplayed(), "price of the product is not displayed");
	}
	
	public void check_reviews_displayed()
	{
		Assert.assertTrue(selected_product_reviews.isDisplayed(), "reviews of the product is not displayed");
	}
	
	public void check_description_displayed()
	{
		Assert.assertTrue(selected_product_derscription.isDisplayed(), "reviews of the product is not displayed");
	}
	
	public void add_to_cart(WebDriver driver)
	{
		
		try
		{
			WebDriverWait e_wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			e_wait.until(ExpectedConditions.elementToBeClickable(addToCart_Button));
			addToCart_Button.click();
			Assert.assertTrue(proceedtobuy.isDisplayed(), "product has not been added to cart correctly");
		}
		catch(NoSuchElementException | org.openqa.selenium.TimeoutException e1)
		{
			WebDriverWait e_wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		   e_wait.until(ExpectedConditions.elementToBeClickable(addToCart_button1));
			addToCart_button1.click();
			Assert.assertTrue(driver.getTitle().equals("Amazon Sign In"),"user is not navigated to sign in page when user clicks 'add to cart' button");
		}
		
	}
	
	
	
	
	
	public Amz_product_details_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
}
