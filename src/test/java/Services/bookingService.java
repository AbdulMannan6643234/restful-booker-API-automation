package Services;

import java.util.List;

import static io.restassured.RestAssured.given;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.Booking;
import models.BookingDates;
import models.BookingIds;
import models.BookingResponse;

public class bookingService {
        public List<BookingIds> getBookingIds(RequestSpecification reqSpec, ResponseSpecification resSpec){
           return given()
           .spec(reqSpec)
           .when()
           .get("/booking")
           .then()
           .spec(resSpec)
           .extract()
           .as(new TypeRef<List<BookingIds>>() {});
        }
        public List<BookingIds> getBookingIdsByName(RequestSpecification reqSpec, ResponseSpecification resSpec){
            var request = new Booking("sally","brown");
            return given()
           .spec(reqSpec)
           .body(request)
           .when()
           .get("/booking")
           .then()
           .spec(resSpec)
           .extract()
           .as(new TypeRef<List<BookingIds>>() {});
        }
        public List<BookingIds> getBookingIdsByDates(RequestSpecification reqSpec, ResponseSpecification resSpec){
            var request = new BookingDates("2014-03-13","2014-05-21");
            return given()
           .spec(reqSpec)
           .body(request)
           .when()
           .get("/booking")
           .then()
           .spec(resSpec)
           .extract()
           .as(new TypeRef<List<BookingIds>>() {});
        }
        public Response getBookingById(int id,RequestSpecification reqSpec){
            return given()
            .spec(reqSpec)
            .pathParam("id", id)
            .when()
            .get("https://restful-booker.herokuapp.com/booking/{id}");
        }
        public Response CreateBooking(RequestSpecification reqSpec, String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout,
            String additionalneeds){
               BookingDates bookingdates = new BookingDates(checkin,checkout);
               Booking booking = new Booking(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
         return given()
         .spec(reqSpec)
         .body(booking)
         .when()
         .post("/booking");
         
        }
        public Response updateExistingBooking(RequestSpecification reqSpec,int id, String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout,
            String additionalneeds){
               BookingDates bookingdates = new BookingDates(checkin,checkout);
               Booking booking = new Booking(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
         return given()
         .spec(reqSpec)
         .pathParam("id", id)
         .body(booking)
         .when()
         .put("/booking/{id}");
         
        }
        public Response partiallyUpdateNameInExistingBooking(RequestSpecification reqSpec,int id ,String firstname,String lastname){
               Booking booking = new Booking(firstname, lastname);
         return given()
         .spec(reqSpec)
         .pathParam("id", id)
         .body(booking)
         .when()
         .patch("/booking/{id}");
         
        }
        public Response partiallyUpdateDateInExistingBooking(RequestSpecification reqSpec,int id ,String checkin,String checkout){
               BookingDates bookingdates = new BookingDates(checkin, checkout);
               Booking booking = new Booking(bookingdates);
               return given()
         .spec(reqSpec)
         .pathParam("id", id)
         .body(booking)
         .when()
         .patch("/booking/{id}");
         
        }
        public Response deleteExistingBooking(RequestSpecification reqSpec , int id){
         return given()
         .spec(reqSpec)
         .pathParam("id", id)
         .when()
         .delete("/booking/{id}");
        }
}

