package iooperations.json;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonReader {
    public static void main(String[] args) {
        read("employee.json");
    }

    public static void read(String filePath){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)){
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;

            System.out.println("JSON" +employeeList);
            System.out.println("First element" +employeeList.get(0));  // print the first JSON block
            parseEmployeeObject(new JSONObject((Map) employeeList.get(0)));

            //METHOD2 - Without taking individual objects, here we are the object using the JSON path
            String firstName = JsonPath.read(employeeList.get(0),"employee.firstName");
            System.out.print("First name: "+firstName);


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseEmployeeObject(JSONObject employee)
    {
        JSONObject employeeObject = (JSONObject) employee.get("employee");
        String firstName = (String) employeeObject.get("firstName");
        System.out.println("First Name is : "+firstName);

        String lastName = (String) employeeObject.get("lastName");
        System.out.println("Last Name is : "+lastName);

        String website = (String) employeeObject.get("website");
        System.out.println("WebSite is : "+website);
    }
}
