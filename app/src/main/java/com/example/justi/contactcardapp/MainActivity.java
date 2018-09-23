package com.example.justi.contactcardapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.justi.contactcardapp.models.RandomUser;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<RandomUser> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        RandomUserFactory.getInstance(this).volleyGet(10);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 1 seconds
                Log.d("Size of Random Users", RandomUserFactory.getInstance(getApplicationContext()).getUsers().getRandomUsers().size() + "");
                adapter = new UserAdapter(getApplicationContext(), RandomUserFactory.getInstance(getApplicationContext()).getUsers().getRandomUsers());
                listView.setAdapter(adapter);
            }
        }, 1000);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                RandomUser user = RandomUserFactory.getInstance(getApplicationContext()).getUsers().getRandomUsers().get(position);

                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        });
    }
}
