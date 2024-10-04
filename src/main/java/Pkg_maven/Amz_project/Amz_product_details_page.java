package Pkg_maven.Amz_project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Amz_product_details_page {
	@FindBy(xpath="//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price-whole']")
	WebElement selected_product_price;
	
	
}
