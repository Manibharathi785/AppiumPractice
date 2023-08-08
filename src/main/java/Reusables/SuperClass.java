package Reusables;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class SuperClass {

	public static AndroidDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setCapabilities() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("udid", "f499644e0621");
		capabilities.setCapability("deviceName", "Poco M3");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");
//		capabilities.setCapability("appPackage", "com.google.android.apps.photos");
//		capabilities.setCapability("appActivity", ".home.HomeActivity");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", ".ApiDemos");
//		capabilities.setCapability("appPackage", "com.google.android.calculator");
//		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
//		capabilities.setCapability("appPackage", "io.selendroid.testapp");
//		capabilities.setCapability("appActivity", ".HomeScreenActivity");

		URL url = new URL("http://0.0.0.0:4723");
		driver = new AndroidDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void ScrollCoordinates(AndroidDriver driver, int StartX, int StartY, int EndX, int EndY) {

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence sequence = new Sequence(finger, 1);

		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), StartX, StartY));
		sequence.addAction(finger.createPointerDown(0));
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(500), Origin.viewport(), EndX, EndY));
		sequence.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(sequence));
	}

	public static void pinch(AndroidDriver driver, int StartXOne, int StartYOne, int EndXOne, int EndYOne,
			int StartXTwo, int StartYTwo, int EndXTwo, int EndYTwo) {

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

		Sequence sequence = new Sequence(finger, 1);
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), StartXOne, StartYOne));
		sequence.addAction(finger.createPointerDown(0));
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(500), Origin.viewport(), EndXOne, EndYOne));
		sequence.addAction(finger.createPointerUp(0));

		Sequence sequence2 = new Sequence(finger2, 1);
		sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(0), Origin.viewport(), StartXTwo, StartYTwo));
		sequence2.addAction(finger2.createPointerDown(0));
		sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(500), Origin.viewport(), EndXTwo, EndYTwo));
		sequence2.addAction(finger2.createPointerUp(0));

		driver.perform(Arrays.asList(sequence, sequence2));
	}

	@AfterTest
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
