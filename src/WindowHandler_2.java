import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandler_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		
		//parent window to another tab
		/*
		 * driver.findElement(By.id("tabButton")).click();
		 * 
		 * Set<String> windows=driver.getWindowHandles(); java.util.Iterator<String> it
		 * = windows.iterator(); String Parentid = it.next(); String childid =
		 * it.next();
		 * 
		 * driver.switchTo().window(childid);
		 * 
		 * //driver.findElement(By.id("sampleHeading")).getText();
		 * System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		 * driver.switchTo().window(Parentid); System.out.println(driver.getTitle());
		 */
		
		//parent window to child window
		driver.findElement(By.id("messageWindowButton")).click();
		  
		 Set<String> windows=driver.getWindowHandles();
		 java.util.Iterator<String> it= windows.iterator(); 
		 String Parentid = it.next();
		 String childid =it.next();
		 driver.switchTo().window(childid);
		 
		  //driver.findElement(By.id("sampleHeading")).getText();
		 System.out.println(driver.findElement(By.tagName("body")).getText());
		 //driver.switchTo().window(Parentid); System.out.println(driver.getTitle());
		 
		
	}

}
