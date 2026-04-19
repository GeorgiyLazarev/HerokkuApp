package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputsTest {

    @Test
    public void inputsTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

        driver.quit();
        softAssert.assertAll();
    }
}
