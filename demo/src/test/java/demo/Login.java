package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	/*
	 * ��һ�죺�������������Ĵ���
	 */
	
	public WebDriver  driver;
	
	//��ʼ��driver
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	//��½
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
		if ("Ľ��1917095012".equals(name)) {
		System.out.println("����ͨ��");
		}else{
			System.out.println("������ͨ��");
		}
	}

	//���
	public static void main(String[] args) throws Exception{
		Login  login=new Login();
		login.InitDriver();
		login.login_imocc();
	}
}
