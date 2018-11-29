package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDiscountCouponListResult {
    public class GetDiscountCouponList {
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
        @SerializedName("Code")
        public String code;

        @SerializedName("ContactId")
        private Integer contactId;

        @SerializedName("Description")
        private Object description;

        @SerializedName("DiscountPrice")
        public Double discountPrice;

        @SerializedName("DiscountRate")
        private Integer discountRate;

        @SerializedName("EndDate")
        public String endDate;

        @SerializedName("StartDate")
        public String startDate;

        @SerializedName("RecordDate")
        private String recordDate;

        @SerializedName("IsApplyCampaign")
        private Boolean isApplyCampaign;

        @SerializedName("IsDiscountIsCoupon")
        private Boolean isDiscountIsCoupon;

        @SerializedName("MaxRequiredSaleAmount")
        private Object maxRequiredSaleAmount;

        @SerializedName("MinRequiredSaleAmount")
        private Double minRequiredSaleAmount;

        @SerializedName("MaxUserUseCount")
        private Integer maxUserUseCount;

        @SerializedName("Type")
        private String type;

        @SerializedName("UseCount")
        private Integer useCount;

        @SerializedName("UsedCount")
        private Integer usedCount;

        @SerializedName("CouponType")
        private String couponType;

        @SerializedName("IsValid")
        public Boolean isValid;

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getContactId() {
            return contactId;
        }

        public void setContactId(Integer contactId) {
            this.contactId = contactId;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public void setDiscountPrice(Double discountPrice) {
            this.discountPrice = discountPrice;
        }

        public Integer getDiscountRate() {
            return discountRate;
        }

        public void setDiscountRate(Integer discountRate) {
            this.discountRate = discountRate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getRecordDate() {
            return recordDate;
        }

        public void setRecordDate(String recordDate) {
            this.recordDate = recordDate;
        }

        public Boolean getIsApplyCampaign() {
            return isApplyCampaign;
        }

        public void setIsApplyCampaign(Boolean isApplyCampaign) {
            this.isApplyCampaign = isApplyCampaign;
        }

        public Boolean getIsDiscountIsCoupon() {
            return isDiscountIsCoupon;
        }

        public void setIsDiscountIsCoupon(Boolean isDiscountIsCoupon) {
            this.isDiscountIsCoupon = isDiscountIsCoupon;
        }

        public Object getMaxRequiredSaleAmount() {
            return maxRequiredSaleAmount;
        }

        public void setMaxRequiredSaleAmount(Object maxRequiredSaleAmount) {
            this.maxRequiredSaleAmount = maxRequiredSaleAmount;
        }

        public Double getMinRequiredSaleAmount() {
            return minRequiredSaleAmount;
        }

        public void setMinRequiredSaleAmount(Double minRequiredSaleAmount) {
            this.minRequiredSaleAmount = minRequiredSaleAmount;
        }

        public Integer getMaxUserUseCount() {
            return maxUserUseCount;
        }

        public void setMaxUserUseCount(Integer maxUserUseCount) {
            this.maxUserUseCount = maxUserUseCount;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getUseCount() {
            return useCount;
        }

        public void setUseCount(Integer useCount) {
            this.useCount = useCount;
        }

        public Integer getUsedCount() {
            return usedCount;
        }

        public void setUsedCount(Integer usedCount) {
            this.usedCount = usedCount;
        }

        public String getCouponType() {
            return couponType;
        }

        public void setCouponType(String couponType) {
            this.couponType = couponType;
        }

        public void setIsValid(Boolean isValid) {
            this.isValid = isValid;
        }
    }
}