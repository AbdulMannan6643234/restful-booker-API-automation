package tests.Bookings;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.bookingService;
import models.Booking;
import tests.Base.BaseTests;
import util.bookingDataProvider;

public class bookingRetrievalTests extends BaseTests {
        @Test(groups="smoke")
        public void retrieve_BookingIds(){
            bookingService getBookings = new bookingService();
            var ids = getBookings.getBookingIds(reqSpec, successfulResSpec);
            assertTrue(ids.size()>0, "No Booking Ids Found");
        }
        @Test(groups="regression")
        public void retrieveBookingIds_WithSpecificName(){
            bookingService getBookings = new bookingService();
            var ids = getBookings.getBookingIdsByName(reqSpec, successfulResSpec);
            assertTrue(ids.size()>0, "No Booking Ids Found");
        }
        @Test(groups="regression")
        public void retrieve_BookingIds_WithSpecificDates(){
            bookingService getBookings = new bookingService();
            var ids = getBookings.getBookingIdsByDates(reqSpec, successfulResSpec);
            assertTrue(ids.size()>0, "No Booking Ids Found");
        }
        @Test(dataProviderClass=bookingDataProvider.class,dataProvider="bookingData",groups="smoke")
        public void retrieve_BookingById(int id){
            bookingService getBooking = new bookingService();
            var booking = getBooking.getBookingById(id, reqSpec)
            .then()
            .spec(successfulResSpec)
            .extract().as(Booking.class);
            assertFalse(booking.getFirstname().equals(null), "Firstname Found Empty");
        }
        @Test(groups="regression")
        public void retrieve_BookingByNegativeId(){
            int id = -1;
            bookingService getBooking = new bookingService();
            var booking = getBooking.getBookingById(id, reqSpec)
            .then()
            .spec(failureResSpec);
            
        }
}
