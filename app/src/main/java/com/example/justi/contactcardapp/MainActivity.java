package com.example.justi.contactcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.justi.contactcardapp.models.RandomUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RandomUserListener {

    private ListView listView;
    private ArrayAdapter<RandomUser> adapter;
    private ArrayList<RandomUser> randomUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        final RandomUserFactory factory  = RandomUserFactory.getInstance(this,this );

        factory.volleyGet(100);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RandomUser user = randomUsers.get(position);

                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponse(ArrayList<RandomUser> randomUsers) {
        this.randomUsers.addAll(randomUsers);
        Log.d("Response: ", randomUsers.size() + "");
        adapter = new UserAdapter(getApplicationContext(), randomUsers);
        listView.setAdapter(adapter);
    }

    @Override
    public void onError(Error error) {
        Log.d("Error:", error.toString());
    }
}
