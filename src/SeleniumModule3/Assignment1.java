 package SeleniumModule3;

 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.Assert;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test; 
 import java.io.IOException;

 public class Assignment1 {

  public WebDriver driver;
  private static Logger log = LogManager.getLogger(Assignment1.class.getName()); 
  
  @BeforeTest
  public void initialize()
  {
	  	driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		driver.manage().window().maximize();
  }				
  @Test
  public void functionality() throws InterruptedException
  {
	  driver.get("https://demo.guru99.com/test/login.html");  
	  String actualtitle = driver.getTitle();
      System.out.println(actualtitle);
      Assert.assertEquals(driver.getTitle(), "Login Page");  //Hard Assertion
      log.info("Title of the page is verfied");   
     
	 WebElement EmailAddress = driver.findElement(By.xpath("//input[@id='email']"));
	 EmailAddress.clear();
	 EmailAddress.sendKeys("gaurav.pathangej@gmail.com");
 
	 WebElement Password = driver.findElement(By.xpath("//input[@id='passwd']"));
	 Password.clear();
	 Password.sendKeys("Gaurav");
	
	 WebElement Button = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
	 Thread.sleep(1000);
	 Button.click();
	}
  
  	@AfterTest
  	public void logout()
  	{
  		driver.close();
  	}
 }
