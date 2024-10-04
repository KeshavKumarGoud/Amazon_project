package amz_testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pkg_maven.Amz_project.Amz_home_page;
import Pkg_maven.Amz_project.Amz_search_page;
@Listeners(Listener.class)
public class Products_sort_price extends login_logout{
	
	@Test
	public void price_lowtohigh()
	{
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("shoes");
		Amz_search_page search_page=new Amz_search_page(driver);
		search_page.select_sort_option("Price: Low to High");
		search_page.verify_searchresult_lowtohigh();
	}

	@Test
	public void price_hightolow()
	{
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("shoes");
		Amz_search_page search_page=new Amz_search_page(driver);
		search_page.select_sort_option("Price: High to Low");
		search_page.verify_searchresult_hightolow();
	}
	
	@Test
	public void sort_reviews()
	{
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("shoes");
		Amz_search_page search_page=new Amz_search_page(driver);
		search_page.select_sort_option("Avg. Customer Review");
		search_page.verify_searchresult_reviewsort();
	}
}
