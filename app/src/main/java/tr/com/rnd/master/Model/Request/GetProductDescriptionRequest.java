package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class GetProductDescriptionRequest {
    String endPoint = "/GetProductDescription";
    public int method = Request.Method.POST;

    String productCode = "";

    public GetProductDescriptionRequest(String barcode) {
        this.productCode = barcode;
    }

    public String getURL() {
        Config config = new Config();
        return config.URL + config.API + config.PRODUCT + endPoint;
    }

    public Map<String, String> getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.ProductCode, productCode);

        return paramaters;
    }
}
