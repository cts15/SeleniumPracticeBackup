import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FilterWebtable_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Gavin Joyce");
		Thread.sleep(1000);
		List<WebElement> name=  driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
		
		List<WebElement> filteredname=name.stream().filter(v -> v.getText().contains("Gavin Joyce")).collect(Collectors.toList());
		
		Assert.assertEquals(name.size(), filteredname.size());
	}

}
