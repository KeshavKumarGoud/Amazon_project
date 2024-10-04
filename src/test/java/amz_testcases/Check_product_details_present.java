package amz_testcases;

import org.testng.annotations.Test;

import Pkg_maven.Amz_project.Amz_home_page;
import Pkg_maven.Amz_project.Amz_search_page;

public class Check_product_details_present extends login_logout{

	@Test
	public void verify_product_details()
	{
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("laptop");
		Amz_search_page search_page=new Amz_search_page(driver);
		search_page.select_1st_product();
		
	}
}
