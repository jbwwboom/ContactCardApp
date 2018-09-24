package com.example.justi.contactcardapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.justi.contactcardapp.models.Converter;
import com.example.justi.contactcardapp.models.RandomUsers;

public class RandomUserFactory {

    private RandomUsers users = null;

    private static RandomUserFactory instance = null;

    private Context context;

    private RandomUserListener listener;

    private RandomUserFactory(Context context , RandomUserListener listener) {
        this.context = context;
        this.listener = listener;
    }

    // Singleton
    public static RandomUserFactory getInstance(Context context, RandomUserListener listener) {
        if( instance == null ) {
            instance = new RandomUserFactory(context, listener);
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
                            listener.onResponse(users.getRandomUsers());
                        }catch (Exception e){
                            Log.d(e.getLocalizedMessage(), "Error");
                            listener.onError(new Error(e.getLocalizedMessage()));
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(new Error(error.getLocalizedMessage()));
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}