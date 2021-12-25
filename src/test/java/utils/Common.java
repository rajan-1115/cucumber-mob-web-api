package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import tests.TestRunnerMobile;

public class Common extends TestRunnerMobile {

	public static WebDriverWait wait;

	public static String getElementText(MobileElement elm, long timeoutInSecond) {
		log.info("Function getElementText started.");
		String elmText;
		try {
			wait = new WebDriverWait(driver, timeoutInSecond);
			wait.until(ExpectedConditions.visibilityOf(elm));
			elmText = elm.getText();

		} catch (Exception e) {
			log.fatal("Failed to get element text.");
			throw e;
		}
		log.info("Function getElementText finished.");
		return elmText;
	}

	public static void throwNewException(String message) throws Exception {
		log.info("Function throwNewException started.");
		try {
			log.fatal(message);
			throw new Exception(message);
		} catch (Exception e) {
			log.fatal("Failed to get element text.");
			throw e;
		}

	}

	public static String getScreenShot() {

		log.info("Method getSceenshot started.");
		String stringScreenshot = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			stringScreenshot = ts.getScreenshotAs(OutputType.BASE64);

		} catch (Exception e) {
			log.fatal("Method getScreenShot failed.");
			throw e;
		}

		log.info("Method getSceenshot finished.");
		return "data:image/png;base64" + stringScreenshot;
	}

	public static void relaunchApp() throws Exception {

		log.info("Method relaunchApp started.");
		try {
			Thread.sleep(2000);

			((AndroidDriver<MobileElement>) driver).startActivity(
					new Activity(ReadPropertiesFile.readAppPackage(), ReadPropertiesFile.readAppMainActivity()));

		} catch (Exception e) {
			log.fatal("Method relaunchApp failed.");
			throw e;
		}

		log.info("Method relaunchApp finished.");
	}


}
