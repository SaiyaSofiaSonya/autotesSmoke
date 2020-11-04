package ru.ttestess.actions.adminportal.adminreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;
import ru.ttestess.dataarea.FutureTripData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class FutureTripPage extends Base {
    Logger logger = Logger.getLogger(FutureTripPage.class.getName());
    String arrivalDate;
    String bookingType;
    String passengerName;
    String country;
    String emailAddress;
    List<FutureTripData> futureTrips;
    public FutureTripPage(WebDriver driver) {super(driver);}

    public List<FutureTripData> getFutureTripList(String requiredDate){

        logger.info("FutureTrip");
        waitALoadToBeVisible(7, By.xpath("//*[@id = 'sn']//tr/td")); // КОСТЫЛЬ!! Разобраться
        selectEntriesOnPage(By.name("tripreport_length"), By.xpath("//*[@name = 'tripreport_length']//*[@value = '-1']"));
        waitALoadToBeVisible(7, By.xpath("//*[@id = 'sn']//tr/td")); // КОСТЫЛЬ!! Разобраться

        futureTrips= new ArrayList<>();

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tripreport']//tbody//tr"));
        logger.info("Создан список для нужных записей и все записи на страниы записаны в массив " + rows.size());
        getPageData(rows, futureTrips);

        return futureTrips;
    }
    public void getPageData(List<WebElement> rows, List<FutureTripData> alerts){
        int i = 0;
        for (WebElement row: rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));

            i++;
            logger.info("Массив из ячеек создан"+i);

            arrivalDate = cells.get(0).getText();
            bookingType = cells.get(1).getText();
            passengerName = cells.get(2).getText();
            country = cells.get(3).getText();
           // emailAddress = cells.get(6).getText();


            alerts.add(new FutureTripData().withArrivalDate(arrivalDate).withBookingType(bookingType)
                    .withPassengerName(passengerName).withCountry(country).withEmailAddress(emailAddress));
        }
    }


    public Set<String> getSetCompanies(String company){
        Set<String> companies = new HashSet<>();


        //Во множество сохранить компании из таблицы
        if (!isElementInDOM(By.xpath("//td[@class = 'dataTables_empty']"))) {

            waitALoadToBeVisible(2, By.xpath(String.format("//*[contains(text(), '%s')]", company)));
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));
            logger.info("FutureTrip.Admin report: Размер записанного массива для таблицы: = " + rows.size());

            for (WebElement row : rows) {
                String companyRow = row.findElement(By.xpath("(./td)[1]")).getText();
                logger.info("FutureTrip.Admin report: Название компании в таблице: " + companyRow);
                companies.add(companyRow);

            }


        }   return companies;



    }

}
