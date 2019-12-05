package Selenium;

import org.openqa.selenium.JavascriptExecutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SFDC {

	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	public static void main(String[] args) throws Exception {
		setUpDriver();
		setUpReport();
		//Navigation(String MenuText);
		//loginmain();
		//TC1_loginErrorMessage();
        //TS2_loginToSFDC();
		//TC3_rememberMeCheckBox();
		//TC4_forgotpasswordA();
		//TC5_forgotpasswordB();
		//TC05_usermenudropdown();
		//TC06_selectmyprofile();  
		//TC07_SelectMysettingsoption();
		//TC08_SelectDevelopersConsole();
		//TC09_logout();
		//TC10_CreatAccount();
		//TC11_Creatnewview();
		//TC12_Editview();
		//TC13_Mergeaccount();
		//TC14_CreataccountReport(); 
		//TC15_SelectUserMenu();  
		//TC16_CreatenewOpty();
		//TC17_TestOptyPipeline();
		//TC18_TestStuckOpty();
		//TC19_TestQuarterlysummary();
		//TC20_LeadsTab();
		//TC21_validatedropdown(); 
		//TC22_FunctionalityofGoButton(); 
		//TC23_TodaysLeadswork();
		//TC24_ChecNewbuttonOnLeadsHome();
		//TC25_Createnewcontact();  //talk with shweta
		//TC26_CreatenewviewintheContactPage();
		//TC27_CheckrecentlycreatedcontactintheContactPage();
		//TC28_CheckMycontactsviewintheContactPage();
		//TC29_ViewacontactinthecotactPage();
		//TC30_ChecktheErrormessage();
		//TC31_ChecktheCancelbutton();
		//TC32_ChecktheSaveandNewbutton(); 
		tearDownDriver();
	}
		public static void setUpDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Sonal\\testing\\Jar_files\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        System.out.println("chrome driver lunched");
		
		//to maximize browser
		driver.manage().window().maximize();
		
		//Instead of Thread sleep use this timewait in starting so dont need to put everywhere 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//pass the URL of web app
		driver.get("https://login.salesforce.com/");
		}
		
		public static void setUpReport() {
			String fileName=new SimpleDateFormat("'SampleDemo_'yyyymmddHHmm'.html'").format(new Date());
			//String filename="salesforce"+String.valueOf(LocalDateTime.now())+".html";
			String path="C:/Sonal/testing/Selenium liveproject/ExtendReport/"+fileName;
			reports=new ExtentReports(path);
		}
		public static void loginmain() {
			logger=reports.startTest("Test Login");
			WebElement UserName=driver.findElement(By.xpath("//input[@id='username']"));
			UserName.sendKeys("abhijit0001@gmail.com");
			logger.log(LogStatus.PASS, "User name entered");
			//System.out.println("user name entered");
			WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			password.sendKeys("Maythis@1234");
			logger.log(LogStatus.PASS, "Password is entered");
			//System.out.println("password entered");
			WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
			loginButton.click();
			logger.log(LogStatus.PASS, "Click login button");
			try {
			WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
			
			PopupWin.click();
			
			}
			catch(Exception E)
			{
				logger.log(LogStatus.INFO, "Pop up did not displayed");
			}

			
			//System.out.println("click login button");
			reports.endTest(logger);
		}
		
		public static void Navigation(String MenuText) {
			
			switch(MenuText) {
			case "Accounts":
				break;
			case "Leads":
				break;
			case "Opportunities":
				break;
			case "Conatct":
				driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
				logger.log(LogStatus.PASS, "Click on contact button ");
				break;
			case "My Profile":
				break;
			case "My Settings":
				break;
			case "Developer Console" :
				break;
				
			
			default :
				
			}
			try {
				WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
				
				PopupWin.click();
				
				}
				catch(Exception E)
				{
					logger.log(LogStatus.INFO, "Pop up did not displayed");
				}
			
		}
		
		public static void TC1_loginErrorMessage() throws IOException {
			System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
			
			FileInputStream file=new FileInputStream(System.getProperty("user.dir") +"\\TestData\\TC_1_Login_blankpass.xls");
			HSSFWorkbook workbook=new HSSFWorkbook(file);
			HSSFSheet sheet=workbook.getSheet("Sheet1");
			int rowCount=sheet.getLastRowNum();
			for(int i=1;i<rowCount;i++)
			{
				HSSFRow row=sheet.getRow(i);
				HSSFCell userName=row.getCell(3);
				HSSFCell password=row.getCell(4);
				
			}
			String val=sheet.getRow(1).getCell(2).getStringCellValue();
			System.out.println(val);
			logger=reports.startTest("login Error Message");
		WebElement UserName=driver.findElement(By.xpath("//input[@id='username']"));
		UserName.sendKeys("userName");
		logger.log(LogStatus.INFO, "User name is entered");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		//password.clear();
		password.sendKeys("password");
		logger.log(LogStatus.INFO, "Password kept blank");
		WebElement LoginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		LoginButton.click();
		logger.log(LogStatus.INFO, "Click on login");
		WebElement errorMessage=driver.findElement(By.xpath("//div[@id='error']"));
		String actualErrorMessage=errorMessage.getText();
		String expectedErrorMessage="Please enter your password";
		logger.log(LogStatus.INFO, "Please enter correct password");
		if(actualErrorMessage.equals(expectedErrorMessage))
		{
			//System.out.println("pass:correct error message displayed");
			logger.log(LogStatus.INFO, "pass:correct error message displayed");
		}
		else
			//System.out.println("fail:incorrect error message displayed");
			logger.log(LogStatus.INFO, "Fail:incorrect error message displayed");
		reports.endTest(logger);
		}
		
		public static void TS2_loginToSFDC() {
			logger=reports.startTest("Login to SFDC");
			WebElement UserName=driver.findElement(By.xpath("//input[@id='username']"));
			UserName.sendKeys("sonu1002-pvku@force.com");
			logger.log(LogStatus.PASS, "User name entered");
			//System.out.println("user name entered");
			WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			password.sendKeys("Maythis@1234");
			logger.log(LogStatus.PASS, "Password is entered");
			//System.out.println("password entered");
			WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
			loginButton.click();
			logger.log(LogStatus.PASS, "Click login button");
			//System.out.println("click login button");
			reports.endTest(logger);
			
	}
		
		public static void TC3_rememberMeCheckBox()
		{
			logger=reports.startTest("Test Login");
		WebElement UserName=driver.findElement(By.xpath("//input[@id='username']"));
		logger.log(LogStatus.PASS, "User name entered");
		UserName.sendKeys("sonu1002-pvku@force.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Maythis@1234");
		logger.log(LogStatus.PASS, "Password is entered");
		WebElement rememberMeCheckBox=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		rememberMeCheckBox.click();
		logger.log(LogStatus.PASS, "Click remember me check box");
		//System.out.println("remember me check box");
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		logger.log(LogStatus.PASS, "Click login button");
		//System.out.println("click login button");
		
		WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		PopupWin.click();
		logger.log(LogStatus.PASS, "Click popup window button");
		
		WebElement userProfile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		userProfile.click();
		logger.log(LogStatus.PASS, "Click user profile button");
		//System.out.println("click user profile button");
		WebElement logOut=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut.click();
		logger.log(LogStatus.PASS, "Click logout button");
		//System.out.println("click logout button");
		WebElement verifyUserName=driver.findElement(By.xpath("//span[contains(text(),'sonu1002-pvku@force.com')]"));
		String actualUserName=verifyUserName.getAttribute("innerHTML");
		String expectedUserName="sonu1002-pvku@force.com";
		
		if(actualUserName.equals(expectedUserName))
		{
			//System.out.println("pass:correct error message displayed");
			logger.log(LogStatus.PASS, "pass:correct error message displayed");
		}
		else
			logger.log(LogStatus.PASS, "fail:incorrect error message displayed");
			//System.out.println("fail:incorrect error message displayed");
        
		
		}
		
		public static void TC4_forgotpasswordA(){
			logger=reports.startTest("Forgot password A");
		WebElement forgotPassword=driver.findElement(By.xpath("//a[@id='forgot_password_link']"));	
		forgotPassword.click();
		logger.log(LogStatus.INFO, "click on forgot password link");
		WebElement userName=driver.findElement(By.xpath("//input[@id='un']"));
		userName.sendKeys("sonu1002-pvku@force.com");
		logger.log(LogStatus.INFO, "enter username");
		WebElement continew=driver.findElement(By.xpath("//input[@id='continue']"));
		continew.click();
		logger.log(LogStatus.INFO, "Click on continue button");
		}
		
		public static void TC5_forgotpasswordB() {
			logger=reports.startTest("forgot password B");
		WebElement wrongUserName=driver.findElement(By.xpath("//input[@id='username']"));
		wrongUserName.sendKeys("123");
		logger.log(LogStatus.PASS, "wrong User name entered");

		WebElement wrongPassword=driver.findElement(By.xpath("//input[@id='password']"));
		wrongPassword.sendKeys("22131");
		logger.log(LogStatus.PASS, "wrong Password is entered");

		WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		logger.log(LogStatus.PASS, "Click login button");

		}
		
		public static void TC05_usermenudropdown() {
			logger=reports.startTest("Select user menu for <username> drop down");
			WebElement UserName=driver.findElement(By.xpath("//input[@id='username']"));
			UserName.sendKeys("sonu1002-pvku@force.com");
			logger.log(LogStatus.PASS, "wrong User name entered");
			System.out.println("user name entered");
			WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
			password.sendKeys("Maythis@1234");
			logger.log(LogStatus.PASS, "Password is entered");
			System.out.println("password entered");
			WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
			loginButton.click();
			logger.log(LogStatus.PASS, "Click login button");

			WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
			PopupWin.click();
			logger.log(LogStatus.PASS, "Click Popup Window button");

			//System.out.println("click on popup window button");
			WebElement userMenu=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			userMenu.click();
			logger.log(LogStatus.PASS, "Click on user profile menu and check for dropdown");
		}
		
		public static void TC06_selectmyprofile() throws InterruptedException {
			logger=reports.startTest("Select My Profile option from user menu for username drop down");
		/*
		 * WebElement UserName=driver.findElement(By.xpath("//input[@id='username']"));
		 * UserName.sendKeys("sonu1002-pvku@force.com"); logger.log(LogStatus.PASS,
		 * "User name entered"); //System.out.println("user name entered"); WebElement
		 * password=driver.findElement(By.xpath("//input[@id='password']"));
		 * password.sendKeys("Maythis@1234"); logger.log(LogStatus.PASS,
		 * "Password is entered"); //System.out.println("password entered"); WebElement
		 * loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		 * loginButton.click(); logger.log(LogStatus.PASS, "Click login button");
		 * WebElement PopupWin =
		 * driver.findElement(By.xpath("//a[@id='tryLexDialogX']")); PopupWin.click();
		 * logger.log(LogStatus.PASS, "Click Popup Window button");
		 *///System.out.println("click login button");
			WebElement userMenu=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			userMenu.click();
			logger.log(LogStatus.PASS, "Click on user profile menu and check for dropdown");
			WebElement myProfile=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
			myProfile.click();
			logger.log(LogStatus.PASS, "Select my profile from user menu and Click on it");
			Thread.sleep(4000);
			WebElement editProfile=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
			String parentWindow= driver.getWindowHandle();
			int size = driver.findElements(By.tagName("iframe")).size();
		    // prints the total number of frames inside outer frame           
		    System.out.println("Total Frames after EditLink --" + size);
			
			editProfile.click();
			 size = driver.findElements(By.tagName("iframe")).size();
		    // prints the total number of frames inside outer frame           
		    System.out.println("Total Frames -- after Edit Link" + size);
			//WebElement editProfileFrm = driver.findElement(By.xpath("//div[@id='contactInfoContentId']"));
			//driver.switchTo().frame("contactInfoContentId");
			driver.switchTo().frame(size-1); // Switching to innerframe
		   // System.out.println(driver.findElement(By.xpath("//div[@id='contactInfoContentId']")).getText());
			logger.log(LogStatus.PASS, "see for edit profile button anad click on it");
			WebElement about=driver.findElement(By.xpath("//a[contains(text(),'About')]"));
			////a[contains(text(),'About')]
			about.click();
			logger.log(LogStatus.PASS, "click on about button");

			WebElement enterLastName=driver.findElement(By.xpath("//input[@id='lastName']"));
			enterLastName.clear();
			enterLastName.sendKeys("Abhi");
			logger.log(LogStatus.PASS, "enter last name as Abhi");

			//WebElement saveAllButton=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
			//saveAllButton.click();
			
			WebElement CancelButton=driver.findElement(By.xpath("//input[@id='editContactInfoCancelButton']"));
			CancelButton.click();
			logger.log(LogStatus.PASS, "click on save button");

			//size = driver.findElements(By.tagName("iframe")).size();
		    // prints the total number of frames inside outer frame           
		    //System.out.println("Total Frames after Cancel or save--" + size);
		    driver.switchTo().parentFrame();
			//WebElement postButton=driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
		    WebElement postButton=driver.findElement(By.xpath("//span[contains(text(),'Post')]"));
		    postButton.click();
			size = driver.findElements(By.tagName("iframe")).size();
		    // prints the total number of frames inside outer frame           
		    System.out.println("Total Frames --" + size);
		    //driver.switchTo().frame(2); 
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.cke_wysiwyg_frame.cke_reset")));
		    WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		    body.sendKeys("How are you doing?");
			logger.log(LogStatus.PASS, "Click on post button and enter text as how are you? in the body");
 		    driver.switchTo().defaultContent();
		    WebElement shareButton=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
			//shareButton.click();
			logger.log(LogStatus.PASS, "Click on share button for Post");

			//Click on File
			//span[contains(@class,'publisherattachtext')][contains(text(),'File')]
			WebElement FileButton=driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
			FileButton.click();
			logger.log(LogStatus.PASS, "Click on File Link");
			WebElement UploadLink=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
			UploadLink.click();
			logger.log(LogStatus.PASS, "Click on Upload a file from your computer");
			//input[@id='chatterFile']
			WebElement UploadFile=driver.findElement(By.xpath("//input[@id='chatterFile']"));
			String strUploadFilePath = System.getProperty("user.dir") +"\\TestData\\TC_06_File.docx";
			UploadFile.sendKeys(strUploadFilePath);
			logger.log(LogStatus.PASS, "File upload from loacation " + strUploadFilePath);
		    shareButton.click();
			logger.log(LogStatus.PASS, "Click on share button for File Upload");

			
		}
		
		public static void TC07_SelectMysettingsoption() throws InterruptedException {
			//loginmain();
			logger=reports.startTest("Select My settings option from user menu for <username> drop down");
			WebElement userMenu=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			userMenu.click();
			logger.log(LogStatus.PASS, "Click on user profile menu and check for dropdown");
			WebElement mySetting=driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
			mySetting.click();
			logger.log(LogStatus.PASS, "Click on My Setting from user menu");
			WebElement personalButton=driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
			personalButton.click();
			logger.log(LogStatus.PASS, "Click on personal Button");
			WebElement loginHistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
			loginHistory.click();
			logger.log(LogStatus.PASS, "Click on login History Button");
			WebElement downloadlink=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
			downloadlink.click();
			WebElement displayAndLayout=driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
			displayAndLayout.click();
			WebElement customizeMyTabLink=driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
			customizeMyTabLink.click();
			WebElement customApp=driver.findElement(By.xpath("//select[@id='p4']"));
			Select SalesForceChatter = new Select(customApp);
			SalesForceChatter.selectByIndex(3);
			
			WebElement availableTabListBox=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
			WebElement SelectedTabsListBox=driver.findElement(By.xpath("//select[@id='duel_select_1']"));////select[@id='duel_select_1']
			
			Select reportSelected=new Select(SelectedTabsListBox);
		    //Get all options
		    List<WebElement> SelectedTabOptions = reportSelected.getOptions();

		    //Get the length
		    System.out.println(SelectedTabOptions.size());

		    // Loop to print one by one
		    for (int j = 0; j < SelectedTabOptions.size(); j++) 
		    {
		        if(SelectedTabOptions.get(j).getText().equals("Reports"))
		        {
		        	
		        	reportSelected.selectByVisibleText("Reports");
		        	WebElement RemoveButton=driver.findElement(By.xpath("//img[@class='leftArrowIcon']"));
		        	RemoveButton.click();
		        	break;
		        }
		    }
		    Select report=new Select(availableTabListBox);
			report.selectByVisibleText("Reports");
			WebElement addButton=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
			addButton.click();
			WebElement saveButton=driver.findElement(By.xpath("//input[@name='save']"));
			saveButton.click();
			
			WebElement MySetting=driver.findElement(By.xpath("//span[contains(text(),'My Settings')]"));
			MySetting.click();			
			
			WebElement email=driver.findElement(By.xpath("//span[@id='EmailSetup_font']"));
			email.click();
			WebElement myEmailSetting=driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
			myEmailSetting.click();
			WebElement emailName=driver.findElement(By.xpath("//input[@id='sender_name']"));
			emailName.sendKeys("Sonal");
			WebElement emailAddress=driver.findElement(By.xpath("//input[@id='sender_email']"));
			emailAddress.sendKeys("abhijit0001@gmail.com");
			WebElement radioButton=driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
			radioButton.click();
			WebElement saveButton1=driver.findElement(By.xpath("//input[@name='save']"));
			saveButton1.click();
			WebElement calenderAndReminder=driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
			calenderAndReminder.click();
			WebElement activityReminder=driver.findElement(By.xpath("//span[@id='Reminders_font']"));
			activityReminder.click();
			 String MainWindow=driver.getWindowHandle();		
	     		System.out.println("Main hdl "+ MainWindow);
			WebElement previewReminder=driver.findElement(By.xpath("//input[@id='testbtn']"));
			previewReminder.click();
			Thread.sleep(4000);
			Set<String> windowIterator = driver.getWindowHandles();
	        System.err.println("No of windows :  " + windowIterator.size());
	        for (String s : windowIterator) {
	        	
	          String windowHandle = s; 
	          System.out.println("Inside Loop " +  windowHandle);
	          if (!MainWindow.equals(windowHandle)) {
	          WebDriver popup =driver.switchTo().window(windowHandle);
	          System.out.println("Window Title : " + popup.getTitle());
	          System.out.println("Window Url : " + popup.getCurrentUrl());
	          //popup.close();
	          //driver.switchTo().window(windowHandle).close();
	         
	          
	         WebElement dissmissAll=popup.findElement(By.xpath("//input[@id='dismiss_all']"));
	         dissmissAll.click();
	          }
	        }
	       // driver.close();
	        driver.switchTo().window(MainWindow);
	        Set<String> windowIterator1 = driver.getWindowHandles();
	        System.err.println("No of windows after :  " + windowIterator1.size());

		}
		public static void TC08_SelectDevelopersConsole() throws InterruptedException{
			loginmain();
			logger=reports.startTest("Select Developers Console option from user menu for <username> drop down");
			WebElement userMenu=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			userMenu.click();
			logger.log(LogStatus.PASS, "Click on user profile menu and check for dropdown");
			String parent = driver.getWindowHandle();
			System.out.println("Main Window " + parent);
			logger.log(LogStatus.PASS, "Main window"+parent);

			WebElement developerConsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
			developerConsole.click();
			logger.log(LogStatus.PASS, "click on developerConsole");

			for (String winhandle: driver.getWindowHandles()) {
				
			    driver.switchTo().window(winhandle);
				logger.log(LogStatus.PASS, "Window Switch to developerConsole");

			   // System.out.println("Window Switch developerConsole");        
			    Thread.sleep(2000);
			}
			driver.close();// To close developerConsole window
			logger.log(LogStatus.PASS, "Closed  developerConsole Window");

			//System.out.println("Closed Window developerConsole");
			driver.switchTo().window(parent);
					
		}
		public static void TC09_logout() {
			loginmain();
			logger=reports.startTest("Select Logout option from user menu for <username> drop down");
			WebElement userMenu=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			userMenu.click();
			logger.log(LogStatus.PASS, "Click on user profile menu and check for dropdown");
			WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logout.click();
			logger.log(LogStatus.PASS, "click on logout button");

			
		}
		
		public static void TC10_CreatAccount() {
			loginmain();
			logger=reports.startTest("Create account report");
			WebElement account=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			account.click();
			logger.log(LogStatus.PASS, "click on Account button");
			WebElement newAccount=driver.findElement(By.xpath("//input[@name='new']"));
			newAccount.click();
			logger.log(LogStatus.PASS, "click on new account button , new account will be created");
		}
		
		public static void TC11_Creatnewview() {
			loginmain();
			logger=reports.startTest("Create new view");
			WebElement account=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			account.click();
			logger.log(LogStatus.PASS, "click on Account button");
			WebElement creatnewview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			creatnewview.click();
			logger.log(LogStatus.PASS, "click on new view button , new view of your account will be created");

			
		}
		
		public static void TC12_Editview() {
			loginmain();
			logger=reports.startTest("Edit view");
			WebElement account=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			account.click();
			logger.log(LogStatus.PASS, "click on Account button");
			Select selectView = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
			selectView.selectByVisibleText("Ridhima Patil Updated");
			logger.log(LogStatus.PASS, "select view by visiblt/by index");

			WebElement EditLink =driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
			EditLink.click();
			//System.out.println("Edit Link Click");
			logger.log(LogStatus.PASS, "click Edit Link");

			
			WebElement PageTitel =driver.findElement(By.xpath("//h2[@class='pageDescription']"));
			if (PageTitel.getText().toString().equals("Edit View")) {
				System.out.println("Edit View Page Found");
				logger.log(LogStatus.PASS, "Edit View Page Found");
			}else {
				System.out.println("Edit View Page not Found");
				logger.log(LogStatus.PASS, "Edit View Page not Found");
			}
			//View Name Update
			WebElement viewName =driver.findElement(By.xpath("//input[@id='fname']"));
			viewName.clear();
			viewName.sendKeys("RidhimaPatil12");
			logger.log(LogStatus.PASS, "update new view name");
			//Account Field 1
			Select AccountSelectField1 = new Select (driver.findElement(By.xpath("//select[@id='fcol1']")));
			AccountSelectField1.selectByVisibleText("Account Name");
			logger.log(LogStatus.PASS, "select a field named account name");
			Select operator = new Select (driver.findElement(By.xpath("//select[@id='fop1']")));
			operator.selectByVisibleText("contains");
			logger.log(LogStatus.PASS, "select operator named contains");
			WebElement FilterValue =driver.findElement(By.xpath("//input[@id='fval1']"));
			FilterValue.clear();
			FilterValue.sendKeys("a");
			logger.log(LogStatus.PASS, "send filter value as <a>");
			Select AvailableFields = new Select (driver.findElement(By.xpath("//select[@id='colselector_select_0']")));
			AvailableFields.selectByVisibleText("Last Activity");
			logger.log(LogStatus.PASS, "select Last activity text from available Fields"); 
			WebElement AddButton =driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
			AddButton.click();
			logger.log(LogStatus.PASS, "click on Add button");
			//Save Button
			List <WebElement> SaveButton =(List<WebElement>) driver.findElements(By.xpath("//input[@type='submit' and @class='btn primary']"));
			SaveButton.get(1).click();
			logger.log(LogStatus.PASS, "click on save button");

					
		}
		
		public static void TC13_Mergeaccount() {
			loginmain();
			logger=reports.startTest("Merge account");
			WebElement account=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			account.click();
			logger.log(LogStatus.PASS, "click on Account button");
			try {
				WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
				
				PopupWin.click();
				
				}
				catch(Exception E)
				{
					logger.log(LogStatus.INFO, "Pop up did not displayed");
				}
			WebElement mergeaccount=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
			mergeaccount.click();
			logger.log(LogStatus.PASS, "click on Merge Account button");
			
			WebElement accountName=driver.findElement(By.xpath("//input[@id='srch']"));
			accountName.sendKeys("Un");
			logger.log(LogStatus.PASS, "send account name as Ge and select teo or more account from the serch result");
			WebElement findaccounts=driver.findElement(By.xpath("//input[@name='srchbutton']"));
			findaccounts.click();
			List <WebElement> AccountCkBox =(List<WebElement>) driver.findElements(By.xpath("//input[@name='cid']"));
			for (int i=1; i<=2;i++){
			      AccountCkBox.get(i).click();
			    } 
			WebElement NextButton =driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='goNext']"));
			NextButton.click();
			logger.log(LogStatus.PASS, "click on next button");
			WebElement MergeButton =driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
			MergeButton.click();
			logger.log(LogStatus.PASS, "click on Merge Account button");

			
			driver.switchTo().alert().accept();
			
		}
		
		public static void TC14_CreataccountReport() {
			loginmain();
			logger=reports.startTest("Merge account");

			WebElement account=driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
			account.click();
			logger.log(LogStatus.PASS, "click on Account button");
			try {
				WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
				
				PopupWin.click();
				
				}
				catch(Exception E)
				{
					logger.log(LogStatus.INFO, "Pop up did not displayed");
				}
			WebElement accountlastActivity=driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
			accountlastActivity.click();
			logger.log(LogStatus.PASS, "click on Account last activity button");

			WebElement todaysDateFrom=driver.findElement(By.xpath("//input[@id='ext-comp-1042']"));
			 // Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
			//get current date time with Date()
			 Date date = new Date();
			  // Now format the date
			 String TodaysDate= dateFormat.format(date);
			 todaysDateFrom.sendKeys(TodaysDate);
				logger.log(LogStatus.PASS, "Entered today's date :from");

			WebElement todaysDateTo=driver.findElement(By.xpath("//input[@id='ext-comp-1045']"));
			 todaysDateFrom.sendKeys(TodaysDate);
				logger.log(LogStatus.PASS, "Entered today's date :to");

			 WebElement saveButton=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
			 saveButton.click();
				logger.log(LogStatus.PASS, "click on save button");

			 
			 //driver.switchTo().window();
			
		}
		
		public static void TC15_SelectUserMenu() {
			loginmain();
			logger=reports.startTest("Select User Menu");
			WebElement apportunity=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			apportunity.click();
			logger.log(LogStatus.PASS, "click on Apportunity button");
			try {
				WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
				
				PopupWin.click();
				
				}
				catch(Exception E)
				{
					logger.log(LogStatus.INFO, "Pop up did not displayed");
				}

			WebElement select = driver.findElement(By.xpath("//select[@id='fcf']"));
			//WebElement option = ((Select) select).getFirstSelectedOption();
			Select reportSelected=new Select(select);
		    //Get all options
		    List<WebElement> SelectedTabOptions = reportSelected.getOptions();

		    //Get the length
		    int itemCount = SelectedTabOptions.size();

		    for(int l = 0; l < itemCount; l++)
		    {
		        System.out.println(SelectedTabOptions.get(l).getText());
		        logger.log(LogStatus.INFO, SelectedTabOptions.get(l).getText());
		    }
		    
		    //System.out.println(SelectedTabOptions.size());
			//String selectedValueInDropDown = SelectedTabOptions.getText();
			
			//logger.log(LogStatus.PASS, "Verify opportunities drop down is present");
			
		}
		
		public static void TC16_CreatenewOpty() {
			loginmain();
			logger=reports.startTest("Create new Opportunity");
			WebElement apportunity=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			apportunity.click();
			logger.log(LogStatus.PASS, "click on Apportunity button");
			WebElement newopty=driver.findElement(By.xpath("//input[@name='new']"));
			newopty.click();
			logger.log(LogStatus.PASS, "click on new Apportunity button");
			WebElement optyName=driver.findElement(By.xpath("//input[@id='opp3']"));
			optyName.sendKeys("pqr");
			logger.log(LogStatus.PASS, "Pass opportunity name as pqr");
			WebElement accountName=driver.findElement(By.xpath("//input[@id='opp4']"));
			accountName.sendKeys("rid1");
			logger.log(LogStatus.PASS, "Pass account name as rid1");
			WebElement Date=driver.findElement(By.xpath("//input[@id='opp9']"));
			Date currentDate = new Date();  
			String dateToStr = DateFormat.getInstance().format(currentDate);
			String date[]= dateToStr.split(" ");
			logger.log(LogStatus.PASS, "Date is entered");
			Select Stage = new Select (driver.findElement(By.xpath("//select[@id='opp11']")));
			Stage.selectByVisibleText("Qualification");
			logger.log(LogStatus.PASS, "selected Qualification from the dropdown ");
			WebElement probability=driver.findElement(By.xpath("//input[@id='opp12']"));
			probability.sendKeys("10");
			logger.log(LogStatus.PASS, "pass probability 10 ");
			Select leadSource=new Select(driver.findElement(By.xpath("//select[@id='opp6']")));
			leadSource.selectByVisibleText("Advertisement");
			logger.log(LogStatus.PASS, "select Advertisment ");
			WebElement savebutton=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
			savebutton.click();
			logger.log(LogStatus.PASS, "Click on save button ");

		}
		
		public static void TC17_TestOptyPipeline() {
			loginmain();
			logger=reports.startTest("Test Opportunity Pipeline");
			WebElement opportunity=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			opportunity.click();
			logger.log(LogStatus.PASS, "Click on opportunity button ");
			WebElement optyPipeline=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
			optyPipeline.click();
			logger.log(LogStatus.PASS, "Click on optyPipeline button ");
		}
		
		public static void TC18_TestStuckOpty() {
			loginmain();
			logger=reports.startTest("Test stuck opportunity ");
			WebElement opportunity=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			opportunity.click();
			logger.log(LogStatus.PASS, "Click on opportunity button ");
			WebElement stuckopportunity=driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
			stuckopportunity.click();
			logger.log(LogStatus.PASS, "Click on stuck opportunity button ");
		}
		
		public static void TC19_TestQuarterlysummary(){
			loginmain();
			logger=reports.startTest("Test Quarterly summary ");
			WebElement opportunity=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
			opportunity.click();
			logger.log(LogStatus.PASS, "Click on opportunity button ");
			WebElement quarterlysummary=driver.findElement(By.xpath("//h3[contains(text(),'Quarterly Summary')]"));
			quarterlysummary.click();
			logger.log(LogStatus.PASS, "Click on quarterly summary button ");
			Select Interval=new Select(driver.findElement(By.xpath("//select[@id='quarter_q']")));
			Interval.selectByVisibleText("Current FQ");
			logger.log(LogStatus.PASS, "select current FQ ");
			//Select Interval=new Select(driver.findElement(By.xpath("//select[@id='quarter_q']")));
			//Interval.selectByVisibleText("Next FQ");
			Select Include=new Select(driver.findElement(By.xpath("//select[@id='open']")));
			Include.selectByVisibleText("All Opportunities");
			logger.log(LogStatus.PASS, "Include app opprtunities ");
			WebElement RunReport=driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']"));
			RunReport.click();
			logger.log(LogStatus.PASS, "Click on Run Report button ");
		}
		
		public static void TC20_LeadsTab() {
			loginmain();
			logger=reports.startTest("Test for Leads Tab ");
			WebElement leadtab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
			leadtab.click();
			logger.log(LogStatus.PASS, "Click on Leads Tab button ");
		}
		
		public static void TC21_validatedropdown() {
			loginmain();
			logger=reports.startTest("Test for Leads Tab ");
			WebElement leadtab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
			leadtab.click();
			logger.log(LogStatus.PASS, "Click on Leads Tab button ");
			WebElement dropdown=driver.findElement(By.xpath("//select[@id='fcf']"));
			Select reportSelected=new Select(dropdown);
		    //Get all options
		    List<WebElement> SelectedTabOptions = reportSelected.getOptions();

		    //Get the length
		    int itemCount = SelectedTabOptions.size();

		    for(int l = 0; l < itemCount; l++)
		    {
		        System.out.println(SelectedTabOptions.get(l).getText());
		        logger.log(LogStatus.INFO, SelectedTabOptions.get(l).getText());
		    }
		    
			
		}
		
		public static void TC22_FunctionalityofGoButton() {
			loginmain();
			logger=reports.startTest("Test for Functionality of Go Button ");
			WebElement leadtab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
			leadtab.click();
			logger.log(LogStatus.PASS, "Click on Leads Tab button ");
			try {
				WebElement PopupWin = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
				
				PopupWin.click();
				
				}
				catch(Exception E)
				{
					logger.log(LogStatus.INFO, "Pop up did not displayed");
				}
			Select viewdrpodown=new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
			viewdrpodown.selectByVisibleText("Today's Leads");
			logger.log(LogStatus.PASS, "from view drop down select todays leads ");
			WebElement userprofile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			userprofile.click();
			logger.log(LogStatus.PASS, "Click on user profile button ");
			WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logout.click();
			logger.log(LogStatus.PASS, "Click on logout button ");
			loginmain();
			WebElement leadtab1=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
			leadtab1.click();
			logger.log(LogStatus.PASS, "Click on Leads Tab button ");
			WebElement goButton=driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));			
			goButton.click();
			logger.log(LogStatus.PASS, "Click on go button ");

		}
		
		public static void TC23_TodaysLeadswork() {
			loginmain();
			logger=reports.startTest("Test for Todays Leads Button works ");
			WebElement leadtab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
			leadtab.click();
			logger.log(LogStatus.PASS, "Click on Leads Tab button ");
			WebElement viewMenu=driver.findElement(By.xpath("//select[@id='fcf']"));
			Select view=new Select(viewMenu);
			logger.log(LogStatus.PASS, "select view dropdown ");
			view.selectByIndex(3);
			logger.log(LogStatus.PASS, "select Todays Leads and it will disaplay Todays Leads page ");

			}
		
		public static void TC24_ChecNewbuttonOnLeadsHome() {
			loginmain();
			logger=reports.startTest("Test for Check New button On Leads Home ");
			WebElement leadtab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
			leadtab.click();
			logger.log(LogStatus.PASS, "Click on Leads Tab button ");
			WebElement newButton=driver.findElement(By.xpath("//input[@name='new']"));
			newButton.click();
			logger.log(LogStatus.PASS, "Click on NEW button ");
			WebElement lastName=driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
			lastName.sendKeys("PQRS");
			logger.log(LogStatus.PASS, "Enter PQRS as a last name ");
			WebElement companyName=driver.findElement(By.xpath("//input[@id='lea3']"));
			companyName.sendKeys("PQRS");
			logger.log(LogStatus.PASS, "Enter PQRS as a company name ");
			WebElement saveButton=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
			saveButton.click();
			logger.log(LogStatus.PASS, "Click on save button ");
		}
		
		public static void TC25_Createnewcontact() {
			loginmain();
			
			WebElement ContactNewLink = driver.findElement(By.xpath("//input[@name='new']"));
			ContactNewLink.click();

			logger=reports.startTest("Test for Create new contact ");
			Navigation("Contact");
//			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
//			logger.log(LogStatus.PASS, "Click on contact button ");
			logger.log(LogStatus.PASS, "Click on new button ");
			driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("<lastName>");
			logger.log(LogStatus.PASS, "Enter last name as <lastName> ");
			driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("<AccountName>");
			logger.log(LogStatus.PASS, "Enter Account name as <AccountName> ");
			driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']")).click();
			logger.log(LogStatus.PASS, "Click on save button ");

		}
		public static WebElement getElement(String locater,String ByType) {
			WebElement ObjElement = null;
			switch (ByType) {
			case "xpath":
				ObjElement = driver.findElement(By.xpath(locater));
			break;
			case "id":
				ObjElement = driver.findElement(By.id(locater));
			break;
			}
			
			return ObjElement;
		}
		public static void TC26_CreatenewviewintheContactPage() {
			loginmain();
			logger=reports.startTest("Test for Create new contact ");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			logger.log(LogStatus.PASS, "Click on contact button ");
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			logger.log(LogStatus.PASS, "Click on create new view ");
			driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("<viewName>");
			logger.log(LogStatus.PASS, "Enter view name as <viewName> ");
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("Uniqueviewname");
			logger.log(LogStatus.PASS, "Enter view name as Unique view name ");
			driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
			logger.log(LogStatus.PASS, "Click on save button ");
		}
		
		public static void TC27_CheckrecentlycreatedcontactintheContactPage() {
			loginmain();
			logger=reports.startTest("Test for Check recently created contact in the Contact Page");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			logger.log(LogStatus.PASS, "Click on contact button ");
			WebElement dropdown=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
			Select recentlyCreated=new Select(dropdown);
			logger.log(LogStatus.PASS, "click on dropdown to select recently created ");
			recentlyCreated.selectByIndex(0);
			logger.log(LogStatus.PASS, "Recently created contact will be displayed ");

		}
		
		public static void TC28_CheckMycontactsviewintheContactPage() {
			loginmain();
			logger=reports.startTest("Test for Check My contacts view in the Contact Page");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			logger.log(LogStatus.PASS, "Click on contact button ");	
			Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='fcf']"))) ;
			dropdown.selectByVisibleText("My Contacts");
			logger.log(LogStatus.PASS, "select My Contacts from the drop down ");	
			logger.log(LogStatus.PASS, "My contact list will be displayed ");	

		}
		public static void TC29_ViewacontactinthecotactPage() {
			loginmain();
			logger=reports.startTest("Test for View a contact in the contact Page");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			logger.log(LogStatus.PASS, "Click on contact button ");	
			driver.findElement(By.xpath("//a[contains(text(),'Escober (Sample), Jack')]")).click();
			logger.log(LogStatus.PASS, "Click on a contact name under the Name field in the Recent Contact Frame , info of that contact name will display");	

		}
		public static void TC30_ChecktheErrormessage() {
			loginmain();
			logger=reports.startTest("Test for Check the Error message if, the required information is not entered while creating a New view in Contacts");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			logger.log(LogStatus.PASS, "Click on contact button ");	
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			logger.log(LogStatus.PASS, "Click on Create New View ");	
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
			logger.log(LogStatus.PASS, "Enter unique name as EFGH ");	
			driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
			logger.log(LogStatus.PASS, "Click on save button ");
			logger.log(LogStatus.PASS, "Error message is appeared under the View Name field. The Error message appears as \"Error: You must enter a value\". ");	
		}
		
		public static void TC31_ChecktheCancelbutton() {
			loginmain();
			logger=reports.startTest("Test for Check the Cancel button works fine in Create New View");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			logger.log(LogStatus.PASS, "Click on contact button ");	
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			logger.log(LogStatus.PASS, "Click on Create New View ");
			driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ABCD");
			logger.log(LogStatus.PASS, "Enter view name as ABCD ");
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
			logger.log(LogStatus.PASS, "Enter unique name as EFGH ");
			driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']")).click();
			logger.log(LogStatus.PASS, "Click on cancel, Contacts Home page is displayed and the View ABCD should not be created. ");

		}
		
		public static void TC32_ChecktheSaveandNewbutton() {
			loginmain();
			logger=reports.startTest("Test for Check the Cancel button works fine in Create New View");
//			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
//			logger.log(LogStatus.PASS, "Click on contact button ");
			Navigation("Contacts");
			
			driver.findElement(By.xpath("//input[@name='new']")).click();
			logger.log(LogStatus.PASS, "Click on new button ");
			driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Indian");
			logger.log(LogStatus.PASS, "Enter Indian as last name  ");
			driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("Global Media");
			logger.log(LogStatus.PASS, "Enter account name as  Global Media");
            driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']")).click();
			logger.log(LogStatus.PASS, "Click on save and new button ");
			logger.log(LogStatus.FAIL,"New contact is created. Contact Edit: New Contact Page is dispalyed");


		}
		public static void tearDownDriver() throws Exception
		{
			Thread.sleep(5000);	
			reports.endTest(logger);
			reports.flush();
			driver.close();
		}

	
}



