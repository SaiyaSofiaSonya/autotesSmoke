package ru.ttestess.actions.adminportal.locatorreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class ByAirportLocatorReport extends Base {

    Logger logger = Logger.getLogger(ByAirportLocatorReport.class.getName());

    public ByAirportLocatorReport(WebDriver driver){
        super(driver);}


    public Set<String> getSetByAirport(String airport, int reportDays, String startDate) throws ParseException {
        Set<String> companies = new HashSet<>();


        // сгнерировать репорт и передать параметры в метод: String country/airport, int reportDay, Str
        //
        // ing startDate, By newReportLocator,
        //                       By countryFieldLocator/airport, By startDatelocator,
        //                       By endDateLocator, By submitButtonLocator, By tableVisibilityLocator


        generate(airport, reportDays, startDate,
                By.cssSelector("a.beauty-table-to-json.areport"),                                                       //By newReportLocator
                By.xpath("//div[@class = 'form-group has-feedback']//ul[@class = 'select2-selection__rendered']//input"),                                                                                  //By countryFieldLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='dfdate']"),                               //By startDatelocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='dtdate']"),                               // By endDateLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//button[@name = 'generate' ]"),                         //By submitButtonLocator
                By.xpath(String.format("//td[contains(text(), '%s')][1]", airport)));                                   //By tableVisibilityLocator


        //В множество сохранить компании из таблицы

        List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));
        logger.info("By airport.Locator report: Размер записанного массива для таблицы: = "+rows.size());

        for(WebElement row:rows){
            String company = row.findElement(By.xpath(".//td[2]")).getText();
            companies.add(company);
            logger.info("By airport.Locator report: : Название компании в таблице: "+company); }

        return companies;}
}
