package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContextMenuPage extends BasePage {

    private final By SQUARE = By.xpath("//div[@id='hot-spot']");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу")
    public ContextMenuPage openUrl() {
        driver.get(BASE_URL + "/context_menu");
        return this;
    }

    @Step("Клик правой кнопкой мыши в квадрат")
    public ContextMenuPage rightClickSquare() {
        rightClick(SQUARE);
        return this;
    }

    @Step("Получить текст алерта")
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    @Step("Закрыть алерт")
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Проверка появления алерта")
    public ContextMenuPage isAlertDisplayed() {
        assertTrue(isAlertPresent(), "Алерт не отображается");
        return this;
    }

    @Step("Проверка совпадения текста алерта")
    public ContextMenuPage checkAlertText(String expectedText) {
        String actualText = getAlertText();
        assertEquals(actualText, expectedText,
                """
                Текст не совпадает
                Ожидаемый результат: %s
                Фактический результат: %s
                """.formatted(expectedText, actualText));
        return this;
    }
}
