package API_Demos;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Reusables.SuperClass;
import io.appium.java_client.AppiumBy;

public class LongPressMethods extends SuperClass {

	public void usingXYCoordinates() {

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();
		WebElement expandableLists = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
		expandableLists.click();
		WebElement customAdapter = driver
				.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"));
		customAdapter.click();

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1);

		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), 450, 270))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(2000)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(sequence));

	}

	public void usingCentreOfElement() {

		WebElement text = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Text\"]"));
		Point textLocation = text.getLocation();
		Dimension textSize = text.getSize();

		Point centreOfElement = getCentreOfElement(textLocation, textSize);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1);

		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), centreOfElement))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(sequence));

	}

	
	private Point getCentreOfElement(Point textLocation, Dimension textSize) {
		return new Point(textLocation.getX() + textSize.getWidth() / 2, textLocation.getY() + textSize.getHeight() / 2);
	}
	
	
	@Test
	public void usingJSExecutor() {

		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();
		WebElement expandableLists = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
		expandableLists.click();
		WebElement customAdapter = driver
				.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"));
		customAdapter.click();
		
		WebElement dogNames = driver.findElements(By.className("android.widget.TextView")).get(1);
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) dogNames).getId(), "duration", 2000));
		
		
		
		
		
		
		
		
		
		
		
	}

}
