package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutForm {

	WebDriver driver;
	Ebay ebay;
	
	public CheckOutForm(WebDriver driver, Ebay ebay) {
		this.driver = driver;
		this.ebay = ebay;
	}
	
	public void init() {
		ebay.connect();
	}
	
	public void fillDetails(Buyer buyer) {
		
		driver.findElement(By.cssSelector("option[value='" + buyer.getStateSymbol() + "']")).click();
		driver.findElement(By.id("af-first-name")).sendKeys(buyer.getFirstName());
		driver.findElement(By.id("af-last-name")).sendKeys(buyer.getLastName());
		driver.findElement(By.id("af-address1")).sendKeys(buyer.getAddress());
		driver.findElement(By.id("af-city")).sendKeys(buyer.getCity());
		driver.findElement(By.id("af-state")).sendKeys(buyer.getState());
		driver.findElement(By.id("af-zip")).sendKeys(buyer.getZipCode());
		driver.findElement(By.id("af-email")).sendKeys(buyer.getEmail());
		driver.findElement(By.id("af-email-confirm")).sendKeys(buyer.getEmail());
		driver.findElement(By.cssSelector("input[class='input-field ipt-phone']")).sendKeys(buyer.getPhone());
	}
	
	public void submit() {
		
		driver.findElement(By.cssSelector("button[data-click-id='7310']")).click();
	}
}
