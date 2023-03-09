package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.*;
import static org.json.JSONArray.*;

//to change the order of execution, we use fixMethodOrder since it is executing
// in top to bottom approach which is not good for us
//this method sorters will execute my methods in ascending order, alphabetically
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //one thing to remember
    //base URI is base URL here
    // end then using when keyword, we will send the endpoint

    //we need to add http:// because here we are using URL and postman does it for us here we need to provide it
    String baseURI= RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    //we need to perform CRUD operations

    String token= "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQ1MjkyNzcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDU3MjQ3NywidXNlcklkIjoiNDk1MyJ9.MH1sc8axqghS2T2PQGsZH2ZfugOM1WGrGW4ofIkOXMM";
    static String employee_id;
    @Test
    public void bgetOneEmployee(){
        //prepare the request
        //whenever to prepare the request, we use request specification
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", employee_id);

        //to hit the endpoint / to make the request which will return response
        Response response = request.when().get("/getOneEmployee.php");

        //printing the response, there are 2 ways, we use second one most of the time
        //System.out.println(response.asString());
        response.prettyPrint();

        //verifying the status code
        response.then().assertThat().statusCode(200);

        //using jsonPath() method, we are extracting the value from the response body
        String firstName = response.jsonPath().get("employee.emp_firstname");
        System.out.println(firstName);

        //first way of assertion
        Assert.assertEquals(firstName, "Aram");
        //second way of assertion to verify the value in response body using hamcrest matchers
        response.then().assertThat().body("employee.emp_firstname", equalTo("Aram"));

    }
    @Test
    public void acreateEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"emp_firstname\": \"Aram\",\n" +
                        "  \"emp_lastname\": \"Lango\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2010-01-14\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        //verifying the status code which is 201
        response.then().statusCode(201);
        //getting the employee id from the response and use it as static
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        response.then().assertThat().body("Employee.emp_lastname", equalTo("Lango"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("ms"));
        //verify console header
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }
    @Test
    public void cupdateEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Yuza\",\n" +
                        "  \"emp_lastname\": \"Wali\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-01-15\",\n" +
                        "  \"emp_status\": \"maternityleave\",\n" +
                        "  \"emp_job_title\": \"manager\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();

        //verification
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", employee_id);

        //to hit the endpoint / to make the request which will return response
        Response response = request.when().get("/getOneEmployee.php");

        //printing the response, there are 2 ways, we use second one most of the time
        //System.out.println(response.asString());
        response.prettyPrint();

        //verifying the status code
        response.then().assertThat().statusCode(200);
        //verifying the job title has changed
        response.then().assertThat().body("employee.emp_job_title", equalTo("Manager"));
    }

    @Test
    public void getAllJobTitles(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json");
        Response response=request.when().get("/jobTitle.php");
        //response.prettyPrint();
        /*String responseBody=response.jsonPath().getString("Jobs.job");
        System.out.println(responseBody);
        String[] array = responseBody.split(",");
        System.out.println(array.length);*/


        List<String> jobs=response.jsonPath().getList("Jobs");
        System.out.println(jobs.size());

       /* for (int i = 0; i< jobs.size() ; i++) {
            String x = response.jsonPath().getString("Jobs[" + i + "].job");
            System.out.println(x);
        }*/
        /*JSONArray jobs=json.getJSONArray("Jobs");
        System.out.println(jobs.length());*/

        }




}
