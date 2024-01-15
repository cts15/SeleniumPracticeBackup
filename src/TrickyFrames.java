import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TrickyFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);

		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		int framessize = driver.findElements(By.tagName("iframe")).size();
		int total =0;
		for(int i=0; i<framessize; i++)
		{
			driver.switchTo().frame(i);

			// Switch the controller 'driver'from default content and onto theframe

			int num= driver.findElements(By.tagName("iframe")).size();       

			// goes inside each outer frame to count the numbers of inner frames inside it (If there is any)

			driver.switchTo().defaultContent();                             

			// switch the controller 'driver' back to default content (main webpage)

			total=total + num;       // represents total number of inner frames for all outer frames
		}
			int Total_Number_Frames= total + framessize;   

		// adds the number of outer frames and inner frames (if there is any) to obtain the total number     of frames on the webpage.

		System.out.println("Total number of Frames on this webpage is: "+ Total_Number_Frames);
		
	}

}
