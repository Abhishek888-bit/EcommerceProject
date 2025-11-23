package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_006 {

	@Test
	public void VerifyRegisterAccountbyMissMatchPassword() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Abhishek");
		driver.findElement(By.id("input-lastname")).sendKeys("Saykar");

		driver.findElement(By.id("input-email")).sendKeys(newemail());

		driver.findElement(By.id("input-telephone")).sendKeys("123345677898");
		driver.findElement(By.id("input-password")).sendKeys("Abhi@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Abhi1234");
		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String expectedErrorMessage = "Password confirmation does not match password!";

		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(),
				expectedErrorMessage);

		driver.quit();

	}

	public String newemail() {

		Date date = new Date();

		String stringdate = date.toString();
		String withoutspace = stringdate.replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";

		return withoutspace;

	}

}
