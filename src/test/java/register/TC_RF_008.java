package register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TC_RF_008 {

	@Test
	public void VerifyRegisterpageWithExistingEmail() throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Abhishek");
		driver.findElement(By.id("input-lastname")).sendKeys("Saykar");

		driver.findElement(By.id("input-email")).sendKeys("abhisheksaykar997gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys("123345677898");
		driver.findElement(By.id("input-password")).sendKeys("Abhi@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("Abhi@1234");
		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(5000);

		File Screenshot = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(Screenshot, new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png"));

	}
}
