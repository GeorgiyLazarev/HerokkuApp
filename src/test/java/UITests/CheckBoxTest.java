package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * 2. Checkboxes - проверить, что первый чекбокс unchecked, отметить
 * первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
 * checked, сделать unheck, проверить, что он unchecked
 */

public class CheckBoxTest {

    @Test
    public void verifyCheckBox() {
    ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");

    WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));

        boolean isCheck = checkboxes.get(0).isSelected();
        assertFalse(isCheck);
        checkboxes.get(0).click();
        assertTrue(checkboxes.get(0).isSelected());

        boolean isCheck2 = checkboxes.get(1).isSelected();
        assertTrue(isCheck2);
        checkboxes.get(1).click();
        assertFalse(checkboxes.get(1).isSelected());

        driver.quit();
    }
}
