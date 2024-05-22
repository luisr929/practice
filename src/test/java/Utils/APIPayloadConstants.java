package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"sleepy\",\n" +
                "  \"emp_lastname\": \"joe\",\n" +
                "  \"emp_middle_name\": \"biden\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1997-09-29\",\n" +
                "  \"emp_status\": \"coder\",\n" +
                "  \"emp_job_title\": \"tester\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonPayload() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "sleepy");
        obj.put("emp_lastname", "joe");
        obj.put("emp_middle_name", "biden");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1997-09-29");
        obj.put("emp_status", "coder");
        obj.put("emp_job_title", "tester");
        return obj.toString();
    }
    public static String createEmployeeJsonPayloadDynamic
            (String fn, String ln, String mn, String gender,
             String dob, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", fn);
        obj.put("emp_lastname", ln);
        obj.put("emp_middle_name", mn);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }
    public static String partiallyUpdatePayload(String empID,String key,String value){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", empID);
        obj.put(key,value);
        return obj.toString();
    }
}
