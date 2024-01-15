import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshotfeature {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		
		driver.findElement(By.xpath("//span[@class='DocSearch-Button-Container']")).click();
		WebElement searchbtn=driver.findElement(By.id("docsearch-input"));
		searchbtn.sendKeys("Application");
		
		//to get partial screenshot
		File file=searchbtn.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//to get dimension i.e. height  & width of webelement
		System.out.println(searchbtn.getRect().getDimension().getHeight());
		System.out.println(searchbtn.getRect().getDimension().getWidth());
				
	}

}
