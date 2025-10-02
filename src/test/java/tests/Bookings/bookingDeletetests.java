package tests.Bookings;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import Services.bookingService;
import tests.Base.BaseTests;
import util.bookingDataProvider;

public class bookingDeletetests extends BaseTests{
    @Test(dataProviderClass=bookingDataProvider.class,dataProvider="bookingData")
    public void deleteExistingBooking(int id){
        bookingService deleteBooking = new bookingService();
        String response = deleteBooking.deleteExistingBooking(reqSpec, id)
        .then()
        .spec(deletionResSpec)
        .extract().asString();
        assertTrue(response.contains("Created"),"Invalid Response");
        
    }
      @Test
        public void deleteNonExistentBooking(){
            int id=47;
        bookingService deleteBooking = new bookingService();
        deleteBooking.deleteExistingBooking(reqSpec, id);
        String response = deleteBooking.deleteExistingBooking(reqSpec, id)
        .then()
        .statusCode(405)
        .extract().asString();
        assertTrue(response.contains("Method Not Allowed"),"Invalid Response");
        
      }
      
}
