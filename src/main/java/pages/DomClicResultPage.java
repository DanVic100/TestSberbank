package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;


import java.util.List;

public class DomClicResultPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'result')]//span")
    public List<WebElement> result;
    @FindBy(xpath = "//h1")
    public WebElement title;

    public void revis(int i,String valueExpected)
    {
        ((JavascriptExecutor) BaseStep.getDriver()).executeScript("arguments[0].scrollIntoView(false);", result.get(i));
        new Actions(BaseStep.getDriver()).moveToElement(result.get(i));
        WebDriverWait wait = new WebDriverWait(BaseStep.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(result.get(i)));
     //  String actual = result.get(i).getText();
        Assert.assertTrue(String.format("Ожидаемое - [%s], действительное - [%s]",valueExpected,result.get(i).getText()),
                valueExpected.contains(result.get(i).getText()));
    }

}
