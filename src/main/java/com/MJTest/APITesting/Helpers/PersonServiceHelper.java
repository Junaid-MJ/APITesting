package com.MJTest.APITesting.Helpers;

import com.MJTest.APITesting.Constants.EndPoints;
import com.MJTest.APITesting.Model.Person;
import com.MJTest.APITesting.Utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.http.util.Asserts;
import org.testng.Assert;


import java.lang.reflect.Type;
import java.util.List;

public class PersonServiceHelper {

    private static final String  BASE_URL = ConfigManager.getInstance().getString("basURL");
    private static final String  PORT = ConfigManager.getInstance().getString("port");

    public PersonServiceHelper(){
        RestAssured.baseURI=BASE_URL;
        RestAssured.port= Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<Person> getAllPerson(){
        Response response= RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_PERSON)
                .andReturn();

        Type type= new TypeReference<List<Person>>(){}.getType();
       Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK,"OK");
        return response.as(type);

    }

    public Response createPerson(){
        Person person= new Person();
        person.setFirstname("Avinash");
        person.setId(3);
        person.setLastname("Thanvi");
        person.setAge(23);
        person.setPhoneNumber("12345678");
        person.setAddress("pune, Maharashtra");

        Response response= RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(person).log().all()
                .post(EndPoints.CREATE_PERSON)
                .andReturn();
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED,"Created");

        return response;
    }

    public Response updatePerson(Integer id){

        Person person = new Person();
        person.setFirstname("Siddharth");
        person.setLastname("Rawat");
        person.setAddress("lalitpur , UP");

        Response response= RestAssured
                .given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .when().body(person)
                .patch(EndPoints.UPDATE_PERSON)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK,"Updated");
        return response;

    }


    public Response deletePerson(Integer id){
        Response response= RestAssured
                .given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_PERSON)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK,"Updated");
        return response;
    }

}
