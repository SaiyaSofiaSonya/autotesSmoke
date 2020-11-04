package ru.ttestess.actions.adminportal.adminreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;
import ru.ttestess.dataarea.EmailLogData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class EmailLogPage extends Base {

    public EmailLogPage(WebDriver driver) {super(driver);}

    Logger logger = Logger.getLogger(EmailLogPage.class.getName());
    List<EmailLogData> logs = null;

    String timeStamp;
    String email;
    String typeInLog;
    boolean actualDate = true;




    public List<EmailLogData> getListInLog(String requiredTypeInLog, String requiredDate) throws ParseException {



        searchAndFilterListBy(requiredTypeInLog, By.xpath("//*[@id='elog_filter']//*[@type = 'search']"));
        while (actualDate = true) {


            logs = new ArrayList<>();
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'elog']//tbody/tr"));

            int numberOfIteration = 0;

            getPageData(rows, logs, requiredDate, requiredTypeInLog, numberOfIteration);


        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date requiredDateFormated = format.parse(requiredDate);
        Date timeStampFormated = format.parse(timeStamp);


        if (timeStampFormated.before(requiredDateFormated)) {

        break;
        }


        if (!driver.findElement(By.xpath("//div[@id = 'dashboard-elog']//li[@class='paginate_button active']//following::li[1]//a"))
                .getText().equals("Next")) {
            clickNextPangination(By.xpath("//div[@id = 'dashboard-elog']//li[@class='paginate_button active']//following::li[1]//a"));


        } else {
            break;}
    }

        return logs;

    }



    private boolean isTypeRequered(String requiredTypeInLog, String typeInLog) {
    if (requiredTypeInLog.equals(typeInLog)){



        return true;
    }
    else return false;
    }



    private boolean isDateActual(String timeStamp, String requiredDate) {
    if(timeStamp.contains(requiredDate)){

        return true;}

    else return false;
    }


    public void getPageData(List<WebElement> rows, List<EmailLogData> logs,
                            String requiredDate, String requiredTypeInLog, int numberOfIteration)
            throws ParseException {
        PDFPage pdf = new PDFPage(driver);
        for (WebElement row : rows) {

            ++numberOfIteration;


            List<WebElement> cells = row.findElements(By.tagName("td"));   //(By.xpath(".//*[name()='td']"));
            timeStamp = cells.get(0).getText();
           typeInLog = cells.get(1).getText();



            if (isTypeRequered(requiredTypeInLog, typeInLog)) {


                if (isDateActual(timeStamp, requiredDate)) {

                    email = cells.get(2).getText();
                    row.findElement(By.xpath(".//*[name() = 'button']")).click();


                    if (typeInLog.equals("PNR Created")){
                        if(searchStringByWord("Dear").getText().contains("Risk")) {

                        pdf.pnrCreatedForRiskManager(); // названия ПДФов

                        logs.add(new EmailLogData().withTimeStampInLog(timeStamp)
                                .withEmail(email).withTypeInLog(requiredTypeInLog).withCountry(pdf.withDepatureCountry())
                                .withEmailTraveller(pdf.withEmailTraveller()).withNameTraveller(pdf.withNameTraveller())
                                .withSurnameTraveller(pdf.withSurnameTraveller())
                                .withDateOfDeparture(pdf.withDateOfDeparture()).withArivalCountry(pdf.withArivalCountry()));

                        closeX(By.xpath("//i[@class = 'fa fa-times']"));
 //       logger.info("Переменные сохранены в массив, ПДФ закрыт");

                    } else if (searchStringByWord("testr").getText().contains("for")) {

                        pdf.pnrCreatedForTravellers(); // названия ПДФов

                        logs.add(new EmailLogData().withTimeStampInLog(timeStamp)
                                .withEmail(email).withTypeInLog(requiredTypeInLog).withCountry(pdf.withDepatureCountry())
                                .withEmailTraveller(email).withNameTraveller(pdf.withNameTraveller())
                                .withSurnameTraveller(pdf.withSurnameTraveller()).withDateOfDeparture(pdf.withDateOfDeparture())
                                .withLastUpdate(pdf.withLastUpdate()).withArivalCountry(pdf.withArivalCountry()));

                        closeX(By.xpath("//i[@class = 'fa fa-times']"));



                    }}
                    else if (typeInLog.equals("Incident near City/Country Area"))
                    {


                       if(isElementInDOM(searchStringByWordLocator("SOS International travel alert"))
                               &&isElementInDOM(searchStringByWordLocator("Dear"))) {

                            pdf.incidentForTravellersEmail();

                            logs.add(new EmailLogData().withTimeStampInLog(timeStamp)
                                    .withEmail(email).withTypeInLog(requiredTypeInLog).withCountry(pdf.withDepatureCountry())
                                    .withEmailTraveller(email).withSurnameTraveller(pdf.withNameTraveller()+pdf.withSurnameTraveller())
                                    .withLastUpdate(pdf.withLastUpdate()).withAlertText(pdf.withAlertText()));

                            closeX(By.xpath("//i[@class = 'fa fa-times']"));



                        } else if (isElementInDOM(searchStringByWordLocator("test"))){
                           pdf.incidentForTravellersSMS();

                           logs.add(new EmailLogData().withTimeStampInLog(timeStamp)
                                   .withEmail(email).withTypeInLog(requiredTypeInLog).withCountry(pdf.withDepatureCountry())
                                   .withEmailTraveller(email).withSurnameTraveller(pdf.withNameTraveller()+pdf.withSurnameTraveller())
                                   .withLastUpdate(pdf.withLastUpdate()).withAlertText(pdf.withAlertText()));

                           closeX(By.xpath("//i[@class = 'fa fa-times']"));





                       }

                    }

                }
            }
            }
        }





    }




