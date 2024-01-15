import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Fluentwait_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		
		driver.get("https://theautomationzone.blogspot.com/2022/08/dynamic-elements-synchronization.html");
		
	 //Small delay button
		driver.findElement(By.xpath("//button[contains(text(), 'Show Message with small delay')]")).click();
			
		Wait<ChromeDriver> wait= new FluentWait<ChromeDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) //max time is 10 sec
				.pollingEvery(Duration.ofSeconds(1)) //interval 
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class);
		
		WebElement foo = wait.until(new Function<ChromeDriver,WebElement>()
				{
					public WebElement apply(ChromeDriver driver)
					{
//						System.out.println("Finding the element");
//						WebElement elem1 = driver.findElement(By.xpath("//p[contains(text(),'This message is shown with small delay')]"));
//						elem1.click();
//						System.out.println(" element found");
//						return elem1;
						if(driver.findElement(By.xpath("//p[contains(text(),'This message is shown with small delay')]")).isDisplayed())
						  {
							  System.out.println("Element found");
							  return driver.findElement(By.xpath("//p[contains(text(),'This message is shown with small delay')]"));
							  
						  }
						  else
							  System.out.println("Element searching");
							  return null;
					}
				});
		
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'This message is shown with small delay')]")).getText());
		
	}
}
