package ru.ttestess.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginTest extends BaseFixture {
    Logger logger = Logger.getLogger(LoginTest.class.getName());

    @DataProvider (name = "LoginData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"https://tsp.sos.eu/", "test4@traxess.eu", "8mMoBqqcrYWK", "valid"},
                {"https://tsp.sos.eu/", "test49@traxess.eu", "8mMoBqqcrYWK", "invalid"}};
    }


    @Test(dataProvider = "LoginData")
    public void loginPassenger(String urlTextPassenger, String loginPassenger, String passwordPassenger, String credentialStatus) {
        String expectedTextPassenger = "Risk Map";
        app.launch(urlTextPassenger, loginPassenger, passwordPassenger, null);

        String nameOfTravelPortal= app.travelPortalPage().getNameOfTravelPortal();
            if(credentialStatus.equals("valid")){ Assert.assertEquals(nameOfTravelPortal, expectedTextPassenger);}
            else{Assert.assertEquals(nameOfTravelPortal, null);}

             app.stop();
 }

}
