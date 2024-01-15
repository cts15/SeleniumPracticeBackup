import java.util.List;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.internal.junit.ArrayAsserts;
import org.testng.Assert;


public class ScrollDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//to scroll page using javascript
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(1000);
		//to scroll inside table or any element in webpage
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//to get sum of column in given table in page
		List<WebElement> amtval=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		
		for(int i=0; i<amtval.size(); i++)
		{
		sum = sum + Integer.parseInt(amtval.get(i).getText());
		}
		
		System.out.println(sum);
		String valtxt= driver.findElement(By.cssSelector(".totalAmount")).getText();
		String[] actualtxt= valtxt.split(":");
		int amttxt=Integer.parseInt(actualtxt[1].trim());
		Assert.assertEquals(sum,amttxt);
	}

}
