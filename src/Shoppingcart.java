import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Shoppingcart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// it takes 5 seconds for every step to trigger
		driver.findElement(By.xpath("//a[contains(text(),'Phones & PDAs')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'iPhone')]")).click();
		
		driver.findElement(By.xpath("//ul[@class='thumbnails']/li[1]")).click();
		//to view images in slideshow
		for(int i=1; i<6;i++)
		{	
			 Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
		}
		driver.findElement(By.xpath("//button[@title='Close (Esc)']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("input-quantity")).clear();
		driver.findElement(By.id("input-quantity")).sendKeys("2");
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Laptops & Notebooks')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'HP LP3065')]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		driver.findElement(By.xpath("//i[@class='fa fa-calendar']")).click();
	}

}
