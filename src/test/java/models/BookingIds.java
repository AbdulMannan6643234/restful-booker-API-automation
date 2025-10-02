package models;

public class BookingIds {
    private int bookingid;
    public BookingIds(){}
    public int getId() {
        return bookingid;
    }

    public void setId(int bookingid) {
        this.bookingid = bookingid;
    }
    @Override
    public String toString() {
        return "BookingIds [id=" + bookingid + "]";
    }
}
