package Pkg_maven.Amz_project;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import Pkg_maven.Amz_project.Amz_home_page;
import Pkg_maven.Amz_project.Amz_search_page;

public class Check_product_details_present extends login_logout{

	@Test
	public void verify_product_details() 
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
		product_details_page.check_price_displayed();
		product_details_page.check_reviews_displayed();
		product_details_page.check_description_displayed();
		
	}
}
