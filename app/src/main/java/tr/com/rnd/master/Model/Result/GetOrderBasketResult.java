package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderBasketResult {
    public class GetOrderBasket {
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

    public class Address {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Type")
        private Integer type;

        @SerializedName("ContactId")
        private Integer contactId;

        @SerializedName("CountryId")
        private Integer countryId;

        @SerializedName("CityId")
        private Integer cityId;

        @SerializedName("CityName")
        private String cityName;

        @SerializedName("TownId")
        private Integer townId;

        @SerializedName("TownName")
        private String townName;

        @SerializedName("AreaId")
        private Integer areaId;

        @SerializedName("AreaName")
        private String areaName;

        @SerializedName("AddressText")
        private String addressText;

        @SerializedName("Name")
        private String name;

        @SerializedName("Surname")
        private Object surname;

        @SerializedName("NickName")
        private String nickName;

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

        public Integer getType() {
            return type;
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

        public String getCityName() {
            return cityName;
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

        public String getTownName() {
            return townName;
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

        public String getAddressText() {
            return addressText;
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

        public String getNickName() {
            return nickName;
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
        private String saleCode;

        @SerializedName("IsBasket")
        private Boolean isBasket;

        @SerializedName("IsCancel")
        private Boolean isCancel;

        @SerializedName("IsValid")
        private Boolean isValid;

        @SerializedName("IsStore")
        private Boolean isStore;

        @SerializedName("Addresses")
        private List<Address> addresses = null;

        @SerializedName("Details")
        public List<Detail> details = null;

        @SerializedName("GroupDetails")
        private List<Object> groupDetails = null;

        @SerializedName("Payments")
        private List<Object> payments = null;

        @SerializedName("Fields")
        private List<Object> fields = null;

        @SerializedName("Discounts")
        private List<Discount> discounts = null;

        @SerializedName("BasketCreateDate")
        private String basketCreateDate;

        @SerializedName("SaleCreateDate")
        private Object saleCreateDate;

        @SerializedName("Status")
        private Integer status;

        @SerializedName("SaleNote")
        private Object saleNote;

        @SerializedName("GiftNote")
        private String giftNote;

        @SerializedName("CargoLink")
        private String cargoLink;

        @SerializedName("SubGrandTotal")
        private Integer subGrandTotal;

        @SerializedName("SubGrandTotalWithoutCargo")
        private Integer subGrandTotalWithoutCargo;

        @SerializedName("SubGrandTotalWithProductDiscounts")
        private Integer subGrandTotalWithProductDiscounts;

        @SerializedName("GrandTotal")
        public Double grandTotal;

        @SerializedName("GrandTotalWithoutCargo")
        private Double grandTotalWithoutCargo;

        @SerializedName("TotalProductDiscount")
        private Integer totalProductDiscount;

        @SerializedName("TotalCouponDiscount")
        private Integer totalCouponDiscount;

        @SerializedName("TotalCampaignDiscount")
        private Double totalCampaignDiscount;

        @SerializedName("TotalCargo")
        private Integer totalCargo;

        @SerializedName("TotalPayment")
        private Integer totalPayment;

        @SerializedName("TotalVat")
        private Double totalVat;

        @SerializedName("TotalDiscount")
        private Double totalDiscount;

        @SerializedName("RemainingPrice")
        private Double remainingPrice;

        @SerializedName("RemaningFreeCargoPrice")
        private Integer remaningFreeCargoPrice;

        @SerializedName("FreeCargoPrice")
        private Integer freeCargoPrice;

        @SerializedName("BasketCargoMessage")
        private String basketCargoMessage;

        @SerializedName("CouponCode")
        private Object couponCode;

        @SerializedName("IsGiftBox")
        private Boolean isGiftBox;

        @SerializedName("RefundGrandTotal")
        private Integer refundGrandTotal;

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

        public String getSaleCode() {
            return saleCode;
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

        public List<Address> getAddresses() {
            return addresses;
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

        public List<Object> getPayments() {
            return payments;
        }

        public void setPayments(List<Object> payments) {
            this.payments = payments;
        }

        public List<Object> getFields() {
            return fields;
        }

        public void setFields(List<Object> fields) {
            this.fields = fields;
        }

        public List<Discount> getDiscounts() {
            return discounts;
        }

        public void setDiscounts(List<Discount> discounts) {
            this.discounts = discounts;
        }

        public String getBasketCreateDate() {
            return basketCreateDate;
        }

        public void setBasketCreateDate(String basketCreateDate) {
            this.basketCreateDate = basketCreateDate;
        }

        public Object getSaleCreateDate() {
            return saleCreateDate;
        }

        public void setSaleCreateDate(Object saleCreateDate) {
            this.saleCreateDate = saleCreateDate;
        }

        public Integer getStatus() {
            return status;
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

        public Integer getSubGrandTotal() {
            return subGrandTotal;
        }

        public void setSubGrandTotal(Integer subGrandTotal) {
            this.subGrandTotal = subGrandTotal;
        }

        public Integer getSubGrandTotalWithoutCargo() {
            return subGrandTotalWithoutCargo;
        }

        public void setSubGrandTotalWithoutCargo(Integer subGrandTotalWithoutCargo) {
            this.subGrandTotalWithoutCargo = subGrandTotalWithoutCargo;
        }

        public Integer getSubGrandTotalWithProductDiscounts() {
            return subGrandTotalWithProductDiscounts;
        }

        public void setSubGrandTotalWithProductDiscounts(Integer subGrandTotalWithProductDiscounts) {
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

        public Integer getTotalProductDiscount() {
            return totalProductDiscount;
        }

        public void setTotalProductDiscount(Integer totalProductDiscount) {
            this.totalProductDiscount = totalProductDiscount;
        }

        public Integer getTotalCouponDiscount() {
            return totalCouponDiscount;
        }

        public void setTotalCouponDiscount(Integer totalCouponDiscount) {
            this.totalCouponDiscount = totalCouponDiscount;
        }

        public Double getTotalCampaignDiscount() {
            return totalCampaignDiscount;
        }

        public void setTotalCampaignDiscount(Double totalCampaignDiscount) {
            this.totalCampaignDiscount = totalCampaignDiscount;
        }

        public Integer getTotalCargo() {
            return totalCargo;
        }

        public void setTotalCargo(Integer totalCargo) {
            this.totalCargo = totalCargo;
        }

        public Integer getTotalPayment() {
            return totalPayment;
        }

        public void setTotalPayment(Integer totalPayment) {
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

        public Integer getRemaningFreeCargoPrice() {
            return remaningFreeCargoPrice;
        }

        public void setRemaningFreeCargoPrice(Integer remaningFreeCargoPrice) {
            this.remaningFreeCargoPrice = remaningFreeCargoPrice;
        }

        public Integer getFreeCargoPrice() {
            return freeCargoPrice;
        }

        public void setFreeCargoPrice(Integer freeCargoPrice) {
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

        public Integer getRefundGrandTotal() {
            return refundGrandTotal;
        }

        public void setRefundGrandTotal(Integer refundGrandTotal) {
            this.refundGrandTotal = refundGrandTotal;
        }
    }

    public class Detail {
        @SerializedName("ProductId")
        private Integer productId;

        @SerializedName("ProductDescriptionId")
        private Integer productDescriptionId;

        @SerializedName("UniqNo")
        public String uniqNo;

        @SerializedName("Quantity")
        private Integer quantity;

        @SerializedName("OldPrice")
        private Integer oldPrice;

        @SerializedName("Price")
        public Integer price;

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
        private Integer vatRatio;

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
        private Integer productDiscount;

        @SerializedName("SalePrice")
        private Double salePrice;

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

        public void setUniqNo(String uniqNo) {
            this.uniqNo = uniqNo;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Integer oldPrice) {
            this.oldPrice = oldPrice;
        }

        public void setPrice(Integer price) {
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

        public Integer getVatRatio() {
            return vatRatio;
        }

        public void setVatRatio(Integer vatRatio) {
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

        public Integer getProductDiscount() {
            return productDiscount;
        }

        public void setProductDiscount(Integer productDiscount) {
            this.productDiscount = productDiscount;
        }

        public Double getSalePrice() {
            return salePrice;
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

    public class Discount {
        @SerializedName("Name")
        private String name;

        @SerializedName("GrandTotal")
        private Double grandTotal;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(Double grandTotal) {
            this.grandTotal = grandTotal;
        }
    }
}