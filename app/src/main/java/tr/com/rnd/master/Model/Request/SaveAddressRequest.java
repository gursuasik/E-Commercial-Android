package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class SaveAddressRequest {
    String endPoint = "/SaveAddress";
    public int method = Request.Method.POST;

    String token_type = "";
    String authorization = "";

    int type;
    int contactId;
    String nickName;
    String name;
    String surname;
    int countryId;
    int cityId;
    String cityName;
    int townId;
    String townName;
    String areaId;
    String apartmentNo;
    String nearestArea;
    String addressText;
    String phone;
    String taxNo;
    String taxOffice;
    int id;
    String identityNumber;

    public SaveAddressRequest(String token_type, String authorization, int type, int contactId, String nickName, String name, String surname, int countryId, int cityId, String cityName, int townId, String townName, String areaId, String apartmentNo, String nearestArea, String addressText, String phone, String taxNo, String taxOffice, int id, String identityNumber) {
        this.token_type = token_type;
        this.authorization = authorization;
        this.type = type;
        this.contactId = contactId;
        this.nickName = nickName;
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
        this.cityId = cityId;
        this.cityName = cityName;
        this.townId = townId;
        this.townName = townName;
        this.areaId = areaId;
        this.apartmentNo = apartmentNo;
        this.nearestArea = nearestArea;
        this.addressText = addressText;
        this.phone = phone;
        this.taxNo = taxNo;
        this.taxOffice = taxOffice;
        this.id = id;
        this.identityNumber = identityNumber;
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

        paramaters.put(RequestApi.type, String.valueOf(type));
        paramaters.put(RequestApi.ContactId, String.valueOf(contactId));
        paramaters.put(RequestApi.NickName, nickName);
        paramaters.put(RequestApi.Name, name);
        paramaters.put(RequestApi.Surname, surname);
        paramaters.put(RequestApi.CountryId, String.valueOf(countryId));
        paramaters.put(RequestApi.CityId, String.valueOf(cityId));
        paramaters.put(RequestApi.CityName, cityName);
        paramaters.put(RequestApi.TownId, String.valueOf(townId));
        paramaters.put(RequestApi.TownName, townName);
        paramaters.put(RequestApi.AreaId, areaId);
        paramaters.put(RequestApi.ApartmentNo, apartmentNo);
        paramaters.put(RequestApi.NearestArea, nearestArea);
        paramaters.put(RequestApi.AddressText, addressText);
        paramaters.put(RequestApi.Phone, phone);
        paramaters.put(RequestApi.TaxNo, taxNo);
        paramaters.put(RequestApi.TaxOffice, taxOffice);
        paramaters.put(RequestApi.Id, String.valueOf(id));
        paramaters.put(RequestApi.IdentityNumber, identityNumber);

        JSONObject jsonObject = new JSONObject(paramaters);

        return jsonObject;
    }
}
