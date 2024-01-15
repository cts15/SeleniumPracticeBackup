import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Relativelocators_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		
		WebElement addresstxt = driver.findElement(By.xpath("//form/div[2]/div"));
		driver.findElement(with(By.tagName("input")).above(addresstxt)).sendKeys("name");
		//System.out.println();
		
		WebElement emailinput=driver.findElement(By.xpath("//input[@type='email']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toLeftOf(emailinput)).getText());
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(emailinput)).getText());
		
		
	}

}
