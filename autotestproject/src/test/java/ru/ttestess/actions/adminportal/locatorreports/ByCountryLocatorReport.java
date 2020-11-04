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

public class ByCountryLocatorReport extends Base {
    Logger logger = Logger.getLogger(ByCountryLocatorReport.class.getName());

    public ByCountryLocatorReport(WebDriver driver){
        super(driver);}


    public Set<String> getSetByCountry(String country, int reportDays, String startDate) throws ParseException {
    Set<String> companies = new HashSet<>();


    // cсгнерировать репорт и передать параметры в метод: String country, int reportDay, String startDate, By newReportLocator,
        //                       By countryFieldLocator, By startDatelocator,
        //                       By endDateLocator, By submitButtonLocator, By tableVisibilityLocator


    generate(country, reportDays, startDate, By.cssSelector("a.beauty-table-to-json.nreport"),
            By.xpath("//div[@class = 'form-group has-feedback']//ul[@class = 'select2-selection__rendered']//input"),
            By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='dfdate']"),
                    By.xpath("//div[@class = 'devoops-modal-inner']//input[@name='dtdate']"),
                            By.xpath("//div[@class = 'devoops-modal-inner']//button[@name = 'generate' ]"),
                            By.xpath(String.format("//td[contains(text(), '%s')][1]", country)));


        //В множество сохранить компании из таблицы
    List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'dataTables_scrollBody']//tbody//tr"));
    logger.info("By country.Locator report: Размер записанного массива для таблицы: = "+rows.size());

        for(WebElement row:rows){
            String company = row.findElement(By.xpath(".//td[2]")).getText();
            companies.add(company);
            logger.info("By country.Locator report: : Название компании в таблице: "+company); }

    return companies;}


    }




