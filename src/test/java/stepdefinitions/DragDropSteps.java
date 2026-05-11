package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.DragDropPage;
import pageclasses.WelcomeToTheInternet;

public class DragDropSteps {
	WelcomeToTheInternet wlObj;
	DragDropPage dragDropObj;

	@When("user clicks on drag drop link")
	public void user_clicks_on_drag_drop_link() {
		wlObj = new WelcomeToTheInternet();
		wlObj.clickDragDrop();
	}

	@Then("user should land on dragDrop page")
	public void user_should_land_on_drag_drop_page() {
		dragDropObj = new DragDropPage();
		String heading = dragDropObj.getHeading();
		Assert.assertEquals(heading, "Drag and Drop");
	}

	@When("user drap source to desination")
	public void user_drap_source_to_desination() {
		dragDropObj.performDragandDrop();
	}

	@Then("user should be confirm heading of destination")
	public void user_should_be_confirm_heading_of_destination() {
		dragDropObj = new DragDropPage();
		String heading = dragDropObj.getDragDropHeading();
		Assert.assertEquals(heading, "A");
	}
}
