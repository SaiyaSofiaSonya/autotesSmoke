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

public class FullAdminUserLogAR extends Base {
    public FullAdminUserLogAR(WebDriver driver) {
        super(driver);
    }

    Logger logger = Logger.getLogger(FullAdminUserLogAR.class.getName());

    public Set<String> getSetCompanies(int reportDays, String startDate, String company) throws ParseException {
        Set<String> companies = new HashSet<>();




        generate(null, reportDays, startDate,
                By.id("newreport-clog"),                                                       //By newReportLocator
                null,                                                                                  //By countryFieldLocator
                By.xpath("(//form[@id= 'fulladminform']//input[@name='fdate'])[1]"),                               //By startDatelocator
                By.xpath("(//form[@id= 'fulladminform']//input[@name='tdate'])[1]"),                               // By endDateLocator
                By.xpath("(//form[@id= 'fulladminform']//button[@name='generate'])[1]"),                         //By submitButtonLocator
                By.xpath(String.format("//td[contains(text(), '%s')][1]", company)));                                   //By tableVisibilityLocator


        //В множество сохранить компании из таблицы
        if (!isElementInDOM(By.xpath("//*[@id = 'clog']//td[@class = 'dataTables_empty']"))) {

            waitALoadToBeVisible(2, By.xpath(String.format("//*[contains(text(), '%s')]", company)));
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr[@role = 'row']"));
            logger.info("Full Admin Log.Admin report: Размер записанного массива для таблицы: = " + rows.size());

            for (WebElement row : rows) {
                String companyRow = row.findElement(By.xpath("(./td)[2]")).getText();
                logger.info("Full Admin Log.Admin report: Название компании в таблице: " + companyRow);
                companies.add(companyRow);

            }


        }
        return companies;

    }
}