package ru.ttestess.filearea;

import ru.ttestess.dataarea.EmailLogData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class EmailLogInFile {


    public void save(String requiredTypeInLog, List<EmailLogData> dataFromEmailLog, File file) throws IOException {

            System.out.println(new File(".").getAbsolutePath());
            Writer writer = new FileWriter(file);
        if(requiredTypeInLog.equals("PNR Created")) {
            for (EmailLogData data : dataFromEmailLog) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", data.getTimeStampInLog(), data.getTypeInLog(),
                        data.getEmail(), data.getNameTraveller(), data.getSurnameTraveller(),
                        data.getEmailTraveller(), data.getCountry(), data.getDateOfDeparture(), data.getCountryRiskLevel()));
            }
        }
        if(requiredTypeInLog.equals("Incident near")) {
            for (EmailLogData data : dataFromEmailLog) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;\n", data.getTimeStampInLog(), data.getTypeInLog(),
                        data.getEmail(), data.getSurnameTraveller(), data.getEmailTraveller(), data.getCountry(),
                        data.getAlertText()));
            }
        }

        writer.close();


    }


}
