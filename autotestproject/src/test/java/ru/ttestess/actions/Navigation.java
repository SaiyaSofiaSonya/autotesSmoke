package ru.ttestess.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.util.logging.Logger;

public class Navigation extends Base {

    public Navigation(WebDriver driver) {super(driver);}

    Logger logger = Logger.getLogger(Navigation.class.getName());

    // Admin Potal

    public void homePage() {
        click(By.xpath("//*[@href= 'ajax/dashboard']"));
        if(isElementInDOM(By.xpath("//*[@id= 'dashboard-netmap']"))){
            return;};
    }

    //Locator reports

    public void byCountryLocatorPage(){
        if(isElementInDOM(By.xpath(""))){
            return;}

        // нажимаем на Locator report
        driver.findElement(By.id("Passenger-Localization")).click();


        //нижимаем на By country
        driver.findElement(By.id("by-Countries")).click();

        waitALoadToBeVisible(10, By.id("whoreport_wrapper"));
    }

    public void byAreaLocatorPage(){
        if(isElementInDOM(By.xpath(""))){
            return;}

        // нажимаем на Locator report
        driver.findElement(By.id("Passenger-Localization")).click();


        //нижимаем на By area
        driver.findElement(By.id("by-Area")).click();

        waitALoadToBeVisible(10, By.id("whoreport_wrapper"));
    }

    public void byAirportLocatorPage(){
        if(isElementInDOM(By.xpath(""))){
            return;}

        // нажимаем на Locator report
        driver.findElement(By.id("Passenger-Localization")).click();


        //нижимаем на By area
        driver.findElement(By.id("by-Airports")).click();

        waitALoadToBeVisible(10, By.id("whoreport_wrapper"));
    }

    public void byAirTrafficAnalysisLocatorPage(){
        if(isElementInDOM(By.xpath(""))){
            return;}

        // нажимаем на Locator report
        driver.findElement(By.id("Passenger-Localization")).click();


        //нижимаем на By area
        driver.findElement(By.id("by-Air-Traffic-Analysis")).click();

        waitALoadToBeVisible(10, By.id("whoreport_wrapper"));
    }






    //Admin reports


    public void passengerBookingReportAR(){
        if(isElementInDOM(By.xpath("(//i[@class='fa fa-table'])[1]"))) {return;}
        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на Booking report на боковой панели

        driver.findElement(By.id("Booking-Data-Report")).click();

        //Нажимаем на Passengers на правой боковой панели
        waitALoadToClick(1, By.id("passtab"));
        driver.findElement(By.id("passtab")).click();
        waitALoadToBeVisible(10, By.xpath("//li[@class = 'active']/a[@id = 'passtab']"));

    }

    public void comfirmationReport(String company){

        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на Confirmation  report на боковой панели

        driver.findElement(By.id("Confirmation-Report")).click();

        waitALoadToBeVisible(10, By.xpath(String.format("//*[contains(text(), '%s')]", company)));

    }


    public void emergencyCall(String company){

        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на Emergency Call на боковой панели

        driver.findElement(By.id("Emergency-Call-Report")).click();

        waitALoadToBeVisible(10,
                By.xpath("//*[@class = '\"table responsive nowrap table-striped table-bordered table-ajax dataTable\"']"));

    }

    public void emailLogPage() {

        if(isElementInDOM(By.xpath("//h4[text()='Email Log']"))){
       return;}

        click(By.id("Admin-Reports"));
       logger.info("Админ репорт");
       click(By.xpath("//li[@id = 'Admin-Reports']//a[@href = 'ajax/logs']"));
       click(By.id("elog"));
       logger.info("Емаил лог");
       waitALoadToClick(240, By.xpath("(//td/button)[1]"));
        logger.info("емаил лог загружен");

    }


    public void pnrReportPage(String date, int reportDay, String company) throws ParseException {
        if(isElementInDOM(By.xpath("i//span[text()='Future Trips Report']"))){
            return;}

        click(By.id("Admin-Reports"));
        click(By.id("PNR-Report"));
        click(By.xpath("//*[@class= 'beauty-table-to-json nreport']"));
        input(By.xpath("//*[@class = 'form-horizontal fv-form fv-form-bootstrap' ]//*[@name='ofdate']"), date);
        input(By.xpath("//*[@class = 'form-horizontal fv-form fv-form-bootstrap' ]//*[@name='otdate']"),
        dateIncrement(date, reportDay));
        click(By.xpath("//*[@class = 'form-horizontal fv-form fv-form-bootstrap']//*[@name= 'generate']"));
         //Подождать пока таблица загрузиться
        waitALoadToBeVisible(10, By.xpath(String.format("//*[contains(text(), %s]", company)));
        logger.info("Перешли в отчет pnrReport и сформировали репорт за дату + 1 день ");
    }

