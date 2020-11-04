package ru.ttestess.actions.adminportal.adminreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;
import ru.ttestess.dataarea.PNRreportData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class PNRReportPage extends Base {
    public PNRReportPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = Logger.getLogger(PNRReportPage.class.getName());

    public List<PNRreportData> getListInPNRReport(String companyRequired) {
        String pnr;
        String bookingDate;
        String lastUpdate;
        String passengerName;
        String company;
        String bookingCategory;

        searchAndFilterListBy(companyRequired, By.xpath("//*[@id = 'pnrreport_filter' ]//*[@type='search']"));

        List<PNRreportData> pnrReportList = new ArrayList<>();

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='pnrreport_wrapper']//tbody//tr"));

        for (WebElement row : rows) {

            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            company = cells.get(4).getText();
            if (company.equals(companyRequired)) {

                pnr = cells.get(0).getText();
                bookingDate = cells.get(1).getText();
                lastUpdate = cells.get(2).getText();
                passengerName = cells.get(3).getText();
                bookingCategory = cells.get(5).getText();
                System.out.println(company + ":  Переменные записаны - " + pnr + bookingDate + lastUpdate + passengerName + bookingCategory);

                pnrReportList.add(new PNRreportData().withBookingDate(bookingDate).withPassengerName(passengerName)
                        .withBookingCategory(bookingCategory).withPnr(pnr).withCompany(company));

            }
        }
        return pnrReportList;
    }


    public Set<String> getSetCompanies(String company){
        Set<String> companies = new HashSet<>();


        //Во множество сохранить компании из таблицы
        if (!isElementInDOM(By.xpath("//td[@class = 'dataTables_empty']"))) {

            waitALoadToBeVisible(2, By.xpath(String.format("//*[contains(text(), '%s')]", company)));
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));
            logger.info("PNRReport.Admin report: Размер записанного массива для таблицы: = " + rows.size());

            for (WebElement row : rows) {
                String companyRow = row.findElement(By.xpath("(./td)[5]")).getText();
                logger.info("PNRReport.Admin report: Название компании в таблице: " + companyRow);
                companies.add(companyRow);

            }


        }   return companies;



    }
}
