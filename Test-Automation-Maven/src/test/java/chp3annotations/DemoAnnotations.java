package chp3annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utility.Highlighter;

public class DemoAnnotations 
{
	WebDriver driver;

	@BeforeClass
	public void setUp (){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\zenbook\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("1. Open Chrome & Application");
	}
	@Test
	public void signIn(){
		WebElement textUsername=driver.findElement(By.id("txtUsername"));
		Highlighter.highlightElement(driver,textUsername);
		textUsername.sendKeys("Admin");

		WebElement textPassword=driver.findElement(By.id("txtPassword"));
		Highlighter.highlightElement(driver,textPassword);
		textPassword.sendKeys("admin123");

		WebElement buttonLogin=driver.findElement(By.id("btnLogin"));
		Highlighter.highlightElement(driver,buttonLogin);
		buttonLogin.click();

		System.out.println("2. Sign in");
	}

	@Test
	public void userSearch(){
		WebElement menuAdmin= driver.findElement(By.xpath("//b[.='Admin']"));
		Highlighter.highlightElement(driver,menuAdmin);
		menuAdmin.click();

		WebElement textUserName= driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']"));
		Highlighter.highlightElement(driver,textUserName);
		textUserName.sendKeys("Admin");

		WebElement buttonSearch= driver.findElement(By.xpath("//input[@id='searchBtn']"));
		Highlighter.highlightElement(driver,buttonSearch);
		buttonSearch.click();

		System.out.println("search for user");
	}

	@Test
	public void userSignOut(){
		WebElement linkWelcome=driver.findElement(By.id("welcome"));
		Highlighter.highlightElement(driver,linkWelcome);
		linkWelcome.click();

		WebElement linkLogout=driver.findElement(By.xpath("//a[.='Logout']"));
		Highlighter.highlightElement(driver,linkLogout);
		linkLogout.click();
	}
	@AfterClass
	public void tearDown(){
		driver.quit();

	}
}
