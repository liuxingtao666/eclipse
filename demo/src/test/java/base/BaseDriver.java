package base;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseDriver {
	
	Logger log=Logger.getLogger(BaseDriver.class);
	public WebDriver driver;
	
	public BaseDriver() {
		SelectDriver  sd=new SelectDriver();
		this.driver=sd.driverName();
	}
	
	public void stop() {
		log.info("关闭浏览器");
		driver.close();
	} 

	/*
	 * 封装element
	 */
	public WebElement findElement(By by) {
		WebElement elemtent =driver.findElement(by);
		return elemtent;
	}
	//手动截图方法封装
		public void dotake() throws Exception {
			File pickturefile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir");
			path=path+"\\"+"screenshot";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String time=sdf.format(System.currentTimeMillis());
			String name=this.getClass().getName();
			String p=time+"_"+name+".png";
			System.out.println(path+"/"+p);
			FileUtils.copyFile(pickturefile, new File(path+"/"+p));
		}
}
