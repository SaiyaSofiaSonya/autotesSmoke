package ru.ttestess.test;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import ru.ttestess.actions.GeneralActionsWithApp;

public class BaseFixture {


    protected GeneralActionsWithApp app = new GeneralActionsWithApp(BrowserType.CHROME);

    //Добавить дата провайдер

    String urlText = "https://test.ru/";
    String login = "test";
    String password = "test";
    String language = null;
    String company = "test";
    String startDate = "2020-01-01";
    int reportDays = 180;

    @BeforeMethod(enabled =  false)


    public void setup() {



        app.launch(urlText, login, password, language);
    }


    @AfterSuite(enabled =  true)

    public void tearDown(){
        app.stop();
    }



}
