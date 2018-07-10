package demo;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.PropUtil;
import util.TestngListener;

@Listeners({TestngListener.class})
	public class TakePicture extends BaseDriver{
	 /*第五天
	  *  封住手动截图方法实现在TestngListener.java中
	  */

				//初始化driver
				public void InitDriver() throws InterruptedException{
					String  url="https://www.imooc.com";
					driver.get(url);
					driver.manage().window().maximize();
					driver.findElement(By.id("js-signin-btn")).click();
					Thread.sleep(3000);
				}
				
				//登陆
				public void  loginScript(String para_user,String para_pass) throws InterruptedException, Exception{
					 
					 
					//脚本
					WebElement autologin=this.findele(this.pack_by("autologin"));
					autologin.click();
					WebElement username=this.findele(this.pack_by("user"));
					username.isDisplayed();//判断元素是否可见
					WebElement pass=this.findele(this.pack_by("pass"));
					pass.isDisplayed();
					WebElement button=this.findele(this.pack_by("button"));
					button.isDisplayed();
					username.sendKeys(para_user);
					pass.sendKeys(para_pass);
					button.click();
					Thread.sleep(5000);
					WebElement logo=this.findele(this.pack_by("logo"));
					Actions builder = new Actions(driver);
					builder.moveToElement(logo).perform(); 
					String name=this.findele(By.cssSelector("header-user-card > div > div > div.card-top.clearfix > div > a > span")).getText();
					if ("65656".equals(name)) {
					System.out.println("用例通过");
					
					}else{
						System.out.println("用例不通过");
					}
					//driver.close();
					 
				}
				
			
			 
				//封装By
				public  By  pack_by(String ele) throws Exception {
					
					PropUtil p=new PropUtil("a.properties");
					String para_user=p.getProp(ele);
					if (para_user.contains(",")) {
						String selectorType=para_user.split(",")[0];
						String selector=para_user.split(",")[1];
					if ("cssSelector".equals(selectorType)) {
						return By.cssSelector(selector);
					}else if ("id".equals(selectorType)) {
						return By.id(selector);
					}else if("class".equals(selectorType)){
						return By.className(selector);
					}else{
						return null;
					}
					}else{
						System.out.println("没有改元素");
						return null;
					}
				}
				
			//封装Element
			  private WebElement findele(By by) {
				return driver.findElement(by);

			}
			
		@Test
		public void testdemo() throws Exception {
			TakePicture login=new TakePicture();
			login.InitDriver();
			login.loginScript("18792749809", "20190523lmr");
			
			
		}
		
		
		
}
