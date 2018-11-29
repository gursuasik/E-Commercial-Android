package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class FastDeliveryIDSResult {
    public class FastDeliveryIDS {
        @SerializedName("Success")
        public Boolean success;

        @SerializedName("Message")
        private String message;

        @SerializedName("Data")
        public String data;

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}