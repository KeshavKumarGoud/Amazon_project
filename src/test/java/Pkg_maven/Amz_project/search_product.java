package Pkg_maven.Amz_project;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pkg_maven.Amz_project.Amz_home_page;
@Listeners(Listener.class)
public class search_product extends login_logout{
	
	@Test
	public void Amz_search_product()
	{
		Amz_home_page homepage=new Amz_home_page(driver);
		homepage.search_products("shoes");
		
		
	}
}
