package pack3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiqueCSS {

	@Test	
	public void loginTest() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("[type=submit]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("[href='/logout']")).click();
		Thread.sleep(3000);
	}
	
	@Test	
	public void forgotLoginTest() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/forgot_password");
		driver.findElement(By.cssSelector("#email")).sendKeys("tomsmith");
		//driver.findElement(By.cssSelector("[type=submit]")).click();
		//#form_submit
		driver.findElement(By.cssSelector("#form_submit")).click();
		Thread.sleep(3000);
		
	}
		
	
	@Test	
	public void getAtributeTest() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/forgot_password");
		driver.findElement(By.cssSelector("#email")).sendKeys("tomsmith");
		//driver.findElement(By.cssSelector("[type=submit]")).click();
		//#form_submit
		String strID = driver.findElement(By.cssSelector("#form_submit")).getAttribute("id");
		Thread.sleep(3000);
		System.out.println("La valeur d'attribute est :"+ strID);
		Thread.sleep(3000);
		driver.close();
		
	}
	
	
	@Test	
	public void getHiddenTest() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.cssSelector("#email")).sendKeys("tomsmith");
		//driver.findElement(By.cssSelector("[type=submit]")).click();
		//#form_submit
		String strID = driver.findElement(By.cssSelector("#form_submit")).getAttribute("id");
		Thread.sleep(3000);
		System.out.println("La valeur d'attribute est :"+ strID);
		Thread.sleep(3000);
		 boolean display= driver.findElement(By.cssSelector("div[class='submit'] [value='my-account']")).isDisplayed();
			Thread.sleep(3000);
		driver.close();
		
	}
	
	@Test	
	public void getActiveTest() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		
		boolean isEnabled= driver.findElement(By.cssSelector("#but1")).isEnabled();
		boolean isEnabled2= driver.findElement(By.cssSelector("#but2")).isEnabled();
		Thread.sleep(3000);
		Thread.sleep(3000);
		System.out.println("L'element 1  isEnabled :"+ isEnabled);
		System.out.println("L'element 2 isEnabled  :"+ isEnabled2);
		Thread.sleep(3000);
		driver.close();
		
	}
	
	@Test	
	public void getCheckedTest() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		
		boolean orange= driver.findElement(By.cssSelector("[value='orange']")).isSelected();
		boolean blue= driver.findElement(By.cssSelector("[value='blue']")).isSelected();
		Thread.sleep(3000);
		Thread.sleep(3000);
		System.out.println("L'element orange  checked :"+ orange);
		System.out.println("L'element blue  checked  :"+ blue);
		Thread.sleep(3000);
		driver.close();
		
	}
	
	
	
	
	
}
