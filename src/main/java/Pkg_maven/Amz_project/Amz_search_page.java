package Pkg_maven.Amz_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amz_search_page {
	WebDriver driver;
	@FindBy(xpath="(//div[@id='brandsRefinements']//li[@aria-label='Nike']//div)")
	WebElement Nike_brand;
	
	@FindBy(xpath="//div[@id='brandsRefinements']//div[@class='a-row a-expander-container a-expander-extend-container']/a")
	WebElement see_more;
	
	@FindBy(xpath="(//div[contains(@class,'SEARCH_RESULTS')]//h2/span)[1]")
	WebElement search_results_brand;
	
	@FindBy(xpath="//div[@id='departments']//li//a/span[contains(text(),\"Boys' Casual Shoes\")]")
	WebElement category_boys_casual_shoes;
	
	@FindBy(xpath="//div[@id='departments']//li//span[contains(text(),\"Boys' Casual Shoes\")]")
	WebElement Selected_boys_casual_shoes;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result']//span[@class='a-price-whole']")
	List<WebElement> price_list;
	
	@FindBy(id="s-result-sort-select")
	WebElement sort_dropdown;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result']//span[contains(@aria-label,'stars')]")
	List<WebElement> ratings_list; 
	
	//@FindBy(xpath="(//div[@data-component-type='s-search-result'])[1]")
	@FindBy(xpath="(//div[@data-component-type='s-search-result'])[1]//div[contains(@class,'product-image')][1]")
	WebElement product_1st;
	
	List<Double> searchlist=new ArrayList<Double>();
	List<Double> sort_searchlist=new ArrayList<Double>();
	
	public void select_brand(WebDriver driver)
	{
		WebDriverWait e_wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		e_wait.until(ExpectedConditions.elementToBeClickable(see_more));
		see_more.click();
		
		e_wait.until(ExpectedConditions.elementToBeClickable(Nike_brand));
		Nike_brand.click();
	}
	
	public void select_category()
	{
		category_boys_casual_shoes.click();
		String class_value=Selected_boys_casual_shoes.getAttribute("class");
		Assert.assertTrue(class_value.contains("a-text-bold"), class_value);
		
	}
	
	public Amz_search_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void select_sort_option(String sort_option)
	{
		Select sortd=new Select(sort_dropdown);
		sortd.selectByVisibleText(sort_option);
	}
	
	public void verify_searchresult_lowtohigh()
	{
		for(int i=0;i<5;i++)
		{
			String price=price_list.get(i).getText();
			price=price.replace(",", "");
			searchlist.add(Double.parseDouble(price));
		}
		sort_searchlist.addAll(searchlist);
		Collections.sort(sort_searchlist);
		Assert.assertTrue(searchlist.equals(sort_searchlist), "the products in search page are not shown in ascending order of price");
	}
	
	public void verify_searchresult_hightolow()
	{
		for(int i=0;i<5;i++)
		{
			String price=price_list.get(i).getText();
			price=price.replace(",", "");
			searchlist.add(Double.parseDouble(price));
		}
		sort_searchlist.addAll(searchlist);
		Collections.sort(sort_searchlist,Collections.reverseOrder());
		Assert.assertTrue(searchlist.equals(sort_searchlist), "the products in search page are not shown in descending order of price");
	}
	
	public void verify_searchresult_reviewsort()
	{
		for(int i=0;i<5;i++)
		{
			String[] rating_value=ratings_list.get(i).getAttribute("aria-label").split(" ");
			Double rating_int=Double.parseDouble(rating_value[0]);
			
			searchlist.add(rating_int);
		}
		sort_searchlist.addAll(searchlist);
		Collections.sort(sort_searchlist,Collections.reverseOrder());
		Assert.assertTrue(searchlist.equals(sort_searchlist), "the products in search page are not shown in ascending order of average customer reviews");
	}
	
	public void select_1st_product() 
	{
		
		WebDriverWait ewait=new WebDriverWait(driver,Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.elementToBeClickable(product_1st));
		
		product_1st.click();
		
		
	}
	
	
	
}
