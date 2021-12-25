package pageObjectsMobile;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import tests.TestRunnerMobile;

public class LandingPage extends TestRunnerMobile {
	public LandingPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hello Default Locale, Selendroid-test-app!']")
	List<MobileElement> lblScreenTitle;

	@AndroidFindBy(accessibility = "buttonTestCD")
	List<MobileElement> btnEn;

	@AndroidFindBy(accessibility = "buttonStartWebviewCD")
	List<MobileElement> btnChrome;

	@AndroidFindBy(accessibility = "startUserRegistrationCD")
	List<MobileElement> btnFolder;

	@AndroidFindBy(accessibility = "my_text_fieldCD")
	List<MobileElement> txtBox;

	@AndroidFindBy(accessibility = "waitingButtonTestCD")
	List<MobileElement> btnShowProgressBar;

	@AndroidFindBy(id = "io.selendroid.testapp:id/input_adds_check_box")
	List<MobileElement> chkIaccptAdds;

	@AndroidFindBy(accessibility = "visibleButtonTestCD")
	List<MobileElement> btnDisplayTextview;

	@AndroidFindBy(accessibility = "showToastButtonCD")
	List<MobileElement> btnDisplaysToast;

	@AndroidFindBy(accessibility = "showPopupWindowButtonCD")
	List<MobileElement> btnDisplayPopupWindow;

	@AndroidFindBy(accessibility = "exceptionTestButtonCD")
	List<MobileElement> btnThrowException;

	@AndroidFindBy(id = "io.selendroid.testapp:id/exceptionTestField")
	List<MobileElement> txtBoxThrowException;

	@AndroidFindBy(id = "io.selendroid.testapp:id/topLevelElementTest")
	List<MobileElement> btnFocusOnLayout;

	public void verifyLandingScreenTitle() throws Exception {
		log.info("Function verifyLandingScreenTitle started.");
		try {

			if (lblScreenTitle.isEmpty()) {

				throw new Exception("Landing screen title is not visible.");
			} else {
				log.info("Title is shown correctly");
			}

		} catch (Exception e) {
			log.fatal("Failed to verify landing title.");
			e.printStackTrace();
			throw e;
		}
		log.info("Function verifyLandingScreenTitle finished.");
	}

	public void verifyLandingScreen() throws Exception {
		log.info("Function verifyLandingScreen started.");
		List<String> listErrors = new ArrayList<>();
		try {

			// step.info("Verify the elements shown on screen.");

			if (btnEn.isEmpty())
				listErrors.add("En button is not found.");

			if (btnChrome.isEmpty())
				listErrors.add("Chrome' button is not found.");

			if (btnFolder.isEmpty())
				listErrors.add("'Folder' button is not found.");

			if (txtBox.isEmpty())
				listErrors.add("Blank textbox is not found.");

			if (btnShowProgressBar.isEmpty())
				listErrors.add("Show Progress Bar for a while' button is not found.");

			if (chkIaccptAdds.isEmpty())
				listErrors.add("'I accept adds' checkbox is not found.");

			if (btnDisplayTextview.isEmpty())
				listErrors.add("'Dispaly text view' button is not found.");

			if (btnDisplaysToast.isEmpty())
				listErrors.add("'Dispaly Toast' button is not found.");

			if (btnDisplayPopupWindow.isEmpty())
				listErrors.add("'Display Popup Window' button is not found.");

			if (btnThrowException.isEmpty())
				listErrors.add("'Press to throw unhandled exception' button is not found.");

			if (txtBoxThrowException.isEmpty())
				listErrors.add("'Type to throw unhandled exception' text box is not found.");

			if (btnFocusOnLayout.isEmpty())
				listErrors.add("'Display and focus on layout' button is not found.");

			if (!listErrors.isEmpty()) {
				String errMsg = "";
				for (String error : listErrors) {
					errMsg = errMsg + "<br>" + error;
				}

			}
		} catch (Exception e) {
			log.fatal("Function verifyLandingScreen started.");
			throw e;
		}
		log.info("Function verifyLandingScreen finished.");
	}

	public void clickOnBtnThrowException() throws Exception {
		log.info("Function clickOnBtnThrowException started.");
		try {
			btnThrowException.get(0).click();
		} catch (Exception e) {
			log.fatal("Failed to click on button 'Press to throw unhandled exception'.");
			e.printStackTrace();
			throw e;
		}
		log.info("Function clickOnBtnThrowException finished.");
	}

	public void setvalueInTxtBoxUnhandledException(String value) throws Exception {
		log.info("Function setvalueInTxtBoxUnhandledException started.");
		try {
			txtBoxThrowException.get(0).sendKeys(value);
		} catch (Exception e) {
			log.fatal("Failed to enter data in textbox 'Type to throw unhandled exception'.");
			e.printStackTrace();
			throw e;
		}
		log.info("Function setvalueInTxtBoxUnhandledException finished.");
	}

}
