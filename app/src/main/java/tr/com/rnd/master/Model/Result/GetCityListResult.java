package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCityListResult {
    public class GetCityList {
        @SerializedName("Success")
        private Boolean success;

        @SerializedName("Message")
        private String message;

        @SerializedName("Data")
        public List<Data> data = null;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
    }

    public class Data {
        @SerializedName("Id")
        public Integer id;

        @SerializedName("CountryId")
        private Integer countryId;

        @SerializedName("Name")
        public String name;

        @SerializedName("IntegrationCode")
        private String integrationCode;

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntegrationCode() {
            return integrationCode;
        }

        public void setIntegrationCode(String integrationCode) {
            this.integrationCode = integrationCode;
        }
    }
}