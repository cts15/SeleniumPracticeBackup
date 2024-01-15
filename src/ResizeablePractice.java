import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ResizeablePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		
		  driver.get("https://jqueryui.com/resizable/");
		  
		  //First switch to frame 
		  driver.switchTo().frame(0); 
		  //then find element to increase-decrease size 
		  WebElement resizeframe=driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		  
		  Actions a=new Actions(driver);
		  a.clickAndHold(resizeframe).moveByOffset(60,40).release(resizeframe).build().perform();
		 
		
		//to select all items in list
		/*
		 * driver.get("https://jqueryui.com/selectable/"); //First switch to frame
		 * driver.switchTo().frame(0); List<WebElement>
		 * selecteditems=driver.findElements(By.xpath("//ol/li"));
		 * 
		 * WebElement selectedFirst = driver.findElement(By.xpath("//ol/li[1]"));
		 * WebElement selectedlast = driver.findElement(By.xpath("//ol/li[7]"));
		 * 
		 * Actions a=new Actions(driver); int i=0; for(i=0; i<selecteditems.size(); i++)
		 * {
		 * a.clickAndHold(selectedFirst).moveToElement(selectedlast).release().build().
		 * perform(); break; }
		 */
	}

}
