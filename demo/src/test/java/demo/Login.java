package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	/*
	 * 第一天：这个类是最基础的代码
	 */
	
	public WebDriver  driver;
	
	//初始化driver
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	//登陆
	public void  login_imocc() throws InterruptedException{
		driver.get("https://www.imooc.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("auto-signin")).click();
		driver.findElement(By.cssSelector(".xa-emailOrPhone")).sendKeys("18792749809");
		driver.findElement(By.cssSelector(".ipt.ipt-pwd")).sendKeys("20190523lmr");
		driver.findElement(By.cssSelector("input.moco-btn")).click();
		Thread.sleep(3000);
		WebElement we=driver.findElement(By.cssSelector("#header-avator"));
		Actions builder = new Actions(driver);
		builder.moveToElement(we).perform(); 
		String name=driver.findElement(By.cssSelector(".name")).getText();
		if ("慕粉1917095012".equals(name)) {
		System.out.println("用例通过");
		}else{
			System.out.println("用例不通过");
		}
	}

	//入口
	public static void main(String[] args) throws Exception{
		Login  login=new Login();
		login.InitDriver();
		login.login_imocc();
	}
}
