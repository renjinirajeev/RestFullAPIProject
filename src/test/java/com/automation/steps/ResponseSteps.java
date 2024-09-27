package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status is {int}")
    public void verify_status_is(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());

    }


    @Then("verify the bookingId is not null")
    public void verify_the_booking_id_is_not_null() {
        String bookingId = RestAssuredUtils.getFieldFromJsonPath("bookingid");
        Assert.assertFalse(bookingId.isEmpty());
    }


    @When("user stores booking id to {string}")
    public void user_stores_booking_id_to(String key) {
        ConfigReader.setConfig(key,RestAssuredUtils.getFieldFromJsonPath("bookingid"));

    }


    @When("user stores token value to {string}")
    public void userStoresTokenValueTo(String key) {
        ConfigReader.setConfig(key,RestAssuredUtils.getFieldFromJsonPath("token"));
    }
}
