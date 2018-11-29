package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderResult {
    public class GetOrder {
        @SerializedName("Success")
        private Boolean success;

        @SerializedName("Message")
        private String message;

        @SerializedName("Data")
        public Data data;

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

        public void setData(Data data) {
            this.data = data;
        }
    }

    public class Address {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Type")
        public Integer type;

        @SerializedName("ContactId")
        private Integer contactId;

        @SerializedName("CountryId")
        private Integer countryId;

        @SerializedName("CityId")
        private Integer cityId;

        @SerializedName("CityName")
        public String cityName;

        @SerializedName("TownId")
        private Integer townId;

        @SerializedName("TownName")
        public String townName;

        @SerializedName("AreaId")
        private Integer areaId;

        @SerializedName("AreaName")
        private String areaName;

        @SerializedName("AddressText")
        public String addressText;

        @SerializedName("Name")
        private String name;

        @SerializedName("Surname")
        private Object surname;

        @SerializedName("NickName")
        public String nickName;

        @SerializedName("TaxOffice")
        private String taxOffice;

        @SerializedName("TaxNo")
        private String taxNo;

        @SerializedName("Phone")
        private String phone;

        @SerializedName("IdentityNumber")
        private String identityNumber;

        @SerializedName("RecordDate")
        private String recordDate;

        @SerializedName("ApartmentNo")
        private Object apartmentNo;

        @SerializedName("NearestArea")
        private Object nearestArea;

        @SerializedName("PostCode")
        private Object postCode;

        @SerializedName("Receiver")
        private String receiver;

        @SerializedName("Region")
        private Object region;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getContactId() {
            return contactId;
        }

        public void setContactId(Integer contactId) {
            this.contactId = contactId;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Integer getTownId() {
            return townId;
        }

        public void setTownId(Integer townId) {
            this.townId = townId;
        }

        public void setTownName(String townName) {
            this.townName = townName;
        }

        public Integer getAreaId() {
            return areaId;
        }

        public void setAreaId(Integer areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public void setAddressText(String addressText) {
            this.addressText = addressText;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getSurname() {
            return surname;
        }

        public void setSurname(Object surname) {
            this.surname = surname;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getTaxOffice() {
            return taxOffice;
        }

        public void setTaxOffice(String taxOffice) {
            this.taxOffice = taxOffice;
        }

        public String getTaxNo() {
            return taxNo;
        }

        public void setTaxNo(String taxNo) {
            this.taxNo = taxNo;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIdentityNumber() {
            return identityNumber;
        }

        public void setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
        }

        public String getRecordDate() {
            return recordDate;
        }

        public void setRecordDate(String recordDate) {
            this.recordDate = recordDate;
        }

        public Object getApartmentNo() {
            return apartmentNo;
        }

        public void setApartmentNo(Object apartmentNo) {
            this.apartmentNo = apartmentNo;
        }

        public Object getNearestArea() {
            return nearestArea;
        }

        public void setNearestArea(Object nearestArea) {
            this.nearestArea = nearestArea;
        }

        public Object getPostCode() {
            return postCode;
        }

        public void setPostCode(Object postCode) {
            this.postCode = postCode;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public Object getRegion() {
            return region;
        }

        public void setRegion(Object region) {
            this.region = region;
        }
    }

    public class Data {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("DateTimeNow")
        private String dateTimeNow;

        @SerializedName("SaleCode")
        public String saleCode;

        @SerializedName("IsBasket")
        private Boolean isBasket;

        @SerializedName("IsCancel")
        private Boolean isCancel;

        @SerializedName("IsValid")
        private Boolean isValid;

        @SerializedName("IsStore")
        private Boolean isStore;

        @SerializedName("Addresses")
        public List<Address> addresses = null;

        @SerializedName("Details")
        public List<Detail> details = null;

        @SerializedName("GroupDetails")
        private List<Object> groupDetails = null;

        @SerializedName("Payments")
        private List<Payment> payments = null;

        @SerializedName("Fields")
        private List<Field> fields = null;

        @SerializedName("Discounts")
        private List<Object> discounts = null;

        @SerializedName("BasketCreateDate")
        private String basketCreateDate;

        @SerializedName("SaleCreateDate")
        public String saleCreateDate;

        @SerializedName("Status")
        public Integer status;

        @SerializedName("SaleNote")
        private Object saleNote;

        @SerializedName("GiftNote")
        private String giftNote;

        @SerializedName("CargoLink")
        private String cargoLink;

        @SerializedName("SubGrandTotal")
        private Double subGrandTotal;

        @SerializedName("SubGrandTotalWithoutCargo")
        private Double subGrandTotalWithoutCargo;

        @SerializedName("SubGrandTotalWithProductDiscounts")
        private Double subGrandTotalWithProductDiscounts;

        @SerializedName("GrandTotal")
        public Double grandTotal;

        @SerializedName("GrandTotalWithoutCargo")
        private Double grandTotalWithoutCargo;

        @SerializedName("TotalProductDiscount")
        private Double totalProductDiscount;

        @SerializedName("TotalCouponDiscount")
        private Double totalCouponDiscount;

        @SerializedName("TotalCampaignDiscount")
        private Double totalCampaignDiscount;

        @SerializedName("TotalCargo")
        private Double totalCargo;

        @SerializedName("TotalPayment")
        private Double totalPayment;

        @SerializedName("TotalVat")
        private Double totalVat;

        @SerializedName("TotalDiscount")
        private Double totalDiscount;

        @SerializedName("RemainingPrice")
        private Double remainingPrice;

        @SerializedName("RemaningFreeCargoPrice")
        private Double remaningFreeCargoPrice;

        @SerializedName("FreeCargoPrice")
        private Double freeCargoPrice;

        @SerializedName("BasketCargoMessage")
        private String basketCargoMessage;

        @SerializedName("CouponCode")
        private Object couponCode;

        @SerializedName("IsGiftBox")
        private Boolean isGiftBox;

        @SerializedName("RefundGrandTotal")
        private Double refundGrandTotal;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDateTimeNow() {
            return dateTimeNow;
        }

        public void setDateTimeNow(String dateTimeNow) {
            this.dateTimeNow = dateTimeNow;
        }

        public void setSaleCode(String saleCode) {
            this.saleCode = saleCode;
        }

        public Boolean getIsBasket() {
            return isBasket;
        }

        public void setIsBasket(Boolean isBasket) {
            this.isBasket = isBasket;
        }

        public Boolean getIsCancel() {
            return isCancel;
        }

        public void setIsCancel(Boolean isCancel) {
            this.isCancel = isCancel;
        }

        public Boolean getIsValid() {
            return isValid;
        }

        public void setIsValid(Boolean isValid) {
            this.isValid = isValid;
        }

        public Boolean getIsStore() {
            return isStore;
        }

        public void setIsStore(Boolean isStore) {
            this.isStore = isStore;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

        public void setDetails(List<Detail> details) {
            this.details = details;
        }

        public List<Object> getGroupDetails() {
            return groupDetails;
        }

        public void setGroupDetails(List<Object> groupDetails) {
            this.groupDetails = groupDetails;
        }

        public List<Payment> getPayments() {
            return payments;
        }

        public void setPayments(List<Payment> payments) {
            this.payments = payments;
        }

        public List<Field> getFields() {
            return fields;
        }

        public void setFields(List<Field> fields) {
            this.fields = fields;
        }

        public List<Object> getDiscounts() {
            return discounts;
        }

        public void setDiscounts(List<Object> discounts) {
            this.discounts = discounts;
        }

        public String getBasketCreateDate() {
            return basketCreateDate;
        }

        public void setBasketCreateDate(String basketCreateDate) {
            this.basketCreateDate = basketCreateDate;
        }

        public void setSaleCreateDate(String saleCreateDate) {
            this.saleCreateDate = saleCreateDate;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Object getSaleNote() {
            return saleNote;
        }

        public void setSaleNote(Object saleNote) {
            this.saleNote = saleNote;
        }

        public String getGiftNote() {
            return giftNote;
        }

        public void setGiftNote(String giftNote) {
            this.giftNote = giftNote;
        }

        public String getCargoLink() {
            return cargoLink;
        }

        public void setCargoLink(String cargoLink) {
            this.cargoLink = cargoLink;
        }

        public Double getSubGrandTotal() {
            return subGrandTotal;
        }

        public void setSubGrandTotal(Double subGrandTotal) {
            this.subGrandTotal = subGrandTotal;
        }

        public Double getSubGrandTotalWithoutCargo() {
            return subGrandTotalWithoutCargo;
        }

        public void setSubGrandTotalWithoutCargo(Double subGrandTotalWithoutCargo) {
            this.subGrandTotalWithoutCargo = subGrandTotalWithoutCargo;
        }

        public Double getSubGrandTotalWithProductDiscounts() {
            return subGrandTotalWithProductDiscounts;
        }

        public void setSubGrandTotalWithProductDiscounts(Double subGrandTotalWithProductDiscounts) {
            this.subGrandTotalWithProductDiscounts = subGrandTotalWithProductDiscounts;
        }

        public void setGrandTotal(Double grandTotal) {
            this.grandTotal = grandTotal;
        }

        public Double getGrandTotalWithoutCargo() {
            return grandTotalWithoutCargo;
        }

        public void setGrandTotalWithoutCargo(Double grandTotalWithoutCargo) {
            this.grandTotalWithoutCargo = grandTotalWithoutCargo;
        }

        public Double getTotalProductDiscount() {
            return totalProductDiscount;
        }

        public void setTotalProductDiscount(Double totalProductDiscount) {
            this.totalProductDiscount = totalProductDiscount;
        }

        public Double getTotalCouponDiscount() {
            return totalCouponDiscount;
        }

        public void setTotalCouponDiscount(Double totalCouponDiscount) {
            this.totalCouponDiscount = totalCouponDiscount;
        }

        public Double getTotalCampaignDiscount() {
            return totalCampaignDiscount;
        }

        public void setTotalCampaignDiscount(Double totalCampaignDiscount) {
            this.totalCampaignDiscount = totalCampaignDiscount;
        }

        public Double getTotalCargo() {
            return totalCargo;
        }

        public void setTotalCargo(Double totalCargo) {
            this.totalCargo = totalCargo;
        }

        public Double getTotalPayment() {
            return totalPayment;
        }

        public void setTotalPayment(Double totalPayment) {
            this.totalPayment = totalPayment;
        }

        public Double getTotalVat() {
            return totalVat;
        }

        public void setTotalVat(Double totalVat) {
            this.totalVat = totalVat;
        }

        public Double getTotalDiscount() {
            return totalDiscount;
        }

        public void setTotalDiscount(Double totalDiscount) {
            this.totalDiscount = totalDiscount;
        }

        public Double getRemainingPrice() {
            return remainingPrice;
        }

        public void setRemainingPrice(Double remainingPrice) {
            this.remainingPrice = remainingPrice;
        }

        public Double getRemaningFreeCargoPrice() {
            return remaningFreeCargoPrice;
        }

        public void setRemaningFreeCargoPrice(Double remaningFreeCargoPrice) {
            this.remaningFreeCargoPrice = remaningFreeCargoPrice;
        }

        public Double getFreeCargoPrice() {
            return freeCargoPrice;
        }

        public void setFreeCargoPrice(Double freeCargoPrice) {
            this.freeCargoPrice = freeCargoPrice;
        }

        public String getBasketCargoMessage() {
            return basketCargoMessage;
        }

        public void setBasketCargoMessage(String basketCargoMessage) {
            this.basketCargoMessage = basketCargoMessage;
        }

        public Object getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(Object couponCode) {
            this.couponCode = couponCode;
        }

        public Boolean getIsGiftBox() {
            return isGiftBox;
        }

        public void setIsGiftBox(Boolean isGiftBox) {
            this.isGiftBox = isGiftBox;
        }

        public Double getRefundGrandTotal() {
            return refundGrandTotal;
        }

        public void setRefundGrandTotal(Double refundGrandTotal) {
            this.refundGrandTotal = refundGrandTotal;
        }
    }

    public class Detail {
        @SerializedName("ProductId")
        private Integer productId;

        @SerializedName("ProductDescriptionId")
        private Integer productDescriptionId;

        @SerializedName("UniqNo")
        private String uniqNo;

        @SerializedName("Quantity")
        public Integer quantity;

        @SerializedName("OldPrice")
        private Double oldPrice;

        @SerializedName("Price")
        public Double price;

        @SerializedName("Barcode")
        private String barcode;

        @SerializedName("Code")
        private String code;

        @SerializedName("Status")
        private Integer status;

        @SerializedName("Body")
        public String body;

        @SerializedName("Color")
        public String color;

        @SerializedName("VatRatio")
        private Double vatRatio;

        @SerializedName("VatTotal")
        private Double vatTotal;

        @SerializedName("Name")
        public String name;

        @SerializedName("IsOtherProduct")
        private Boolean isOtherProduct;

        @SerializedName("IsCargo")
        private Boolean isCargo;

        @SerializedName("Discount")
        private Double discount;

        @SerializedName("ProductDiscount")
        private Double productDiscount;

        @SerializedName("SalePrice")
        public Double salePrice;

        @SerializedName("GiftNote")
        private Object giftNote;

        @SerializedName("Mark")
        private String mark;

        @SerializedName("IsGiftBox")
        private Boolean isGiftBox;

        @SerializedName("Image")
        private Object image;

        @SerializedName("ImagePath")
        public String imagePath;

        @SerializedName("OrderDetailFields")
        private List<Object> orderDetailFields = null;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getProductDescriptionId() {
            return productDescriptionId;
        }

        public void setProductDescriptionId(Integer productDescriptionId) {
            this.productDescriptionId = productDescriptionId;
        }

        public String getUniqNo() {
            return uniqNo;
        }

        public void setUniqNo(String uniqNo) {
            this.uniqNo = uniqNo;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Double oldPrice) {
            this.oldPrice = oldPrice;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Double getVatRatio() {
            return vatRatio;
        }

        public void setVatRatio(Double vatRatio) {
            this.vatRatio = vatRatio;
        }

        public Double getVatTotal() {
            return vatTotal;
        }

        public void setVatTotal(Double vatTotal) {
            this.vatTotal = vatTotal;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getIsOtherProduct() {
            return isOtherProduct;
        }

        public void setIsOtherProduct(Boolean isOtherProduct) {
            this.isOtherProduct = isOtherProduct;
        }

        public Boolean getIsCargo() {
            return isCargo;
        }

        public void setIsCargo(Boolean isCargo) {
            this.isCargo = isCargo;
        }

        public Double getDiscount() {
            return discount;
        }

        public void setDiscount(Double discount) {
            this.discount = discount;
        }

        public Double getProductDiscount() {
            return productDiscount;
        }

        public void setProductDiscount(Double productDiscount) {
            this.productDiscount = productDiscount;
        }

        public void setSalePrice(Double salePrice) {
            this.salePrice = salePrice;
        }

        public Object getGiftNote() {
            return giftNote;
        }

        public void setGiftNote(Object giftNote) {
            this.giftNote = giftNote;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public Boolean getIsGiftBox() {
            return isGiftBox;
        }

        public void setIsGiftBox(Boolean isGiftBox) {
            this.isGiftBox = isGiftBox;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public List<Object> getOrderDetailFields() {
            return orderDetailFields;
        }

        public void setOrderDetailFields(List<Object> orderDetailFields) {
            this.orderDetailFields = orderDetailFields;
        }
    }

    public class Detail_ {
        @SerializedName("DetailUniqNo")
        private String detailUniqNo;

        @SerializedName("Price")
        private Double price;

        public String getDetailUniqNo() {
            return detailUniqNo;
        }

        public void setDetailUniqNo(String detailUniqNo) {
            this.detailUniqNo = detailUniqNo;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    public class Field {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        private String name;

        @SerializedName("Value")
        private String value;

        @SerializedName("Reference1")
        private Object reference1;

        @SerializedName("Reference2")
        private Object reference2;

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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Object getReference1() {
            return reference1;
        }

        public void setReference1(Object reference1) {
            this.reference1 = reference1;
        }

        public Object getReference2() {
            return reference2;
        }

        public void setReference2(Object reference2) {
            this.reference2 = reference2;
        }
    }

    public class Payment {
        @SerializedName("Details")
        private List<Detail_> details = null;

        @SerializedName("IsDiscount")
        private Boolean isDiscount;

        @SerializedName("CouponCode")
        private Object couponCode;

        @SerializedName("TotalPrice")
        private Double totalPrice;

        @SerializedName("BankName")
        private String bankName;

        @SerializedName("PaymentTypeName")
        private Object paymentTypeName;

        @SerializedName("RecordDate")
        private String recordDate;

        @SerializedName("Installment")
        private Object installment;

        public List<Detail_> getDetails() {
            return details;
        }

        public void setDetails(List<Detail_> details) {
            this.details = details;
        }

        public Boolean getIsDiscount() {
            return isDiscount;
        }

        public void setIsDiscount(Boolean isDiscount) {
            this.isDiscount = isDiscount;
        }

        public Object getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(Object couponCode) {
            this.couponCode = couponCode;
        }

        public Double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public Object getPaymentTypeName() {
            return paymentTypeName;
        }

        public void setPaymentTypeName(Object paymentTypeName) {
            this.paymentTypeName = paymentTypeName;
        }

        public String getRecordDate() {
            return recordDate;
        }

        public void setRecordDate(String recordDate) {
            this.recordDate = recordDate;
        }

        public Object getInstallment() {
            return installment;
        }

        public void setInstallment(Object installment) {
            this.installment = installment;
        }
    }
}