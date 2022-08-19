package week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_52_CreateWorkTypeGroupwithoutmandatoryfields {

	public static void main(String[] args) throws InterruptedException {
//		String name="saleforce";
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  
//          1. Login to https://login.salesforce.com
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
//			4. Click on the Dropdown icon in the Work Type Groups tab
		driver.findElement(By.xpath("//span[text()='Work Type Groups']/following::div/one-app-nav-bar-menu-button/a/lightning-icon/lightning-primitive-icon[1]")).click();
		Thread.sleep(1000);
//			5. Click on New Work Type Group
		WebElement NWTG = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click()",NWTG);
//			7.Enter Description as 'Automation'.
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("automation");
//			8.Select Group Type as 'Capacity'
		driver.findElement(By.xpath("//span[text()='Group Type']/following::div/div/div/div/a")).click();
		driver.findElement(By.xpath("//a[text()='Capacity']")).click();
//			9. Click on Save
		driver.findElement(By.xpath("//span[text()='Save & New']/following::button/span")).click();
//			10. Verify the Alert message (Complete this field) displayed for Work Type Group Name
		String GT = driver.findElement(By.xpath("//ul[@class='has-error uiInputDefaultError uiInput uiInputText uiInput--default uiInput--input']")).getText();
		System.out.println(GT);
		String find="Complete this field";
		if(GT.contains(find)) {
			System.out.println("field is empty");
					}
		else {
			System.out.println("field is not empty");
		}
		driver.close();

	}

}
