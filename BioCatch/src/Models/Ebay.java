package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ebay {

	WebDriver driver;
	
	public Ebay(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProducts(String productToSearch) {
		
		WebElement searchInput = driver.findElement(By.id("gh-ac"));
		searchInput.sendKeys(productToSearch);
		searchInput.submit();
	}
	
	public void clickOnItem(int numOfItem) {
		
		driver.findElement(By.id("srp-river-results-listing" + numOfItem)).click();		
		driver.findElement(By.id("isCartBtn_btn")).click();		
	}
	
	public double getTotalPrice() {
		
		double price;
		String tottalPrice;
		
		tottalPrice =driver.findElement(By.id("asyncTotal")).getText();
		price = getActualPrice(tottalPrice);
				
		return price;
	}
	
	public double getActualPrice(String tottalPriceText) {
		
		String[] arrTextToSplit = tottalPriceText.split("\\$");
		return (Double.parseDouble(arrTextToSplit[1]));
	}
	
	public void connect() {
		
		driver.findElement(By.id("ptcBtnRight")).click();
		driver.findElement(By.id("gtChk")).click();	
	}	
}