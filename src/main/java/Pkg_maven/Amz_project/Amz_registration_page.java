package Pkg_maven.Amz_project;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_registration_page {
	WebDriver driver;
	@FindBy(id="ap_customer_name")
	WebElement name;
	
	@FindBy(id="ap_phone_number")
	WebElement mobile_number;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="continue")
	WebElement create_accnt;
	
	public void enter_name()
	{
		name.sendKeys("keshasv kumar"+Keys.ENTER);
	}
	
	public void enter_mobilr_num()
	{
		mobile_number.sendKeys("9964643602"+Keys.ENTER);
	}
	
	public void enter_password()
	{
		password.sendKeys("Admin@123");
	}
	
	public void create_accnt_btn()
	{
		create_accnt.click();
	}
	public Amz_registration_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
