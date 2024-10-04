package amz_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pkg_maven.Amz_project.Amz_home_page;
import Pkg_maven.Amz_project.Amz_search_page;
@Listeners(Listener.class)
public class Search_apply_filter_category extends login_logout{
	String Selected_brand="Nike";
	@Test
	public void apply_filter()
	{
		//applying brand filter
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("shoes");
		Amz_search_page search_page=new Amz_search_page(driver);
		search_page.select_brand(driver);
		WebElement product_brand=driver.findElement(By.xpath("(//div[contains(@class,'SEARCH_RESULTS')]//h2/span)[1]"));
		String text_ret=product_brand.getText();
		Assert.assertTrue(Selected_brand.equals(product_brand.getText()), "Selected brand is not matching with search results product brand");
		
		
		//applying category filter
		WebElement goto_home_page=driver.findElement(By.id("nav-logo"));
		goto_home_page.click();
		homepage.search_products("shoes");
		search_page.select_category();
		
	}

}
