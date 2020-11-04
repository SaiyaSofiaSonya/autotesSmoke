package ru.ttestess.actions.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ttestess.actions.Base;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LoginPage extends Base {
    Logger logger = Logger.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver){
        super(driver);}


     public void openRegistrationPage(String urlText){



         System.setProperty("webdriver.chrome.driver","C:\\Devel\\ChromeDriver\\chromedriver.exe" );
         driver = new ChromeDriver();

         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get(urlText);
         driver.findElement(By.cssSelector("a.registration")).click();

     }

}
