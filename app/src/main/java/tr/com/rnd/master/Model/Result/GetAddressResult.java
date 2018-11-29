package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class GetAddressResult {
    public class GetAddress {
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

    public class Data {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Type")
        private Integer type;

        @SerializedName("ContactId")
        private Integer contactId;

        @SerializedName("CountryId")
        private Integer countryId;

        @SerializedName("CityId")
        public Integer cityId;

        @SerializedName("CityName")
        public String cityName;

        @SerializedName("TownId")
        public Integer townId;

        @SerializedName("TownName")
        public String townName;

        @SerializedName("AreaId")
        public Integer areaId;

        @SerializedName("AreaName")
        public String areaName;

        @SerializedName("AddressText")
        public String addressText;

        @SerializedName("Name")
        public String name;

        @SerializedName("Surname")
        public String surname;

        @SerializedName("NickName")
        public String nickName;

        @SerializedName("TaxOffice")
        private Object taxOffice;

        @SerializedName("TaxNo")
        private Object taxNo;

        @SerializedName("Phone")
        public String phone;

        @SerializedName("IdentityNumber")
        private Object identityNumber;

        @SerializedName("RecordDate")
        private String recordDate;

        @SerializedName("ApartmentNo")
        private String apartmentNo;

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

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public void setTownId(Integer townId) {
            this.townId = townId;
        }

        public void setTownName(String townName) {
            this.townName = townName;
        }

        public void setAreaId(Integer areaId) {
            this.areaId = areaId;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public void setAddressText(String addressText) {
            this.addressText = addressText;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public Object getTaxOffice() {
            return taxOffice;
        }

        public void setTaxOffice(Object taxOffice) {
            this.taxOffice = taxOffice;
        }

        public Object getTaxNo() {
            return taxNo;
        }

        public void setTaxNo(Object taxNo) {
            this.taxNo = taxNo;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getIdentityNumber() {
            return identityNumber;
        }

        public void setIdentityNumber(Object identityNumber) {
            this.identityNumber = identityNumber;
        }

        public String getRecordDate() {
            return recordDate;
        }

        public void setRecordDate(String recordDate) {
            this.recordDate = recordDate;
        }

        public String getApartmentNo() {
            return apartmentNo;
        }

        public void setApartmentNo(String apartmentNo) {
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
}