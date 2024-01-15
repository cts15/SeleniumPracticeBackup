import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebTable_Sorting_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://kitchen.applitools.com/ingredients/table");
		
		//click on column then capture all value in list Then capture text into new list then apply sort
		// then compare original list & compared list
		driver.findElement(By.id("column-button-name")).click();
		
		List<WebElement> listitems= driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text into list
		List<String> orilist=listitems.stream().map(s->s.getText()).collect(Collectors.toList());
		//then apply sort
		List<String> sortlist = orilist.stream().sorted().collect(Collectors.toList());
		
		//compare original list with sorted list
		Assert.assertTrue(orilist.equals(sortlist));
		
		//scan veg column for name using gettext ->Onion -> print the flavour of it
		List<String> flavor=listitems.stream().filter(s->s.getText().contains("Onion")).map(s->getFlavor(s)).collect(Collectors.toList());
		flavor.forEach(a->System.out.println(a));
				
	}
	
	private static String getFlavor(WebElement s) {

		String flavortext=s.findElement(By.xpath("//tr[5]/td[3]")).getText();

		return flavortext;

		   }

}
