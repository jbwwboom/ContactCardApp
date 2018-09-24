package com.example.justi.contactcardapp;

import com.example.justi.contactcardapp.models.RandomUser;

import java.util.ArrayList;

public interface RandomUserListener {
    void onResponse(ArrayList<RandomUser> users);

    void onError(Error error);
}
