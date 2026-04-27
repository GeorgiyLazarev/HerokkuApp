package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadPage extends BasePage {

    private final By FILE = By.xpath("//input[@name='file']");
    private final By FILE_UPLOAD_BUTTON = By.xpath("//input[@value='Upload']");
    private final By FILE_UPLOAD = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу")
    public FileUploadPage openUrl() {
        driver.get(BASE_URL + "/upload");
        return this;
    }

    @Step("Загрузить файл")
    public FileUploadPage clickFile() {
        File file = new File("src/test/resources/1.txt");
        driver.findElement(FILE).sendKeys(file.getAbsolutePath());
        return this;
    }

    @Step("Клик на кнопку \"Upload\"")
    public FileUploadPage clickUpload() {
        driver.findElement(FILE_UPLOAD_BUTTON).click();
        return this;
    }

    @Step("Получить текст")
    public String getTextUpload() {
        return driver.findElement(FILE_UPLOAD).getText();
    }

    @Step("Проверить название файла")
    public FileUploadPage verifyFileText(String expectedText) {
        String actualText = getTextUpload();
        assertEquals(actualText, expectedText,
                """
                Текст файла не совпадает
                Ожидаемый результат: '%s'
                Фактический результат: '%s'
                """.formatted(expectedText, actualText));
        return this;
    }
}
