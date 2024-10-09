package Pkg_maven.Amz_project;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Apply_promocode extends login_logout{

	@Test
	public void enter_promocode()
	{
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("shoes");
		Amz_search_page search_page=new Amz_search_page(driver);
		search_page.select_1st_product();
		Set<String> windowid=    driver.getWindowHandles();
		Iterator <String> listOfId=windowid.iterator();
		String parentId=listOfId.next();
		String childId=listOfId.next();
		driver.switchTo().window(childId);
		Amz_product_details_page product_details_page=new Amz_product_details_page(driver);
		product_details_page.add_to_cart(driver);
		Amz_shopping_cart_page cartPage=new Amz_shopping_cart_page(driver);
		cartPage.goto_cart(driver);
		cartPage.proceedtobuy();
		Amz_checkout_page checkout_page=new Amz_checkout_page(driver);
		checkout_page.select_address();
		checkout_page.nextAction_button();
		checkout_page.select_cashOnDelivery(driver);
		checkout_page.nextAction_button();
		checkout_page.enter_promotionalcode();	
		WebElement goto_home_page=driver.findElement(By.xpath("//div[@id='banner-image']/span"));
		goto_home_page.click();
		WebElement ReturnToCart=driver.findElement(By.partialLinkText("Return to Cart"));
		ReturnToCart.click();
	}
}
