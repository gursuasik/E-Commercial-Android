package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResult {
    public class Register {
        @SerializedName("Success")

        public Boolean success;
        @SerializedName("Message")

        public String message;
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
        @SerializedName("UniqNo")
        private String uniqNo;

        @SerializedName("Name")
        private String name;

        @SerializedName("Surname")
        private String surname;

        @SerializedName("Email")
        public String email;

        @SerializedName("Password")
        public String password;

        @SerializedName("Mobile")
        private String mobile;

        @SerializedName("WantsNewsletter")
        private Boolean wantsNewsletter;

        @SerializedName("IsSms")
        private Boolean isSms;

        @SerializedName("IsConfirmSms")
        private Boolean isConfirmSms;

        @SerializedName("Id")
        private Integer id;

        @SerializedName("RecordDate")
        private String recordDate;

        @SerializedName("Gender")
        private String gender;

        @SerializedName("BirthDay")
        private String birthDay;

        @SerializedName("IdentityNumber")
        private String identityNumber;

        @SerializedName("WorkingStatus")
        private String workingStatus;

        @SerializedName("IsUpdated")
        private Boolean isUpdated;

        @SerializedName("IsUsesGlasses")
        private Boolean isUsesGlasses;

        @SerializedName("IsValid")
        private Boolean isValid;

        @SerializedName("Segments")
        private List<Segment> segments = null;

        @SerializedName("FacebookId")
        private Object facebookId;

        public String getUniqNo() {
            return uniqNo;
        }

        public void setUniqNo(String uniqNo) {
            this.uniqNo = uniqNo;
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

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Boolean getWantsNewsletter() {
            return wantsNewsletter;
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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public String getIdentityNumber() {
            return identityNumber;
        }

        public void setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
        }

        public String getWorkingStatus() {
            return workingStatus;
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

        public Boolean getIsUsesGlasses() {
            return isUsesGlasses;
        }

        public void setIsUsesGlasses(Boolean isUsesGlasses) {
            this.isUsesGlasses = isUsesGlasses;
        }

        public Boolean getIsValid() {
            return isValid;
        }

        public void setIsValid(Boolean isValid) {
            this.isValid = isValid;
        }

        public List<Segment> getSegments() {
            return segments;
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
        private Integer contactId;

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

        public Integer getContactId() {
            return contactId;
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