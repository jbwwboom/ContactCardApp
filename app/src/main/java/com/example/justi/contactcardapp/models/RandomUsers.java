package com.example.justi.contactcardapp.models;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import com.fasterxml.jackson.annotation.*;

public class RandomUsers  implements Serializable {
    private ArrayList<RandomUser> randomUsers;
    private Info info;

    @JsonProperty("results")
    public ArrayList<RandomUser> getRandomUsers() { return randomUsers; }
    @JsonProperty("results")
    public void setRandomUsers(ArrayList<RandomUser> value) { this.randomUsers = value; }

    @JsonProperty("info")
    public Info getInfo() { return info; }
    @JsonProperty("info")
    public void setInfo(Info value) { this.info = value; }
}
