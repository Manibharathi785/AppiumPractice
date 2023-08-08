package API_Demos;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.PointerInput.Origin;

import Reusables.SuperClass;
import io.appium.java_client.AppiumBy;

public class Scroll extends SuperClass {

	public void usingXYCoordinates() {

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		for (int i = 0; i < 2; i++) {

			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), 450, 1900));
			sequence.addAction(finger.createPointerDown(0));
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(500), Origin.viewport(), 450, 400));
			sequence.addAction(finger.createPointerUp(0));
			driver.perform(Arrays.asList(sequence));

		}

	}

	public void usingAndroidUIAutomator() {

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();

		WebElement visibility = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Visibility\").instance(0))"));
		visibility.click();

//		WebElement view = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Visibility\").instance(0))"));
//		view.click();

	}

	@Test
	public void scrollHorizontal() {

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();
		WebElement gallery = driver.findElement(AppiumBy.accessibilityId("Gallery"));
		gallery.click();
		WebElement photos = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]"));
		photos.click();

		ScrollCoordinates(driver, 1060, 350, 300, 350);

	}

}
