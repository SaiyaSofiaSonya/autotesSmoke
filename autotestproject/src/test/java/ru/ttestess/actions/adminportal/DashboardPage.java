package ru.ttestess.actions.adminportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ttestess.actions.Base;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class DashboardPage extends Base {
    Logger logger = Logger.getLogger(DashboardPage.class.getName());

    public DashboardPage(WebDriver driver){
        super(driver);}
    By locator;

    public Set<String> getSet(){

       Set<String> companies = new HashSet<>();

       //Получение компаний из таблицы In Country
       getCompanyFromEachStatus(By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw1\"]/b"),
               By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw1\"]")
               , companies, "Incountry");

        //Получение компаний из таблицы In Airport
        getCompanyFromEachStatus(By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw2\"]/b"),
                By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw2\"]")
                , companies, "In Airport");

        //Получение компаний из таблицы Hotel
        getCompanyFromEachStatus(By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw3\"]/b"),
                By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw3\"]")
                , companies, "Hotel");

        //Получение компаний из таблицы Car
        getCompanyFromEachStatus(By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw5\"]/b"),
                By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw5\"]")
                , companies, "Car");

        //Получение компаний из таблицы Flights
        getCompanyFromEachStatus(By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw7\"]/b"),
                By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw7\"]")
                , companies, "Flights");

        //Получение компаний из таблицы GPS
        getCompanyFromEachStatus(By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw6\"]/b"),
                By.xpath("//*[@class=\"col-xs-2 col-sm-2 btn-default text-center mpbtn bot-sw6\"]")
                , companies, "GPS");

        return companies;
    }

    public Set<String> getCompanyFromEachStatus(By locatorNumber, By locatorOpenTable, Set<String> companies, String tableName){

        //Проверить есть ли пассажиры в локации
        String numberOfPassengersInText = driver
                .findElement(locatorNumber)
                .getText();
        logger.info("Dashboard: В таблице " + tableName + " количество пассажиров = "+ numberOfPassengersInText);

        int countOfPassengers = Integer.parseInt(numberOfPassengersInText);



       if(countOfPassengers!=0) {

            // Открываем таблицу
            driver.findElement(locatorOpenTable).click();

            //Ожидание загрузки таблицы. ориентир на кнопку Show
            By openTableLocator = By.xpath("//div[@class = \"dataTables_scrollBody\"]//tbody//tr") ;
            WebElement wait = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.xpath("(//button[@class = \"btn btn-default btn-sm btn-block btn-margin\"])[1]")));

            //В множество сохранить компании из таблицы
            List<WebElement> passengers = driver.findElements(openTableLocator);
            logger.info("Dashboard: Размер записанного массива для таблицы " + tableName + ": = "+passengers.size());

            for(WebElement passenger: passengers){
            String company = passenger.findElement(By.xpath("//td[2]")).getText();
            companies.add(company);
            logger.info("Dashboard: Название компании в таблице "+ tableName + ": "+company); }

        //Закрыть таблицу
            driver.findElement(By.xpath("//div[@class = \"box-icons\"]//i")).click();
        }

   return companies;


}
}

