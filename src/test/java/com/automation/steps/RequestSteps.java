package com.automation.steps;

import com.automation.pojo.CreateBookingPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class RequestSteps {

    @Given("user wants to call {string} endpoint")
    public void user_wants_to_call_endpoint(String endpoint) {
        if(endpoint.contains("@")){
            endpoint=endpoint.replace("@id",ConfigReader.getConfig("booking.id"));
        }
        RestAssuredUtils.setEndpoint(endpoint);
    }


    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        if(value.contains("@")){
            value=value.replace("@token",ConfigReader.getConfig("api.token"));
        }
        RestAssuredUtils.setHeader(key,value);
    }


    @Given("set body request from the file {string}")
    public void set_body_request_from_the_file(String fileName) throws JsonProcessingException {
        String JsonFolderPath= ConfigReader.getConfig("Json.folder.path");
        String content=RestAssuredUtils.getDataFromFile(JsonFolderPath+fileName);
        ObjectMapper om = new ObjectMapper();
        CreateBookingPojo createBookingPojo = om.readValue(content,CreateBookingPojo.class);
        RestAssuredUtils.setBodyFromPojo(createBookingPojo);
    }


    @Then("user perform post call")
    public void user_perform_post_call() {
        RestAssuredUtils.post();
    }


    @Then("user perform put call")
    public void userPerformPutCall() {
        RestAssuredUtils.put();
    }
}
