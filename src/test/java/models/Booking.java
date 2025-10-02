package models;

public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds; 
    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingDates,
            String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingDates;
        this.additionalneeds = additionalneeds;
    }
    public Booking(BookingDates bookingDates) {
        this.bookingdates = bookingDates;
    }
    public Booking(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Booking(){}
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public boolean isDepositpaid() {
        return depositpaid;
    }
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    public BookingDates getBookingDates() {
        return bookingdates;
    }
    public void setBookingDates(BookingDates bookingDates) {
        this.bookingdates = bookingDates;
    }
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
    @Override
    public String toString() {
        return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
                + ", depositpaid=" + depositpaid + ", bookingDates=" + bookingdates + ", additionalneeds="
                + additionalneeds + "]";
    }
}
