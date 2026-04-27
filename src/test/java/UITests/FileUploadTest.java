package UITests;

import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    private final String textFile = "1.txt";

    @Test
    public void testUploadFile() {
        fileUploadPage
                .openUrl()
                .clickFile()
                .clickUpload()
                .verifyFileText(textFile);
    }
}
