package Pkg_maven.Amz_project;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cart_operation extends login_logout{

	@Test
	public void increase_qauntity() throws InterruptedException
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
		cartPage.enter_quantity();
	}
	
	@Test
	public void delete_product_cart() 
	{
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("bags");
		Amz_search_page search_page=new Amz_search_page(driver);
		search_page.select_1st_product();
		Set<String> windowid=    driver.getWindowHandles();
		Iterator <String> listOfId=windowid.iterator();
		String parentId=listOfId.next();
		String childId1=listOfId.next();
		driver.switchTo().window(childId1);
		Amz_product_details_page product_details_page=new Amz_product_details_page(driver);
		product_details_page.add_to_cart(driver);
		Amz_shopping_cart_page cartPage=new Amz_shopping_cart_page(driver);
		cartPage.goto_cart(driver);	
		cartPage.delete_product();
		WebElement delete_msg=driver.findElement(By.xpath("//div[@data-name='Active Items']//div[@data-csa-c-owner='CartX']//span[text()=' was removed from Shopping Cart. ']"));
		Assert.assertTrue(delete_msg.isDisplayed(), "product is not deleted successfully");
	}
}
