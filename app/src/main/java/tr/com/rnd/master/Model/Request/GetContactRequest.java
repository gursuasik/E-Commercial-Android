package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;

public class GetContactRequest {
    String endPoint = "/getcontact";
    public int method = Request.Method.GET;

    String token_type = "";
    String authorization = "";

    public GetContactRequest(String token_type, String authorization) {
        this.token_type = token_type;
        this.authorization = authorization;
    }

    public String getURL() {
        Config config = new Config();
        return config.URL + config.API + config.CONTACT + endPoint;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Accept", "application/json; charset=UTF-8");
        headers.put("Authorization", token_type + " " + authorization);

        return headers;
    }

    public JSONObject getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        JSONObject jsonObject = new JSONObject(paramaters);

        return jsonObject;
    }
}
