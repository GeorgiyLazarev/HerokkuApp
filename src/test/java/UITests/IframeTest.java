package UITests;

import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    private final String textParagraph = "Your content goes here.";

    @Test
    public void testIframeParagraphText() {
        iframePage
                .openUrl()
                .switchToIframe()
                .verifyParagraphText(textParagraph);
    }
}
