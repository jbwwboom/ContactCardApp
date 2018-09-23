package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Dob  implements Serializable {
    private String date;
    private long age;

    @JsonProperty("date")
    public String getDate() { return date; }
    @JsonProperty("date")
    public void setDate(String value) { this.date = value; }

    @JsonProperty("age")
    public long getAge() { return age; }
    @JsonProperty("age")
    public void setAge(long value) { this.age = value; }
}
