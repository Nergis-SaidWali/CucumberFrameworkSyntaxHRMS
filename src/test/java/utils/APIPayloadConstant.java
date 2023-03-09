package utils;

import org.json.JSONObject;

public class APIPayloadConstant {

    public static String createEmployeePayload(){
        String createEmployeePayload =
                "{\n" +
                        "  \"emp_firstname\": \"Aram\",\n" +
                        "  \"emp_lastname\": \"Lango\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2010-01-14\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonBody(){
        JSONObject obj= new JSONObject();
        obj.put("emp_firstname", "Aram");
        obj.put("emp_lastname", "Lango");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2010-01-14");
        obj.put("emp_status", "confirmed");
        obj.put("emp_job_title", "QA Engineer");
        return obj.toString();
    }

    public static String createEmployeePayloadDynamic(String firstname, String lastname, String middlename,
                                                      String gender, String dob,
                                                      String empStatus, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }

    public static String updateEmployeePayloadDynamic(String empId, String firstname, String lastname, String middlename,
                                                      String gender, String dob,
                                                      String empStatus, String jobTitle) {
        JSONObject obj = new JSONObject();
        obj.put("employee_id", empId);
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title", jobTitle);
        return obj.toString();
    }


    public static String adminPayload(){
        String adminPayload =
                "{\n" +
                        "  \"email\": \"Nergis1234@test.com\",\n" +
                        "  \"password\": \"Nergis123\"\n" +
                        "}";
        return adminPayload;
    }


}
