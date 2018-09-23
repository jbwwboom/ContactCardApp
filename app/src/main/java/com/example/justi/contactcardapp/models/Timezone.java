package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Timezone  implements Serializable {
    private String offset;
    private String description;

    @JsonProperty("offset")
    public String getOffset() { return offset; }
    @JsonProperty("offset")
    public void setOffset(String value) { this.offset = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }
}
