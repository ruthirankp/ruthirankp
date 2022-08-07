package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_6_CreateWorkTypeGroup {

	public static void main(String[] args) throws InterruptedException {
		String entername="saleforce";
		WebDriverManager.chromedriver().setup();
		ChromeOptions Option=new ChromeOptions();
		Option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(Option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		    1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
//			2. Click on the toggle menu button from the left corner
		driver.findElement(By.className("slds-icon-waffle")).click();
//			3. Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("work type groups",Keys.ENTER);
		//driver.findElement(By.xpath("//mark[text()='Work Type Groups']]")).click();
		driver.executeScript("scroll(0,1000);");
		WebElement groupslect = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		driver.executeScript("arguments[0].click();",groupslect);
//			4. Click on the Dropdown icon in the Work Type Groups tab
		driver.findElement(By.xpath("//span[text()='Work Type Groups']/following::div/one-app-nav-bar-menu-button/a/lightning-icon/lightning-primitive-icon[1]")).click();
		Thread.sleep(1000);
//			5. Click on New Work Type Group
		WebElement NWTG = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click()",NWTG);
//			6. Enter Work Type Group Name as 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(entername);
//			7.Click save and verify Work Type Group Name
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")).click();
		String verify = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
				System.out.println("saved name in work type:"+verify);
		if(verify.contains(entername))
		{
		System.out.println("condition verified");
		}
		else
		{
			System.out.println("condition not verified");
		}
		driver.close();
		}

}

