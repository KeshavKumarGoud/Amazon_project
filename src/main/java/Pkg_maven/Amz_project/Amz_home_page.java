package Pkg_maven.Amz_project;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Amz_home_page {
	WebDriver driver;
	@FindBy(xpath="//button[text()='Manage Profiles']")
	WebElement Manage_profile;
	
	@FindBy(id="nav-link-accountList")
	WebElement account_list;
	
	@FindBy(linkText="View")
	WebElement view_profile;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement Searchbox;
	
	@FindBy(id="nav-orders")
	WebElement Goto_orders;
	
	
	public void hoverover_account(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(account_list).perform();
	}
	
	public void click_manage_profile() throws InterruptedException
	{
		Thread.sleep(1000);
		Manage_profile.click();
	}
	
	public void click_view() throws InterruptedException
	{
		Thread.sleep(1000);
		view_profile.click();
	}
	
	public void search_products(String product)
	{
		
		if(!(Searchbox.getAttribute("value").isEmpty()))
		{
			Searchbox.clear();
		}
		Searchbox.sendKeys(product+Keys.ENTER);
		String text_entered=Searchbox.getAttribute("value");
		Assert.assertTrue(product.equals(text_entered), "product name not entered correctly");
		
	}
	
	public void click_orders()
	{
		Goto_orders.click();
	}
	
	public Amz_home_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	

}
