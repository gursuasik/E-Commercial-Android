package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class UpdateContactRequest {
    String endPoint = "/updatecontact";
    public int method = Request.Method.POST;

    String token_type = "";
    String authorization = "";

    int id;
    String uniqNo;
    String name;
    String surname;
    String email;
    String password;
    String gender;
    String birthDay;
    String mobile;
    String wantsNewsletter;
    String isValid;
    String workingStatus;
    String identityNumber;

    public UpdateContactRequest(String token_type, String authorization, int id, String uniqNo, String name, String surname, String email, String password, String gender, String birthDay, String mobile, String wantsNewsletter, String isValid, String workingStatus, String identityNumber) {
        this.token_type = token_type;
        this.authorization = authorization;

        this.id = id;
        this.uniqNo = uniqNo;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthDay = birthDay;
        this.mobile = mobile;
        this.wantsNewsletter = wantsNewsletter;
        this.isValid = isValid;
        this.workingStatus = workingStatus;
        this.identityNumber = identityNumber;
    }

    public String getURL() {
        Config config = new Config();
        return config.URL + config.API + config.CONTACT + endPoint;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Accept", "application/json; charset=UTF-8");
        headers.put("Authorization", token_type + " " + authorization);

        return headers;
    }

    public JSONObject getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.Id, String.valueOf(id));
        paramaters.put(RequestApi.UniqNo, uniqNo);
        paramaters.put(RequestApi.Name, name);
        paramaters.put(RequestApi.Surname, surname);
        paramaters.put(RequestApi.Email, email);
        paramaters.put(RequestApi.Password, password);
        paramaters.put(RequestApi.Gender, gender);
        paramaters.put(RequestApi.BirthDay, birthDay);
        paramaters.put(RequestApi.Mobile, mobile);
        paramaters.put(RequestApi.WantsNewsletter, wantsNewsletter);
        paramaters.put(RequestApi.IsValid, isValid);
        paramaters.put(RequestApi.WorkingStatus, workingStatus);
        paramaters.put(RequestApi.IdentityNumber, identityNumber);

        JSONObject jsonObject = new JSONObject(paramaters);

        return jsonObject;
    }
}
