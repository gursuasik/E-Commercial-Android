package tr.com.rnd.master.Model.Request;


import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Config.RequestApi;

public class RegisterRequest {
    String endPoint = "/register";
    public int method = Request.Method.POST;

    String name = "";
    String surname = "";
    String email = "";
    String password = "";
    String gender = "";
    String birthDay = "";
    String mobile = "";
    String wantsNewsletter = "";
    String isValid = "";
    String iWantCard = "";

    public RegisterRequest(String name, String surname, String email, String password, String gender, String birthDay, String mobile, String wantsNewsletter, String isValid, String iWantCard) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthDay = birthDay;
        this.mobile = mobile;
        this.wantsNewsletter = wantsNewsletter;
        this.isValid = isValid;
        this.iWantCard = iWantCard;
    }

    public String getURL() {
        Config config = new Config();

        return config.URL + config.API + config.MEMBER + endPoint;
    }

    public Map<String, String> getParameters() {
        Map<String, String> paramaters = new HashMap<>();

        paramaters.put(RequestApi.Name, name);
        paramaters.put(RequestApi.Surname, surname);
        paramaters.put(RequestApi.Email, email);
        paramaters.put(RequestApi.Password, password);
        paramaters.put(RequestApi.Gender, gender);
        paramaters.put(RequestApi.BirthDay, birthDay);
        paramaters.put(RequestApi.Mobile, mobile);
        paramaters.put(RequestApi.WantsNewsletter, wantsNewsletter);
        paramaters.put(RequestApi.IsValid, isValid);
        paramaters.put(RequestApi.IWantCard, iWantCard);

        return paramaters;
    }
}
