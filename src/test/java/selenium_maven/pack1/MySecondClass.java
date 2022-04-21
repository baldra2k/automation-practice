package selenium_maven.pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondClass {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.ca/");
		driver.findElement(By.name("q")).sendKeys("Test Automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
	}
}
