package gem.qa.GemEcosystem_api;

import com.gemini.generic.QuanticAPIBase;
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




public class Put_suite extends QuanticAPIBase {


    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Putsuite(JsonObject inputData){
        GemTestReporter.addTestStep("Test Case", "Test to Update the suite using Put API  ", STATUS.INFO);
        String url=ProjectApiUrl.getUrl("putu");
        GemTestReporter.addTestStep("Url for Put Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("put_1_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res=null;

        try {
            res = ApiClientConnect.putRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Executed Successfully", STATUS.PASS);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status=res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status==200) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 200", STATUS.PASS);
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
    public void Putsuite_srunidnotpresent(JsonObject inputData){
        GemTestReporter.addTestStep("Test Case", "Test to Update the suite using Put API and the s-run_id is not present in the database ", STATUS.INFO);

        String url=ProjectApiUrl.getUrl("putu");

        GemTestReporter.addTestStep("Url for Put Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("put_2_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res=null;

        try {
            res = ApiClientConnect.putRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Executed Successfully", STATUS.PASS);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status=res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status==400) {

            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 400", STATUS.PASS);


            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.PASS);
        }
        else if (status==200){



            GemTestReporter.addTestStep("Status Verification", "Expected Status : 200", STATUS.FAIL);
            JsonObject body=res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message=body.get("message").toString();
            GemTestReporter.addTestStep("Final Message",message, STATUS.FAIL);

        }
        else {

            JsonObject body= res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 400", STATUS.FAIL);


            String l=  body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message",l, STATUS.FAIL);

        }

    }



}
