package RestAssured;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class RestTest {

    RequestSpecification request;
    Response response;
    ValidatableResponse json;
    ExtentTest test;
    ExtentReports report;


    @Before
    public void example() {
        request = given().contentType(JSON);
        response = request.when().get("http://10.0.10.10:9966/petclinic/swagger-ui.html");
        System.out.println(response.prettyPrint());
        json = response.then().statusCode(200);
        //begin reporting
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\PetOwnersRestTest.html", false);
    }

    @Test
    public void getOwners() {
        Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        //add to report
        test = report.startTest("Retrieve all owners");
        test.log(LogStatus.INFO, "owner information retrieved!");
        test.log(LogStatus.PASS, "retrieval Success!");

    }
    @Test
    public void postOwners () {

        JSONArray petArray = new JSONArray();
        JSONArray visitArray = new JSONArray();

         Map<String, Object> type = new HashMap<String, Object>();
         //type.put("id", 0);
         type.put("name", "ted");

        Map<String, Object> pets = new HashMap<String, Object>();
        pets.put("birthDate", "2018-07-27T09:57:00.372Z");
        //pets.put("id", 0);
        pets.put("name", "teddy");
        pets.put("type", "dog");
        petArray.put(pets);


        Map<String, Object> visits = new HashMap<String, Object>();
        visits.put("date", "2018/06/25");
        visits.put("description", "checkin");
       // visits.put("id", 0);
        visits.put("pet", pets);
        visitArray.put(visits);


        JSONObject jsonAsMap = new JSONObject();
        jsonAsMap.put("address", "6 Penny close");
        jsonAsMap.put("city", "Manchester");
        jsonAsMap.put("firstName", "Austin");
        //jsonAsMap.put("id", 30);
        jsonAsMap.put("lastName", "Beads");
        jsonAsMap.put("pet", petArray);
        jsonAsMap.put("visits", visitArray);
        jsonAsMap.put("telephone", "093752382");

        Response response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
        System.out.println(jsonAsMap);
//      given().contentType(ContentType.JSON).body(jsonAsMap).when().post("http://10.0.10.10:9966/petclinic/api/owners/").then().statusCode(200);
//      System.out.println(jsonAsMap);
       System.out.println(response.getStatusCode());

        //add to report
        test = report.startTest("Add an owner");
        test.log(LogStatus.INFO, "owner created!");
        test.log(LogStatus.PASS, "Success!");

    }

    @Test
    public void getOwnersList() {
        Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners/*/lastname/sten");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        //add to report
        test = report.startTest("Retrieve Owners List");
        test.log(LogStatus.INFO, "owner information retrieved!");
        test.log(LogStatus.PASS, "Owners List Success!");

    }

    @Test
    public void deleteOwner() {
        Response response = request.delete("http://10.0.10.10:9966/petclinic/api/owners/12");
        System.out.println(response.getStatusCode());
        //add to report
        test = report.startTest("delete owner details");
        test.log(LogStatus.INFO, "owner deleted!");
        test.log(LogStatus.PASS, "deletion Success!");

    }
    @Test
    public void getOwnersById() {
        Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners/5");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        //add to report
        test = report.startTest("Retrieve by id");
        test.log(LogStatus.INFO, "owner information retrieved!");
        test.log(LogStatus.PASS, " id retrieval Success!");

    }
  //  @Test
 //   public void updateOwners () {
//        JSONObject obj = new JSONObject();
//        obj.put("address", "6 Penny close");
//        obj.put("city", "Manchester");
//        obj.put("firstName", "Austin");
//        obj.put("id", "");
//        obj.put("lastName", "Beads");
//
//        JSONObject pets = new JSONObject();
//        //pets.put("pets"),
//        pets.put("birthDate", "2018-07-27T09:57:00.372Z");
//        pets.put("id", "");
//        pets.put("name", "teddy");
//        pets.put("owner", "{}");
//        pets.put("type", "dog");

//        "Kevin");
//        obj.put("firstName", "Kevin");
///        obj.put("telephone", "093752382");
//        System.out.println(request.body(obj.toString()));
//        // finally send the request we have built up
//        Response response = request.post("http://localhost:8090/example/v1/hotels");
//        System.out.println(response.getStatusCode());
//        System.out.println(response.prettyPrint());
//        //add to report
//        test = report.startTest("Add an owner");
//        test.log(LogStatus.INFO, "owner created!");
//        test.log(LogStatus.PASS, "Success!");
//    }
        @After
        public void tearDown () throws InterruptedException {
            Thread.sleep(2000);
            report.endTest(test);
            report.flush();

        }

    }









