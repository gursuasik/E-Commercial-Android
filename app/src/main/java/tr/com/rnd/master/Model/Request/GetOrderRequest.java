package tr.com.rnd.master.Model.Request;

import com.android.volley.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class GetOrderRequest {
    String endPoint = "/getorder";
    public int method = Request.Method.POST;

    String token_type = "";
    String authorization = "";

    String data;

    public GetOrderRequest(String token_type, String authorization, String data) {
        this.token_type = token_type;
        this.authorization = authorization;

        this.data = data;
    }

    public String getURL() {
        Config config = new Config();
        return config.URL + config.API + config.ORDER + endPoint;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Accept", "application/json; charset=UTF-8");
        headers.put("Authorization", token_type + " " + authorization);

        return headers;
    }

    public JSONObject getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.Data, data);

        JSONObject jsonObject = new JSONObject(paramaters);

        return jsonObject;
    }
}
