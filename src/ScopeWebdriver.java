import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScopeWebdriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//to get count of number of links in page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//to get count of links present in Footer section
		WebElement footerlink=driver.findElement(By.id("gf-BIG"));
		footerlink.findElements(By.tagName("a")).size();
		System.out.println(footerlink.findElements(By.tagName("a")).size());

		//to get count of links of 1st column in foooter section
		WebElement columnlink= footerlink.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));	
		System.out.println(columnlink.findElements(By.tagName("a")).size());
		
		//click on each link of column & check if pages are opening
		for(int i=1; i<columnlink.findElements(By.tagName("a")).size(); i++)
		{
			//it helps to open any link in another tab
			String linktab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columnlink.findElements(By.tagName("a")).get(i).sendKeys(linktab);
			Thread.sleep(5000);
			
		}
		
		//to get title of all links opened in different tabs
		Set<String> titlecontain=driver.getWindowHandles();
		Iterator<String> it=titlecontain.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}


}
