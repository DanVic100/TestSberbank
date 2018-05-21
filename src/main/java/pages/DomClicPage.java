package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DomClicPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(BaseStep.getDriver(), 5);

    @FindBy(xpath = ".//div[@class = 'dcCalc_frame']//div[contains(text(), 'Цель кредита')]/following-sibling::div//input[@class = 'dcCalc_textfield__input']")
    public WebElement itemButton; // Кнопка выбора опций цели кредита

    @FindBy(xpath = ".//div[@class = 'Select-menu']/div[@role = 'option']")
    public List<WebElement> itemOption; // Опции цели кредита
    //ссылки на поля заполнения
    //input[contains(@class,'dcCalc')]
    @FindBy(xpath = " //input[contains(@class,'dcCalc')]")
    public List<WebElement> fields;

    public void sendField(int i, String value) {

        fields.get(i).click();
        fields.get(i).clear();

        fields.get(i).sendKeys(value);
        value = filtersField(i, value);
        System.out.println(fields.get(i).getAttribute("value"));


        fields.get(i).sendKeys(Keys.ENTER);
        String actualValue = fields.get(i).getAttribute("value");

        BaseStep.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(String.format("Не так заполнено поле [%s] || [%s]", value, actualValue), value.contains(actualValue));
    }

    public void sendCheck(int i, String value) {
        wait.until(ExpectedConditions.visibilityOf(fields.get(i)));
        if (value.equals("true")) fields.get(i)
                .findElement(By.xpath("./..")).click();
    }

    private String filtersField(int j, String str) {
        if ((j == 1) || (j == 2)) {
            str = str.concat(" \u20BD");
            StringBuffer sb = new StringBuffer(str.subSequence(0, str.length()));
            sb = sb.insert(4, " ");
            sb = sb.insert(1, " ");
            str = sb.toString();
        }
        if (j == 3) str = str.concat(" лет");
        return str;
    }

    public WebElement sendString(String value) {

        WebElement webelement = BaseStep.getDriver().findElement(By.xpath("//*[contains(@value,'" + value + "')]"));
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
        return webelement;
    }

    public void getList(String valeu) {

        new Actions(BaseStep.getDriver()).moveToElement(itemButton);


        wait.until(ExpectedConditions.visibilityOf(itemButton));
        wait.until(ExpectedConditions.elementToBeClickable(itemButton));

        itemButton.click();
        wait.until(ExpectedConditions.visibilityOf(itemOption.get(0)));

        for (WebElement item : itemOption) {
            if (item.getText().equals(valeu)) {
                item.click();
                return;
            }
        }

    }
}
