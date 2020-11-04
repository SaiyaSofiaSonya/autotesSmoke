package ru.ttestess.dataarea;

public class PNRreportData {

    private String pnr;
    private String bookingDate;
    private String lastUpdate;
    private String passengerName;
    private String company;
    private String bookingCategory;

    public String getPnr() {
        return pnr;
    }

    public PNRreportData withPnr(String pnr) {
        this.pnr = pnr;
        return this;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public PNRreportData withBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
        return this;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public PNRreportData withLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public PNRreportData withPassengerName(String passengerName) {
        this.passengerName = passengerName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public PNRreportData withCompany(String company) {
        this.company = company;
        return this;
    }

    public String getBookingCategory() {
        return bookingCategory;
    }

    public PNRreportData withBookingCategory(String bookingCategory) {
        this.bookingCategory = bookingCategory;
        return this;
    }


    @Override
    public String toString() {
        return "PNRreportData{" +
                "pnr='" + pnr + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", company='" + company + '\'' +
                ", bookingCategory='" + bookingCategory + '\'' +
                '}';
    }



}


