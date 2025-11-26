package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_013 {

	WebDriver driver;

	@AfterMethod
	public void teardown() {

		driver.quit();

	}

	@Test
	public void verifyMandatoryFieldsSymbolAndColorInRegisterAccountPage() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";

		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		String fnContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				firstNameLabel);
		String fnColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);

		WebElement LastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));

		String LnContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", LastNameLabel);

		String LnColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", LastNameLabel);
		Assert.assertEquals(LnContent, expectedContent);
		Assert.assertEquals(LnColor, expectedColor);

	}
}