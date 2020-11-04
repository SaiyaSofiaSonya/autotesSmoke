package ru.ttestess.test;

import org.testng.annotations.Test;
import ru.ttestess.dataarea.EmailLogData;
import ru.ttestess.dataarea.FutureTripData;
import ru.ttestess.dataarea.PassengerCountry;
import ru.ttestess.filearea.EmailLogInFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class DisabledNotificIncidentsTest extends BaseFixture {
        String neededDate = "2020-03-11";

        @Test
   public void testIncidentNotifications() throws ParseException, IOException, InterruptedException {

            Set<String> countriesAlert = new HashSet<>();
            Set<PassengerCountry> impactedTrip = new HashSet<>();
            Set<PassengerCountry> emailCountryForPassenger = new HashSet<>();
            Set<PassengerCountry> missedTrips = new HashSet<>();

            app.navigateTo().emailLogPage();
            List<EmailLogData> logs = app.emailLog().getListInLog("Incident near",neededDate);
            for(EmailLogData log:logs){
                System.out.println(log);
                emailCountryForPassenger.add(new PassengerCountry().withCountry(log.getNameSurnameTraveller())
                        .withCountry(log.getCountry()));
            }

            EmailLogInFile writeInFileEmailLog = new EmailLogInFile();
            File fileEmailLog = new File("src/test/resources/incident.csv");
            writeInFileEmailLog.save("Incident near", logs, fileEmailLog);

            app.navigateTo().homePage();
        /*    app.navigateTo().alertTPPage();
            List<AlertTPData> alerts = app.alertTP().getAlertsList(neededDate);//

                for(AlertTPData alert:alerts){
                    countriesAlert.add(alert.getCountry());
                    System.out.println(alert);

            }
             app.navigateTo().back();*/

             app.navigateTo().futureTrip(neededDate, 2, company);
             List<FutureTripData> futureTrips = app.futureTrip().getFutureTripList(neededDate);

             for(FutureTripData trip:futureTrips){
                System.out.println(trip);

                if(countriesAlert.contains(trip.getCountry())){
                    if(!emailCountryForPassenger.contains(trip)){ missedTrips.add(new PassengerCountry()
                            .withPassengerName(trip.getPassengerName()).withCountry(trip.getCountry()));
                    System.out.println(trip);}

                }
            }




        }



}
