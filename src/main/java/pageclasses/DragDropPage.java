package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionsUtils;

public class DragDropPage {
	By boxA = By.xpath("//div[@id='column-a']");
	By boxB = By.xpath("//div[@id='column-b']");
	By header = By.xpath("//div[@id='column-b']/header[text()='A']");
	By heading = By.xpath("//h3[text()='Drag and Drop']");

	public void performDragandDrop() {
		UiActionsUtils.dragAndDrop(boxA, boxB);

	}

	public String getDragDropHeading() {

		return UiActionsUtils.getText(header);
	}

	public String getHeading() {
		return UiActionsUtils.getText(heading);
	}
}
