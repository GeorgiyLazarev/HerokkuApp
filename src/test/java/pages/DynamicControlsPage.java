package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class DynamicControlsPage extends BasePage {

    private final By CHECKBOX = By.xpath("//input[@type='checkbox']");
    private final By REMOVE = By.xpath("//button[text()='Remove']");
    private final By MESSAGE_GONE = By.xpath("//p[text()=\"It's gone!\"]");
    private final By MESSAGE_ENABLED = By.xpath("//p[text()=\"It's enabled!\"]");
    private final By DISABLED_INPUT = By.xpath("//input[@disabled]");
    private final By NOT_DISABLED_INPUT = By.xpath("//input[not(@disabled)]");
    private final By ENABLE = By.xpath("//button[text()='Enable']");
    private final By DISABLED = By.xpath("//button[text()='Disable']");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу")
    public DynamicControlsPage openUrl() {
        driver.get(BASE_URL + "/dynamic_controls");
        return this;
    }

    @Step("Проверка отсутствия чек-бокса")
    public DynamicControlsPage absenceCheckBox() {
        assertTrue(isNotVisible(CHECKBOX, 2), "Чек-бокс отображается");
        return this;
    }

    @Step("Проверка отображения чек-бокса")
    public DynamicControlsPage displayCheckBox() {
        assertTrue(isVisible(CHECKBOX, 2), "Чек-бокс не отображается");
        return this;
    }

    @Step("Клик на кнопку \"Remove\"")
    public DynamicControlsPage clickRemove() {
        driver.findElement(REMOVE).click();
        return this;
    }

    @Step("Проверка отображения надписи \"It's gone!\"")
    public DynamicControlsPage checkTitle() {
        assertTrue(isVisible(MESSAGE_GONE, 10), "Надпись \"It's gone!\" не отображается");
        return this;
    }

    @Step("Проверка отображения задизейбленого поля ввода")
    public DynamicControlsPage checkInputDisabled() {
        assertTrue(isVisible(DISABLED_INPUT, 10), "Поле не задизейблено");
        return this;
    }

    @Step("Проверка отображения активного поля ввода")
    public DynamicControlsPage checkInputEnabled() {
        assertTrue(isVisible(NOT_DISABLED_INPUT, 10), "Поле задизейблено");
        return this;
    }

    @Step("Проверка отображения кнопки \"Enable\"")
    public DynamicControlsPage checkButtonEnabledDisplay() {
        assertTrue(isVisible(ENABLE, 10), "Кнопка \"Enable\" не отображается");
        return this;
    }

    @Step("Проверка отображения кнопки \"Disable\"")
    public DynamicControlsPage checkButtonDisableDisplay() {
        assertTrue(isVisible(DISABLED, 10), "Кнопка \"Disable\" не отображается");
        return this;
    }

    @Step("Клик на кнопку \"Enable\"")
    public DynamicControlsPage clickButtonEnabled() {
        driver.findElement(ENABLE).click();
        return this;
    }

    @Step("Проверка отображения надписи \"It's enabled!\"")
    public DynamicControlsPage checkTitleEnable() {
        assertTrue(isVisible(MESSAGE_ENABLED, 10), "Надпись \"It's enabled!\" не отображается");
        return this;
    }
}
