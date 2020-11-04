package ru.ttestess.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class NoCompanyDuplicatesInAppsettingsTest extends BaseFixture{
    Logger logger = Logger.getLogger(DataSegregationTests.class.getName());

    @Test
    public void testNoCompanyDuplicatesInAppsettings(){

    app.navigateTo().companySettings();
    List<String> companies = app.companySettings().getCompanyList();
    Set<String> duplicates = new HashSet<>(); //список дубликатов

    //Проверка количества вхождений
    for(int i=0; i<companies.size() -1 ; i++){
        for(int j = i+1; j<companies.size()-1; j++){
            if (companies.get(i).equals(companies.get(j))){
                duplicates.add(companies.get(j));
                logger.info("Обнаружены дубликаты: " + companies.get(j));
            }
        }
    }

        Assert.assertTrue(duplicates.size()==0);

    }



}
