import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RealtimeExcercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//to count number of links in page
		int linkcount=driver.findElements(By.tagName("a")).size();
		System.out.println("Number of links in page::"+linkcount);
		
		//to get count of links in footer
		WebElement footerlink= driver.findElement(By.xpath("//body/div[@id='gf-BIG']")); //limiting webdriver scope
		int footercount=footerlink.findElements(By.tagName("a")).size();
		System.out.println("Number of links in footer::"+footercount);
		
		//to get count of links of 1st column in footer section
		WebElement footerfirst= footerlink.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		//int footerfirstlink=footerfirst.findElements(By.tagName("a")).size();
		System.out.println("Number of links in footer first section::"+footerfirst.findElements(By.tagName("a")).size());
		
		//to click on each column & check if links are opening 
		for(int i=0; i<footerfirst.findElements(By.tagName("a")).size(); i++)
		{
			String clickontab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerfirst.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
		}
		
		//to get title of tab opened
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
