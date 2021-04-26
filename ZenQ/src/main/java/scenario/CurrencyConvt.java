package scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrencyConvt {
	
	static WebDriver driver;
	
	public static void openBrowser() {
		
		System.setProperty("webelement.chrome.driver", "D:\\chromedriver.exe");
		driver.manage().window().maximize();
	}
	public static void getUrl() {
		driver.get("https://demo.opencart.com/index.php");
		driver.findElement(By.xpath("//img [@title=\"iPhone\"]")).click();
		
	}
	public static void main(String[] args) {
		openBrowser();
		getUrl();
	}

}
