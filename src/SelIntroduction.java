import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//Invoking Browser
		//Chrome - ChromeDriver ->Method
		
	    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\schitra\\Documents\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		
		ChromeDriver driver = new ChromeDriver(options);
		
		
		// to maximize window
		driver.manage().window().maximize();
		// methods
		driver.get("https://www.udemy.com/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.name("q")).sendKeys("Selenium Java");
		//driver.findElement(By.className("ud-icon-color-neutral")).click();
		
		
			
		
		//Firefox - FirefoxDriver ->Method
		//FirefoxDriver driver1 = new FirefoxDriver();
		
		//driver1.get("https://www.udemy.com/");
		//System.out.println(driver1.getTitle());
		//System.out.println(driver1.getCurrentUrl());
	
	    //Microsft Edge - EdgeDriver ->Method
	  // EdgeDriver driver2 = new EdgeDriver();
			
	 // driver2.get("https://www.udemy.com/");
	//System.out.println(driver2.getTitle());
	//System.out.println(driver2.getCurrentUrl());
		
		//driver.close();
	}


}
