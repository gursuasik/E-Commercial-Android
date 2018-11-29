package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class DeleteProductResult {
    public class DeleteProduct {
        @SerializedName("Success")
        public Boolean success;

        @SerializedName("Message")
        public String message;

        @SerializedName("Data")
        private Object data;

        public void setSuccess(Boolean success) {
            this.success = success;
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