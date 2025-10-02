package models;

public class BookingResponse {
        private Booking booking;
        private int bookingid;
        public Booking getBooking() {
            return booking;
        }
        public void setBooking(Booking booking) {
            this.booking = booking;
        }
        public int getBookingid() {
            return bookingid;
        }
        public void setBookingid(int bookingid) {
            this.bookingid = bookingid;
        }
}
