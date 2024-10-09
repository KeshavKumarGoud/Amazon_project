package Pkg_maven.Amz_project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amz_profile_page {
	WebDriver driver;
	@FindBy(className="editProfile")
	WebElement edit_user;

	@FindBy(id="editProfileNameInputId")
	WebElement username_field;

	@FindBy(xpath="//span[@id='editProfileContinueButton']//input")
	WebElement continue_btn;
	
	@FindBy(xpath="//div[@class='profile-name desktop']")
	WebElement profile_name;
	
	String update_name="keshav kumar";
	
	
	public void edit_name() throws InterruptedException
	{
		edit_user.click();
		username_field.clear();
		username_field.sendKeys(update_name);
		WebDriverWait e_wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		e_wait.until(ExpectedConditions.elementToBeClickable(continue_btn));
		Thread.sleep(1000);
		continue_btn.click();
		Assert.assertTrue(update_name.equals(profile_name.getText()), "profile name not matching");
		//profile_name.getText()
		
	}
	
	public Amz_profile_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
}
