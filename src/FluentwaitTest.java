import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentwaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		Wait<ChromeDriver> wait =new FluentWait<ChromeDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		  WebElement foo = wait.until(new Function<ChromeDriver, WebElement>() 
		  { 
			
			  public WebElement apply(ChromeDriver driver)
			  {
				  if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
				  {
					  System.out.println("Element finding");
					  return driver.findElement(By.cssSelector("[id='finish'] h4"));
					 
				  }
				  else
					  return null;
			  }
		  });
		  System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}

}
