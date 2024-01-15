import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\schitra\\Documents\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Traverse from Parent to Sibling & Sibling to Sibling
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//Traverse from Sibling to Parent 
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).click();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText()+" TestCasePassed");


	}

}
