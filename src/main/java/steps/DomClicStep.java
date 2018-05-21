package steps;

import org.junit.Assert;
import pages.DomClicPage;
import ru.yandex.qatools.allure.annotations.Step;

public class DomClicStep {

    DomClicPage domClicPage = new DomClicPage();

    @Step("Заполняем поля")
    public void send(String field, String value) {

        switch (field) {
            case "Цель кредита":
                domClicPage.getList(value);
                break;
            case "Стоимость недвижимости":
               domClicPage.sendField(1,value);
                break;
            case "Предварительный взнос":
                domClicPage.sendField(2,value);
                break;
            case "Срок кредита":
                domClicPage.sendField(3,value);
                break;
            case "Скидка 0,3% при покупке квартиры на ДомКлик.":
                domClicPage.sendCheck(4,value);
                break;
            case "Есть зарплатная карта Сбербанка":
                domClicPage.sendCheck(5,value);
                break;
            case "Страхование жизни":
                domClicPage.sendCheck(6,value);
                break;
            case "Электронная регистрация":
                domClicPage.sendCheck(7,value);
                break;
            case "Молодая семья":
                domClicPage.sendCheck(8,value);
                break;
            default:
                Assert.fail("Нет такого поля заполнения");
        }
    }

    @Step
    public String getValueInField(String field) {
        String str = new String();
        switch (field) {
            case "сумма кредита":
                break;
            case "Ежемесячный платеж":
                break;
            case "необходимый доход":
                break;
            case "процентная ставка":
                break;
            default:
                Assert.fail("Нет такого поля для получения значения");

        }
        return str;
    }
}