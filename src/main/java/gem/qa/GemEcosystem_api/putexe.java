package gem.qa.GemEcosystem_api;

import com.gemini.apitest.ApiHealthCheckUtils;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;
import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class putexe extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Putexe(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Put function ", STATUS.INFO);


        String url = ProjectApiUrl.getUrl("putexe");


        GemTestReporter.addTestStep("Url for Put Request", url, STATUS.INFO);


        //headers
        Map<String, String> headers = new HashMap<>();
        headers.put("username", "ragahav.suneja");
        headers.put("bridgeToken", "ebbd1724-6aa7-431c-92b7-af8c3f24659b1656580322679");

        GemTestReporter.addTestStep("Headers", String.valueOf(headers), STATUS.INFO);

        //payload
        JsonObject payload = ProjectSampleJson.getSampleData("puter1_sampleJson").getAsJsonObject();
        payload = (JsonObject) ApiHealthCheckUtils.result(payload);

        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.putRequest(url, String.valueOf(payload), "json", headers);
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 200) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 200", STATUS.PASS);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.PASS);

        } else {
            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.FAIL);


        }

    }


    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Putexe_srunidnotgiven(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "To update data of particular testcase using tc_run_id when s run id is not given by the user ", STATUS.INFO);


        String url = ProjectApiUrl.getUrl("putexe");


        GemTestReporter.addTestStep("Url for Put Request", url, STATUS.INFO);


        //headers
        Map<String, String> headers = new HashMap<>();
        headers.put("username", "ragahav.suneja");
        headers.put("bridgeToken", "ebbd1724-6aa7-431c-92b7-af8c3f24659b1656580322679");

        GemTestReporter.addTestStep("Headers", String.valueOf(headers), STATUS.INFO);

        //payload
        JsonObject payload = ProjectSampleJson.getSampleData("puter2_sampleJson").getAsJsonObject();
        payload = (JsonObject) ApiHealthCheckUtils.result(payload);


        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.putRequest(url, String.valueOf(payload), "json", headers);
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 400) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 400", STATUS.PASS);

            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.PASS);

        } else if (status == 200) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 200", STATUS.FAIL);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.FAIL);

        } else {
            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.FAIL);


        }

    }


    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Putexe_tcrunidnotgiven(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "To update data of particular testcase using tc_run_id when Tc run id is not given by the user ", STATUS.INFO);


        String url = ProjectApiUrl.getUrl("putexe");


        GemTestReporter.addTestStep("Url for Put Request", url, STATUS.INFO);


        //headers
        Map<String, String> headers = new HashMap<>();
        headers.put("username", "ragahav.suneja");
        headers.put("bridgeToken", "ebbd1724-6aa7-431c-92b7-af8c3f24659b1656580322679");

        GemTestReporter.addTestStep("Headers", String.valueOf(headers), STATUS.INFO);

        //payload
        JsonObject payload = ProjectSampleJson.getSampleData("puter3_sampleJson").getAsJsonObject();
        payload = (JsonObject) ApiHealthCheckUtils.result(payload);


        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.putRequest(url, String.valueOf(payload), "json", headers);
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 400) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 400", STATUS.PASS);

            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.PASS);

        } else if (status == 200) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 200", STATUS.FAIL);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.FAIL);

        } else {
            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.FAIL);


        }

    }


}

