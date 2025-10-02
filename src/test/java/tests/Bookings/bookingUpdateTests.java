package tests.Bookings;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.bookingService;
import models.Booking;
import tests.Base.BaseTests;
import util.bookingDataProvider;

public class bookingUpdateTests extends BaseTests {
    @Test(dataProviderClass=bookingDataProvider.class,dataProvider="bookingUpdationData",groups="smoke")
    public void request_UpdateBooking_WithValidCreds(int id,String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout,
            String additionalneeds){
            bookingService updateBooking = new bookingService();
            var bookingUpdationResponse = updateBooking.updateExistingBooking(reqSpec ,id, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds)
            .then()
            .spec(successfulResSpec)
            .extract().as(Booking.class);
            
            assertTrue(bookingUpdationResponse.getFirstname().equals(firstname), "FirstName Doesnt Match");
            }
    @Test(groups="knownBug")
    public void request_UpdateBooking_WithInvalidCreds(){
            bookingService updateBooking = new bookingService();
            var bookingUpdationResponse = updateBooking.updateExistingBooking(reqSpec,2, "", "", 0, false, "", "", "")
            .then()
            .spec(successfulResSpec)
            .extract().as(Booking.class);
            
            assertTrue(bookingUpdationResponse.getFirstname().isBlank(), "Fields Are Not Blank");
            }
    @Test(groups="knownBug")
    public void request_UpdateBooking_WithNegativePrice(){
            bookingService updateBooking = new bookingService();
            var bookingUpdationResponse = updateBooking.updateExistingBooking(reqSpec,6, "Claire", "Redfield", -100, false, "2022-04-06", "2025-05-05", "")
            .then()
            .spec(successfulResSpec)
            .extract().as(Booking.class);
            
            assertTrue(bookingUpdationResponse.getTotalprice()<0, "Entered Price is Positive");
            }
    @Test(groups="knownBug")
    public void request_UpdateBooking_WithInvalidDate(){
            bookingService updateBooking = new bookingService();
            var bookingUpdationResponse = updateBooking.updateExistingBooking(reqSpec,2, "Leon", "Kennedy", 100, false, "2020-15-15", "2020-42-51", "")
            .then()
            .spec(successfulResSpec)
            .extract().as(Booking.class);
            
            assertTrue(bookingUpdationResponse.getBookingDates().getCheckin().equals("0NaN-aN-aN"), "Date is Incorrect");
            }
    @Test(groups="smoke")
    public void request_UpdateName_InBooking(){
        bookingService updateName = new bookingService();
        var booking = updateName.partiallyUpdateNameInExistingBooking(reqSpec, 5, "Kelvin", "Clien")
        .then()
        .spec(successfulResSpec)
        .extract().as(Booking.class);
        assertTrue(booking.getFirstname().equals("Kelvin"), "Firstname Doesnt Match");
    }
    @Test(groups="knownBug")
    public void request_UpdateBlankName_InBooking(){
        bookingService updateName = new bookingService();
        var booking = updateName.partiallyUpdateNameInExistingBooking(reqSpec, 5, "", "")
        .then()
        .spec(successfulResSpec)
        .extract().as(Booking.class);
        assertTrue(booking.getFirstname().isBlank(), "Firstname cannot be blank");
    }
    @Test(groups="smoke")
    public void request_UpdateDate_InBooking(){
        bookingService updateDate = new bookingService();
        var booking = updateDate.partiallyUpdateDateInExistingBooking(reqSpec , 5, "2025-04-01", "2025-04-01")
        .then()
        .spec(successfulResSpec)
        .extract().as(Booking.class);
        assertTrue(booking.getBookingDates().getCheckin().equals("2025-04-01"), "Date Doesnt Match");
    }
    @Test(groups="knownBug")
    public void requestUpdateDate_WithInvalidDates_InBooking(){
        bookingService updateDate = new bookingService();
        var booking = updateDate.partiallyUpdateDateInExistingBooking(reqSpec, 5, "2025-50-50", "2025-04-01")
        .then()
        .spec(successfulResSpec)
        .extract().as(Booking.class);
        assertTrue(booking.getBookingDates().getCheckin().equals("0NaN-aN-aN"), "Date is Incorrect");
    }     
}
