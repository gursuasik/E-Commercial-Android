package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPaymentViewerResult {
    public class GetPaymentViewer {
        @SerializedName("Success")
        public Boolean success;
        @SerializedName("Message")
        private String message;
        @SerializedName("Data")
        public Data data;

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public class Data {
        @SerializedName("GrandTotal")
        private Double grandTotal;

        @SerializedName("BKMGrandTotal")
        private Double bKMGrandTotal;

        @SerializedName("TransferGrandTotal")
        private Double transferGrandTotal;

        @SerializedName("PaypalGrandTotal")
        private Double paypalGrandTotal;

        @SerializedName("PayDoorGrandTotal")
        private Double payDoorGrandTotal;

        @SerializedName("CreditCardBankList")
        public List<CreditCardBankList> creditCardBankList = null;

        public Double getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(Double grandTotal) {
            this.grandTotal = grandTotal;
        }

        public Double getBKMGrandTotal() {
            return bKMGrandTotal;
        }

        public void setBKMGrandTotal(Double bKMGrandTotal) {
            this.bKMGrandTotal = bKMGrandTotal;
        }

        public Double getTransferGrandTotal() {
            return transferGrandTotal;
        }

        public void setTransferGrandTotal(Double transferGrandTotal) {
            this.transferGrandTotal = transferGrandTotal;
        }

        public Double getPaypalGrandTotal() {
            return paypalGrandTotal;
        }

        public void setPaypalGrandTotal(Double paypalGrandTotal) {
            this.paypalGrandTotal = paypalGrandTotal;
        }

        public Double getPayDoorGrandTotal() {
            return payDoorGrandTotal;
        }

        public void setPayDoorGrandTotal(Double payDoorGrandTotal) {
            this.payDoorGrandTotal = payDoorGrandTotal;
        }

        public void setCreditCardBankList(List<CreditCardBankList> creditCardBankList) {
            this.creditCardBankList = creditCardBankList;
        }
    }

    public class CreditCardBankList {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        private String name;

        @SerializedName("Image")
        private String image;

        @SerializedName("IntegrationBankCode")
        private String integrationBankCode;

        @SerializedName("BankInstallmentColorCode")
        private String bankInstallmentColorCode;

        @SerializedName("BankInstallmentFontColor")
        private String bankInstallmentFontColor;

        @SerializedName("TotalInstallmentCount")
        private Integer totalInstallmentCount;

        @SerializedName("InstallmentList")
        public List<InstallmentList> installmentList = null;

        @SerializedName("GrandTotal")
        private Double grandTotal;

        @SerializedName("SpecId")
        private Integer specId;

        @SerializedName("SuccessUrl")
        private String successUrl;

        @SerializedName("IsNormalPay")
        private Boolean isNormalPay;

        @SerializedName("Is3DPay")
        private Boolean is3DPay;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getIntegrationBankCode() {
            return integrationBankCode;
        }

        public void setIntegrationBankCode(String integrationBankCode) {
            this.integrationBankCode = integrationBankCode;
        }

        public String getBankInstallmentColorCode() {
            return bankInstallmentColorCode;
        }

        public void setBankInstallmentColorCode(String bankInstallmentColorCode) {
            this.bankInstallmentColorCode = bankInstallmentColorCode;
        }

        public String getBankInstallmentFontColor() {
            return bankInstallmentFontColor;
        }

        public void setBankInstallmentFontColor(String bankInstallmentFontColor) {
            this.bankInstallmentFontColor = bankInstallmentFontColor;
        }

        public Integer getTotalInstallmentCount() {
            return totalInstallmentCount;
        }

        public void setTotalInstallmentCount(Integer totalInstallmentCount) {
            this.totalInstallmentCount = totalInstallmentCount;
        }

        public void setInstallmentList(List<InstallmentList> installmentList) {
            this.installmentList = installmentList;
        }

        public Double getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(Double grandTotal) {
            this.grandTotal = grandTotal;
        }

        public Integer getSpecId() {
            return specId;
        }

        public void setSpecId(Integer specId) {
            this.specId = specId;
        }

        public String getSuccessUrl() {
            return successUrl;
        }

        public void setSuccessUrl(String successUrl) {
            this.successUrl = successUrl;
        }

        public Boolean getIsNormalPay() {
            return isNormalPay;
        }

        public void setIsNormalPay(Boolean isNormalPay) {
            this.isNormalPay = isNormalPay;
        }

        public Boolean getIs3DPay() {
            return is3DPay;
        }

        public void setIs3DPay(Boolean is3DPay) {
            this.is3DPay = is3DPay;
        }
    }

    public class InstallmentList {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Installment")
        public Integer installment;

        @SerializedName("Description")
        private String description;

        @SerializedName("InstallmentPrice")
        private Double installmentPrice;

        @SerializedName("GrandTotal")
        private Double grandTotal;

        @SerializedName("SpecId")
        private Integer specId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setInstallment(Integer installment) {
            this.installment = installment;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getInstallmentPrice() {
            return installmentPrice;
        }

        public void setInstallmentPrice(Double installmentPrice) {
            this.installmentPrice = installmentPrice;
        }

        public Double getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(Double grandTotal) {
            this.grandTotal = grandTotal;
        }

        public Integer getSpecId() {
            return specId;
        }

        public void setSpecId(Integer specId) {
            this.specId = specId;
        }
    }
}