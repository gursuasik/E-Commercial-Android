package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class SearchRequest {
    String endPoint = "/search";
    public int method = Request.Method.POST;

    String Url = "";
    String p = "";
    String ps = "";
    String s = "";
    String o = "";
    String k = "";
    String t = "";

    public SearchRequest(String url, String p, String ps, String s, String o, String k, String t) {
        this.Url = url;
        this.p = p;
        this.ps = ps;
        this.s = s;
        this.o = o;
        this.k = k;
        this.t = t;
    }

    public String getURL() {
        Config config = new Config();
        return config.URL + config.API + config.CATALOG + endPoint;
    }

    public Map<String, String> getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.Url, Url);
        paramaters.put(RequestApi.p, p);
        paramaters.put(RequestApi.ps, ps);
        paramaters.put(RequestApi.s, s);
        paramaters.put(RequestApi.o, o);
        paramaters.put(RequestApi.k, k);
        paramaters.put(RequestApi.t, t);

        return paramaters;
    }
}
