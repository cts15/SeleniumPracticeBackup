import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class calendarpractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		driver.findElement(By.id("second_date_picker")).click();
		while(!driver.findElement(By.xpath("//div[@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']")).getText().contains("December"))
		{

			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Next']")).click();

		}
	
		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=driver.findElements(By.className("ui-state-default")).size();

		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.className("ui-state-default")).get(i).getText();
		if(text.equalsIgnoreCase("21"))
		{
		driver.findElements(By.className("ui-state-default ui-state-highlight ui-state-hover")).get(i).click();
		break;
		}

		}
		
		
	}

}
