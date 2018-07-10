package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PackageDemo {
	/*
	 * 第二天：这个类封装了By 方法和findElement方法
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
		public void  loginScript() throws InterruptedException{
			//参数
			String para_user="18792749809";
			String para_pass="20190523lmr";
			//元素
			String ele_autologin="#auto-signin";
			String ele_user=".xa-emailOrPhone";
			String ele_pass=".ipt.ipt-pwd";
			String ele_button="input.moco-btn";
			String ele_logo="#header-avator";
			//脚本
			//WebElement autologin=driver.findElement(By.cssSelector(ele_autologin));
			WebElement autologin=this.findele(this.pack_by("cssSelector", ele_autologin));
			autologin.click();
			WebElement username=this.findele(this.pack_by("cssSelector", ele_user));
			username.isDisplayed();//判断元素是否可见
			WebElement pass=this.findele(this.pack_by("cssSelector", ele_pass));
			pass.isDisplayed();
			WebElement button=this.findele(this.pack_by("cssSelector", ele_button));
			button.isDisplayed();
			username.sendKeys(para_user);
			pass.sendKeys(para_pass);
			button.click();
			Thread.sleep(3000);
			WebElement logo=this.findele(this.pack_by("cssSelector", ele_logo));
			Actions builder = new Actions(driver);
			builder.moveToElement(logo).perform(); 
			String name=this.findele(By.cssSelector(".name")).getText();
			if ("慕粉1917095012".equals(name)) {
			System.out.println("用例通过");
			}else{
				System.out.println("用例不通过");
			}
			
			 
		}
		
		//入口
		public static void main(String[] args) throws Exception {
			PackageDemo  login=new PackageDemo();
			login.InitDriver();
			login.loginScript();
		}
	 
		//封装By
		public  By  pack_by(String selectorType,String selector) {
			if ("cssSelector".equals(selectorType)) {
				return By.cssSelector(selector);
			}else if ("id".equals(selectorType)) {
				return By.id(selector);
			}else if("class".equals(selectorType)){
				return By.className(selector);
			}else{
				return null;
			}
		}
		
		//封装Element
	  private WebElement findele(By by) {
		return driver.findElement(by);

	}

}
