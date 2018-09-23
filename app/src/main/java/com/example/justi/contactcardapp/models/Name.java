package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Name implements Serializable {
    private String title;
    private String first;
    private String last;

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("first")
    public String getFirst() { return first; }
    @JsonProperty("first")
    public void setFirst(String value) { this.first = value; }

    @JsonProperty("last")
    public String getLast() { return last; }
    @JsonProperty("last")
    public void setLast(String value) { this.last = value; }

    @Override
    public String toString() {
        return title + " " + first + " " + last;
    }
}
