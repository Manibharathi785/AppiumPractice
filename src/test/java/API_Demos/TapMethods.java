package API_Demos;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import Reusables.SuperClass;

public class TapMethods extends SuperClass {


	public void usingXYCoordinates() {

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1);

		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), 415, 1640))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(sequence));

//		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), 1080, 1640))
//				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//				.addAction(new Pause(finger, Duration.ofMillis(200)))
//				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//		driver.perform(Arrays.asList(sequence));

		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), 450, 970))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(sequence));

	}

	
	public void usingIdAndCoordinates() {

		WebElement text = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Text\"]"));
		Point textLocation = text.getLocation();
		Dimension textSize = text.getSize();

		Point centreOfElement = getCentreOfElement(textLocation, textSize);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1);

		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), centreOfElement))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(2000)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(sequence));
	}

	@Test
	private Point getCentreOfElement(Point textLocation, Dimension textSize) {
		return new Point(textLocation.getX() + textSize.getWidth() / 2, textLocation.getY() + textSize.getHeight() / 2);
	}

}
