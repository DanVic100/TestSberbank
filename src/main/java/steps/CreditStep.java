package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CreditPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CreditStep {

    CreditPage creditPage = new CreditPage();

    @Step("Жмем кнопку {0}")
    public void clickCalkulate(String str) {

        creditPage.findButton(str).click();
        BaseStep.getDriver().get(creditPage.findButton(str).findElement(By.tagName("a")).getAttribute("href"));

    }

    @Step("Ищем {0}")
    public void goTo(String str) {
        creditPage.findPart(str);

        //проверка надписи
        String label = creditPage.findPart(str).getText();
        Assert.assertEquals("Надпись не найдена", str, label);
    }


}
