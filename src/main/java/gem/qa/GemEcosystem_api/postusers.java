package gem.qa.GemEcosystem_api;

import com.gemini.generic.QuanticAPIBase;
import com.gemini.apitest.ApiHealthCheckUtils;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;
import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class postusers extends QuanticAPIBase {

    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postusers(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Post function ", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("Post");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("Postgemini_sampleJson").getAsJsonObject();

        payload = (JsonObject) ApiHealthCheckUtils.result(payload);

        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");

            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        // System.out.println(res);

        int status = res.get("status").getAsInt();

        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);

        if (status == 201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);

            JsonObject body = res.get("responseBody").getAsJsonObject();

            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);

            JsonObject token = body.get("data").getAsJsonObject();
            String Token = token.get("bridgeToken").getAsString();
            GemTestReporter.addTestStep("Bridge Token", String.valueOf(Token), STATUS.INFO);

            String message = body.get("message").toString();

            GemTestReporter.addTestStep("Final Message", message, STATUS.PASS);

        } else {
            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.FAIL);


        }

    }

    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postusers_alreadyexists(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Post function ", STATUS.INFO);

        String url = ProjectApiUrl.getUrl("Post");

        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("Postgemini2_sampleJson").getAsJsonObject();

        payload = (JsonObject) ApiHealthCheckUtils.result(payload);

        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");

            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        // System.out.println(res);

        int status = res.get("status").getAsInt();

        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);

        if (status == 409) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 409", STATUS.PASS);


            JsonObject Error = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(Error), STATUS.PASS);

            String Message = Error.get("message").getAsString();
            GemTestReporter.addTestStep("Final Message", String.valueOf(Message), STATUS.INFO);


        } else if (status == 400) {
            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.FAIL);


        } else if (status == 201) {
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(body), STATUS.FAIL);

        }
    }


    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postusers_compulsory_field_not_present(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Post function ", STATUS.INFO);

        String url = ProjectApiUrl.getUrl("Post");

        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("Postgemini3_sampleJson").getAsJsonObject();

        payload = (JsonObject) ApiHealthCheckUtils.result(payload);

        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {

            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");

            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);

        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        // System.out.println(res);

        int status = res.get("status").getAsInt();

        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);

        if (status == 500) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 500", STATUS.PASS);


            JsonObject Error = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(Error), STATUS.PASS);

            String Message = Error.get("message").getAsString();
            GemTestReporter.addTestStep("Final Message", String.valueOf(Message), STATUS.INFO);


        } else if (status == 400) {
            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.FAIL);


        } else {
            JsonObject bo = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Final response", String.valueOf(bo), STATUS.FAIL);

        }

    }


}
