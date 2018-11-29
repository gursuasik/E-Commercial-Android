package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class SetOrderAddressRequest {
    String endPoint = "/SetOrderAddress";
    public int method = Request.Method.POST;

    String token_type;
    String authorization;

    Boolean IsFastDelivery;
    int InvoiceId;
    String UseDelivery;

    public SetOrderAddressRequest(String token_type, String authorization, Boolean isFastDelivery, int invoiceId, String useDelivery) {
        this.token_type = token_type;
        this.authorization = authorization;

        IsFastDelivery = isFastDelivery;
        InvoiceId = invoiceId;
        UseDelivery = useDelivery;
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

        paramaters.put(RequestApi.isFastDelivery, String.valueOf(IsFastDelivery));
        paramaters.put(RequestApi.invoiceId, String.valueOf(InvoiceId));
        paramaters.put(RequestApi.useDelivery, UseDelivery);

        JSONObject jsonObject = new JSONObject(paramaters);

        return jsonObject;
    }
}
