import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Windowshandler {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		
		driver.findElement(By.xpath("//body/a")).click();
		//Return a set of window handles which can be used to iterate over all open windows of thisWebDriver instance by passing them to (parentid,childid)
		Thread.sleep(1000);
		Set<String> windows = driver.getWindowHandles(); 
		java.util.Iterator<String> it =windows.iterator();
		String parentid =it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		Thread.sleep(1000);
		driver.switchTo().window(parentid);

		driver.findElement(By.id("username")).sendKeys(emailId);
	  	
	}

}
