import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignement5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));

		System.out.println(driver.findElement(By.id("content")).getText());
		

	}

}
