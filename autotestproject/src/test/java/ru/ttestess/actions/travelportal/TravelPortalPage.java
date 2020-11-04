package ru.ttestess.actions.travelportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.ttestess.actions.Base;

import java.util.logging.Logger;

public class TravelPortalPage extends Base {
    public TravelPortalPage(WebDriver driver) {super(driver);}
    Logger logger = Logger.getLogger(TravelPortalPage.class.getName());


    public String getNameOfTravelPortal(){
        String name = null;
        try { name = driver.findElement(By.id("tpname")).getText();}
        catch (Exception E) {logger.info("The page is not displayed");}


            return name;
        }

}
