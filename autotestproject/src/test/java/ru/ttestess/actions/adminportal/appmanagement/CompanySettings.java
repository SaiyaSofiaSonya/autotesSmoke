package ru.ttestess.actions.adminportal.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CompanySettings extends Base {

    Logger logger = Logger.getLogger(CompanySettings.class.getName());
    public CompanySettings(WebDriver driver){
        super(driver);}


    public List <String> getCompanyList(){
        List <String> companies = new ArrayList<>();

        List <WebElement> rows = driver.findElements(By.xpath("//table[@id = 'device']//tbody//tr"));
        logger.info("Company settings.App management: Размер записанного массива для таблицы: = "+rows.size());

        for (WebElement row: rows){

            String company = row.findElement(By.xpath("(.//td)[1]")).getText();
            logger.info("Company settings.App management: Название компании в таблице: "+company);
            companies.add(company);



        }

    return companies;}

}
