import java.util.Set;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiWindows_Tab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");

		driver.switchTo().newWindow(WindowType.TAB);
		
		//steps to handle multiple windows
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindow=it.next();
		String childwindow=it.next();
		driver.switchTo().window(childwindow);
		
		driver.get("https://www.selenium.dev/blog/");
		String childtext= driver.findElement(By.xpath("//div[@class='col-12']/h2[1]")).getText();
		driver.switchTo().window(parentWindow);
		
		//to write text fetched from child window in parent window
		driver.findElement(By.xpath("//span[@class='DocSearch-Button-Container']")).click();
		WebElement searchbtn=driver.findElement(By.id("docsearch-input"));
		searchbtn.sendKeys(childtext);
		driver.quit();
		
	}

}
