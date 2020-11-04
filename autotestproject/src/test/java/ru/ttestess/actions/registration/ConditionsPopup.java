package ru.ttestess.actions.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.ttestess.actions.Base;

import java.util.logging.Logger;

public class ConditionsPopup  extends Base {
    Logger logger = Logger.getLogger(ConditionsPopup.class.getName());

    public ConditionsPopup(WebDriver driver){
        super(driver);}

    public void acceptConditions(){

        driver.findElement(By.xpath("(//div[@class = 'modal-content']//button[@class ='btn btn-success continue_regaccept'])[1]"))
                .click();

    }
}
