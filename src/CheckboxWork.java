import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxWork {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//select checkbox
		System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click();
		driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected();
		System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
		
		//count checkbox
		System.out.println("Number of Checkboxes:" + driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		// Using while loop
//		int i=1;
//		while(i<4)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//		}
		for(int i=1; i<5; i++) //using for loop
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	

	}

}
