package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseDriver {
	
	Logger log=Logger.getLogger(BaseDriver.class);
	public WebDriver driver;
	
	public BaseDriver(String browser) {
		SelectDriver  sd=new SelectDriver();
		this.driver=sd.driverName(browser);
	}
	
	public void stop() {
		log.info("¹Ø±Õä¯ÀÀÆ÷");
		driver.close();
	} 

	/*
	 * ·â×°element
	 */
	public WebElement findElement(By by) {
		WebElement elemtent =driver.findElement(by);
		return elemtent;
	}
}
