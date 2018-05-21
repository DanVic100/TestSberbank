package steps;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class ScenarioStep {

    MainStep mainStep = new MainStep();
    CreditStep creditStep = new CreditStep();
    DomClicStep domClicStep = new DomClicStep();
    DomClicResultStep domClicResult = new DomClicResultStep();

    @Пусть("^меню \"(.+)\" и услуга \"(.+)\"")
    public void goMenuSubMenu(String menu, String subMenu) {
        mainStep.getMenu(menu, subMenu);
    }

    @Тогда("^ищем раздел \"(.+)\"")
    public void goPart(String str) {
        creditStep.goTo(str);
    }

    @Тогда("^жмем \"(.+)\"")
    public void pressButton(String str) {
        creditStep.clickCalkulate(str);
        BaseStep.getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    }

    @Тогда("^проверяем заголовок \"(.+)\"$")
    public void assertTitle(String str){
        domClicResult.asser(str);

    }
    @Когда("^заполняем поля:")
    public void sendField(DataTable data) {
        data.asMap(String.class, String.class).forEach((field, value) -> domClicStep.send(field, value));
    }

    @Тогда("^проверяем поля:$")
    public void revisionField(DataTable data){
        data.asMap(String.class,String.class).forEach((name,value)->domClicResult.revision(name,value));
    }
}
