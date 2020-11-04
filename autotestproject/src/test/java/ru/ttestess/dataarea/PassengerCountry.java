package ru.ttestess.dataarea;

public class PassengerCountry {

    public String getPassengerName() {
        return passengerName;
    }

    public PassengerCountry withPassengerName(String passengerName) {
        this.passengerName = passengerName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public PassengerCountry withCountry(String country) {
        this.country = country;
        return this;
    }

    private String passengerName;
    private String country;

    @Override
    public String toString() {
        return "PassengerCountry{" +
                "passengerName='" + passengerName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
