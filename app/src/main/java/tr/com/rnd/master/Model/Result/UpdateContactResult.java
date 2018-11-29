package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class UpdateContactResult {
    public class UpdateContact {
        @SerializedName("Success")
        public Boolean success;

        @SerializedName("Message")
        private String message;

        @SerializedName("Data")
        private Object data;

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}