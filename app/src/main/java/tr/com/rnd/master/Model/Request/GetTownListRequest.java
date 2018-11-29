package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class GetTownListRequest {
    String endPoint = "/GetTownList";
    public int method = Request.Method.POST;

    String token_type = "";
    String authorization = "";

    int cityId;

    public GetTownListRequest(String token_type, String authorization, int cityId) {
        this.token_type = token_type;
        this.authorization = authorization;

        this.cityId = cityId;
    }

    public String getURL() {
        Config config = new Config();
        return config.URL + config.API + config.ADDRESS + endPoint;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Accept", "application/json; charset=UTF-8");
        headers.put("Authorization", token_type + " " + authorization);

        return headers;
    }

    public JSONObject getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.CityId, String.valueOf(cityId));

        JSONObject jsonObject = new JSONObject(paramaters);

        return jsonObject;
    }
}
