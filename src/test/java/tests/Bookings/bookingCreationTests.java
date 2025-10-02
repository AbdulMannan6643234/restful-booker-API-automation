package tests.Bookings;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.bookingService;
import models.BookingResponse;
import tests.Base.BaseTests;
import util.bookingDataProvider;

public class bookingCreationTests extends BaseTests{
    @Test(dataProviderClass=bookingDataProvider.class,dataProvider="bookingCreationData",groups="smoke")
    public void request_CreateBooking_WithValidCreds(String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout,
            String additionalneeds){
            bookingService createBooking = new bookingService();
            var bookingCreationResponse = createBooking.CreateBooking(reqSpec, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds)
            .then()
            .spec(successfulResSpec)
            .extract().as(BookingResponse.class);
            
            assertTrue(bookingCreationResponse.getBooking().getFirstname().equals(firstname), "FirstName Doesnt Match");
            }
            @Test(groups="knownBug")
            public void request_CreateBooking_WithInvalidCreds(){
            bookingService createBooking = new bookingService();
            var bookingCreationResponse = createBooking.CreateBooking(reqSpec, "", "", 0, false, "", "", "")
            .then()
            .spec(successfulResSpec)
            .extract().as(BookingResponse.class);
                assertTrue(bookingCreationResponse.getBooking().getFirstname().isBlank(), "First Name is Not Null");
            }
            @Test(groups="knownBug")
            public void request_CreateBooking_WithNegativePrice(){
            bookingService createBooking = new bookingService();
            var bookingCreationResponse = createBooking.CreateBooking(reqSpec, "Clark", "Kent", -100, false, "2022-02-02", "2022-02-02", "None")
            .then()
            .spec(successfulResSpec)
            .extract().as(BookingResponse.class);
            assertTrue(bookingCreationResponse.getBooking().getTotalprice()<0, "Price Is Positive");
        }
        @Test(groups="knownBug")
        public void request_CreateBooking_WithInvalidDate(){
            bookingService createBooking = new bookingService();
            var bookingUpdationResponse = createBooking.CreateBooking(reqSpec, "Leon", "Kennedy", 100, false, "2020-15-15", "2020-42-51", "")
            .then()
            .spec(successfulResSpec)
            .extract().as(BookingResponse.class);
            
            assertTrue(bookingUpdationResponse.getBooking().getBookingDates().getCheckin().equals("0NaN-aN-aN"), "Date is Incorrect");
            }

}
