package Selendriod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Reusables.SuperClass;
import io.appium.java_client.AppiumBy;

public class BasicOpen extends SuperClass {
	
	@Test(priority = 1)
	public void appAutomation() {
		
		WebElement newForm = driver.findElement(AppiumBy.accessibilityId("startUserRegistrationCD"));
		newForm.click();
		WebElement username = driver.findElement(By.id("io.selendroid.testapp:id/inputUsername"));
		username.sendKeys("Automation");
		WebElement email = driver.findElement(AppiumBy.accessibilityId("email of the customer"));
		email.sendKeys("maniinam782@gmail.com");
		WebElement password = driver.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
		password.click();
		WebElement name = driver.findElement(By.id("io.selendroid.testapp:id/inputName"));
		name.clear();
		name.sendKeys("Mani Bharathi");
		WebElement proLang = driver.findElement(By.id("android.widget.TextView"));
		proLang.click();
		WebElement java = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Java']"));
		java.click();
		driver.hideKeyboard();
		WebElement acceptance = driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
		acceptance.click();
		WebElement registerButton = driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser"));
		registerButton.click();		
		
	}

}
