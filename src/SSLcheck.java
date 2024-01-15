import java.util.HashMap;

import java.util.Map;



import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		Options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(Options);
		Proxy proxy = new Proxy();

		proxy.setHttpProxy("ipaddress:4444");

		Options.setCapability("proxy", proxy);

		Map<String, Object> prefs = new HashMap<String, Object>();



		prefs.put("download.default_directory", "/directory/path");



		Options.setExperimentalOption("prefs", prefs);

		// FirefoxOptions options1 = new FirefoxOptions();

		// options1.setAcceptInsecureCerts(true);

		// EdgeOptions options2 = new EdgeOptions();

		Options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");



		//WebDriver driver1 = new ChromeDriver(Options);

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

	}

}
