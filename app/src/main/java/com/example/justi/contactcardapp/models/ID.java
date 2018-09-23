package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class ID  implements Serializable {
    private String name;
    private Object value;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("value")
    public Object getValue() { return value; }
    @JsonProperty("value")
    public void setValue(Object value) { this.value = value; }
}
