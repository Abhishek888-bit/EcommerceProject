package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_012 {

	@Test
	public void verifyplaceholdersofTextFieldInRegisterPage() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		String expectedFirstNamePlaceHolderText = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),
				expectedFirstNamePlaceHolderText);

		String expectedLastNamePlaceholdertext = "Last Name";

		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),
				expectedLastNamePlaceholdertext);

		String expectedEmailPlaceholderText = "E-Mail";

		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"),
				expectedEmailPlaceholderText);

		String expectedTelephonePlaceholderText = "Telephone";

		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"),
				expectedTelephonePlaceholderText);

		String expectedPasswordPlaceholderText = "Password";

		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"),
				expectedPasswordPlaceholderText);

		String expectedConfirmPasswordPlaceholderText = "Password Confirm";

		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"),
				expectedConfirmPasswordPlaceholderText);

		driver.quit();

	}

}
