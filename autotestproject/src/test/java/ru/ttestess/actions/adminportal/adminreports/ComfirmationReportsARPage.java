package ru.ttestess.actions.adminportal.adminreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class ComfirmationReportsARPage extends Base {


    public ComfirmationReportsARPage(WebDriver driver) {super(driver);}
    Logger logger = Logger.getLogger(EmailLogPage.class.getName());


    public Set<String> getSetPassengers(int reportDays, String startDate, String company ) throws ParseException {
     Set<String> companies = new HashSet<>();



        generate(null, reportDays, startDate,
                By.cssSelector("a.beauty-table-to-json.nreport"),                                                       //By newReportLocator
                null,                                                                                  //By countryFieldLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='reqfdate']"),                               //By startDatelocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='reqtdate']"),                               // By endDateLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//button[@name = 'generate']"),                         //By submitButtonLocator
                By.xpath(String.format("//td[contains(text(), '%s')][1]", company)));                                   //By tableVisibilityLocator


        //В множество сохранить компании из таблицы
        waitALoadToBeVisible(2, By.xpath(String.format("//*[contains(text(), '%s')]", company)));
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));


        for(WebElement row:rows){
            String companyRow = row.findElement(By.xpath("(./td)[1]")).getText();
                       companies.add(companyRow);
             }

        return companies;}

}
