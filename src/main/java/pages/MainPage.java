package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainPage extends BasePage {


    /**
     * @param nameMenu имя искомого меню
     * @return Webelement искомого меню
     */
    public void selectMenu(String nameMenu, String subMenu) {

        List<WebElement> menu = BaseStep.getDriver()
                .findElements(By.xpath("//a[contains(@aria-label,Раздел)]"));

        for (WebElement selected : menu) {
            if (selected.getText().replaceAll("\\s+", " ").contains(nameMenu)) {
                new Actions(BaseStep.getDriver()).moveToElement(selected).build().perform();
                selectSubMenu(subMenu);
                return;
            }

        }
        Assert.fail("Нет такого меню: " + nameMenu);
    }

    /**
     * @param nameSub имя подменю
     *                <p>
     *                вызывает подменю из меню
     */
    private void selectSubMenu(String nameSub) {


        WebElement select = (WebElement) BaseStep.getDriver()
                .findElement(By.xpath("//a[contains(text(),'" + nameSub + "')]"));

        new WebDriverWait(BaseStep.getDriver(), 10)
                .until(ExpectedConditions.visibilityOf(select));

        if (select.isDisplayed()) {
            select.click();
        } else {
            Assert.fail("Нет такого подменю: " + nameSub);
        }
    }
}
