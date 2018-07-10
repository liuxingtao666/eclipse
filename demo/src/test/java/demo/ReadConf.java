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
 /*������
  * ��������3����
  * 1���proputil��ȡproperties�ļ�
  * 2�ٴη�װpack_by����
  * 3�û��������������ʽ������ҲӦ���Ƿŵ�properties�ļ��еģ�����Ϊ�˶����շ�����map���ϴ��棩
  */

	 
			public WebDriver  driver;
			
			//��ʼ��driver
			public void InitDriver() throws InterruptedException{
				String  url="https://www.imooc.com";
				System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.findElement(By.id("js-signin-btn")).click();
				Thread.sleep(3000);
			}
			
			//��½
			public void  loginScript(String para_user,String para_pass) throws InterruptedException, Exception{
				 
				 
				//�ű�
				WebElement autologin=this.findele(this.pack_by("autologin"));
				autologin.click();
				WebElement username=this.findele(this.pack_by("user"));
				username.isDisplayed();//�ж�Ԫ���Ƿ�ɼ�
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
				if ("Ľ��1917095012".equals(name)) {
				System.out.println("����ͨ��");
				}else{
					System.out.println("������ͨ��");
				}
				driver.close();
				 
			}
			
		
		 
			//��װBy
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
					System.out.println("û�и�Ԫ��");
					return null;
				}
			}
			
		//��װElement
		  private WebElement findele(By by) {
			return driver.findElement(by);

		}
		  //���
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
