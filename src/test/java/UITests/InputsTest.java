package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/**
 * 4. Inputs - Проверить на возможность ввести различные цифровые и
 * нецифровые значения, используя Keys.ARROW_UP И
 * Keys.ARROW_DOWN
 * Локатор: By.tagName(“input”)
 */

public class InputsTest extends BaseTest {

    @Test
    public void inputsTest() {

        driver.get("https://the-internet.herokuapp.com/inputs");

        //Проверка с вводом текста
        String beforeValue = driver.findElement(By.tagName("input")).getAttribute("value");
        driver.findElement(By.tagName("input")).sendKeys("Привет");
        String afterValue = driver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(afterValue, beforeValue, "Текст не должен был появиться");

        //Проверка с правильным подсчетом числа
        driver.findElement(By.tagName("input")).sendKeys("15");

        int beforeUp = Integer.parseInt(driver.findElement(By.tagName("input")).getAttribute("value"));
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        int afterUp = Integer.parseInt(driver.findElement(By.tagName("input")).getAttribute("value"));
        softAssert.assertEquals(afterUp, beforeUp + 1, "Число не прибавилось");

        int beforeDown = Integer.parseInt(driver.findElement(By.tagName("input")).getAttribute("value"));
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        int afterDown = Integer.parseInt(driver.findElement(By.tagName("input")).getAttribute("value"));
        softAssert.assertEquals(afterDown, beforeDown - 1, "Число не убавилось");

        softAssert.assertAll();
    }
}
