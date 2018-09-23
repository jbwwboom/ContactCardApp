package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Login  implements Serializable {
    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    @JsonProperty("uuid")
    public String getUUID() { return uuid; }
    @JsonProperty("uuid")
    public void setUUID(String value) { this.uuid = value; }

    @JsonProperty("username")
    public String getUsername() { return username; }
    @JsonProperty("username")
    public void setUsername(String value) { this.username = value; }

    @JsonProperty("password")
    public String getPassword() { return password; }
    @JsonProperty("password")
    public void setPassword(String value) { this.password = value; }

    @JsonProperty("salt")
    public String getSalt() { return salt; }
    @JsonProperty("salt")
    public void setSalt(String value) { this.salt = value; }

    @JsonProperty("md5")
    public String getMd5() { return md5; }
    @JsonProperty("md5")
    public void setMd5(String value) { this.md5 = value; }

    @JsonProperty("sha1")
    public String getSha1() { return sha1; }
    @JsonProperty("sha1")
    public void setSha1(String value) { this.sha1 = value; }

    @JsonProperty("sha256")
    public String getSha256() { return sha256; }
    @JsonProperty("sha256")
    public void setSha256(String value) { this.sha256 = value; }
}
