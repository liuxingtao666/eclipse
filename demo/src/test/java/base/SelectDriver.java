package base;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
	public  WebDriver driverName(String web) {
		if (StringUtils.equalsAnyIgnoreCase(web, "firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Program Files\\geckodriver");
			return new FirefoxDriver();
		}else{
			System.setProperty("webdriver.chromedriver.driver", "D:\\Program Files\\chromedriver");
			return new ChromeDriver();
		}
	}
}
