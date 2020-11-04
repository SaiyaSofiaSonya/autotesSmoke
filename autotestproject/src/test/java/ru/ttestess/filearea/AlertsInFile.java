package ru.ttestess.filearea;

import ru.ttestess.dataarea.AlertTPData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class AlertsInFile {

    public void save(String requiredTypeInLog, List<AlertTPData> dataAlerts, File file) throws IOException {

        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for(AlertTPData alert:dataAlerts){
        writer.write(String.format("%s;%s;%s;\n", alert.getCountry(),
                alert.getUrgency(), alert.getDescription()));
        }


    }
}