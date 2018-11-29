package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class AddProductResult {
    public class AddProduct {
        @SerializedName("Success")
        public Boolean success;

        @SerializedName("Message")
        public String message;

        @SerializedName("Data")
        private Data data;

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public class Data {
        @SerializedName("Data1")
        private String data1;

        @SerializedName("Data2")
        private String data2;

        @SerializedName("Data3")
        private Object data3;

        @SerializedName("Data4")
        private Object data4;

        @SerializedName("Data5")
        private Object data5;

        public String getData1() {
            return data1;
        }

        public void setData1(String data1) {
            this.data1 = data1;
        }

        public String getData2() {
            return data2;
        }

        public void setData2(String data2) {
            this.data2 = data2;
        }

        public Object getData3() {
            return data3;
        }

        public void setData3(Object data3) {
            this.data3 = data3;
        }

        public Object getData4() {
            return data4;
        }

        public void setData4(Object data4) {
            this.data4 = data4;
        }

        public Object getData5() {
            return data5;
        }

        public void setData5(Object data5) {
            this.data5 = data5;
        }
    }
}