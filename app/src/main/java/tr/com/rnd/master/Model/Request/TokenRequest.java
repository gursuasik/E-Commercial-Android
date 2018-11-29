package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class TokenRequest {
    String endPoint = "/token";
    public int method = Request.Method.POST;

    String grand_type = "password";
    public String username = "";
    public String password = "";

    public TokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String url() {
        Config config = new Config();
        return config.URL + endPoint;
    }

    public Map<String, String> parameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.grand_type, grand_type);
        paramaters.put(RequestApi.username, username);
        paramaters.put(RequestApi.password, password);

        return paramaters;
    }
}
