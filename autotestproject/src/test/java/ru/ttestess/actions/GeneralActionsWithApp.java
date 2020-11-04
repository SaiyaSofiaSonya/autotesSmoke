package ru.ttestess.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.ttestess.actions.adminportal.DashboardPage;
import ru.ttestess.actions.adminportal.adminreports.*;
import ru.ttestess.actions.adminportal.appmanagement.CompanySettings;
import ru.ttestess.actions.adminportal.locatorreports.ByAirTrafficAnalysisLocatorReport;
import ru.ttestess.actions.adminportal.locatorreports.ByAirportLocatorReport;
import ru.ttestess.actions.adminportal.locatorreports.ByAreaLocatorReport;
import ru.ttestess.actions.adminportal.locatorreports.ByCountryLocatorReport;
import ru.ttestess.actions.registration.ConditionsPopup;
import ru.ttestess.actions.registration.LoginPage;
import ru.ttestess.actions.registration.RegistrationPage;
import ru.ttestess.actions.travelportal.AlertTPPage;
import ru.ttestess.actions.travelportal.TravelPortalPage;

import java.util.concurrent.TimeUnit;

public class GeneralActionsWithApp {

        WebDriver driver;

    private Base baseActions;
    private Navigation navigationActions;
    private Session sessionActions;
    private String browser;

    //Registration&Login
    private ConditionsPopup conditionsPopup;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    //Travel Portal
    private AlertTPPage alertTPPage;
    private TravelPortalPage travelPortalPage;

    //Admin Portal
    // Dashboard
    private DashboardPage dboardPage;

    //Admin log
    private PassengerBookingReportAdminReport passengerBookingReportAdminPortalPage;
    private FutureTripPage futureTripPage;
    private PNRReportPage pnrReportPage;
    private EmailLogPage emailLogPage;
    private PDFPage pdfPage;
    private ComfirmationReportsARPage comfirmationReportsARPage;
    private EmergencyCallARPage emergencyCallARPage;
    private PCCReportPage pccReportPage;
    private RiskRatingReportPage riskRatingReportPage;
    private AdminLogUserLogAR adminLogUserLogAR;
    public FullAdminUserLogAR fullAdminUserLogARPage;
    public FullPassengerUserLogARPage fullPassengerUserLogARPage;

    //Locator reports
    private ByCountryLocatorReport byCountryLocatorReportPage;
    private ByAreaLocatorReport byAreaLocatorReportPage;
    private ByAirportLocatorReport byAirportLocatorReportPage;
    private ByAirTrafficAnalysisLocatorReport byAirTrafficAnalysisLocatorReportPage;

    //App Management
    private CompanySettings companySettingsPage;

    public GeneralActionsWithApp(String browser){
        this.browser = browser;
    }

    public void launch(String urlText, String login, String password, String language ){

        if (browser.equals(BrowserType.CHROME)){
        System.setProperty("webdriver.chrome.driver","C:\\Devel\\ChromeDriver\\chromedriver.exe" );
        driver = new ChromeDriver();}

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(urlText);
        emailLogPage = new EmailLogPage(driver);
        baseActions = new Base(driver);
        pdfPage = new PDFPage(driver);
        navigationActions = new Navigation(driver);
        sessionActions = new Session(driver);

        //Admin portal
        passengerBookingReportAdminPortalPage = new PassengerBookingReportAdminReport(driver);
        comfirmationReportsARPage = new ComfirmationReportsARPage(driver);
        emergencyCallARPage = new EmergencyCallARPage(driver);
        pnrReportPage = new PNRReportPage(driver);
        futureTripPage  = new FutureTripPage(driver);
        alertTPPage = new AlertTPPage(driver);
        dboardPage = new DashboardPage(driver);
        pccReportPage = new PCCReportPage(driver);
        riskRatingReportPage = new RiskRatingReportPage(driver);
        adminLogUserLogAR = new AdminLogUserLogAR(driver);
        fullAdminUserLogARPage = new FullAdminUserLogAR(driver);
        fullPassengerUserLogARPage = new FullPassengerUserLogARPage(driver);

        //Locator report
        byCountryLocatorReportPage = new ByCountryLocatorReport(driver);
        byAreaLocatorReportPage = new ByAreaLocatorReport(driver);
        byAirportLocatorReportPage = new ByAirportLocatorReport(driver);
        byAirTrafficAnalysisLocatorReportPage = new ByAirTrafficAnalysisLocatorReport(driver);
       //App management
        companySettingsPage = new CompanySettings(driver);


        //Travel Portal
        travelPortalPage = new TravelPortalPage(driver);

        //Registration
        conditionsPopup = new ConditionsPopup(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);


        driver.manage().window().maximize();
        sessionActions.login(login, password);



    }



    public void stop() {
        driver.quit();
    }

    public Navigation navigateTo(){
        return navigationActions;
    }

    //Login
    public EmailLogPage emailLog(){
        return emailLogPage;
    }

    //Registration
    public ConditionsPopup conditionsPopup() {return conditionsPopup;}
    public LoginPage loginPage() {return loginPage;}
    public RegistrationPage registrationPage() {return registrationPage;}

    //Admin portal
    public DashboardPage dboard() { return dboardPage;}

    //Admin reports
    public PassengerBookingReportAdminReport passengerBookingReportAdminReports() {return passengerBookingReportAdminPortalPage;}
    public ComfirmationReportsARPage comfirmationReportsAR() {return comfirmationReportsARPage;}
    public EmergencyCallARPage emergencyCallARPage() {return emergencyCallARPage;}
    public PDFPage pdf(){
        return pdfPage;
    }
    public PNRReportPage pnrReport() {return pnrReportPage;}
    public FutureTripPage futureTrip() {return futureTripPage; }
    public PCCReportPage pccReport() {return pccReportPage;}
    public RiskRatingReportPage riskRating() {return riskRatingReportPage;}
    public AdminLogUserLogAR adminLog() {return adminLogUserLogAR;}
    public FullAdminUserLogAR fullAdminLog() {return fullAdminUserLogARPage;}
    public FullPassengerUserLogARPage fullPassenger(){return fullPassengerUserLogARPage;}

    //Locator report
    public ByCountryLocatorReport byCountryLocatorReport(){return  byCountryLocatorReportPage;}
    public ByAreaLocatorReport byAreaLocatorReport() {return byAreaLocatorReportPage;}
    public ByAirportLocatorReport byAirportLocatorReport() {return byAirportLocatorReportPage; }
    public  ByAirTrafficAnalysisLocatorReport byAirTrafficAnalysisLocatorReport() {return byAirTrafficAnalysisLocatorReportPage;}

    //App management
    public CompanySettings companySettings() {return companySettingsPage;}

    //Travel Portal
    public TravelPortalPage  travelPortalPage(){return travelPortalPage;}
    public AlertTPPage alertTP() {
        return alertTPPage; }



}
