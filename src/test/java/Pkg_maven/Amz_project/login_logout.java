package Pkg_maven.Amz_project;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class login_logout extends Listener{
	//protected WebDriver driver;
	@BeforeMethod
	public void Amz_login() throws EncryptedDocumentException, IOException
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement username=driver.findElement(By.name("email"));
		Excel_data data1=new Excel_data();
		String creds=data1.get_excel_data(1);
		String[]  username_password=creds.split("&");
		username.sendKeys(username_password[0]+ Keys.ENTER);
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys(username_password[1]+Keys.ENTER);
	}
	
	@AfterMethod
	public void Amz_logout() throws InterruptedException
	{
		WebElement Accnt_options=driver.findElement(By.id("nav-link-accountList"));
		Actions A1=new Actions(driver);
		A1.moveToElement(Accnt_options).perform();
		WebElement logout_btn=driver.findElement(By.id("nav-item-signout"));
		//WebDriverWait e_wait=new Webdriverwait(driver,Duration.ofSeconds(10));
		logout_btn.click();
		
		driver.quit();
		
	}

}
