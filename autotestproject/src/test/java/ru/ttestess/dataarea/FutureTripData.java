package ru.ttestess.dataarea;

public class FutureTripData {



    private String arrivalDate;
    private String bookingType;
    private String passengerName;
    private String country;
    private String emailAddress;

    public String getArrivalDate() {
        return arrivalDate;
    }

    public FutureTripData withArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public String getBookingType() {
        return bookingType;
    }

    public FutureTripData withBookingType(String bookingType) {
        this.bookingType = bookingType;
        return this;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public FutureTripData withPassengerName(String passengerName) {
        this.passengerName = passengerName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public FutureTripData withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public FutureTripData withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }



    @Override
    public String toString() {
        return "FutureTripData{" +
                "arrivalDate='" + arrivalDate + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", country='" + country + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
