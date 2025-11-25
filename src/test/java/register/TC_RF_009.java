package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_009 {
	
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	
	}

	@Test
	public void verifyregisterpagewithinvalidmobnumber() {

		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Abhishek");
		driver.findElement(By.id("input-lastname")).sendKeys("Saykar");

		driver.findElement(By.id("input-email")).sendKeys(generateEmail());

		driver.findElement(By.id("input-telephone")).sendKeys("akjk123");
		driver.findElement(By.id("input-password")).sendKeys("Abhi@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Abhi@1234");
		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String expectedwarningmessage = "Warning:Please Enter valid Telephone!";

		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-telephone\"]")).getText(),
				expectedwarningmessage);

	}

	public String generateEmail() {

		Date date = new Date();

		String stringdate = date.toString();
		String email = stringdate.replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";

		return email;

	}

}
