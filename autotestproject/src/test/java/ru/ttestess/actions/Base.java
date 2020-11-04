package ru.ttestess.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Base {
    protected WebDriver driver;
    public Base(WebDriver driver) {
        this.driver = driver;
    }
    Logger logger = Logger.getLogger(Base.class.getName());

    protected void input(By locator, String text) {
        click(locator);

        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void pressEscape(By locator) {
        driver.findElement(locator).sendKeys(Keys.ESCAPE);
    }


    protected void click(By locator) throws ElementNotInteractableException {
        driver.findElement(locator).click();
    }

    protected void waitALoadToClick(int seconds, By locator) {

        try {
            (new WebDriverWait(driver, seconds)).until(elementToBeClickable(locator));
        }
        catch (TimeoutException ex) {
            System.out.println("The page is not found");
        }
    }


    protected void waitALoadToBeVisible(int seconds, By locator) {

        try {
            (new WebDriverWait(driver, seconds)).until(visibilityOfElementLocated(locator));
            logger.info("Element is visible");

        }
        catch (TimeoutException ex) {
            logger.info("The page is not found");
        }
    }


    protected void waitALoadToSee(int seconds, By locator) {

        try {
            (new WebDriverWait(driver, seconds)).until(visibilityOfElementLocated(locator));
        }
        catch (TimeoutException ex) {
            System.out.println("The page is not found");
        }
    }

    protected boolean isElementInDOM(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected void selectEntriesOnPage(By field, By value) {
            click(field);
            click(value);
            logger.info("Нажали - Показать 100 элементов на странице - Хелпер бейс и ждем загрузки ");
          //  waitALoadToSee(120, By.xpath("(//td[@tabindex= '0'])[1]"));
        }

  //Report generating

    //Инкрементирование даты
  public  String dateIncrement(String dateString, int reportDay) throws ParseException {
      SimpleDateFormat format = new SimpleDateFormat();
      format.applyPattern("yyyy-MM-dd");
      Calendar cal = Calendar.getInstance();
      cal.setTime(format.parse(dateString));
      cal.add(Calendar.DATE, reportDay);
      String incrementedDate = format.format(cal.getTime());
      System.out.println(incrementedDate);

      return incrementedDate;

  }

  //Генерация репорт
  public void generate(String country, int reportDay, String startDate, By newReportLocator,
                       By countryFieldLocator, By startDatelocator,
                       By endDateLocator, By submitButtonLocator, By tableVisibilityLocator ) throws ParseException {

        driver.findElement(newReportLocator).click();


        //Выбрать страну
      if(countryFieldLocator!=null){
      WebElement countryField =   driver.findElement(countryFieldLocator);
      countryField.sendKeys(country);
      waitALoadToBeVisible(10, By.xpath(String.format("//li[contains(text(), '%s')]", country)));
      countryField.sendKeys(Keys.chord(Keys.ENTER));}

      // Выбрать дату
      driver.findElement(startDatelocator).sendKeys(startDate);
      driver.findElement(endDateLocator).sendKeys(dateIncrement(startDate, reportDay));
      driver.findElement(submitButtonLocator).submit();

      //Подождать пока таблица загрузиться
      waitALoadToBeVisible(10, tableVisibilityLocator);






    }



    protected By searchStringByWordLocator(String text){
        return By.xpath(String.format(".//*[contains(text(), '%s')]", text));
        //String.format("//*[.='%s']", text)));
    }


    protected WebElement searchStringByWord(String text){
        return driver.findElement(By.xpath(String.format(".//*[contains(text(), '%s')]", text)));
                //String.format("//*[.='%s']", text)));
    }

    protected void clickNextPangination(By locator) {
        click(locator);

    }

    protected void searchAndFilterListBy(String required, By locator) {
        click(locator);
        driver.findElement(locator).sendKeys(required);
    }

    protected void closeX(By locator) {
        click(locator);
    }

    protected String getTextFromFirstSymbol(String text, String firstSymbolPosition) {
        return text.substring(text.indexOf(firstSymbolPosition)+1);

    }

    protected String getTextaAfterLastSymbols(String text, String lastSymbolPosition) {
        return  text.substring(text.lastIndexOf(lastSymbolPosition)+1);
    }



    protected String getTextBetweenSymbols(String text, String symbolPosition1, String symbolPosition2) {
        return  (text.substring(0, (text.lastIndexOf(symbolPosition2)+1)).substring(text.indexOf(symbolPosition1)+1));
    }

    protected void selectDropdown(By locator, String Text){
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(Text);
        driver.findElement(locator).sendKeys(Keys.chord(Keys.ENTER));

    }
}