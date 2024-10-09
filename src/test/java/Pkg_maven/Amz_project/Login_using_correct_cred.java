package Pkg_maven.Amz_project;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pkg_maven.Amz_project.Amz_login_page;

public class Login_using_correct_cred {
WebDriver driver;
	@Test
	public void login_method() throws EncryptedDocumentException, IOException
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		Excel_data data1=new Excel_data();
		String creds=data1.get_excel_data(1);
		String[]  username_password=creds.split("&");
		Amz_login_page aml=new Amz_login_page(driver);
		aml.amz_username(username_password[0]);
		aml.amz_password(username_password[1]);
		
		String home_page_title="Your Amazon.in";
		Assert.assertTrue(home_page_title.equals(driver.getTitle()),"Not logged in to Amazon");
		
		WebElement Accnt_options=driver.findElement(By.id("nav-link-accountList"));
		Actions A1=new Actions(driver);
		A1.moveToElement(Accnt_options).perform();
		WebElement logout_btn=driver.findElement(By.id("nav-item-signout"));
		
		logout_btn.click();
		
		driver.quit();
		
	}
}
