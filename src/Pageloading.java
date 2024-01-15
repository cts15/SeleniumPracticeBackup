import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pageloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		Options.setPageLoadStrategy(PageLoadStrategy.NONE);
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		
		driver.get("https://automationstepbystep.com/");
		driver.quit();
		

	}

}
