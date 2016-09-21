package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestEmail {
	
	private static WebDriver driver;
	private static String baseUrl;
	
	public static void main(String[] args) throws Exception {

		String username = "testovimail";
		String password = "testivi1parol";
		TestMail(username,password);
		}
	
	public static void TestMail(String username,String password) throws Exception {

		System.setProperty("webdriver.gecko.driver", "D:\\all\\soft\\Selenium\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		baseUrl = "https://mail.tut.by";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(baseUrl);
		driver.manage().window().maximize();

		driver.findElement(By.id("Username")).clear();
		driver.findElement(By.id("Username")).sendKeys(username);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@value='Войти']")).click();
		
		Thread.sleep(7000);
		
		String title = "Входящие — Яндекс.Почта";
		if (driver.getTitle().contains(title)){
		System.out.println("Logged in sucessfully !!!"+driver.getTitle());
		}
		else {
		System.out.println("Unable to loggin :-( "+driver.getTitle());
		}
		
		String numberOfLetters = driver.findElement(By.xpath(".//*[@class='mail-NestedList-Item-Info-Extras']")).getText();
		System.out.println("Numbers of letters = " + numberOfLetters);

		driver.quit();
		}
}
