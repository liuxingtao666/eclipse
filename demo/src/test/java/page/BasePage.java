package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




import base.BaseDriver;

public class BasePage {
	Logger log=Logger.getLogger(BasePage.class);
	public BaseDriver driver;
	
	public BasePage(BaseDriver driver) {
		this.driver=driver;
	}
	
	/*
	 * 定位element
	 * @Parameter By by
	 */
	public WebElement element(By by){
		
		WebElement element=driver.findElement(by);
		
		return element;
		
	}
	/*
	 *封装点击
	 */
	public void click(WebElement element){
		if (element!=null) {
			element.click();
		}else{
			log.error(element+"：没有该元素，点击失败");
		}
	}
}
