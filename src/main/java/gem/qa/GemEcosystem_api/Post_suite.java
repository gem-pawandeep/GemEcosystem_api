package gem.qa.GemEcosystem_api;

import com.gemini.generic.QuanticAPIBase;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;
import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class Post_suite extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postsuitess(JsonObject inputData) {
        GemTestReporter.addTestStep("Test Case", "Test to insert the suite using Post API  ", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("pospo");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("psuite_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.PASS);

        } else {
            JsonObject body = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me = body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l = body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message", l, STATUS.FAIL);


        }

    }


    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postsuite_s_run_idpresent(JsonObject inputData) {
        GemTestReporter.addTestStep("Test Case", "Test to insert the suite using Post API when S-run-id is already present", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("pospo");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("psuite1_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 400) {
            JsonObject body = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 400", STATUS.PASS);
            String me = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message ", me, STATUS.INFO);

        } else if (status == 201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.FAIL);

        } else {
            JsonObject body = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me = body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l = body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message", l, STATUS.FAIL);


        }

    }


    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postsuite_s_run_idpresentinthepayload(JsonObject inputData) {
        GemTestReporter.addTestStep("Test Case", "Test to insert the suite using Post API when S-run-id is not given in the payload", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("pospo");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("psuite2_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.PASS);

        } else {
            JsonObject body = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me = body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l = body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message", l, STATUS.FAIL);


        }
    }


}
