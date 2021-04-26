package Maven.ZenQ;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCart {

	static WebDriver driver = new ChromeDriver();
	@Test(priority = 0)
	public static void openBrowser() {
		System.setProperty("webelement.chrome.driver", "D:\\chromedriver.exe");
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public static void getUrl() {
		driver.get("https://demo.opencart.com/index.php");
	}
	@Test(priority = 2)
	@Parameters(value="searchquery")
	public static void checkingFeatures(String name) {
		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='caption']//a"));
		for (WebElement ele : productName) {
			if (ele.getText().equals(name)) {
				System.out.println(ele.getText());
				ele.click();
				String Name = driver.findElement(By.xpath("//div//h1[text()='Canon EOS 5D']")).getText();
				System.out.println(Name);
				System.out.println(driver.findElement(By.xpath("//li//h2")).getText());

				break;
			}
		}
	}
	
	
}
