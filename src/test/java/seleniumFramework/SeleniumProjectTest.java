package seleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
	
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("soumyarohit@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Soumya123");
		driver.findElement(By.cssSelector("#login")).click();
		
		List <WebElement> ls = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement product= ls.stream().filter(products-> 
		products.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();              
		
	
		
	}
}
