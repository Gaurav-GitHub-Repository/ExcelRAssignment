package SeleniumModule3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment2 {

	public WebDriver driver;
	
	@BeforeTest
	public void initialize()
	{
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		
		String filename = "C:\\Selenium Temp\\Dumps\\AutoSheet.xlsx";
		
		FileInputStream fs = new FileInputStream(filename);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);

		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Thread.sleep(1000);
		String Email = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(Email);
		
		Thread.sleep(1000);
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(Password);
		
	    driver.get("https://demo.guru99.com/test/login.html");
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    WebElement EmailAddress = driver.findElement(By.xpath("//*[@id='email']"));
		EmailAddress.clear();
	    EmailAddress.sendKeys(Email);
	 
	    WebElement Pwd = driver.findElement(By.xpath("//*[@id='passwd']"));
		Pwd.clear();
	    Pwd.sendKeys(Password);
		
        WebElement Button = driver.findElement(By.xpath("//*[@id='SubmitLogin']"));
		Button.click();
     }
	
	@AfterTest
	public void Close()
	{
		driver.close();
		System.out.println("Verified");
	}
	
	}
