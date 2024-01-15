import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
		
		// need to capture all names from the column
		List<WebElement> namesElements =driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
		
		List<String> names=new ArrayList<String>();
		//by looping adding names in empty list names
		for(WebElement namesElement:namesElements)
		{
			names.add(namesElement.getText());
		}
		
		String nextbutton=driver.findElement(By.id("example_next")).getAttribute("class");
		while(!nextbutton.contains("disabled"))
		{
			driver.findElement(By.id("example_next")).click();
			namesElements =driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			
			for(WebElement namesElement:namesElements)
			{
				names.add(namesElement.getText());
			}
			nextbutton=driver.findElement(By.id("example_next")).getAttribute("class");
		}
		for(String name:names)
		{
			System.out.println(name);
		}
		int totalnames=names.size();
		System.out.println("Total number of names:"+totalnames);
		
		String displayedcount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("Total number of displayed names:"+displayedcount);
		
		Assert.assertEquals(displayedcount, String.valueOf(totalnames));
		Thread.sleep(8000);
		
	}

}
