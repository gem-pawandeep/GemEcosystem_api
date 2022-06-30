package gem.qa.GemEcosystem_api;

import com.gemini.generic.QuanticAPIBase;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.apitest.ApiHealthCheckUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;

import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.google.gson.JsonObject;

import io.cucumber.java.ca.Quan;
import jdk.jshell.Snippet;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Post_exe extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postsuite(JsonObject inputData){

        GemTestReporter.addTestStep("Test Case", "To create a new testcase in the database using Post function  ", STATUS.INFO);
        String url=ProjectApiUrl.getUrl("pospos");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("ptest_sampleJson").getAsJsonObject();
        payload = (JsonObject) ApiHealthCheckUtils.result(payload);
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res=null;

        //headers
        Map<String,String> headers=new HashMap<>();
        headers.put("username","ragahav.suneja");
        headers.put("bridgeToken","ebbd1724-6aa7-431c-92b7-af8c3f24659b1656580322679");

        GemTestReporter.addTestStep("Headers", String.valueOf(headers),STATUS.INFO);
        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json",headers);
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status=res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status==201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body=res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message=body.get("message").toString();
            GemTestReporter.addTestStep("Final Message",message, STATUS.PASS);

        }
        else {
            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me=body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.FAIL);




        }




    }



    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postsuite_srunidnotexists(JsonObject inputData){

        GemTestReporter.addTestStep("Test Case", "To create a new testcase in the database using Post function S_run_id  Does not Exist in the database ", STATUS.INFO);
        String url=ProjectApiUrl.getUrl("pospos");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("ptest1_sampleJson").getAsJsonObject();
        payload = (JsonObject) ApiHealthCheckUtils.result(payload);
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        //headers
        Map<String,String> headers=new HashMap<>();
        headers.put("username","ragahav.suneja");
        headers.put("bridgeToken","ebbd1724-6aa7-431c-92b7-af8c3f24659b1656580322679");

        GemTestReporter.addTestStep("Headers", String.valueOf(headers),STATUS.INFO);

        JsonObject res=null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json",headers);
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        // System.out.println(res);

        int status=res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if(status==400)
        {
            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 400", STATUS.PASS);
            //  String me=body.get("message").toString();
            //  GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.PASS);
        }
        else if (status==201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body=res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message=body.get("message").toString();
            GemTestReporter.addTestStep("Final Message",message, STATUS.FAIL);

        }
        else {
            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            //  String me=body.get("message").toString();
            //  GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.FAIL);




        }




    }

    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postsuite_srunidnotgiven(JsonObject inputData){

        GemTestReporter.addTestStep("Test Case", "To create a new testcase in the database using Post function S_run_id  is not given by the user ", STATUS.INFO);
        String url=ProjectApiUrl.getUrl("pospos");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("ptest2_sampleJson").getAsJsonObject();
        payload = (JsonObject) ApiHealthCheckUtils.result(payload);
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        //headers
        Map<String,String> headers=new HashMap<>();
        headers.put("username","ragahav.suneja");
        headers.put("bridgeToken","ebbd1724-6aa7-431c-92b7-af8c3f24659b1656580322679");

        GemTestReporter.addTestStep("Headers", String.valueOf(headers),STATUS.INFO);

        JsonObject res=null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json",headers);
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        // System.out.println(res);

        int status=res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if(status==400)
        {
            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 400", STATUS.PASS);
            //  String me=body.get("message").toString();
            //  GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.PASS);
        }
        else if (status==201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body=res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message=body.get("message").toString();
            GemTestReporter.addTestStep("Final Message",message, STATUS.FAIL);

        }
        else {
            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            //  String me=body.get("message").toString();
            //  GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.FAIL);




        }




    }
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)

    public void Postsuitetcnotpresentinpayload(JsonObject inputData){

        GemTestReporter.addTestStep("Test Case", "To create a new testcase in the database using Post function when user doesnot give tc run id in the payload  ", STATUS.INFO);
        String url=ProjectApiUrl.getUrl("pospos");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("ptest3_sampleJson").getAsJsonObject();
        payload = (JsonObject) ApiHealthCheckUtils.result(payload);
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res=null;

        //headers
        Map<String,String> headers=new HashMap<>();
        headers.put("username","ragahav.suneja");
        headers.put("bridgeToken","ebbd1724-6aa7-431c-92b7-af8c3f24659b1656580322679");

        GemTestReporter.addTestStep("Headers", String.valueOf(headers),STATUS.INFO);
        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json",headers);
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status=res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status==201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body=res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message=body.get("message").toString();
            GemTestReporter.addTestStep("Final Message",message, STATUS.PASS);

        }
        else {
            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me=body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.FAIL);




        }




    }


}