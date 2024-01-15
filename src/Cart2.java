import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// it takes 5 seconds for every step to trigger
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//driver.findElement(By.cssSelector("input.search-keyword")).sendKeys("Brocolli");
		String[] listproduct= {"Cucumber", "Brocolli", "Beetroot"};
		
		Thread.sleep(1000);
		
		addItems(driver, listproduct);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		//removeItems(driver,listproduct);
		
			
	}
	public static void addItems(ChromeDriver driver, String[] listproduct)
	{
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int j=0;
			
		for (int i=0; i<products.size(); i++)
		{
			//format name of product
			String[] nameproduct=products.get(i).getText().split("-");
			String formattedname = nameproduct[0].trim();
			
			//convert array into array list for easy search
			List itemsneededlist = Arrays.asList(listproduct);
			
			if(itemsneededlist.contains(formattedname))
			{
				//to add 2 quantity of each item
				driver.findElements(By.cssSelector("a.increment")).get(i).click();
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==listproduct.length)
				{
					break;
				}
				
			}
		}

	}
	public static void removeItems(ChromeDriver driver, String[] listproduct)
	{
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int j=0;
			
		for (int i=0; i<products.size(); i++)
		{
			//format name of product
			String[] nameproduct=products.get(i).getText().split("-");
			String formattedname = nameproduct[0].trim();
			
			//convert array into array list for easy search
			List itemsneededlist = Arrays.asList(listproduct);
			
			if(itemsneededlist.contains(formattedname))
			{
				j++;
				driver.findElements(By.xpath("//a[@class='product-remove']")).get(i).click();
				
			}
			
		}
		
	}
}
