import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Filterwebtable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		Thread.sleep(1000);
		List<WebElement> veggie=  driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredveggie=veggie.stream().filter(v -> v.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggie.size(), filteredveggie.size());

	}

}
