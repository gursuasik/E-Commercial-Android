package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class CardPaymentResult {
    public class CardPayment {
        @SerializedName("Success")
        public Boolean success;

        @SerializedName("Message")
        public String message;

        @SerializedName("Data")
        public String data;

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}