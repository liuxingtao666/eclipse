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
	 * ��װ��λelement
	 * @Parameter By by
	 */
	public WebElement element(By by){
		
		WebElement element=driver.findElement(by);
		
		return element;
		
	}
	/*
	 *��װ���
	 */
	public void click(WebElement element){
		if (element!=null) {
			element.click();
		}else{
			log.error(element+"��û�и�Ԫ�أ����ʧ��");
		}
	}
	/*
	 * ��װ����
	 */
	
	public void sendKeys(WebElement element,String keys) {
		if (element!=null) {
			
			element.sendKeys(keys);
		}else{
			log.error(element+":��Ԫ���Ҳ���������ʧ��");
		}
	}
	
	/*
	 * �ж�Ԫ���Ƿ���ʾ
	 */
	public boolean isDisplayed(WebElement element) {
	 
			return	element.isDisplayed();
		 
	}
}
