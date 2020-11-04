package ru.ttestess.test;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class RegistrationTest extends BaseFixture  {
    Logger logger = Logger.getLogger(RegistrationTest.class.getName());

    @DataProvider(name = "SelfRegistrationPassenger")
    Object [][] dataProveder(){

        return new Object[][]{
                {"https://sentinelpreview.traxess.eu/login.php",
                        "test50@traxess.eu", "+41435051331", "Test", "Profile 50", "Russian", "English", "Male", "true",
                ""},

                {"https://sentinelpreview.traxess.eu/login.php",
                        "test50@traxess.eu", "+41435051331", "Test", "Profile 50", "Russian", "English", "Male", "false",
                        ""}
        };
    }
    @Test(dataProvider = "SelfRegistrationPassenger")
    public void selfRegistrationPassengerTest(String urlTextR, String Email, String mobilePhone,
                                              String Name, String Surname,
                                              String countryOfResidence, String language,
                                              String Gender, Boolean newEmail, String expectedMessage){


    app.loginPage().openRegistrationPage(urlTextR);
    app.conditionsPopup().acceptConditions();
    app.registrationPage().register(Email, mobilePhone,
            Name, Surname,
            countryOfResidence, language,
            Gender);

     String actualMessage = app.registrationPage().getRegistrationMessage();

     //Полученное сообщение сравнивается с ожидаемым для новых и существующих в базе емайл адресов
     Assert.assertEquals(actualMessage, expectedMessage);




    }




}