    public void futureTrip(String date, int reportDay, String company) throws ParseException {
        if(isElementInDOM(By.xpath("i//span[text()='Future Trips Report']"))){
            return;}

        click(By.id("Admin-Reports"));
        logger.info("Админ репорт");
        click(By.id("Future-Trips-Report"));
        click(By.xpath("//*[@class= 'beauty-table-to-json nreport']"));
        input(By.xpath("//*[@class='datetimepicker']//*[@name= 'dfdate']"), date);
        input(By.xpath("//*[@class='datetimepicker']//*[@name= 'dtdate']"),
                dateIncrement(date, reportDay));
        click(By.xpath("//*[@class= 'form-horizontal fv-form fv-form-bootstrap']//*[@name= 'generate']"));
        waitALoadToBeVisible(10, By.xpath(String.format("//*[contains(text(), %s]", company)));
        logger.info("Future report сформирован ");
    }


    public void pccReport(){
        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на PCC report на боковой панели

        driver.findElement(By.id("PCC-Report")).click();

        waitALoadToBeVisible(10,
                By.xpath("(//*[@class = \"table responsive nowrap table-striped table-bordered table-ajax dataTable\"])[1]"));

    }

    public void riskRatingReport(){
        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на PCC report на боковой панели

        driver.findElement(By.id("Risk-Rating-Change-Report")).click();

        waitALoadToBeVisible(10,
                By.xpath("(//*[@class = \"table responsive nowrap table-striped table-bordered table-ajax dataTable\"])[1]"));


    }

    public void adminLog(){
        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на User Log reports на боковой панели

        driver.findElement(By.id("User-Log-Reports")).click();

        //Нажимаем на Admin log report на правой панели

        driver.findElement(By.id("alog")).click();

        waitALoadToBeVisible(10,
                By.xpath("(//*[@class = \"table responsive nowrap table-striped table-bordered table-ajax dataTable\"])[1]"));
   }

    public void fulladminLog(){
        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на User Log reports на боковой панели

        driver.findElement(By.id("User-Log-Reports")).click();

        //Нажимаем на Admin log report на правой панели

        driver.findElement(By.id("clog")).click();

        waitALoadToBeVisible(10,
                By.xpath("(//*[@class = \"table responsive nowrap table-striped table-bordered table-ajax dataTable\"])[1]"));
    }

    public void fullPassengerLog(){
        //Нажимаем на Admin portal на боковой панели
        driver.findElement(By.id("Admin-Reports")).click();

        //Нажимаем на User Log reports на боковой панели

        driver.findElement(By.id("User-Log-Reports")).click();

        //Нажимаем на Admin log report на правой панели

        driver.findElement(By.id("passlog")).click();

        waitALoadToBeVisible(10,
                By.xpath("(//*[@class = \"table responsive nowrap table-striped table-bordered table-ajax dataTable\"])[1]"));
    }

  //App management
    //Company settings
  public   void companySettings(){
        isElementInDOM(By.xpath("(//th[@data-column-index = \'0\'])[1]"));

    //Нажимаем на App management на боковй панели
    driver.findElement(By.id("Device-Management")).click();
      logger.info("перешла в App Settings ");

    //Нажимаем на Company settings на бокой панели
      waitALoadToClick(1, By.xpath("//li[@id='App-General-Settings']/a"));
      driver.findElement(By.xpath("//li[@id='App-General-Settings']/a")).click();
      logger.info("перешла в Company settings ");

    waitALoadToBeVisible(10, By.xpath(String.format("//li[contains(text(), '%s')]", "Assistance")));


  }


//Travel portal

    public void alertTPPage() {

     if(isElementInDOM(By.id("tpname"))){
            return;}
    click(By.id("Travel-Portal"));
    isElementInDOM(By.id("tpname"));
    logger.info("alert TP");
    click(By.id("alerts"));
    }

    public void back(){
        driver.navigate().back();
        if(isElementInDOM(By.xpath("//*[@id= 'dashboard-netmap']"))){
            return;}
    }


}
