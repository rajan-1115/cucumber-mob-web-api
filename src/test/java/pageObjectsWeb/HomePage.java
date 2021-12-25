package pageObjectsWeb;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Common;
import utils.CommonWeb;
import webTests.TestRunnerWeb;

public class HomePage extends TestRunnerWeb {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Droppable")
	WebElement lnkDroppable;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	WebElement frameDragable;

	@FindBy(xpath = "//p[text()='Drag me to my target']")
	WebElement elmDraggableBox;

	@FindBy(id = "droppable")
	WebElement elmDroppableBox;

	@FindBy(xpath = "//p[text()='Dropped!']")
	List<WebElement> lblDropped;

	public void verifyHomePageTitle(String title) {
		log.info("Method verifyHomePageTitle started.");
		try {
			softAssert.assertEquals(CommonWeb.getPageTitle(), title);
		} catch (Exception e) {
			log.fatal("Not able to verify homepage title.");
			e.printStackTrace();
			throw e;
		}
		log.info("Method verifyHomePageTitle finished.");
	}

	public void gotoDroppable() {
		log.info("Method gotoDroppable started.");
		try {
			CommonWeb.clickOnElement(lnkDroppable, 15);
		} catch (Exception e) {
			log.fatal("Not able to verify page title.");
			e.printStackTrace();
			throw e;
		}
		log.info("Method gotoDroppable finished.");
	}

	public void dragAndDropToElement() throws Exception {
		log.info("Method dragAndDropToElement started.");
		try {
			CommonWeb.switchToFrame(frameDragable);
			CommonWeb.dragAndDropElm(elmDraggableBox, elmDroppableBox, 15);
			CommonWeb.switchOutOfFrame();
			CommonWeb.getScreenShot();
		} catch (Exception e) {
			log.fatal("Not able to drag and drop element.");
			e.printStackTrace();
			throw e;
		}
		log.info("Method dragAndDropToElement finished.");
	}

	public void verifyElementIsDropped() throws Exception {
		log.info("Method verifyElementIsDropped started.");
		try {
			Thread.sleep(1000);
			softAssert.assertTrue(lblDropped.isEmpty(), "Source element not dropped onto destination");
			CommonWeb.switchOutOfFrame();
		} catch (Exception e) {
			log.fatal("Not able to verify if the source element is dropped onto destination.");
			e.printStackTrace();
			throw e;
		}
		log.info("Method verifyElementIsDropped finished.");
	}
}
