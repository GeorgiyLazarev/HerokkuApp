package UITests;

import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkDynamicControls() {
        dynamicControlsPage
                .openUrl()
                .displayCheckBox()
                .clickRemove()
                .checkTitle()
                .absenceCheckBox()
                .checkInputDisabled()
                .checkButtonEnabledDisplay()
                .clickButtonEnabled()
                .checkTitleEnable()
                .checkInputEnabled()
                .checkButtonDisableDisplay();
    }
}
