package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TyposTest {

    private final String actualText = "Sometimes you'll see a typo, other times you won't.";

    @Test
    public void isParagraphSpellingCorrect() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/typos");

        for (int i = 0; i < 10; i++) {
            String text = driver.findElement((By.xpath("//p[contains(text(), 'Sometimes')]"))).getText();
            softAssert.assertEquals(text, actualText,
                    "Ошибка в параграфе после %d-го рефреша".formatted(i + 1));

            if (i < 9) {
                driver.navigate().refresh();
            }
        }

        driver.quit();
        softAssert.assertAll();
    }
}
