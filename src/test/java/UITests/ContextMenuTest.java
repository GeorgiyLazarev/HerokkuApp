package UITests;

import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    private final String alertText = "You selected a context menu";

    @Test
    public void testRightClickOnHotSpot() {
        contextMenuPage
                .openUrl()
                .rightClickSquare()
                .isAlertDisplayed()
                .checkAlertText(alertText)
                .acceptAlert();
    }
}
