import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Windowshandlepractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		Set<String> windows = driver.getWindowHandles(); 
		java.util.Iterator<String> it =windows.iterator();
		String parentid =it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		
		driver.findElement(By.tagName("h1")).getText();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		
		driver.switchTo().window(parentid);
		System.out.println(driver.findElement(By.linkText("Top Deals")).getText());   
	}

}
