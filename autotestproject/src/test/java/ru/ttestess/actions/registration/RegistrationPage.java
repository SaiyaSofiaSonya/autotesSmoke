package ru.ttestess.actions.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.ttestess.actions.Base;

import java.util.logging.Logger;

public class RegistrationPage extends Base {
    Logger logger = Logger.getLogger(RegistrationPage.class.getName());

    public RegistrationPage(WebDriver driver){
        super(driver);}
        public void register(String email, String mobilePhone,
                               String name, String surname,
                               String countryOfResidence, String language,
                               String gender){



            input(By.xpath("//div[@style = 'display: block;' ]//input[@name='email']"), email);
            input(By.xpath("//div[@style = 'display: block;' ]//input[@name='phone']"), mobilePhone);
            input(By.xpath("//div[@style = 'display: block;' ]//input[@name='name']"), name);
            input(By.xpath("//div[@style = 'display: block;' ]//input[@name='surname']"), surname);
            selectDropdown(By.id("select2-country-en-container"), countryOfResidence);
            selectDropdown(By.id("select2-language-xx-container"), language);
            selectDropdown(By.id("select2-sex-r0-container"), gender);

           //Сабмит формы
            driver.findElement(By.xpath("//div[@style = 'display: block;' ]//button[@class='btn btn-succes continue_step continue_registration']"))
                    .click();
       }

        public String getRegistrationMessage() {
            String actualMessage = driver.findElement(By.xpath("(//div[@class = 'modal-body'])[2]")).getText();

            return null;
        }

}
