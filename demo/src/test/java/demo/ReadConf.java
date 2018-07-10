package demo;

  


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import util.PropUtil;
public class ReadConf {
 /*第三天
  * 这个类干了3件事
  * 1配合proputil读取properties文件
  * 2再次封装pack_by方法
  * 3用户名密码参数化形式（本来也应该是放到properties文件中的，但是为了多掌握方法用map集合代替）
  */

	 
			public WebDriver  driver;
			
			//初始化driver
			public void InitDriver() throws InterruptedException{
				String  url="https://www.imooc.com";
				System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver.exe");
				driver=new ChromeDriver();
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
				String name=this.findele(By.cssSelector(".name")).getText();
				if ("慕粉1917095012".equals(name)) {
				System.out.println("用例通过");
				}else{
					System.out.println("用例不通过");
				}
				driver.close();
				 
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
		  //入口
		  public static void main(String[] args) throws Exception {
				ReadConf  login=new ReadConf();
				HashMap<String,String> map=new HashMap<String, String>();
				map.put("18792749809", "20190523lmr");
				map.put("1879274980sdfsdfsdfsdfdsfdsfsd9", "20190523lmr");
				map.put("18792749809ddd", "20190523lmr");
				Iterator<Map.Entry<String, String>>  it=map.entrySet().iterator();
				
				while (it.hasNext()) {
					Map.Entry<String,String> entry=it.next();
					String name=entry.getKey();
					String pass=entry.getValue();
					System.out.println(name+pass);
					login.InitDriver();
					login.loginScript(name, pass);
				}
			}		
}
