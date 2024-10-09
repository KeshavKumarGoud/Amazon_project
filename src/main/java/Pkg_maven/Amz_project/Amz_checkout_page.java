package Pkg_maven.Amz_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amz_checkout_page {
	WebDriver driver;
@FindBy(id="orderSummaryPrimaryActionBtn")
WebElement nextAction;

@FindBy(xpath="(//form[@id='address-list']//div[contains(@class,'a-row address-row')]//label)[2]")
WebElement address;

@FindBy(xpath="(//form[@id='address-list']//div[contains(@class,'a-row address-row')])[2]")
WebElement verify_address;

@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[9]")
WebElement cashondelivery;

@FindBy(id="submitOrderButtonId")
WebElement placeYourOrder;

@FindBy(name="claimCode")
WebElement promotionalCode;

@FindBy(id="addPromo_BadCode")
WebElement promocode_status;

@FindBy(xpath="//span[@id='gcApplyButtonId']//input")
WebElement Apply;

public void select_address()
{
	//WebDriverWait ewait=new WebDriverWait(driver, Duration.ofSeconds(10));
	//ewait.until(ExpectedConditions.elementToBeClickable(address));
	address.click();
	String class_value=verify_address.getAttribute("class");
	Assert.assertTrue(class_value.contains("list-address-selected"), "required address not selected");
}

public void nextAction_button()
{
	nextAction.click();
}

public void select_cashOnDelivery(WebDriver driver)
{
	WebDriverWait ewait=new WebDriverWait(driver, Duration.ofSeconds(10));
	ewait.until(ExpectedConditions.elementToBeClickable(cashondelivery));
	cashondelivery.click();
}

public Amz_checkout_page(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void select_payment_options(WebDriver driver,int option)
{
	
	WebElement paymentmethod=driver.findElement(By.xpath("(//input[@name='ppw-instrumentRowSelection'])["+option+ "]"));
	if(paymentmethod.isEnabled())
	{
	paymentmethod.click();
	Assert.assertTrue(paymentmethod.isSelected(), "Radio button is not selected for "+option+ " payment option");
	}
	
}

public void enter_promotionalcode()
{
	WebDriverWait ewait=new WebDriverWait(driver,Duration.ofSeconds(20));
	ewait.until(ExpectedConditions.elementToBeClickable(promotionalCode));
	promotionalCode.sendKeys("testing");
	Apply.click();
	ewait.until(ExpectedConditions.elementToBeClickable(promocode_status));
	String promo_code=promocode_status.getText();
	promo_code.trim();
	Assert.assertTrue(promo_code.trim().equals("The promotional code you entered is not valid."), "promocode not entered");
}
}
