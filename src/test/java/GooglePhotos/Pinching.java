package GooglePhotos;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Reusables.SuperClass;
import io.appium.java_client.AppiumBy;

public class Pinching extends SuperClass {


	public void zoomIn() {

		WebElement picture = driver.findElement(AppiumBy.accessibilityId("Photo taken on 06-Aug-2023 12:52:10 pm"));
		picture.click();

		pinch(driver, 540, 1000, 540, 500, 540, 1100, 540, 1900);

	}
	@Test
	public void zoomOut() throws InterruptedException {

		WebElement picture = driver.findElement(AppiumBy.accessibilityId("Photo taken on 06-Aug-2023 12:52:10 pm"));
		picture.click();

		pinch(driver, 540, 1000, 540, 500, 540, 1100, 540, 1900);
		Thread.sleep(3000);

		pinch(driver, 540, 500, 540, 1000, 540, 1900, 540, 1100);

	}

}
