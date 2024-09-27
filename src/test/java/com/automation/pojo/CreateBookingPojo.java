package com.automation.pojo;


import io.cucumber.java.eo.Se;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateBookingPojo {

    String firstname;
    String lastname;
    String totalprice;
    String depositpaid;
    BookingDates bookingdates;
    String additionalneeds;
}
