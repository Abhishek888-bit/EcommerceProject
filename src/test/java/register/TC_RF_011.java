package register;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_011 {

	@Test
	public void verifyregisterpagewithkeyboard() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		Actions ac = new Actions(driver);

		for (int i = 1; i <= 23; i++) {

			ac.sendKeys(Keys.TAB).perform();

		}

		ac.sendKeys("Abhishek").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys("Saykar").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(getemail())
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).sendKeys("8977667676").sendKeys(Keys.TAB)
				.sendKeys("Titan@123").sendKeys(Keys.TAB).sendKeys("Titan@123").sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE)
				.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

		Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).isDisplayed());

		driver.quit();

	}

	public String getemail() {

		Date date = new Date();
		String email = date.toString().replaceAll(" ", "").replaceAll(":", "") + "@gmail.com";
		return email;

	}

}
