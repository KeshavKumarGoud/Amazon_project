package Pkg_maven.Amz_project;

import org.testng.annotations.Test;

public class Reviews_order extends login_logout{
 @Test
 public void give_review()
 {
	 Amz_home_page homepage=new Amz_home_page(driver);
	 homepage.click_orders();
	 Amz_orders_page orderspage=new Amz_orders_page(driver);
	 orderspage.write_overview();
	 Amz_review_page reviewpage=new Amz_review_page(driver);
	 reviewpage.select_fivestar();
 }
}
