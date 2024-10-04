package amz_testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Pkg_maven.Amz_project.Amz_home_page;
import Pkg_maven.Amz_project.Amz_profile_page;
import Pkg_maven.Amz_project.Amz_registration_page;

public class Profile_edit_name extends login_logout{
	//WebDriver driver;
	@Test
	public void edit_profile_username() throws InterruptedException
	{   
		
		Amz_home_page home_page=new Amz_home_page(driver);
		home_page.hoverover_account(driver);
		home_page.click_manage_profile();
		home_page.click_view();
		Amz_profile_page profile=new Amz_profile_page(driver);
		profile.edit_name();
		
	}
	
	

}
