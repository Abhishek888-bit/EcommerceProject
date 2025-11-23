package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_002 {

	@Test
	public void registerpagewithoutctrdentials() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		WebElement privacy=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/i"));

		System.out.println(privacy.getText());

		String firstnamewarningsms = "First Name must be between 1 and 32 characters!";

		String lastnamewarningsms = "Last Name must be between 1 and 32 characters!";

		String emailwaerningsms = "E-Mail Address does not appear to be valid!";
		String telephonewarningsms = "Telephone must be between 3 and 32 characters!";
		String passwordwarningsms = "Password must be between 4 and 20 characters!";

		String policywarningsms = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(firstnamewarningsms,
				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());

		Assert.assertEquals(lastnamewarningsms,
				driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());

		Assert.assertEquals(emailwaerningsms,
				driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());

		Assert.assertEquals(telephonewarningsms,
				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());

		Assert.assertEquals(passwordwarningsms,
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());

		Assert.assertEquals(policywarningsms,
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());

	}

}
