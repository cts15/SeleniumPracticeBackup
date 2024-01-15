import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WaitPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.findElement(By.id("APjFqb")).sendKeys("hello world");
		driver.findElement(By.cssSelector("//input[@value='Google Search']")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.name("abcd")).click();

	}

}
