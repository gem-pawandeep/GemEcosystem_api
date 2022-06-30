package gem.qa.GemEcosystem_api;

import com.gemini.generic.QuanticAPIBase;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class gettoken extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Gettoken(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Get Token API ", STATUS.INFO);

        String url = ProjectApiUrl.getUrl("Gettoken");

        GemTestReporter.addTestStep("Url for Get Request", url, STATUS.INFO);

        JsonObject res = null;
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWdhaGF2LnN1bmVqYSIsImlhdCI6MTY1NjU5MDc0NSwiZXhwIjoxNjU2NTkxMDQ1fQ.ZHGhUyhjFGrNKvz9p0xQRQ67wTYdMTFMARrm4ot8XuHosOC0IBlSSIPARgiuDOp4CLQEQHE80weQcYuAJvdpUw");
        try {
            res = ApiClientConnect.createRequest("Get", url, "", headers);
            GemTestReporter.addTestStep(" Get Request Verification ", "Get Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Get Request Verification ", "Get Request Did not Executed Successfully", STATUS.FAIL);
        }

        int status = res.get("status").getAsInt();

        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);

        if (status == 200) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 200", STATUS.PASS);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response After hitting the API ", String.valueOf(body), STATUS.INFO);

            //  System.out.println(body);
            //  System.out.println(res);
            String message = String.valueOf(body.get("message"));
            GemTestReporter.addTestStep("Final Message ", String.valueOf(message), STATUS.PASS);

        } else {

            GemTestReporter.addTestStep("Final response", "No response", STATUS.FAIL);


        }


    }


}
