package steps;

import org.junit.Assert;
import pages.DomClicResultPage;
import ru.yandex.qatools.allure.annotations.Step;

public class DomClicResultStep {
    DomClicResultPage domClicResultPage = new DomClicResultPage();

    @Step("Проверяем поле {0} и значене {1}")
    public void revision(String field,String value){
        switch(field){
            case"Сумма кредита":
                domClicResultPage.revis(0,value);
                break;
            case"Ежемесячный платеж":
                domClicResultPage.revis(1,value);
                break;
            case"процентная ставка":
                domClicResultPage.revis(2,value);
                break;
            case"Необходимы доход":
                domClicResultPage.revis(3,value);
                break;
            default:
                Assert.fail("Нет такого поля проверки");
        }
    }

    public void asser(String str) {
        Assert.assertTrue(String.format("Ожидаемый заголовок",str,domClicResultPage.title.getText()),
                domClicResultPage.title.getText().contains(str));
    }
}
