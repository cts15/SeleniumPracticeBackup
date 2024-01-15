import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MultiWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windhandle= driver.getWindowHandles();
		Iterator<String> it=windhandle.iterator();
		String parentwindow= it.next();
		String childwindow=it.next();
		driver.switchTo().window(childwindow);
		driver.get("https://rahulshettyacademy.com/");
		
		String coursename= driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentwindow);
		
		WebElement txtboxname =driver.findElement(By.xpath("//div[@class='form-group'][1]/input"));
		txtboxname.sendKeys(coursename);
		//File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		System.out.println("Height"+txtboxname.getRect().getDimension().getHeight());
		System.out.println("Width"+txtboxname.getRect().getDimension().getWidth());		

	}

}
