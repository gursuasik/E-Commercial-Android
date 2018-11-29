package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAddressListResult {
    public class GetAddressList {
        @SerializedName("Success")
        public Boolean success;

        @SerializedName("Message")
        private String message;

        @SerializedName("Data")
        public List<Data> data = null;

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
        @SerializedName("Id")
        public Integer id;

        @SerializedName("Type")
        private Integer type;

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
        public Integer areaId;

        @SerializedName("AreaName")
        private String areaName;

        @SerializedName("AddressText")
        public String addressText;

        @SerializedName("Name")
        private String name;

        @SerializedName("Surname")
        private String surname;

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
        private String apartmentNo;

        @SerializedName("NearestArea")
        private Object nearestArea;

        @SerializedName("PostCode")
        private Object postCode;

        @SerializedName("Receiver")
        private Object receiver;

        @SerializedName("Region")
        private Object region;

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

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
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

        public Object getReceiver() {
            return receiver;
        }

        public void setReceiver(Object receiver) {
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