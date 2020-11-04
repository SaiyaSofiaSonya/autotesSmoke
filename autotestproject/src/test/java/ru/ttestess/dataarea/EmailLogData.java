package ru.ttestess.dataarea;

public class EmailLogData {




    private String timeStampInLog;
    private String typeInLog;
    private String email;
    private String country;
    private String nameTraveller;
    private String surnameTraveller;


    private String nameSurnameTraveller;
    private String countryRiskLevel;
    private String emailTraveller;
    private String dateOfDeparture;
    private String lastUpdate;
    private String arivalCountry;
    private String alertText;
    private String pnr;

    public String getTimeStampInLog() {
        return timeStampInLog;
    }

    public EmailLogData withTimeStampInLog(String timeStampInLog) {
        this.timeStampInLog = timeStampInLog;
        return this;
    }

    public String getTypeInLog() {
        return typeInLog;
    }

    public EmailLogData withTypeInLog(String typeInLog) {
        this.typeInLog = typeInLog;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmailLogData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public EmailLogData withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getNameTraveller() {
        return nameTraveller;
    }

    public EmailLogData withNameTraveller(String nameTraveller) {
        this.nameTraveller = nameTraveller;
        return this;
    }

    public String getSurnameTraveller() {
        return surnameTraveller;
    }

    public EmailLogData withSurnameTraveller(String surnameTraveller) {
        this.surnameTraveller = surnameTraveller;
        return this;
    }

    public String getCountryRiskLevel() {
        return countryRiskLevel;
    }

    public EmailLogData recivedCountryRiskLevel(String countryRiskLevel) {
        this.countryRiskLevel = countryRiskLevel;
        return this;
    }

    public String getEmailTraveller() {
        return emailTraveller;
    }

    public String getPNR() {
        return pnr;
    }

    public EmailLogData withEmailTraveller(String emailTraveller) {
        this.emailTraveller = emailTraveller;
        return this;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public EmailLogData withDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
        return this;
    }


    public String getLastUpdate() {
        return lastUpdate;
    }

    public EmailLogData withLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public String getArivalCountry() {
        return arivalCountry;
    }

    public EmailLogData withArivalCountry(String arivalCountry) {
        this.arivalCountry = arivalCountry;
        return this;
    }
    public String getAlertText() {
        return alertText;
    }

    public EmailLogData withAlertText(String alertText) {
        this.alertText = alertText;
        return this;
    }

    public EmailLogData withPNR (String pnr) {
        this.pnr = pnr;
        return this;
    }

    public String getNameSurnameTraveller() {
        return nameSurnameTraveller;
    }

    public EmailLogData withNameSurnameTraveller(String nameSurnameTraveller) {
        this.nameSurnameTraveller = nameSurnameTraveller;
        return this;
    }

    @Override
    public String toString() {
        return "EmailLogData{" +
                "timeStampInLog='" + timeStampInLog + '\'' +
                ", typeInLog='" + typeInLog + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", nameTraveller='" + nameTraveller + '\'' +
                ", surnameTraveller='" + surnameTraveller + '\'' +
                ", countryRiskLevel='" + countryRiskLevel + '\'' +
                ", emailTraveller='" + emailTraveller + '\'' +
                ", dateOfDeparture='" + dateOfDeparture + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", arivalCountry='" + arivalCountry + '\'' +
                ", alertText='" + alertText + '\'' +
                ", pnr='" + pnr + '\'' +
                '}';
    }
}
