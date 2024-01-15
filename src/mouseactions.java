import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class mouseactions {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement alphaA= driver.findElement(By.xpath("//li[text()=\"A\"]"));
		WebElement alphaD= driver.findElement(By.xpath("//li[text()=\"D\"]"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(alphaA);
		actions.clickAndHold();
		actions.moveToElement(alphaD);
		actions.release().perform();
		
		

	}

}
