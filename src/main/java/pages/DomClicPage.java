package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DomClicPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(BaseStep.getDriver(), 15);

    @FindBy(xpath = "//div[@class = 'dcCalc_frame']//div[contains(text(),'Цель кредита')]/following-sibling::div//input[@class = 'dcCalc_textfield__input']")
    public WebElement itemButton; // Кнопка выбора опций цели кредита

    @FindBy(id = "estateCost")
    public WebElement estateCost;

    @FindBy(id = "initialFee")
    public WebElement initialFee;

    @FindBy(id = "creditTerm")
    public WebElement creditTerm;


    public void sendField(WebElement element, String value) {

        new WebDriverWait(BaseStep.getDriver(), 10).until((ExpectedCondition<Boolean>) driver -> {
            element.clear();
            element.sendKeys(value);
            new Actions(BaseStep.getDriver()).sendKeys(Keys.TAB).perform();
            String actualResult = element.getAttribute("value").replaceAll(" ", "");
            return actualResult.contains(value);
        });

     /*   fields.get(i).clear();

        fields.get(i).sendKeys(value);
        value = filtersField(i, value);
        System.out.println(fields.get(i).getAttribute("value"));


        fields.get(i).sendKeys(Keys.ENTER);
        String actualValue = fields.get(i).getAttribute("value");

        BaseStep.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(String.format("Не так заполнено поле [%s] || [%s]", value, actualValue), value.contains(actualValue));*/
    }

    public void sendCheck(String value) {
        WebElement checkBox = BaseStep.getDriver().findElement(By.xpath("//*[text()='"+value
                +"']//ancestor::div[@class = 'dcCalc_switch-desktop']/div[2]"));
        ((JavascriptExecutor) BaseStep.getDriver()).executeScript("arguments[0].scrollIntoView(false);", checkBox);
        switch (value) {
            case "true":
                if (checkBox.findElement(By.xpath("//span[@class = 'dcCalc_switch__icon-off']")).isDisplayed()) {
                    checkBox.findElement(By.xpath(".//label")).click();
                    try {
                        wait.until(ExpectedConditions
                                .visibilityOf(checkBox
                                        .findElement(By
                                                .xpath(".//span[@class = 'dcCalc_switch__icon-on'])"))));
                    } catch (TimeoutException e) {
                        checkBox.findElement(By.xpath(".//label")).click();
                        wait.until(ExpectedConditions
                                .visibilityOf(checkBox
                                        .findElement(By
                                                .xpath(".//span[@class = 'dcCalc_switch__icon-on'])"))));
                    }
                }
                System.out.println(value + "true");
                break;
            case "false":
                if (checkBox.findElement(By.xpath(".//span[@class = 'dcCalc_switch__icon-on'])")).isDisplayed()) {
                    checkBox.findElement(By.xpath(".//label")).click();
                    try {
                        wait.until(ExpectedConditions
                                .visibilityOf(checkBox
                                        .findElement(By
                                                .xpath("//span[@class = 'dcCalc_switch__icon-off']"))));
                    } catch (TimeoutException e) {
                        checkBox.findElement(By.xpath(".//label")).click();
                        wait.until(ExpectedConditions
                                .visibilityOf(checkBox
                                        .findElement(By
                                                .xpath("//span[@class = 'dcCalc_switch__icon-off']"))));
                    }
                }System.out.println(value + " false");
                break;
        }
    }

 /*   private String filtersField(int j, String str) {
        if ((j == 1) || (j == 2)) {
            str = str.concat(" \u20BD");
            StringBuffer sb = new StringBuffer(str.subSequence(0, str.length()));
            sb = sb.insert(4, " ");
            sb = sb.insert(1, " ");
            str = sb.toString();
        }
        if (j == 3) str = str.concat(" лет");
        return str;
    }*/

    public WebElement sendString(String value) {

        WebElement webelement = BaseStep.getDriver().findElement(By.xpath("//*[contains(@value,'" + value + "')]"));
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
        return webelement;
    }

   /* public void getList(String valeu) {

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

    }*/

    public void selectCreditReason(String valueOfOption) {
        ((JavascriptExecutor) BaseStep.getDriver()).executeScript("arguments[0].scrollIntoView(false);", itemButton);
        new Actions(BaseStep.getDriver()).moveToElement(itemButton).perform();
        wait.until(ExpectedConditions.visibilityOf(itemButton));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(itemButton)).click();
        } catch (WebDriverException e) {
            wait.until(ExpectedConditions.elementToBeClickable(itemButton)).click();
        }
        wait.until(ExpectedConditions.visibilityOf(
                BaseStep.getDriver().findElement(By.xpath("//*[text()='" + valueOfOption + "']")))).click();
    }


}
