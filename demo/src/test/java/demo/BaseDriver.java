package demo;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
	public WebDriver  driver;
	//初始化driver
	public   BaseDriver(){
	
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver.exe");
		driver=new ChromeDriver();
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
