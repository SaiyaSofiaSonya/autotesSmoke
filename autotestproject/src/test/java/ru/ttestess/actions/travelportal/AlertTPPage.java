package ru.ttestess.actions.travelportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;
import ru.ttestess.dataarea.AlertTPData;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AlertTPPage extends Base {
    public AlertTPPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = Logger.getLogger(AlertTPPage.class.getName());
    String date;
    String country;
    String urgency;
    String description;
    List<AlertTPData> alerts;



    public List<AlertTPData> getAlertsList(String dateRequired) throws InterruptedException {

        logger.info("TP Alert1");

        searchAndFilterListBy(dateRequired, By.xpath("//*[@id='walerts_filter']//input"));
        waitALoadToBeVisible(5, By.xpath("//*[@id = 'sn']//tr/td")); //
        selectEntriesOnPage(By.name("walerts_length"), By.xpath("//*[@name = 'walerts_length']//*[@value = '-1']"));
        waitALoadToBeVisible(5, By.xpath("//*[@id = 'sn']//tr/td")); //

        alerts= new ArrayList<>();
   //     int t = 0;

     //   while(t == 0) {

            List<WebElement> rows = driver.findElements(By.xpath("//*[@id='walerts']//tbody//tr"));
            logger.info("Создан список для нужных записей и все записи на страниы записаны в массив " + rows.size());
            getPageData(rows, alerts);



   //     }
        logger.info("Переменные сохранены в массив");

        return alerts;
    }


        public void getPageData(List<WebElement> rows, List<AlertTPData> alerts){

        for (WebElement row: rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            date = cells.get(0).getText();
            country = cells.get(1).getText();;
            urgency = cells.get(2).getText();;
            description = cells.get(4).getText().substring(0, 40);

            alerts.add(new AlertTPData().withDate(date).withCountry(country)
                    .withUrgency(urgency).withDescription(description));


        }

        }

}