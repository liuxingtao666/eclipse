package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PackageDemo {
	/*
	 * �ڶ��죺������װ��By ������findElement����
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
		public void  loginScript() throws InterruptedException{
			//����
			String para_user="18792749809";
			String para_pass="20190523lmr";
			//Ԫ��
			String ele_autologin="#auto-signin";
			String ele_user=".xa-emailOrPhone";
			String ele_pass=".ipt.ipt-pwd";
			String ele_button="input.moco-btn";
			String ele_logo="#header-avator";
			//�ű�
			//WebElement autologin=driver.findElement(By.cssSelector(ele_autologin));
			WebElement autologin=this.findele(this.pack_by("cssSelector", ele_autologin));
			autologin.click();
			WebElement username=this.findele(this.pack_by("cssSelector", ele_user));
			username.isDisplayed();//�ж�Ԫ���Ƿ�ɼ�
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
			if ("Ľ��1917095012".equals(name)) {
			System.out.println("����ͨ��");
			}else{
				System.out.println("������ͨ��");
			}
			
			 
		}
		
		//���
		public static void main(String[] args) throws Exception {
			PackageDemo  login=new PackageDemo();
			login.InitDriver();
			login.loginScript();
		}
	 
		//��װBy
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
		
		//��װElement
	  private WebElement findele(By by) {
		return driver.findElement(by);

	}

}
