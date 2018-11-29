package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class AddProductRequest {
    String endPoint = "/addproduct";
    public int method = Request.Method.POST;

    String token_type = "";
    String authorization = "";

    String barcode;
    String isUpdate;
    Boolean isAddedBySnapBuy;
    public static String quantity;

    public AddProductRequest(String token_type, String authorization, String barcode, String isUpdate, Boolean isAddedBySnapBuy, String quantity) {
        this.token_type = token_type;
        this.authorization = authorization;

        this.barcode = barcode;
        this.isUpdate = isUpdate;
        this.isAddedBySnapBuy = isAddedBySnapBuy;
        this.quantity = quantity;
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

    public Map<String, String> getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.Barcode, barcode);
        paramaters.put(RequestApi.IsUpdate, isUpdate);
        paramaters.put(RequestApi.IsAddedBySnapBuy, String.valueOf(isAddedBySnapBuy));
        paramaters.put(RequestApi.Quantity, quantity);

        return paramaters;
    }
}
