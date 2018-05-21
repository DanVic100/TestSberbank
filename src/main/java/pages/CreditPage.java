package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;

public class CreditPage extends BasePage {


    //ищем раздел с надписью
    public WebElement findPart(String string) {

        string = "//*[contains(text(),'" + string + "')]";

        WebElement labelPart = BaseStep.getDriver().findElement(By.xpath(string));
        new Actions(BaseStep.getDriver()).moveToElement(labelPart).build().perform();
        return labelPart;
    }

    //ищем кнопку с надписью
    public WebElement findButton(String string) {

        string = string.substring(0, 4);
        string = "//*[contains(@aria-label,'" + string + "')]" + "/../..";
        WebElement labelPart = BaseStep.getDriver().findElement(By.xpath(string));
        new Actions(BaseStep.getDriver()).moveToElement(labelPart).build().perform();
        return labelPart;
    }
}
