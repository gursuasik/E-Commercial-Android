package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetContactResult {
    public class GetContact {
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
        @SerializedName("UniqNo")
        public String uniqNo;

        @SerializedName("Name")
        public String name;

        @SerializedName("Surname")
        public String surname;

        @SerializedName("Email")
        public String email;

        @SerializedName("Password")
        private String password;

        @SerializedName("Mobile")
        public String mobile;

        @SerializedName("WantsNewsletter")
        public Boolean wantsNewsletter;

        @SerializedName("IsSms")
        private Boolean isSms;

        @SerializedName("IsConfirmSms")
        private Boolean isConfirmSms;

        @SerializedName("Id")
        private Integer id;

        @SerializedName("RecordDate")
        private String recordDate;

        @SerializedName("Gender")
        public String gender;

        @SerializedName("BirthDay")
        public String birthDay;

        @SerializedName("IdentityNumber")
        public String identityNumber;

        @SerializedName("WorkingStatus")
        public String workingStatus;

        @SerializedName("IsUpdated")
        private Boolean isUpdated;

        @SerializedName("IsValid")
        public Boolean isValid;

        @SerializedName("Segments")
        public List<Segment> segments = null;

        @SerializedName("FacebookId")
        private Object facebookId;

        public void setUniqNo(String uniqNo) {
            this.uniqNo = uniqNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setWantsNewsletter(Boolean wantsNewsletter) {
            this.wantsNewsletter = wantsNewsletter;
        }

        public Boolean getIsSms() {
            return isSms;
        }

        public void setIsSms(Boolean isSms) {
            this.isSms = isSms;
        }

        public Boolean getIsConfirmSms() {
            return isConfirmSms;
        }

        public void setIsConfirmSms(Boolean isConfirmSms) {
            this.isConfirmSms = isConfirmSms;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getRecordDate() {
            return recordDate;
        }

        public void setRecordDate(String recordDate) {
            this.recordDate = recordDate;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public void setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
        }

        public void setWorkingStatus(String workingStatus) {
            this.workingStatus = workingStatus;
        }

        public Boolean getIsUpdated() {
            return isUpdated;
        }

        public void setIsUpdated(Boolean isUpdated) {
            this.isUpdated = isUpdated;
        }

        public void setIsValid(Boolean isValid) {
            this.isValid = isValid;
        }

        public void setSegments(List<Segment> segments) {
            this.segments = segments;
        }

        public Object getFacebookId() {
            return facebookId;
        }

        public void setFacebookId(Object facebookId) {
            this.facebookId = facebookId;
        }
    }

    public class Segment {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ContactId")
        public Integer contactId;

        @SerializedName("Name")
        private String name;

        @SerializedName("Value")
        private String value;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setContactId(Integer contactId) {
            this.contactId = contactId;
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
    }
}