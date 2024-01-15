import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Mercury{
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", PATH_TO_EXE_FINAL);
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://uat.mercuryfinancial.co.in/pages/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id ='mat-input-2']")).sendKeys("v0023");
		driver.findElement(By.xpath("//input[@id ='mat-input-3']")).sendKeys("advisor@10062021");
		driver.findElement(By.xpath("//span[contains(text(),'LOGIN')]")).click();
		
		//Thread.sleep(12000);
		WebElement element1 = driver.findElement(By.xpath("//fuse-sidebar[@name='navbar']"));
		Actions userAction = new Actions(driver);
		userAction.moveToElement(element1).perform();
		
		WebElement element2 = driver.findElement(By.xpath("//fuse-nav-vertical-collapsable/a/span[contains(text(),'Commission')]"));
		element2.click();
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Receivable Report')]")).click();
		//Thread.sleep(8000);
		driver.findElement(By.xpath("//body/app[1]/vertical-layout-1[1]/div[1]/div[2]/div[1]/div[1]/content[1]/app-commission[1]/div[1]/div[1]/div[1]/app-receivable-report[1]/form[1]/div[1]/div[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[4]/mat-datepicker-toggle[1]/button[1]/span[1]/mat-icon[1]")).click();
		
		//for selecting Year
		List<WebElement> calelements = driver.findElements(By.xpath("//mat-datepicker-content[1]/mat-calendar[1]/div[1]/mat-multi-year-view[1]/table[1]/tbody[1]/tr[2]/td[4]"));
		for (int i=0; i<calelements.size();i++)
			{
			//System.out.println(calelements.get(i).getText());

			//Selecting the month
			if(calelements.get(i).getText().equalsIgnoreCase("2023"))
			{ 
			  
				driver.findElements(By.xpath("//div[contains(text(),'2023')]")).get(i).click();

					    break;				
			}
			}
		//for selecting Month
			List<WebElement> monthelements = driver.findElements(By.xpath("//mat-year-view/table/tbody/tr/td"));
			for (int j=0; j<monthelements.size();j++)
			{
				
				for (WebElement d:monthelements)
				{ 
				if(d.getText().equalsIgnoreCase("Feb"))
				{
				d.click();
				//Thread.sleep(10000);
				break;
				}
				}
				break;	
			}
			driver.findElement(By.xpath("//mat-radio-button[@value='AMC']")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Go To')]")).click();
			Thread.sleep(8000);
			//to click on AMC link
			List<WebElement> tableelements = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td/span"));
			for (int a=0; a<tableelements.size();a++)
			{
			//Selecting the particular AMC
			if(tableelements.get(a).getText().equalsIgnoreCase("MIRAE ASSET MUTUAL FUND"))
			{ 
			  
				driver.findElements(By.xpath("//span[contains(text(),'MIRAE ASSET MUTUAL FUND')]")).get(a).click();

					    break;				
			}
			}
		
	}		
}
		


