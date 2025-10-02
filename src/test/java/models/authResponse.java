package models;

public class authResponse {
    private String token;
    private String reason;
    public String getFailureReason() {
        return reason;
    }
    public void setFailureReason(String failureReason) {
        this.reason = failureReason;
    }
    public authResponse(){}
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
