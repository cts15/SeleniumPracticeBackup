import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticalProbs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://qavbox.github.io/demo/webtable/");
		
		//to scroll page & print last column values
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,800)");
		 * 
		 * Thread.sleep(1000);
		 * js.executeScript("document.querySelector(\"#table02\").scrollTop=1000");
		 * 
		 * List<WebElement> salary=
		 * driver.findElements(By.xpath("//table[@id='table02']/tbody/tr/td[6]")); //int
		 * totalsalary=0;
		 * 
		 * for(int i=0; i<salary.size();i++) { String sal= salary.get(i).getText();
		 * System.out.println(sal); }
		 */
		
		//to print number of rows, columns & 2nd row data
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table02']/tbody/tr"));
		int rowcount=rows.size();
		System.out.println("Total number of rows: "+rowcount);
		
		List<WebElement> cols=driver.findElements(By.xpath("//table[@id='table02']/thead/tr/th"));
		int colscount=cols.size();
		System.out.println("Total number of columns: "+colscount);
		
		System.out.println(driver.findElement(By.xpath("//table[@id='table02']/tbody/tr[2]")).getText());
		
	}

}
