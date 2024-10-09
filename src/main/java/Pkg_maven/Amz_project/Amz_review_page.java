package Pkg_maven.Amz_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_review_page {
@FindBy(xpath="//img[@alt='select to rate item five star.']")
WebElement five_star;

public void select_fivestar()
{
	five_star.click();
	//boolean result=five_star.isSelected();
	//five_star.click();
}

public Amz_review_page(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
