package com.amazon.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class MobilePurchaseSteps {
	
	static WebDriver driver;

@Given("user launches the amazon application")
public void user_launches_the_amazon_application() {
	WebDriverManager.chromedriver().setup();
	 driver  = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	driver.manage().window().maximize();
  
}

@When("user search and choose mobiles")
public void user_search_and_choose_mobiles() {
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone13");
	WebElement search = driver.findElement(By.xpath("//input[@type='submit']"));
	search.click();
	WebElement demo = driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (256GB) - (Product) RED']"));
    demo.click();
    String text = demo.getText();
    System.out.println(text);
}

@When("user clicked on buy now button and entired payment details")
public void user_clicked_on_buy_now_button_and_entired_payment_details() {
	
	String pwing = driver.getWindowHandle();
	Set<String> allwing = driver.getWindowHandles();
	for (String x : allwing) {
		if (!x.equals(pwing)) {
			System.out.println("tab switched");
			driver.switchTo().window(x);
			
		}
		
	}
    
}

@Then("user should be displayed {string} message")
public void user_should_be_displayed_message(String string) {
  
	Assert.assertTrue(driver.findElement(By.xpath("(//a[@data-action='a-accordion'])[2]")).isDisplayed());
	driver.quit();

}

@When("user search and choose mobiles by using {int} dim list")
public void user_search_and_choose_mobiles_by_using_dim_list(Integer int1, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
   
	List<String> datas = dataTable.asList(String.class);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(datas.get(1));
	WebElement search = driver.findElement(By.xpath("//input[@type='submit']"));
    search.click();
	WebElement demo = driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (256GB) - (Product) RED']"));
    demo.click();
    String text = demo.getText();
    System.out.println(text);
}

@When("user search and choose mobiles by using one dim Map")
public void user_search_and_choose_mobiles_by_using_one_dim_Map(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
  Map<String, String> datas = dataTable.asMap(String.class,String.class);
  Thread.sleep(2000);
  
     driver.findElement(By.xpath("//input[@type='text']")).sendKeys(datas.get("i"));
	WebElement search = driver.findElement(By.xpath("//input[@type='submit']"));
    search.click();
	WebElement demo = driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (256GB) - (Product) RED']"));
    demo.click();
    String text = demo.getText();
     System.out.println(text);
}


}
