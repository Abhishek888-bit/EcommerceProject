package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {

	@Test
	public void VerifyRegisterpageWithExistingEmail() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Abhishek");
		driver.findElement(By.id("input-lastname")).sendKeys("Saykar");

		driver.findElement(By.id("input-email")).sendKeys("abhisheksaykar997@gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys("123345677898");
		driver.findElement(By.id("input-password")).sendKeys("Abhi@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Abhi@1234");
		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String warningmessage = "Warning: E-Mail Address is already registered!";

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),
				warningmessage);

		driver.quit();

	}
}
