package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class seleniumDay1 {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Windows user (need to pass extension .exc) for chrome driver
		//working fine now only change is file extension is exe not exc
		//Setup system for chrome
		System.setProperty("webdriver.chrome.driver","C:\\Sonal\\testing\\Jar_files\\chromedriver_win32\\chromedriver.exe");
		
		//Mac OS(no need to pass extension)
		//System.setProperty("webdriver.chrome.driver","C\\Users\\abhij\\Downloads\\chromedriver_win32\\chromedriver");

		//Setup system for Firefox
		//System.setProperty("webdriver.gecko.driver","C:\\Sonal\\testing\\Jar_files\\geckodriver_32\\geckodriver.exe");
		
		//Initiate the chromedriver
		driver=new ChromeDriver();
		
		//to maximize browser
		driver.manage().window().maximize();
		
		//pass the URL of web app
		driver.get("http://selenium-prd.firebaseapp.com/");
		//Instead of Thread sleep use this timewait in starting so dont need to put everywhere 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Thread.sleep(3000);
		WebElement UserName=driver.findElement(By.id("email_field"));
		UserName.sendKeys("admin123@gmail.com");
		
		WebElement Password=driver.findElement(By.id("password_field"));
		Password.sendKeys("admin123");
		
		WebElement LoginButton=driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		LoginButton.click();
		
		//Thread.sleep(5000);
		/*WebElement HomeTab=driver.findElement(By.cssSelector("body:nth-child(2) div:nth-child(2) div.navbar > a:nth-child(1)"));
		HomeTab.click();
		
		Thread.sleep(3000);
		WebElement Name=driver.findElement(By.name("name"));
		Name.sendKeys("Sonal");
		
		WebElement FatherName=driver.findElement(By.id("lname"));
		FatherName.sendKeys("Patil");
		
		WebElement PostalAddress=driver.findElement(By.id("postaladdress"));
		PostalAddress.sendKeys("postaladdress line1");
		
		WebElement PersonalAddress=driver.findElement(By.id("personaladdress"));
		PersonalAddress.sendKeys("personaladdress line2");
		
		WebElement Sex_Female=driver.findElement(By.xpath("//span[2]//input[1]"));
		Sex_Female.click();
		
		WebElement CityName=driver.findElement(By.id("city"));
		Select citydropdown=new Select(CityName);
		citydropdown.deselectByIndex(3);*/
		
		
		
		
		/*WebElement windowsTab=driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
		windowsTab.click();
		WebElement openNewTab=driver.findElement(By.xpath("//a[1]//button[1]"));
		openNewTab.click();
		String primaryWindow=driver.getWindowHandle();
		
		for(String handel:driver.getWindowHandles())
		{
			System.out.println("Number of Handels" +handel);
			driver.switchTo().window(handel);
		}
		WebElement googleSearch=driver.findElement(By.name("q"));
		googleSearch.sendKeys("selenium");
		Thread.sleep(3000);
	driver.switchTo().window(primaryWindow);*/
	
	/*WebElement switchTo=driver.findElement(By.className("dropbtn"));
	switchTo.click();
	System.out.println("switch tab selected");
	
	WebElement Tab=driver.findElement(By.xpath("//a[contains(text(),'Tabs')]"));
	Tab.click();
	System.out.println("alert tab");
	Thread.sleep(2000);*/
		
		/*WebElement clickLondon=driver.findElement(By.xpath("//button[contains(text(),'London')]"));
		clickLondon.click();
		WebElement textLondon=driver.findElement(By.xpath("//p[contains(text(),'London is the capital city of England.')]"));
		System.out.println(textLondon.getText());
		*/

		
		//WebElement windowAlert=driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		//windowAlert.click();
		/*WebElement promptAlert=driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
		promptAlert.click();
		Thread.sleep(4000);
		System.out.println("Prompt alert clicked");
		
		//Alert switchAlert=driver.switchTo().alert();
		
		Alert switchAlert=driver.switchTo().alert();
		
		//switchAlert.sendKeys("Sonal");
		Thread.sleep(4000);
		//switchAlert.accept();  // click ok on pop up and display name
		switchAlert.dismiss(); //click cancel and pop up dismisses
		System.out.println("click on pop up ok/cancel to close pop up window");
		
		WebElement userMessage=driver.findElement(By.xpath("//p[@id='Selenium']"));
		System.out.println(userMessage.getText());
		*/
		
		WebElement switchTo=driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		Actions action=new Actions(driver);
		action.moveToElement(switchTo).build().perform();
		System.out.println("Mouse over action performed on swich tab");
		WebElement windowsTab=driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
		windowsTab.click();
		
		//Thread.sleep(5000);
		//close the driver
		driver.quit();
	}

}
