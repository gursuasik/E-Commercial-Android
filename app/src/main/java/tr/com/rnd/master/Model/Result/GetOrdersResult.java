package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrdersResult {
    public class GetOrders {
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
        @SerializedName("SaleCode")
        public String saleCode;

        @SerializedName("SaleCreateDate")
        public String saleCreateDate;

        @SerializedName("BillLink")
        private String billLink;

        @SerializedName("CargoLink")
        private String cargoLink;

        @SerializedName("Status")
        public Integer status;

        @SerializedName("Extra")
        private Extra extra;

        @SerializedName("SubGrandTotal")
        private Double subGrandTotal;

        @SerializedName("TotalDiscount")
        private Double totalDiscount;

        @SerializedName("TotalCampaignDiscount")
        private Double totalCampaignDiscount;

        @SerializedName("TotalCouponDiscount")
        private Double totalCouponDiscount;

        @SerializedName("GrandTotal")
        public Double grandTotal;

        @SerializedName("IsCancel")
        private Boolean isCancel;

        public void setSaleCode(String saleCode) {
            this.saleCode = saleCode;
        }

        public void setSaleCreateDate(String saleCreateDate) {
            this.saleCreateDate = saleCreateDate;
        }

        public String getBillLink() {
            return billLink;
        }

        public void setBillLink(String billLink) {
            this.billLink = billLink;
        }

        public String getCargoLink() {
            return cargoLink;
        }

        public void setCargoLink(String cargoLink) {
            this.cargoLink = cargoLink;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Extra getExtra() {
            return extra;
        }

        public void setExtra(Extra extra) {
            this.extra = extra;
        }

        public Double getSubGrandTotal() {
            return subGrandTotal;
        }

        public void setSubGrandTotal(Double subGrandTotal) {
            this.subGrandTotal = subGrandTotal;
        }

        public Double getTotalDiscount() {
            return totalDiscount;
        }

        public void setTotalDiscount(Double totalDiscount) {
            this.totalDiscount = totalDiscount;
        }

        public Double getTotalCampaignDiscount() {
            return totalCampaignDiscount;
        }

        public void setTotalCampaignDiscount(Double totalCampaignDiscount) {
            this.totalCampaignDiscount = totalCampaignDiscount;
        }

        public Double getTotalCouponDiscount() {
            return totalCouponDiscount;
        }

        public void setTotalCouponDiscount(Double totalCouponDiscount) {
            this.totalCouponDiscount = totalCouponDiscount;
        }

        public void setGrandTotal(Double grandTotal) {
            this.grandTotal = grandTotal;
        }

        public Boolean getIsCancel() {
            return isCancel;
        }

        public void setIsCancel(Boolean isCancel) {
            this.isCancel = isCancel;
        }
    }

    public class Extra {
    }
}