package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainStep {

    MainPage mainPage = new MainPage();

    @Step("^меню {0} и услуга {1}$")
    public void getMenu(String menu, String subMenu )
    {
       mainPage.selectMenu(menu,subMenu);
    }

}
