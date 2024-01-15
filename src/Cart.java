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

public class Cart {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// it takes 5 seconds for every step to trigger
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] listproduct= {"Cucumber", "Brocolli", "Beetroot" ,"Onion"};
		Thread.sleep(1000);
		
		//function called
		addItems(driver, listproduct); 
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();	
		
		//Explict wait - it will effect only below step
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//select")).click();
		
		WebElement staticDropdown = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("India");
		
		WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='errorAlert']")).getText());
		
		Thread.sleep(1000);
		chkbox.click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
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
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==listproduct.length)
				{
					break;
				}
				
			}
		}

	}
}
