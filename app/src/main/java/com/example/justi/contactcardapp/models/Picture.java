package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Picture implements Serializable {
    private String large;
    private String medium;
    private String thumbnail;

    @JsonProperty("large")
    public String getLarge() { return large; }
    @JsonProperty("large")
    public void setLarge(String value) { this.large = value; }

    @JsonProperty("medium")
    public String getMedium() { return medium; }
    @JsonProperty("medium")
    public void setMedium(String value) { this.medium = value; }

    @JsonProperty("thumbnail")
    public String getThumbnail() { return thumbnail; }
    @JsonProperty("thumbnail")
    public void setThumbnail(String value) { this.thumbnail = value; }
}
