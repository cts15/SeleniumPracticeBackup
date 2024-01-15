import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendar_2 {
	public static void main(String[] args)
	{
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//to check which month is visible currently
		String[] monthyear=driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
		//System.out.println(monthname[0]);
		
		String monthname=monthyear[0];
		String year=monthyear[1];
		
		while(!(monthname.equalsIgnoreCase("November") && (year.equalsIgnoreCase("2023"))))
		{
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
			monthyear=driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
			monthname=monthyear[0];
			year=monthyear[1];
		}
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='20']")).click();
	}
}
