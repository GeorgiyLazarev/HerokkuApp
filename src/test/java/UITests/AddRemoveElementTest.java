package UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/**
 * 1. Add/Remove Elements - добавить 2 элемента, удалить элемент,
 * проверить количество элементов DELETE
 * Локаторы xpath:
 * a. By.xpath("//button[text()='Add Element']")
 * b. By.xpath("//button[text()='Delete']")
 */

public class AddRemoveElementTest extends BaseTest {

    @Test
    public void checkAddRemoveElement() {

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        int size = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(size, 1);

        driver.findElement(By.xpath("//button[text()='Delete']")).click();

        int size1 = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        softAssert.assertEquals(size1, 1);

        driver.quit();
        softAssert.assertAll();
    }
}
