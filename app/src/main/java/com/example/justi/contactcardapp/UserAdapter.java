package com.example.justi.contactcardapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.justi.contactcardapp.models.RandomUser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

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

        new DownloadImageTask(image).execute(user.getPicture().getLarge());

        return convertView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
