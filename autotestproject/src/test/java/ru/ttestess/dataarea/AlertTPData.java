package ru.ttestess.dataarea;

public class AlertTPData {



    private String date;
    private String country;
    private String urgency;
    private String description;

    public String getDate() {
        return date;
    }

    public AlertTPData withDate(String date) {
        this.date = date;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AlertTPData withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getUrgency() {
        return urgency;
    }

    public AlertTPData withUrgency(String urgency) {
        this.urgency = urgency;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlertTPData withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "AlertTPData{" +
                "date='" + date + '\'' +
                ", country='" + country + '\'' +
                ", urgency='" + urgency + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
