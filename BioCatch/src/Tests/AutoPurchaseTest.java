package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Models.Buyer;
import Models.CheckOutForm;
import Models.Ebay;

public class AutoPurchaseTest {

	WebDriver driver;
	Ebay ebayObj;
	CheckOutForm checkOutForm;
	Buyer buyer;
	
	@BeforeTest
	public void InitDriver() {
		final String driverPath = "C:\\Users\\This_user\\Desktop\\homeTask\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
	}
	
	@Test
	public void AddProducts() {
		
		int numOfItem = 1;
		
		ebayObj = new Ebay(driver);
		ebayObj.searchProducts("fashion men");
		ebayObj.clickOnItem(numOfItem);
		
		while (ebayObj.getTotalPrice() < 5) {
			
			numOfItem++;
			driver.navigate().back();
			driver.navigate().back();
			ebayObj.clickOnItem(numOfItem);
		}
	}
	
	@BeforeTest
	public void initBuyer() {
		
		buyer = new Buyer("IL", "Daniel", "Broner", 
				"Haroeh", "Ramat-Gan", "Israel",
				"4444", "test@test.com", "050505050");
	}
	
	@Test
	public void checkout() {
		
		checkOutForm = new CheckOutForm(driver, ebayObj);
		checkOutForm.init();
		checkOutForm.fillDetails(buyer);
		checkOutForm.submit();
	}
	
	@AfterTest
	public void closeDriver() {

		driver.close();
	}	
}
