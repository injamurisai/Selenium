package Maven.ZenQ;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Currency_Converter {

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
	@Parameters(value ={"searchquery"})
	public static void checkingFeatures(String name) {
		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='caption']//a"));
		for (WebElement ele : productName) {
			if (ele.getText().equals(name)) {
				System.out.println(ele.getText());
				ele.click();

				System.out.println(driver.findElement(By.xpath("//li//h2")).getText());

				break;
			}
		}
	}
	@Test(priority = 3)
	public static void changeCurrency() {
		driver.findElement(By.xpath("//i[@class='fa fa-caret-down']")).click();

		List<WebElement> dropDownList = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li"));
		for (int i = 0; i < dropDownList.size(); i++) {
			System.out.println(dropDownList.get(i).getText());
			String currency = dropDownList.get(i).getText();
			dropDownList.get(i).click();
			String value = driver.findElement(By.xpath("//span [@class=\"price-new\"]")).getText();
			System.out.println("currency changed across the page:"+(value.contains(Character.toString(currency.charAt(0)))));
			driver.findElement(By.xpath("//i[@class='fa fa-caret-down']")).click();
			System.out.println(driver.findElement(By.xpath("//li//h2")).getText());
			dropDownList = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li"));

		}

	}

}