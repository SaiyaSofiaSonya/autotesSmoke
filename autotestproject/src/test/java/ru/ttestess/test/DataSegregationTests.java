package ru.ttestess.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Set;
import java.util.logging.Logger;

//("Company SA 1", "ASA4GFHG");

public class DataSegregationTests extends BaseFixture {
  Logger logger = Logger.getLogger(DataSegregationTests.class.getName());
//  String company = "Traxess Test Company Paying";
    @Test (enabled = false)
    public void testDataSegregationOnDashboard(){

      app.navigateTo().homePage();
      Set<String> componies = app.dboard().getSet();
      logger.info("Dashboard: Размер componies = "+componies.size());
      Assert.assertTrue((componies.contains(company))&&(componies.size()==1));

    }

  // Locator Reports Tests
    @Test (enabled = false)
    public void testDataSegregationLocatorReportByPassenger(){    //если останется свободное время

    }

    @Test (enabled = false)
    public void testDataSegregationLocatorReportByCountry() throws ParseException {
    app.navigateTo().byCountryLocatorPage();
    Set<String> componies =  app.byCountryLocatorReport().getSetByCountry("France", reportDays, startDate);
    Assert.assertTrue((componies.contains(company))&&(componies.size()==1));

    }

    @Test (enabled = false)
    public void testDataSegregationLocatorReportByArea() throws ParseException {
      app.navigateTo().byAreaLocatorPage();
      Set<String> componies =  app.byAreaLocatorReport().getSetByArea(null, reportDays, startDate);
      Assert.assertTrue((componies.contains(company))&&(componies.size()==1));

    }

    @Test (enabled = false)
    public void testDataSegregationLocatorReportByAirport() throws ParseException {
      app.navigateTo().byAirportLocatorPage();
      Set<String> componies =  app.byAirportLocatorReport().getSetByAirport("Paris", reportDays, startDate);
      Assert.assertTrue((componies.contains(company))&&(componies.size()==1));

    }


    @Test (enabled = false)
    public void testDataSegregationLocatorReportByGPS(){ //если останется свободное время

    }

    @Test (enabled = false)
    public void testDataSegregationLocatorReportByResevations(){ //если останется свободное время

    }

    @Test (enabled = false)
    public void testDataSegregationLocatorReportByAirTrafic() throws ParseException {
      app.navigateTo().byAirTrafficAnalysisLocatorPage();
      Set<String> componies =  app.byAirTrafficAnalysisLocatorReport().getSetByAirTraffic(null, reportDays, startDate);
      Assert.assertTrue((componies.contains(company))&&(componies.size()==1));

    }

    // Admin reports

  @Test (enabled = false)
  public void testConfirmationReportAR() throws ParseException {
      app.navigateTo().comfirmationReport(company);
      Set<String> companies = app.comfirmationReportsAR().getSetPassengers(reportDays, startDate, company);
      Assert.assertTrue((companies.contains(company))&&(companies.size()==1));
  }

  @Test (enabled = false)
  public void testEmergencyReportAR() throws ParseException {
      app.navigateTo().emergencyCall(company);
      Set<String> companies = app.emergencyCallARPage().getSetPassengers(reportDays, startDate, company);

      if (companies.size() != 0) {
          Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
      } else logger.info("The report for the stated period is empty");

  }


    @Test (enabled = false)
    public void testFutureTripAR() throws ParseException {
        app.navigateTo().futureTrip(startDate, reportDays, company);
        Set<String> companies = app.futureTrip().getSetCompanies(company);

        if (companies.size() != 0) {
            Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
        } else logger.info("The report for the stated period is empty");

    }

    @Test (enabled = false)
    public void testPNRReportAR() throws ParseException {
        app.navigateTo().pnrReportPage(startDate, reportDays, company);
        Set<String> companies = app.pnrReport().getSetCompanies(company);

        if (companies.size() != 0) {
            Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
        } else logger.info("The report for the stated period is empty");

    }

    @Test (enabled = false)
    public void testPCCReportPageAP() throws ParseException {
        app.navigateTo().pccReport();
        Set<String> companies = app.pccReport().getSetCompanies(reportDays, startDate, company);

        if (companies.size() != 0) {
            Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
        } else logger.info("The report for the stated period is empty");

    }

    @Test (enabled = false)
    public void testRiskRatingReportAP() throws ParseException {
        app.navigateTo().riskRatingReport();
        Set<String> companies = app.riskRating().getSetCompanies(reportDays, startDate, company);

        if (companies.size() != 0) {
            Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
        } else logger.info("The report for the stated period is empty");

    }


    @Test (enabled = false)
    public void testAdminLogUserLogAR() throws ParseException {
        app.navigateTo().adminLog();
        Set<String> companies = app.adminLog().getSetCompanies(reportDays, startDate, company);

        if (companies.size() != 0) {
            Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
        } else logger.info("The report for the stated period is empty");

    }

    @Test (enabled = false)
    public void testFullAdminLogUserLogAR() throws ParseException {
        app.navigateTo().fulladminLog();
        Set<String> companies = app.fullAdminLog().getSetCompanies(reportDays, startDate, company);

        if (companies.size() != 0) {
            Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
        } else logger.info("The report for the stated period is empty");

    }

    @Test (enabled = false)
    public void testFullPassengerLogUserLogAR() throws ParseException {
        app.navigateTo().fullPassengerLog();
        Set<String> companies = app.fullPassenger().getSetCompanies(reportDays, startDate, company);

        if (companies.size() != 0) {
            Assert.assertTrue((companies.contains(company)) && (companies.size() == 1));
        } else logger.info("The report for the stated period is empty");

    }


    //Dropdowns

    @Test (enabled = true)
    public void testNoOtherCompanyConfirmationReportAR(){

        app.navigateTo().emergencyCall(company);
        Set<String> componies = app.emergencyCallARPage().getComponiesFromDropdown(company);

        if(componies.size()!=0){
            Assert.assertTrue(componies.contains(company)&&(componies.size()==1));
        }

        else logger.info("The report for the stated period is empty");

    }

}
