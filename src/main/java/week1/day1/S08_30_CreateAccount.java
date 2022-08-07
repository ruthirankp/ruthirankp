package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_30_CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();  
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		    1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		//Thread.sleep(1000);
//			2. Click on toggle menu button from the left corner
		driver.findElement(By.className("slds-icon-waffle")).click();    
//			3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
//			4. Click on Accounts tab
		WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
		 driver.executeScript("arguments[0].click();",accounts);
		 //driver.executeScript("arguments[0].scrollIntoView();",accounts);
//			5. Click on New button
		 driver.findElement(By.xpath("//div[@title='New']")).click();
//			6. Enter 'your name' as account name
		 driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("ruthiran");
//			7. Select Ownership as Public 
		 driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]")).click();
		 driver.findElement(By.xpath("//span[text()='Public'][1]")).click();
//			8. Click save and verify Account name 
		 driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		
		
		
		
		
	}

}
