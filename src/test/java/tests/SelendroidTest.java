package tests;

import org.testng.asserts.SoftAssert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Common;
import utils.ReadPropertiesFile;

public class SelendroidTest extends TestRunnerMobile {

	@Before
	public void beforeTest() {
		softAssert = new SoftAssert();
	}

	@Given("User has launched the app")
	public void user_has_launched_the_app() throws Exception {

		String currentActivity = ((AndroidDriver<MobileElement>) driver).currentActivity();
		if (!currentActivity.equalsIgnoreCase(ReadPropertiesFile.readAppMainActivity())) {
			Common.throwNewException(currentActivity);
		}
	}

	@When("User is on landing page")
	public void user_is_on_landing_page() throws Exception {

		landingpage.verifyLandingScreenTitle();
	}

	@Then("Verify elements should be shown correctly")
	public void title_of_the_screen_and_elements_should_be_shown_correctly() throws Exception {
		landingpage.verifyLandingScreen();
	}

	@When("User tap on button [Press to throw unhandled exception]")
	public void user_tap_on_button_press_to_throw_unhandled_exception() throws Exception {
		landingpage.clickOnBtnThrowException();
	}

	@Then("Verify home page title")
	public void verify_home_page_title() throws Exception {
		landingpage.verifyLandingScreenTitle();
	}

	@When("Type {string} in textbox Type to throw unhandled exception")
	public void type_in_textbox_type_to_throw_unhandled_exception(String value) throws Exception {
		landingpage.setvalueInTxtBoxUnhandledException(value);
	}

	@After
	public void AfterTest() throws Exception {
		softAssert.assertAll();
		String currentActivity = ((AndroidDriver<MobileElement>) driver).currentActivity();
		if (!currentActivity.equalsIgnoreCase(ReadPropertiesFile.readAppMainActivity())) {
			Common.relaunchApp();
		}

	}

}
