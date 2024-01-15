import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Actions a=new Actions(driver);
		//to scroll down page
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,900)", "");
		//moves to specific element
		//a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
		 
		
		//To write in Capital Letters
		//a.moveToElement(driver.findElement(By.id("name"))).click().keyDown(Keys.SHIFT).sendKeys("chitra").build().perform();
		
		//to select written value
		//a.moveToElement(driver.findElement(By.id("name"))).click().keyDown(Keys.SHIFT).sendKeys("chitra").doubleClick().build().perform();
		
		//to right click on any element
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		a.moveToElement(driver.findElement(By.xpath("//div[3]/a[2]"))).contextClick().build().perform();
	}
	

}
