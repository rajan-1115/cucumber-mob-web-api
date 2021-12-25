package webTests;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTests extends TestRunnerWeb {

	@Before
	public void beforeTest() {
		softAssert = new SoftAssert();
	}

	@Given("User is on jqueryui website homepage with title {string}")
	public void user_is_on_jqueryui_website_homepage(String pageTitle) {
		homepage.verifyHomePageTitle(pageTitle);
	}

	@When("User Select option Droppable from left menu under Interactions")
	public void user_select_option_droppable_from_left_menu_under_interactions() {
		homepage.gotoDroppable();
	}

	@When("User Drag Drag me to my target component to Drop here component")
	public void user_drag_component_to_component() throws Exception {
		homepage.dragAndDropToElement();
	}

	@Then("Verify first component is dragged to second component")
	public void verify_first_component_is_dragged_to_second_component() throws Exception {
		homepage.verifyElementIsDropped();
	}
}
