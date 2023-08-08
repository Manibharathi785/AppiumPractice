package API_Demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Reusables.SuperClass;
import io.appium.java_client.AppiumBy;

public class DatePicker extends SuperClass {

	@Test(priority = 0)
	public void dateOfBirth() {

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();
		WebElement dateWidgets = driver.findElement(AppiumBy.accessibilityId("Date Widgets"));
		dateWidgets.click();
		WebElement dialog = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Dialog\"]"));
		dialog.click();
		WebElement date = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"change the date\"]"));
		date.click();
		WebElement topYear = driver.findElement(By.id("android:id/date_picker_header_year"));
		topYear.click();

		for (int i = 0; i < 3; i++) {

			ScrollCoordinates(driver, 540, 670, 540, 1560);
		}

		WebElement year2001 = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"2001\").instance(0))"));
		year2001.click();

		for (int i = 0; i < 2; i++) {

			WebElement nextMonth = driver.findElement(AppiumBy.accessibilityId("Next month"));
			nextMonth.click();
		}

		WebElement dOB = driver.findElement(AppiumBy.accessibilityId("05 October 2001"));
		dOB.click();
		WebElement oKButton = driver.findElement(By.id("android:id/button1"));
		oKButton.click();
	}

}
