package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {

	@Test
	public void verifyregisteringaccountsubscribetonewsletter() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Abhishek");
		driver.findElement(By.id("input-lastname")).sendKeys("Saykar");

		driver.findElement(By.id("input-email")).sendKeys(newemailgenerate());

		driver.findElement(By.id("input-telephone")).sendKeys("123345677898");
		driver.findElement(By.id("input-password")).sendKeys("Abhi@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Abhi@1234");
		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.xpath("//a[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Subscribe / unsubscribe to newsletter']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Newsletter")).isDisplayed());

		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio'][@value='0']")).isSelected());

		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String expectedSuccessMessage = "Success: Your newsletter subscription has been successfully updated!";

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(),
				expectedSuccessMessage);

		driver.quit();

	}

	public String newemailgenerate() {

		String email = new Date().toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";

		return email;

	}

}
