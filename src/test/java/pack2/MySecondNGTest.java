package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondNGTest {
  @Test
  public void navigateURL() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://login.salesforce.com/?locale=us");
	  driver.findElement(By.className("username")).sendKeys("test1234");
	  driver.findElement(By.className("password")).sendKeys("test");
	  driver.findElement(By.id("Login")).click();
	  WebElement textError = driver.findElement(By.id("error"));
	  String erreur = textError.getText();
	  System.out.println("Le message d'erreur est:"+ erreur);
	  Thread.sleep(3000);
	  driver.close();
  }
  
  @Test
	public void getQuit() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Open a popup window")).click();
		driver.findElement(By.partialLinkText("Open a popup ")).click();
		String url = driver.getCurrentUrl();
		System.out.println("L'url est:"+ url);
		System.out.println("L'url title:" + driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
	}
  
  @Test
	public void getLink() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.className("username")).sendKeys("test1234");
		driver.findElement(By.className("password")).sendKeys("test");
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		String url = driver.getCurrentUrl();
		System.out.println("L'url est:"+ url);
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void getClearURL() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.className("username")).sendKeys("pre-test");
		Thread.sleep(3000);
		driver.findElement(By.className("username")).clear();
		Thread.sleep(3000);
		driver.findElement(By.className("username")).sendKeys("test");
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		String url = driver.getCurrentUrl();
		System.out.println("L'url est:"+ url);
		Thread.sleep(3000);
		driver.close();
	}
	

	
	
	@Test
	public void getTitle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		String url = driver.getCurrentUrl();
		System.out.println("L'url est:"+ url);
		System.out.println("L'url title:" + driver.getTitle());
		Thread.sleep(3000);
		driver.close();
	}
}
