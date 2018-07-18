package base;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.PropUtil;

public class SelectDriver {
	public  WebDriver driverName(){
		String web = null;
		try {
			PropUtil p=new PropUtil("my.properties");
			web = p.getProp("brower");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		 if (StringUtils.equalsAnyIgnoreCase(web, "firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Program Files\\geckodriver.exe");
			return new FirefoxDriver();
		}else{
			System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
