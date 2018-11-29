package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import tr.com.rnd.master.Model.Config.Config;

public class HomePageRequest {
    String endPoint = "/homepage";
    public int method = Request.Method.GET;

    public String getURL() {
        Config config = new Config();
        return config.URL + config.API + config.PAGE + endPoint;
    }

    String[] getParameters() {
        String[] paramaters = {};

        return paramaters;
    }
}
