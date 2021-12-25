package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webTests.TestRunnerWeb;

public class CommonWeb extends TestRunnerWeb {

	static Actions action;
	public static WebDriverWait wait;

	public static String getPageTitle() {
		log.info("Method getPageTitle started.");
		String title;
		try {
			title = driver.getTitle();
			log.info("Page titile is:" + title);
		} catch (Exception e) {
			log.fatal("Not able to get page title.");
			e.printStackTrace();
			throw e;
		}
		log.info("Method getPageTitle finished.");
		return title;
	}

	public static void clickOnElement(WebElement elm, long timeOutInSeconds) {
		log.info("Method clickOnElement started.");

		try {
			wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
			log.info("Clicked on element with visible text " + elm.getText() + "");
		} catch (Exception e) {
			log.fatal("Not able to click on element.");
			e.printStackTrace();
			throw e;
		}
		log.info("Method clickOnElement finished.");
	}

	public static void dragAndDropElm(WebElement source, WebElement destination, long timeoutInSeconds) {
		log.info("Method dragAndDropElm started.");
		try {

			log.info("Draging element with text '" + source.getText() + "' to '" + destination.getText() + "'.");
			action = new Actions(driver);
			action.dragAndDrop(source, destination).build().perform();
		} catch (Exception e) {
			log.fatal("Not able to drag source element to destination.");
			e.printStackTrace();
			throw e;
		}
		log.info("Method dragAndDropElm finished.");
	}

	public static String getScreenShot() throws Exception {

		log.info("Method getSceenshot started.");
		String stringScreenshot = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			String path = System.getProperty("user.dir") + "/" + ReadPropertiesFile.readScreenshotPath();
			log.debug("Placing screen shot in "+path);
			File source = ts.getScreenshotAs(OutputType.FILE);
			stringScreenshot = ts.getScreenshotAs(OutputType.BASE64);
			FileUtils.copyFile(source, new File(path));

		} catch (Exception e) {
			log.fatal("Method getScreenShot failed.");
			throw e;
		}

		log.info("Method getSceenshot finished.");
		return "data:image/png;base64" + stringScreenshot;
	}

	public static void switchToFrame(WebElement elm) throws Exception {

		log.info("Method switchToFrame started.");

		try {
			log.info("Switching to frame:" + elm);
			driver.switchTo().frame(elm);

		} catch (Exception e) {
			log.fatal("Method getScreenShot failed.");
			throw e;
		}

		log.info("Method switchToFrame finished.");

	}

	public static void switchOutOfFrame() throws Exception {

		log.info("Method switchOutOfFrame started.");

		try {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			log.fatal("Not able to switch out of frame.");
			throw e;
		}

		log.info("Method switchOutOfFrame finished.");

	}
}
