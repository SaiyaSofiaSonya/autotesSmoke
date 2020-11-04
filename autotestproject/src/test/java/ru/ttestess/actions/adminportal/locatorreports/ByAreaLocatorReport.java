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

public class ByAreaLocatorReport extends Base {
    Logger logger = Logger.getLogger(ByAreaLocatorReport.class.getName());

    public ByAreaLocatorReport(WebDriver driver){
        super(driver);}

    public Set<String> getSetByArea(String country, int reportDays, String startDate) throws ParseException {
        Set<String> companies = new HashSet<>();


        // cсгнерировать репорт и передать параметры в метод: String country, int reportDay, String startDate, By newReportLocator,
        //                       By countryFieldLocator, By startDatelocator,
        //                       By endDateLocator, By submitButtonLocator, By tableVisibilityLocator


        generate(null, reportDays, startDate,
                By.cssSelector("a.beauty-table-to-json.rreport"),                                                       //By newReportLocator
                null,                                                                                  //By countryFieldLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='dfdate']"),                               //By startDatelocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='dtdate']"),                               // By endDateLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//button[@name = 'generate' ]"),                         //By submitButtonLocator
                By.xpath(String.format("//td[contains(text(), '%s')][1]", country)));                                   //By tableVisibilityLocator


        //В множество сохранить компании из таблицы
        List<WebElement> rows = driver.findElements(By.xpath(".//div[@class = 'dataTables_scrollBody']//tbody//tr"));
        logger.info("By area.Locator report: Размер записанного массива для таблицы: = "+rows.size());

        for(WebElement row:rows){
            String company = row.findElement(By.xpath("//td[2]")).getText();
            companies.add(company);
            logger.info("By area.Locator report: : Название компании в таблице: "+company); }

        return companies;}

}
