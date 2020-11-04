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

public class AdminLogUserLogAR extends Base {
    public AdminLogUserLogAR(WebDriver driver) {super(driver);}
    Logger logger = Logger.getLogger(AdminLogUserLogAR.class.getName());

    public Set<String> getSetCompanies(int reportDays, String startDate, String company) throws ParseException {
        Set<String> companies = new HashSet<>();




        generate(null, reportDays, startDate,
                By.id("newreport-alog"),                                                       //By newReportLocator
                null,                                                                                  //By countryFieldLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='fdate']"),                               //By startDatelocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='tdate']"),                               // By endDateLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//button[@name = 'generate']"),                         //By submitButtonLocator
                By.xpath(String.format("//td[contains(text(), '%s')][1]", company)));                                   //By tableVisibilityLocator


        //В множество сохранить компании из таблицы
        if (!isElementInDOM(By.xpath("//td[@class = 'dataTables_empty']"))) {

            waitALoadToBeVisible(2, By.xpath(String.format("//*[contains(text(), '%s')]", company)));
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));


            for (WebElement row : rows) {
                String companyRow = row.findElement(By.xpath("(./td)[2]")).getText();

                companies.add(companyRow);

            }


        }   return companies;



}}
