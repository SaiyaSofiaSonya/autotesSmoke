package ru.ttestess.test;
import org.testng.annotations.Test;
import ru.ttestess.dataarea.PNRreportData;
import ru.ttestess.filearea.EmailLogInFile;
import ru.ttestess.dataarea.EmailLogData;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class DisabledPNRCreatedTests extends BaseFixture {


    @Test
    public void testPNRCreation() throws ParseException, IOException {
        System.out.println(" Фикстура создана ");
        app.navigateTo().emailLogPage();
        System.out.println(" Перешли на емайл лог пейдж - класс теста ");
        List<EmailLogData> logs = app.emailLog().getListInLog("PNR Created", "2018-08-27");
        System.out.println(" Создали список pnrCreates  за указанную дату из данных лога ");


        app.navigateTo().homePage();
        app.navigateTo().pnrReportPage("2018-08-27", 1,company);
        List<PNRreportData> data= app.pnrReport().getListInPNRReport( "test");

        for(PNRreportData each:data ){
            System.out.println(each);

        }



        EmailLogInFile writeInFile = new EmailLogInFile();
        File file = new File("src/test/resources/pnrCreated.csv");
        writeInFile.save("PNR Created", logs, file);


    }



    }








