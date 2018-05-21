package pages;

import steps.BaseStep;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    WebDriver driver = BaseStep.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public BasePage (){
        PageFactory.initElements(BaseStep.getDriver(),this);
    }


}