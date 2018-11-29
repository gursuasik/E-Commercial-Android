package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

public class TokenResult {
    public class Token {
        @SerializedName("access_token")
        public String accessToken;

        @SerializedName("token_type")
        public String tokenType;

        @SerializedName("expires_in")
        private Integer expiresIn;

        @SerializedName("refresh_token")
        private String refreshToken;

        @SerializedName("client_id")
        private String clientId;

        @SerializedName(".issued")
        private String issued;

        @SerializedName(".expires")
        private String expires;

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getIssued() {
            return issued;
        }

        public void setIssued(String issued) {
            this.issued = issued;
        }

        public String getExpires() {
            return expires;
        }

        public void setExpires(String expires) {
            this.expires = expires;
        }
    }
}