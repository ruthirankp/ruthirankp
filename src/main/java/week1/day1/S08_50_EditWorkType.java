package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_50_EditWorkType {
	public static void main(String[]args)
	{
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
		driver.executeScript("scroll(0,1000);");
		WebElement groupslect = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		driver.executeScript("arguments[0].click();",groupslect);
//			4. Click on the Work Type Group tab 
		
//			5. Search the Work Type Group 'Salesforce Automation by Your Name'
//			6. Click on the Dropdown icon and Select Edit
//			7.Enter Description as 'Automation'.
//			8.Select Group Type as 'Capacity'
//			9.Click on Save
//			10. Click on 'Salesforce Automation by Your Name'and Verify Description as 'Automation'
	}
	

}
