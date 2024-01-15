import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//print no. rows, no.of columns & txt from row 2
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> rowcount= driver.findElements(By.cssSelector(".table-display tr"));
		int row = rowcount.size();
		System.out.println("Number of rows:"+row);
		
		List<WebElement> colcount = driver.findElements(By.cssSelector(".table-display th"));
		int col = colcount.size();
		System.out.println("Number of columns:"+col);
		
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
	}

}
