import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Testname");
		driver.findElement(By.name("email")).sendKeys("Test@example.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password123");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement staticdropdown1 = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown1 = new Select(staticdropdown1);
		Thread.sleep(1000);
		dropdown1.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.name("bday")).sendKeys("23-04-1998");
		
		driver.findElement(By.className("btn-success")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.cssSelector(".alert-dismissible")).getText());
		
		
	}

}
