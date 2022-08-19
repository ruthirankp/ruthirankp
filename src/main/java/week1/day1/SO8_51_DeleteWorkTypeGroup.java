package week1.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.an.E;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SO8_51_DeleteWorkTypeGroup {

	
	public static void main(String[]args) throws InterruptedException 
	{
		String name="saleforce";
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
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
		WebElement wtg = driver.findElement(By.xpath("//a[contains(@title,'Work Type Groups')]"));
		driver.executeScript("arguments[0].click();",wtg);
		Thread.sleep(1000);
//			5. Search the Work Type Group 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys(name,Keys.ENTER);
//			6. Click on the Dropdown icon and Select Delete
		WebElement JC = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/span"));
        driver.executeScript("arguments[0].click();",JC);
        Thread.sleep(5000);
		WebElement CDD = driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]/span/descendant::a"));
		driver.executeScript("arguments[0].click();",CDD);
		//driver.executeScript("arguments[0].click();",CDD);
		WebElement CD = driver.findElement(By.xpath("//div[text()='Delete']"));
		driver.executeScript("arguments[0].click();",CD);
		Thread.sleep(1000);
//			7.Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
//			8. Verify Whether Work Type group is Deleted using Work Type Group Name
		driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys("saleforce",Keys.ENTER);
		String GT = driver.findElement(By.xpath("//table/tbody/tr/th")).getText();
		System.out.println("search text is "+GT);
		//List<E> list=new ArrayList<E>();
		//list.add((E) driver.findElement(By.xpath("//table/tbody/tr/th")));
			//	System.out.println("saved item in list "+list);
				if(GT.contains(name))
					
				{
		   System.out.println("salefroce is not completed deleted");
				}
		     else {
			System.out.println("salefroce is  deleted");
		}
					
		driver.close();


}
	}
