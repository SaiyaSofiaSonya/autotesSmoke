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

public class RiskRatingReportPage extends Base {
    public RiskRatingReportPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = Logger.getLogger(RiskRatingReportPage.class.getName());

    public Set<String> getSetCompanies(int reportDays, String startDate, String company) throws ParseException {
        Set<String> companies = new HashSet<>();




        generate(null, reportDays, startDate,
                By.cssSelector("a.beauty-table-to-json.nreport"),                                                       //By newReportLocator
                null,                                                                                  //By countryFieldLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='ofdate']"),                               //By startDatelocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='otdate']"),                               // By endDateLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//button[@name = 'generate']"),                         //By submitButtonLocator
                By.xpath(String.format("//td[contains(text(), '%s')][1]", company)));                                   //By tableVisibilityLocator


        //В множество сохранить компании из таблицы
        if (!isElementInDOM(By.xpath("//td[@class = 'dataTables_empty']"))) {

            waitALoadToBeVisible(2, By.xpath(String.format("//*[contains(text(), '%s')]", company)));
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));
            logger.info("Risk rating report: Размер записанного массива для таблицы: = " + rows.size());

            for (WebElement row : rows) {
                String companyRow = row.findElement(By.xpath("(./td)[2]")).getText();
                logger.info("Risk rating report.Admin report: Название компании в таблице: " + companyRow);
                companies.add(companyRow);

            }


        }   return companies;
    }



}
