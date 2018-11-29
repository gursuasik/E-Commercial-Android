package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class DeleteAddressResult {
    public class DeleteAddress {
        @SerializedName("Success")
        public Boolean success;

        @SerializedName("Message")
        public String message;

        @SerializedName("Data")
        private Boolean data;

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Boolean getData() {
            return data;
        }

        public void setData(Boolean data) {
            this.data = data;
        }
    }
}