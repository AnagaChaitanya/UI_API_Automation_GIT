package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.JSONObject;
import org.json.simple.parser.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class spaceDataX_RestAPI {
	
	public static void main(String[] args) {
		Response response = getSpaceXDetails();
		Response response2=getSpaceXDetails1();
		System.out.println(response.toString());
		System.out.println(response2);
		
		int status = response.getStatusCode();
		//Scenario 3: Validating JSON response code
		if(status == 200) {
			System.out.println("Scenario 1 is passed with response code :" + status);
		}
		
	}
	
	//Scenario 1: for 200 response code - happy path
	public static Response getSpaceXDetails() {
		Response response = null;
        try {
            RestAssured.baseURI = "https://api.spacexdata.com/v4/launches";
            //can be parameterised the URI to get form config loader
            RequestSpecification request = RestAssured.given();

            response = request.get();
            System.out.println(response);

            int statusCode = response.getStatusCode();
            System.out.println("Status Code : "+ statusCode);
            System.out.println("Response message : " + response.asString());
            System.out.println("Response successful with HTTPCode : " + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response;

    }
	
	//Scenario 2: for 404 response code - for wrong URI
	public static Response getSpaceXDetails1() {
		Response response = null;
        try {
            RestAssured.baseURI = "https://api.spacexdata.com/v4/launche";
            RequestSpecification request = RestAssured.given();

            response = request.get();
            System.out.println(response);

            int statusCode = response.getStatusCode();
            System.out.println("Status Code : "+ statusCode);
            System.out.println("Response message : " + response.asString());
            System.out.println("Response successful with HTTPCode : " + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response;

    }
}
