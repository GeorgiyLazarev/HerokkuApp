package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class IframePage extends BasePage {

    private final By IFRAME = By.id("mce_0_ifr");
    private final By PARAGRAPH = By.xpath("//body[@id='tinymce']/p");

    public IframePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу")
    public IframePage openUrl() {
        driver.get(BASE_URL + "/iframe");
        return this;
    }

    @Step("Переключиться в iframe")
    public IframePage switchToIframe() {
        driver.switchTo().frame(driver.findElement(IFRAME));
        return this;
    }

    @Step("Получить текст из параграфа внутри iframe")
    public String getParagraphText() {
        return driver.findElement(PARAGRAPH).getText();
    }

    @Step("Проверить текст параграфа")
    public IframePage verifyParagraphText(String expectedText) {
        String actualText = getParagraphText();
        assertEquals(actualText, expectedText,
                """
                Текст параграфа не совпадает
                Ожидаемый результат: '%s'
                Фактический результат: '%s'
                """.formatted(expectedText, actualText));
        return this;
    }
}
