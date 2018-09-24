package com.example.justi.contactcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.justi.contactcardapp.models.RandomUser;
import com.squareup.picasso.Picasso;

public class DetailedActivity extends AppCompatActivity {
    ImageView image;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        image = findViewById(R.id.imageView);
        textView = findViewById(R.id.nameView);

        Intent intent = getIntent();
        RandomUser user = (RandomUser) intent.getSerializableExtra("USER");

        Picasso.get().load(user.getPicture().getLarge()).into(image);

        textView.setText(user.getName().toString());

    }
}
