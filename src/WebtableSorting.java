import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebtableSorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column then capture all value in list Then capture text into new list then apply sort
		// then compare original list & compared list
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> veglist= driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text into new list 
		List<String> originallist=  veglist.stream().map(s->s.getText()).collect(Collectors.toList());
		//then apply sort
		List<String> sortedlist=originallist.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originallist.equals(sortedlist));
		
		//scan veg column for name using gettext ->Rice -> print the price of it
		List<String> price;
	do
	{
		List<WebElement> rowslist= driver.findElements(By.xpath("//tr/td[1]"));	
		price=rowslist.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);	
		
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue=s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		
		return pricevalue;
	}

}
