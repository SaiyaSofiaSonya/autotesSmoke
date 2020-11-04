package ru.ttestess.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Session extends Base {

    public Session(WebDriver driver) { super(driver); }

    public void login(String userName, String password) {
        input(By.name("username"), userName);  //username    user
        input(By.name("password"), password); // password   pass
        click(By.xpath("//*[@value='OK']")); //"//button[@input = 'submit']"
        if (isElementInDOM(By.xpath("/div[@style = 'display: yes']//div[@class = 'modal-content']//button"))) {
            click(By.xpath("//div[@style = 'display: yes']//div[@class = 'modal-content']//button")); //
        }

        System.out.println("Pop up закрыли");

    }



}
