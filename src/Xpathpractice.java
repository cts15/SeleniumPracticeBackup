import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xpathpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> row=driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		int rowscount=row.size();
		System.out.println("Number of rows:"+rowscount);
		
		List<WebElement> col=driver.findElements(By.xpath("//table[@class='dataTable']//th"));
		int colcount=col.size();
		System.out.println("Number of columns:"+colcount);
		
		System.out.println("First Row of the table:"+driver.findElement(By.xpath("//table[@class='dataTable']//tr[3]")).getText());
		
		//List<WebElement> dyntext=driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[1]"));
		//String sCellValue = driver.findElement(By.xpath("//table[@class='dataTable']//tr/td")).getText();
		//System.out.println("First Row of the table:"+sCellValue);
		
	      Actions actions = new Actions(driver);
		String sRowValue = "Welspun Corp";	
		List<WebElement> dyntext=driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[1]"));
		for(int i =0;i<dyntext.size();i++)

		{
			if(dyntext.get(i).getText().equalsIgnoreCase(sRowValue))
			{
				actions.moveToElement(dyntext.get(i)).perform();
				System.out.println("Found");
				break;
			}	
			else
			{
				System.out.println("Not Found");
				break;
			}

		}
	
			}
		


}
