package Pkg_maven.Amz_project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pkg_maven.Amz_project.Amz_login_page;
import Pkg_maven.Amz_project.Amz_registration_page;
@Listeners(Listener.class)
public class New_user_registration {
	
	@Test(retryAnalyzer=amz_testcases.Run_failed_testcases.class)
	public void register()
	{
	//opening chrome browser and go to amazon singin page
	WebDriver driver;
	driver=new ChromeDriver();
	driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	driver.manage().window().maximize();
	
	//verify if we have navigated to amazon sign in page
	String amz_signin_title="Amazon Sign In";
	//WebElement page_title=driver.findElement(By.xpath("//title"));
	String actual_title=driver.getTitle().trim();
	Assert.assertTrue(actual_title.equals(amz_signin_title), "Its not sign in page");
	
	//fill out the fields for registering in amazon
	Amz_login_page login_page=new Amz_login_page(driver); 
	//login_page.navigatetourl();
	login_page.create_account_btn();
	Amz_registration_page reg_page=new Amz_registration_page(driver);
	reg_page.enter_name();
	reg_page.enter_mobilr_num();
	reg_page.enter_password();
	//reg_page.create_accnt_btn();
	
	}
}
