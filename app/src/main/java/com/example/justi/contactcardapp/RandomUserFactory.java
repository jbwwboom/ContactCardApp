package com.example.justi.contactcardapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.justi.contactcardapp.models.Converter;
import com.example.justi.contactcardapp.models.RandomUser;
import com.example.justi.contactcardapp.models.RandomUsers;

import org.json.JSONObject;

import java.util.ArrayList;

public class RandomUserFactory {

    private RandomUsers users = null;

    // Private constructor, huh?
    private RandomUserFactory(Context context) {
        this.context = context;
    }

    public RandomUsers getUsers() {
        return users;
    }

    private static RandomUserFactory instance = null;

    private Context context;

    // Singleton
    public static RandomUserFactory getInstance(Context context) {
        if( instance == null ) {
            instance = new RandomUserFactory(context);
        }
        return instance;
    }

    public void volleyGet(int amount){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://randomuser.me/api/?results=" + amount;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("Response is: ", response.substring(0,500));
                        try{
                            users = Converter.fromJsonString(response);
                        }catch (Exception e){
                            Log.d(e.getLocalizedMessage(), "Error");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

    // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}