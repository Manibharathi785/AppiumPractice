package Calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Reusables.SuperClass;
import io.appium.java_client.AppiumBy;

public class LaunchCalc extends SuperClass {

	String expectedResult = "12";

	@Test
	public void simpleAddition() {

		WebElement seven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
		seven.click();
		WebElement plus = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));
		plus.click();
		WebElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		five.click();
		WebElement equalsTo = driver.findElement(AppiumBy.accessibilityId("equals"));
		equalsTo.click();
		
		

//		WebElement result = driver.findElement(By.id(""));
//		String actualResult = result.getText();
//		assertEquals(expectedResult, actualResult);

	}

}
