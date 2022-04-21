package pack3;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiqueWebDriver {

		@Test
		public void takescreenshot() throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://omayo.blogspot.com/");
			driver.manage().window().maximize();
			File screen = driver.findElement(By.cssSelector("[value='orange']")).getScreenshotAs(OutputType.FILE);
			File toFile = new File("screenshoot\\image.png"); 
			FileHandler.copy(screen, toFile);
		}
		
		@Test
		public void takescreenshotInput() throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://omayo.blogspot.com/");
			driver.manage().window().maximize();
			File screen2 = driver.findElement(By.cssSelector("[value='ReadThisText']")).getScreenshotAs(OutputType.FILE);
			File toFile = new File("screenshoot\\image2.png"); 
			FileHandler.copy(screen2, toFile);
			driver.close();
		}
		
		@Test
		public void takescreenshotFull() throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://omayo.blogspot.com/");
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File toFile = new File("screenshoot\\imagefull.png"); 
			FileHandler.copy(screen, toFile);
			driver.close();
		}
		
		
		@Test
		public void takescreenshotandReport() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			// $("#login-button") manipulacion en el jquery css
			Reporter.log("Overture de la page ...");
			driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
			driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
			Reporter.log("Rempli les donées ...");
			
			driver.findElement(By.cssSelector("#login-button")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
			Thread.sleep(1000);
			Reporter.log("Ajouter le cart ...");
			driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
			Reporter.log("logout ...");
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File toFile = new File("screenshoot\\imageout.png"); 
			Thread.sleep(1000);
			FileHandler.copy(screen, toFile);
			Reporter.log("<a target=\"_blank\" href=\"C:\\Automatisation\\selenium_maven\\screenshot\\image4.png\">screenshot</a>");

			driver.close();
			Reporter.log("fermer le navigateur ...");
		
		}
		
		
		@Test
		public void NavigateMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
			
			driver.close();
			Reporter.log("fermer le navigateur ...");
		
		}
		
		
		@Test
		public void findMutipleMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
			
			List<WebElement> maListe =  driver.findElements(By.cssSelector("input"));
			
			for(WebElement element : maListe) {
				String attStr = element.getAttribute("name");
				System.out.println("Attibute:"+ attStr);
			}
			
			//driver.close();
			Reporter.log("fermer le navigateur ...");
		
		}
		
		
		@Test
		public void findLinksMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
			
			driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
			driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
			driver.findElement(By.cssSelector("#login-button")).click();
			
			
			List<WebElement> maListe =  driver.findElements(By.cssSelector("a"));
			
			for(WebElement element : maListe) {
				String attStr = element.getAttribute("href");
				
				System.out.println("href:"+ attStr);
			}
			Thread.sleep(1000);
			driver.close();
			Reporter.log("fermer le navigateur ...");
		
		}
		
		
		
		
		@Test
		public void GetColorBackgroundMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
			
		
			WebElement element = driver.findElement(By.cssSelector("#login-button"));
			String bgcolor = element.getCssValue("background-color");
			
			System.out.println("background:"+ bgcolor);
			
			
			Thread.sleep(1000);
			driver.close();
			Reporter.log("fermer le navigateur ...");
		
		}
		
		@Test
		public void NameDriverMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
		
			String nomDriver = driver.getClass().getSimpleName();
			
			System.out.println("Nom driver: " +nomDriver );
			
		///https://www.selenium.dev/selenium/docs/api/py/webdriver_support/selenium.webdriver.support.color.html

			
		}
		
		@Test
		public void HandleWindowMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://omayo.blogspot.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
			String idPanel = driver.getWindowHandle();
			driver.findElement(By.linkText("Open a popup window")).click();
			
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows ) {
				System.out.println("window : " + window);
			}
			
			Iterator<String> iterateur = windows.iterator();
			while (iterateur.hasNext()) {
				String window = iterateur.next() ;
				//System.out.println("Set : " + window);
				driver.switchTo().window(window);
				System.out.println("Set : " + window);
				if (driver.getTitle().equals("Basic Web Page Title")) {
					String text = driver.findElement(By.id("para1")).getText();
					System.out.println("text : " + text);
				}
			}
			
			driver.switchTo().window(idPanel);
			driver.findElement(By.id("checkbox1")).click();
			driver.quit();
			
		
		}
		
		
		// //tagname[@attribut='value'] syntaxe generale

		@Test
		public void XpathMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
			driver.get("http://omayo.blogspot.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
			String idPanel = driver.getWindowHandle();
			driver.findElement(By.xpath("//div/button[@class='dropbtn']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div/[@id='myDropdown']/a[@href='htpp://facebook.com']")).click();
			String url = driver.getCurrentUrl();
			System.out.println("Current page: "+ url);
			driver.quit();
		
		}
		
		
		@Test
		public void WaitMethod() throws Exception {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
	//		WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.get("http://omayo.blogspot.com/");
			// $("#login-button") manipulacion en el jquery css
			driver.manage().window().maximize();
			String idPanel = driver.getWindowHandle();
			driver.findElement(By.xpath("//div/button[@class='dropbtn']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div/[@id='myDropdown']/a[@href='htpp://facebook.com']")).click();
			String url = driver.getCurrentUrl();
			System.out.println("Current page: "+ url);
			driver.quit();
			
		
		}
		
		@Test
		public void explicitWaitMechanism()  {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		//	WebDriverWait wait = new WebDriverWait(driver,30);
			driver.get("http://omayo.blogspot.com/");

		}
		
		@Test
		public void Mechanism() throws InterruptedException  {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			driver.get("http://omayo.blogspot.com/");
			driver.manage().window().maximize();
			String idPanel = driver.getWindowHandle();
			driver.findElement(By.xpath("//div/button[@class='dropbtn']")).click();;
			//WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")));
			WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("facebook")));
			webElement.click();
			driver.quit();

		}
		
}
