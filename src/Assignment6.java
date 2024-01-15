import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//select checkbox & get text of it then Go to dropdown same as grabbed label of checkbox
		//Enter the step 2 grabbbed label text in textbox
		//click on alert & verify if Text grabbed in Step 2 is present in popup
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String chkval=driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(chkval);
		
		WebElement drp=driver.findElement(By.id("dropdown-class-example"));
		Select drpdown =new Select(drp);
		drpdown.selectByVisibleText(chkval);
		
		Thread.sleep(500);
		driver.findElement(By.id("name")).sendKeys(chkval);
		
		driver.findElement(By.id("alertbtn")).click();
		
		Thread.sleep(1000);
		String alertxt= driver.switchTo().alert().getText();
		if(alertxt.contains(chkval))
		{
			System.out.println("Text present");
		}
		else
		{
			System.out.println("Test fail");
		}

	}

}
