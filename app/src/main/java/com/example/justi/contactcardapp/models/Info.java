package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Info implements Serializable {
    private String seed;
    private long results;
    private long page;
    private String version;

    @JsonProperty("seed")
    public String getSeed() { return seed; }
    @JsonProperty("seed")
    public void setSeed(String value) { this.seed = value; }

    @JsonProperty("results")
    public long getResults() { return results; }
    @JsonProperty("results")
    public void setResults(long value) { this.results = value; }

    @JsonProperty("page")
    public long getPage() { return page; }
    @JsonProperty("page")
    public void setPage(long value) { this.page = value; }

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }
}
