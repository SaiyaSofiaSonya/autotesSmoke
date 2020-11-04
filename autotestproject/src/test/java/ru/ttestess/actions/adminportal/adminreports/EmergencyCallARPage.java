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

public class EmergencyCallARPage extends Base {
    public EmergencyCallARPage(WebDriver driver) {super(driver);}
    Logger logger = Logger.getLogger(EmailLogPage.class.getName());

    public Set<String> getSetPassengers(int reportDays, String startDate, String company) throws ParseException {
        Set<String> companies = new HashSet<>();



        generate(null, reportDays, startDate,
                By.cssSelector("a.beauty-table-to-json.nreport"),                                                       //By newReportLocator
                null,                                                                                  //By countryFieldLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='fdate']"),                               //By startDatelocator
                By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='tdate']"),                               // By endDateLocator
                By.xpath("//div[@class = 'devoops-modal-inner']//button[@name = 'generate']"),                         //By submitButtonLocator
                By.xpath(String.format("//td[contains(text(), '%s')][1]", company)));                                   //By tableVisibilityLocator


        //В множество сохранить компании из таблицы
        if (!isElementInDOM(By.xpath("//td[@class = 'dataTables_empty']"))) {

             waitALoadToBeVisible(2, By.xpath(String.format("//*[contains(text(), '%s')]", company)));
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));
            logger.info("EmergencyCall.Admin report: Размер записанного массива для таблицы: = " + rows.size());

            for (WebElement row : rows) {
                String companyRow = row.findElement(By.xpath("(./td)[1]")).getText();
                logger.info("EmergencyCall.Admin report: Название компании в таблице: " + companyRow);
                companies.add(companyRow);

            }


        }   return companies;
}

    public Set<String> getComponiesFromDropdown(String company){

        Set<String> companies = new HashSet<>();

        //Открыть дропдаун при генерации репорта
        driver.findElement(By.cssSelector("a.beauty-table-to-json.nreport")).click();
        driver.findElement(By.xpath("//*[@id = 'modalbox-inner']//span[@class = 'select2-selection select2-selection--single']")).click();

        //Ожилание, когда в дропдаун загрузятся названия компаний
        waitALoadToBeVisible(4, By.xpath(String.format("//ul[contains(text(), %s)]", company)));

        //Формируем список для записи компаний из дропдауна
        List<WebElement> rows = driver.findElements(By.xpath("//ul[@class = 'select2-results__options']"));
        logger.info("Emergency report.Admin report. The dropdown list size: " + rows.size());
        for(WebElement row: rows){
            company = row.getText();
            logger.info(company);
            companies.add(company);
        }

    return companies;}

}
