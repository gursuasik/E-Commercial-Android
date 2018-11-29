package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class CardPaymentRequest {
    String endPoint = "/CardPayment";
    public int method = Request.Method.POST;

    String token_type = "";
    String authorization = "";

    public String email;
    public String name;
    public String cardNo;
    public String expireMonth;
    public String expireYear;
    public String cvv2;
    String ip;
    public int installmentCount;

    public CardPaymentRequest(String token_type, String authorization, String email, String name, String cardNo, String expireMonth, String expireYear, String cvv2, String ip, int installmentCount) {
        this.token_type = token_type;
        this.authorization = authorization;

        this.email = email;
        this.name = name;
        this.cardNo = cardNo;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.cvv2 = cvv2;
        this.ip = ip;
        this.installmentCount = installmentCount;
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
        Map<String, JSONObject> paramaters = new HashMap<>();
        Map<String, String> paramaters0 = new HashMap<>();

        paramaters0.put(RequestApi.Cvv2, cvv2);
        paramaters0.put(RequestApi.Email, email);
        paramaters0.put(RequestApi.ExpireYear, expireYear);
        paramaters0.put(RequestApi.Name, name);
        paramaters0.put(RequestApi.Ip, ip);
        paramaters0.put(RequestApi.ExpireMonth, expireMonth);
        paramaters0.put(RequestApi.CardNo, cardNo);

        paramaters.put(RequestApi.CreditCard, new JSONObject(paramaters0));
        try {
            paramaters.put(RequestApi.InstallmentCount, new JSONObject(String.valueOf(installmentCount)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(paramaters);

        return jsonObject;
    }
}
