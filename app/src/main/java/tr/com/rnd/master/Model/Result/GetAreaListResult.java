package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAreaListResult {
    public class GetAreaList {
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

        @SerializedName("TownId")
        private Integer townId;

        @SerializedName("Name")
        public String name;

        @SerializedName("IntegrationCode")
        private Object integrationCode;

        @SerializedName("CargoOrderNumber")
        private Object cargoOrderNumber;

        @SerializedName("CargoKey")
        private String cargoKey;

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getTownId() {
            return townId;
        }

        public void setTownId(Integer townId) {
            this.townId = townId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getIntegrationCode() {
            return integrationCode;
        }

        public void setIntegrationCode(Object integrationCode) {
            this.integrationCode = integrationCode;
        }

        public Object getCargoOrderNumber() {
            return cargoOrderNumber;
        }

        public void setCargoOrderNumber(Object cargoOrderNumber) {
            this.cargoOrderNumber = cargoOrderNumber;
        }

        public String getCargoKey() {
            return cargoKey;
        }

        public void setCargoKey(String cargoKey) {
            this.cargoKey = cargoKey;
        }
    }
}