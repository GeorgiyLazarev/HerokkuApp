package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * 2. Checkboxes - проверить, что первый чекбокс unchecked, отметить
 * первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
 * checked, сделать unheck, проверить, что он unchecked
 */

public class CheckBoxTest extends BaseTest {

    @Test
    public void verifyCheckBox() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));

        boolean isCheck = checkboxes.get(0).isSelected();
        softAssert.assertFalse(isCheck);
        checkboxes.get(0).click();
        softAssert.assertTrue(checkboxes.get(0).isSelected());

        boolean isCheck2 = checkboxes.get(1).isSelected();
        softAssert.assertTrue(isCheck2);
        checkboxes.get(1).click();
        softAssert.assertFalse(checkboxes.get(1).isSelected());

        softAssert.assertAll();
    }
}
