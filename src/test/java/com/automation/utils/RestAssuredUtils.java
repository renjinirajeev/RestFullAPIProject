package com.automation.utils;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredUtils {
    static RequestSpecification requestSpecification = RestAssured.given();
    static String endpoint;
    static Response response;

    public static void setEndpoint(String endpoint){
        RestAssuredUtils.endpoint=endpoint;
    }

    public static Response post(){
        requestSpecification.log().all();
        response= requestSpecification.post(endpoint);
        response.then().log().all();
        return response;
    }

    public static Response get(){
        requestSpecification.log().all();
        response= requestSpecification.get(endpoint);
        response.then().log().all();
        return response;
    }

    public static Response put(){
        requestSpecification.log().all();
        response= requestSpecification.put(endpoint);
        response.then().log().all();
        return response;
    }


    public static Response getResponse(){
        return response;
    }

    public static int getStatusCode(){
       return response.getStatusCode();
    }

    public static void setHeader(String key , String value){
        requestSpecification=requestSpecification.header(key,value);
    }

    public static void setBodyFromPojo(Object object){
        requestSpecification=requestSpecification.body(object);
    }

    public static String getFieldFromJsonPath(String jsonPath){
        return response.jsonPath().getString(jsonPath);
    }

    public static String getDataFromFile(String fileName)  {
        String content=null;
        try {
            content = new Scanner(new FileInputStream(fileName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return content ;
    }

}
