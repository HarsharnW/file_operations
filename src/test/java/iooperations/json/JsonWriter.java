package iooperations.json;

import net.minidev.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter
{
    public static void main(String[] args) {
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Osanda");
        employeeDetails.put("lastName", "Nimalarathna");
        employeeDetails.put("Phone Number", "0715522087");
        write(employeeDetails, "employeeDetails.json");
    }

    public static void write(JSONObject jsonObject, String filePath) {
        JSONObject object = new JSONObject();
        object.put("employee", jsonObject);

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(object.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
