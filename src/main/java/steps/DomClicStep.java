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
                domClicPage.selectCreditReason(value);
                break;
            case "Стоимость недвижимости":
                domClicPage.sendField(domClicPage.estateCost, value);
                break;
            case "Предварительный взнос":
                domClicPage.sendField(domClicPage.initialFee, value);
                break;
            case "Срок кредита":
                domClicPage.sendField(domClicPage.creditTerm, value);
                break;
            case "Скидка 0,3% при покупке квартиры на ДомКлик.":
                domClicPage.sendCheck("Скидка ");
                break;
            case "Есть зарплатная карта Сбербанка":
                domClicPage.sendCheck(field);
                break;
            case "Страхование жизни":
                domClicPage.sendCheck(field);
                break;
            case "Электронная регистрация":
                domClicPage.sendCheck(field);
                break;
            case "Молодая семья":
                domClicPage.sendCheck(field);
                break;
            default:
                Assert.fail("Нет такого поля заполнения");
        }
    }
}