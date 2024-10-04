package Pkg_maven.Amz_project;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Amz_login_page {
	
	
	WebDriver driver;
	
	@FindBy(id="createAccountSubmit")
	WebElement create_Amz_account;
	
	@FindBy(name="email")
	WebElement user_name;

	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(id="signInSubmit")
	WebElement signin;
	
	
	public void navigatetourl()
	{
		
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		
	}
	
	public void amz_username(String username)
	{
		user_name.sendKeys(username+Keys.ENTER);
	}
	
	public void amz_password(String amz_password)
	{
		password.sendKeys(amz_password+Keys.ENTER);
	}
	
	public void create_account_btn()
	{
		create_Amz_account.click();
	}
	
	public Amz_login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	




}
