package com.example.justi.contactcardapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.justi.contactcardapp.models.RandomUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<RandomUser> {

    // Constructor
    public UserAdapter(Context context, ArrayList<RandomUser> users) {
        super( context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        RandomUser user = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.user_listview_item,
                    parent,
                    false
            );
        }

        TextView name = convertView.findViewById(R.id.textView);
        ImageView image = convertView.findViewById(R.id.imageView2);

        name.setText( user.getLogin().getUsername() );

        Picasso.get().load(user.getPicture().getLarge()).into(image);

        return convertView;
    }
}
