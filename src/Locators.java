import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\schitra\\Documents\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver .findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//xpath
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");		
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).sendKeys("test@mail.com");
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).clear();  // to clear textbox
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).sendKeys("test123@mail.com"); // again enter email after clear
		
		//driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//driver.findElement(By.cssSelector("//input[@type='text']:nth-child(3)")).sendKeys("test123@mail.com"); // again enter email after clear
	
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("4574856844");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form.p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("chkboxOne")).click();

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
