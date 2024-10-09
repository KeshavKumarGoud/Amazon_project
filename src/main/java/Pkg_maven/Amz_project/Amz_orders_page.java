package Pkg_maven.Amz_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_orders_page 
{
 @FindBy(xpath="(//div[@class='order-card js-order-card']//a[contains(text(),'Write a product review')])[1]")
 WebElement write_product_review;
 
 public void write_overview()
 {
	 write_product_review.click();
 }
 
 public Amz_orders_page(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
}
