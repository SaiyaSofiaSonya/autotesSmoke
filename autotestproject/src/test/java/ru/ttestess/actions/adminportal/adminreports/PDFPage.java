package ru.ttestess.actions.adminportal.adminreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.ttestess.actions.Base;

import java.util.List;
import java.util.logging.Logger;

public class PDFPage extends Base {

    public PDFPage(WebDriver driver) {super(driver);}


    private String nameTraveller;
    private String surnameTraveller;
    private String emailTraveller; // нужна ли?
    private String depatureCountry;
    private String temp;
    private String dateOfDeparture;
    private String lastUpdate;
    private String arivalCountry;
    private String alertText;
    private String pnr;

    Logger logger = Logger.getLogger(EmailLogPage.class.getName());

    protected void pnrCreatedForRiskManager() {
        logger.info("ПДФ для риск менеджера");

        nameTraveller = getTextBetweenSymbols(searchStringByWord("Traveller").getText(), " ", " ");
        surnameTraveller = getTextaAfterLastSymbols(searchStringByWord("Traveller").getText(), " ");
        emailTraveller = getTextaAfterLastSymbols(searchStringByWord("Email").getText(), " ");
        depatureCountry = getTextaAfterLastSymbols(searchStringByWord("Departure country").getText(), " ");
        dateOfDeparture = getTextFromFirstSymbol((getTextBetweenSymbols(searchStringByWord("Departure date").getText(), " ", " ")), " ");
        arivalCountry = getTextBetweenSymbols(searchStringByWord("Reservation to").getText(), "o ", " -");
        logger.info("Переменные (ПДФ для риск менеджера) записаны");
    }


    protected void pnrCreatedForTravellers() {
        logger.info("ПДФ для traveller");

        nameTraveller = getTextBetweenSymbols(searchStringByWord("Dear").getText(),
                ",", ",").replace(",", "");
        surnameTraveller = getTextBetweenSymbols(searchStringByWord("Dear").getText(),
                " ", ", ").replace(",", "");
        emailTraveller = null;
        arivalCountry = getTextaAfterLastSymbols(searchStringByWord("SOS International traveller").getText(), " ");
        lastUpdate = searchStringByWord("Last").getText();
        logger.info("Переменные (ПДФ для риск traveller) записаны");

    }

    protected void incidentForTravellersEmail() {
        logger.info("ПДФ для traveller");

        nameTraveller = getTextBetweenSymbols(searchStringByWord("Dear").getText(),
                ",", ",").replace(",", "");
        surnameTraveller = getTextBetweenSymbols(searchStringByWord("Dear").getText(),
                " ", ", ").replace(",", "");
        emailTraveller = null;
        depatureCountry = getTextBetweenSymbols(searchStringByWord("SOS International").getText(),
                " ", "-");
        lastUpdate = searchStringByWord("Last").getText();
        alertText = driver.findElement(By.xpath("//div//p[3]//span")).getText().substring(0, 40);
        logger.info("Переменные (ПДФ для риск traveller) записаны");

    }

    protected void incidentForTravellersSMS() {
        logger.info("ПДФ для travellerSMS");

        temp = searchStringByWord("SOS International travel").getText().substring(0, 160);
        depatureCountry = temp.substring(36, temp.indexOf("-"));
        alertText = temp.substring(temp.indexOf("-"), temp.indexOf("-")+40);
        lastUpdate =null;
        surnameTraveller = null;
        nameTraveller = null;
        logger.info("Переменные (ПДФ для риск travellerSMS) записаны");

    }

    protected void incidentForRiskManager() {
        logger.info("ПДФ для риск менеджера");


        List <WebElement> rows = driver.findElements(By.xpath("//table[@style = 'border-collapse: collapse; width: 100%; font-size: 10pt; font-family: Arial;']/tbody/tr"));
        for (int i =0; i<rows.size(); i++ ){
            if (i!=0) {
                temp = searchStringByWord("SOS International security").getText();
                depatureCountry = temp.substring(36, temp.indexOf("-") );
                alertText = temp.substring(0, 40) ;
                surnameTraveller = rows.get(i).findElement(By.xpath(".//td[1]")).getText();
               // emailTraveller = rows.get(i).findElement(By.xpath(".//td[1]")).getText();
                pnr = rows.get(i).findElement(By.xpath(".//td[2]")).getText();
                emailTraveller = rows.get(i).findElement(By.xpath(".//td[3]")).getText();

                logger.info("Переменные (ПДФ для риск менеджера) записаны" + " / "+ depatureCountry + " / "+  alertText + " / "+
                        surnameTraveller +  " / "+ pnr +  " / "+ emailTraveller);
            }
    }
    }


    public String withNameTraveller() {
        return nameTraveller;
    }

    public String withSurnameTraveller() {
        return surnameTraveller;
    }

    public String withEmailTraveller() {
        return emailTraveller;
    }

    public String withDepatureCountry() {
        return depatureCountry;
    }

    public String withDateOfDeparture() {
        return dateOfDeparture;
    }

    public String withLastUpdate() {
        return lastUpdate;
    }

    public String withArivalCountry() {
        return arivalCountry;
    }

    public String withAlertText() {
        return alertText;
    }

    public String withPNR() {
        return pnr;
    }

    }




